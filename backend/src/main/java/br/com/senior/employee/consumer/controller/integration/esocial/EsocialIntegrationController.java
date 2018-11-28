package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.authentication.Credential;
import br.com.senior.employee.consumer.client.esocial.*;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategy;
import br.com.senior.employee.consumer.rest.Rest;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j
@Component
public class EsocialIntegrationController {

    @Autowired
    private Rest rest;
    @Autowired
    private EsocialIntegrationStrategy esocialStrategy;
    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private CompanyCredentialsStrategy companyCredentialsStrategy;

    /**
     * Este método é executado ao iniciar este sistema para verificar se existem status dos envios de XML não consumidos.
     */
    public void consumePendenciesStatusIntegration() {
        LOGGER.info("Consumindo status pendentes.");
        companyCredentialsStrategy.getCredentials().forEach(c -> {
            LayoutSituation.PagedResults list;
            do {
                list = getDataStatusXml(c).getBody();
                list.contents.forEach(l -> {
                    ProviderXml data = new ProviderXml();
                    data.idEvento = l.eventId;
                    data.id = l.layoutId;
                    data.layoutType = l.layoutType;
                    data.message = l.layoutMessage;
                    data.xmlStatus = l.xmlStatusType;
                    statusXml(data);
                });
            } while (containsPendenciesStatusXml(list));
        });
    }

    /**
     * Método responsável receber o status do XML.
     *
     * @param providerXml Entidade referente ao status do envio do XML.
     */
    public void statusXml(ProviderXml providerXml) {
        XmlOutput xmlOutput = setXmlOutputForStatusIntegration(providerXml);
        try {
            companyCredentialsStrategy.getCredentials().forEach(c -> {
                esocialStrategy.eSocialStatusXml(xmlOutput);
                /**
                 * Neste ponto o código comunica para a SENIOR que recebeu o Status do XML.
                 * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
                 */
                XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlOutput.xmlId, ProviderStatusType.ON_PROVIDER);
                rest.get(c).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
                LOGGER.info("O Status do xml ID: " + xmlOutput.xmlId + " foi alterado.");
            });
        } catch (Exception e) {
            companyCredentialsStrategy.getCredentials().forEach(c -> {
                XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlOutput.xmlId, ProviderStatusType.PROVIDER_ERROR);
                rest.get(c).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
                LOGGER.info("O Status do xml ID: " + xmlOutput.xmlId + " foi alterado.");
            });
        }
    }

    /**
     * Busca as pendências com status de erro e de sucesso.
     *
     * @return {@Link ResponseEntity<XmlSituation.PagedResults>}
     */
    private ResponseEntity<LayoutSituation.PagedResults> getDataStatusXml(Credential credential) {
        String filter = "providerStatusType eq SENT_TO_PROVIDER";
        return rest.get(credential).exchange(applicationProperties.getG7Location() + "/hcm/esocial/entities/providerXml?filter=" + filter,
                HttpMethod.GET,
                null,
                LayoutSituation.PagedResults.class);
    }

    /**
     * Método responsável por verificar se existem pendencias com recibos não consumidos.
     *
     * @param response Retorno.
     * @return @{@link boolean}
     */
    private boolean containsPendenciesReturnGovernment(LayoutSituation.PagedResults response) {
        return response.totalElements > 0;
    }

    /**
     * Método responsável por verificar se existem pendências com status ero e sucesso não consumidos.
     *
     * @param response Retorno.
     * @return @{@link boolean}
     */
    private boolean containsPendenciesStatusXml(LayoutSituation.PagedResults response) {
        return response.totalElements > 0;
    }

    /**
     * Envia o XML.
     *
     * @param credential Credenciais.
     * @param payload    Payload.
     */
    public XmlOutput sendXml(Credential credential, EsocialEventXmlInput payload) {
        HttpEntity<EsocialEventXmlInput> request = new HttpEntity<>(payload);
        EsocialEventXmlOutput providerXml = rest.get(credential).postForObject(applicationProperties.getG7Location() + "/hcm/esocial/actions/esocialEventXml",
                request,
                EsocialEventXmlOutput.class);
        XmlOutput xmlOutput = setXmlOutputForSendXml(providerXml);
        return xmlOutput;
    }

    private XmlOutput setXmlOutputForSendXml(EsocialEventXmlOutput providerXml) {
        XmlOutput xmlOutput = new XmlOutput();
        xmlOutput.xmlId = providerXml.result.id;
        xmlOutput.xmlStatus = providerXml.result.xmlStatus;
        xmlOutput.message = providerXml.result.message;
        return xmlOutput;
    }

    public XmlOutput setXmlOutputForStatusIntegration(ProviderXml providerXml) {
        XmlOutput xmlOutput = new XmlOutput();
        xmlOutput.xmlId =providerXml.id;
        xmlOutput.xmlStatus =providerXml.xmlStatus;
        xmlOutput.message = providerXml.message;
        if(providerXml.idEvento !=null)
            xmlOutput.esocialEventId = providerXml.idEvento;
        if(providerXml.layoutType !=null)
            xmlOutput.esocialLayoutType = providerXml.layoutType;
        if(providerXml.statusType !=null)
            xmlOutput.esocialReturnType = providerXml.statusType;
        if(providerXml.providerXmlId !=null)
            xmlOutput.xmlProviderId = providerXml.providerXmlId;
        if(providerXml.providerCompanyId !=null)
            xmlOutput.companyProviderId = providerXml.providerCompanyId;
        if(providerXml.subscriptionType !=null)
            xmlOutput.subscriptionType = providerXml.subscriptionType;
        if(providerXml.subscriptionNumber != null)
            xmlOutput.subscriptionNumber = providerXml.subscriptionNumber;
        if(providerXml.layoutSituation != null && providerXml.layoutSituation.receiptNumber !=null)
            xmlOutput.esocialReceiptNumber = providerXml.layoutSituation.receiptNumber;

        return xmlOutput;
    }
}
