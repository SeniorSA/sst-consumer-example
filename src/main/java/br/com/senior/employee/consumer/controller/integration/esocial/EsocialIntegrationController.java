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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

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
                ProviderXml.PagedResults list;
                try {
                    do {
                        list = getDataStatusXml(c).getBody();
                            list.contents.forEach(l -> {
                                ProviderXml data = new ProviderXml();
                                data.idEvento = l.idEvento;
                                data.id = l.id;
                                data.layoutType = l.layoutType;
                                data.message = l.message;
                                data.xmlStatus = l.xmlStatus;
                                statusXml(c.username, data);
                            });
                    } while (containsPendenciesStatusXml(list));
                } catch (HttpClientErrorException e) {
                    LOGGER.info("Credencial inválida para o usuário: " + c.username);
                } catch (ResourceAccessException e) {
                    LOGGER.info("URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.");
                }
            });
    }

    /**
     * Método responsável receber o status do XML.
     * @param user
     * @param providerXml Entidade referente ao status do envio do XML.
     */
    public void statusXml(String user, ProviderXml providerXml) {
        XmlOutput xmlOutput = setXmlOutputForStatusIntegration(providerXml);
        Credential credential = Credential.fromUser(user);
        try {
            esocialStrategy.eSocialStatusXml(xmlOutput);
            /**
            * Neste ponto o código comunica para a SENIOR que recebeu o Status do XML.
            * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
            */
            XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlOutput.xmlId, ProviderStatusType.ON_PROVIDER);
            rest.get(credential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
            LOGGER.info("O Status do xml ID: " + xmlOutput.xmlId + " foi alterado.");
        } catch (Exception e) {
            LOGGER.error("Erro na integração do xml ID: " + xmlOutput.xmlId, e);
            XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlOutput.xmlId, ProviderStatusType.PROVIDER_ERROR, e.getMessage());
            rest.get(credential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
        }
    }

    /**
     * Busca as pendências com status de erro e de sucesso.
     *
     * @return {@Link ResponseEntity<XmlSituation.PagedResults>}
     */
    private ResponseEntity<ProviderXml.PagedResults> getDataStatusXml(Credential credential) {
        String filter = "providerStatusType eq SENT_TO_PROVIDER";
        return rest.get(credential).exchange(applicationProperties.getG7Location() + "/hcm/esocial/entities/providerXml?filter=" + filter,
                HttpMethod.GET,
                null,
                ProviderXml.PagedResults.class);
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
    private boolean containsPendenciesStatusXml(ProviderXml.PagedResults response) {
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
        XmlOutput xmlOutput = null;
        try {
            EsocialEventXmlOutput providerXml = rest.get(credential).postForObject(applicationProperties.getG7Location() + "/hcm/esocial/actions/esocialEventXml",
                    request,
                    EsocialEventXmlOutput.class);
            xmlOutput = setXmlOutputForSendXml(providerXml);
            LOGGER.info("O XML do eSocial de id:" + xmlOutput.xmlId + " foi enviado para a plataforma SeniorX.");
        }catch (HttpClientErrorException e) {
            LOGGER.info("Credencial inválida para o usuário: " + credential.username);
        } catch (ResourceAccessException e) {
            LOGGER.info("URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.");
        }
        return xmlOutput;
    }

    private XmlOutput setXmlOutputForSendXml(EsocialEventXmlOutput providerXml) {
        XmlOutput xmlOutput = new XmlOutput();
        xmlOutput.xmlId = providerXml.result.id;
        xmlOutput.xmlStatus = providerXml.result.xmlStatus;
        xmlOutput.message = providerXml.result.message;
        if(providerXml.result.providerXmlId !=null)
            xmlOutput.xmlProviderId = providerXml.result.providerXmlId;
        if(providerXml.result.providerCompanyId !=null)
            xmlOutput.companyProviderId = providerXml.result.providerCompanyId;
        if(providerXml.result.subscriptionType !=null)
            xmlOutput.subscriptionType = providerXml.result.subscriptionType;
        if(providerXml.result.subscriptionNumber !=null)
            xmlOutput.subscriptionNumber = providerXml.result.subscriptionNumber;
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
        if ((providerXml.layoutSituation != null) && (providerXml.layoutSituation.statusType !=null))
            xmlOutput.esocialReturnType = providerXml.layoutSituation.statusType;
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
