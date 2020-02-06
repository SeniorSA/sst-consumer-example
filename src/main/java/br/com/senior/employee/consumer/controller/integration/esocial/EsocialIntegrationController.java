package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
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
                                data.id = l.id;
                                data.xml = l.xml;
                                data.xmlStatus = l.xmlStatus;
                                data.providerStatusType = l.providerStatusType;
                                data.layoutSituation = l.layoutSituation;
                                data.stackTrace = l.stackTrace;
                                data.message = l.message;
                                data.idEvento = l.idEvento;
                                data.layoutType = l.layoutType;
                                data.receiptDate = l.receiptDate;
                                data.providerCompanyId = l.providerCompanyId;
                                data.subscriptionType = l.subscriptionType;
                                data.subscriptionNumber = l.subscriptionNumber;
                                data.providerXmlId = l.providerXmlId;
                                data.providerErrorMessage = l.providerErrorMessage;
                                statusXml(c.accessKey, data);
                            });
                    } while (containsPendenciesStatusXml(list));
                } catch (HttpClientErrorException e) {
                    LOGGER.info("Credencial inválida para o usuário: " + c.tenantName);
                } catch (ResourceAccessException e) {
                    LOGGER.info("URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.");
                }
            });
    }

    /**
     * Método responsável receber o status do XML.
     * @param accessKey Chave de acesso da aplicação.
     * @param providerXml Entidade referente ao status do envio do XML.
     */
    public void statusXml(String accessKey, ProviderXml providerXml) {
        XmlOutput xmlOutput = setXmlOutputForStatusIntegration(providerXml);
        KeyCredential keyCredential = KeyCredential.getKeyCredentialFromAccessKey(accessKey);
        try {
            esocialStrategy.eSocialStatusXml(xmlOutput);
            /**
            * Neste ponto o código comunica para a SENIOR que recebeu o Status do XML.
            * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
            */
            XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlOutput.xmlId, ProviderStatusType.ON_PROVIDER);
            rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
            LOGGER.info("O Status do xml ID: " + xmlOutput.xmlId + " foi alterado.");
        } catch (Exception e) {
            LOGGER.error("Erro na integração do xml ID: " + xmlOutput.xmlId, e);
            XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlOutput.xmlId, ProviderStatusType.PROVIDER_ERROR, e.getMessage());
            rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
        }
    }

    /**
     * Busca as pendências com status de erro e de sucesso.
     *
     * @return {@Link ResponseEntity<XmlSituation.PagedResults>}
     */
    private ResponseEntity<ProviderXml.PagedResults> getDataStatusXml(KeyCredential keyCredential) {
        String filter = "providerStatusType eq SENT_TO_PROVIDER";
        return rest.getWithKey(keyCredential).exchange(applicationProperties.getG7Location() + "/hcm/esocial/entities/providerXml?filter=" + filter,
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
    public XmlOutput sendXml(KeyCredential credential, EsocialEventXmlInput payload) {
        HttpEntity<EsocialEventXmlInput> request = new HttpEntity<>(payload);
        XmlOutput xmlOutputStatusIntegration = new XmlOutput();

        try {
            if(payload.providerXmlId !=null) {
                xmlOutputStatusIntegration.xmlProviderId = payload.providerXmlId;
            }
            if(payload.providerCompanyId !=null) {
                xmlOutputStatusIntegration.companyProviderId = payload.providerCompanyId;
            }
            if(payload.subscriptionType !=null) {
                xmlOutputStatusIntegration.subscriptionType = payload.subscriptionType;
            }
            if(payload.subscriptionNumber !=null) {
                xmlOutputStatusIntegration.subscriptionNumber = payload.subscriptionNumber;
            }

            xmlOutputStatusIntegration.xmlStatus = XmlStatusType.IN_ANALISYS;

            EsocialEventXmlOutput providerXml = rest.getWithKey(credential).postForObject(applicationProperties.getG7Location() + "/hcm/esocial/actions/esocialEventXml",
                                                                                          request,
                                                                                          EsocialEventXmlOutput.class);

            xmlOutputStatusIntegration.xmlId = providerXml.result.id;
            xmlOutputStatusIntegration.esocialLayoutType = providerXml.result.layoutType;

            LOGGER.info("O XML do eSocial de id:" + xmlOutputStatusIntegration.xmlId + " foi enviado para a plataforma SeniorX.");
        }catch (HttpClientErrorException e) {
            xmlOutputStatusIntegration.xmlStatus = XmlStatusType.SEND_XML_ERROR;
            xmlOutputStatusIntegration.message = "Credencial inválida para o tenant: " + credential.tenantName;
            LOGGER.info("Credencial inválida para o tenant: " + credential.tenantName);
        } catch (ResourceAccessException e) {
            xmlOutputStatusIntegration.xmlStatus = XmlStatusType.SEND_XML_ERROR;
            xmlOutputStatusIntegration.message = "URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.";
            LOGGER.info("URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.");
        }

        try{
            esocialStrategy.eSocialStatusXml(xmlOutputStatusIntegration);
        }catch (Exception e) {
            LOGGER.error("Erro na integração do XML ID: " + xmlOutputStatusIntegration.xmlProviderId, e);
        }

        return xmlOutputStatusIntegration;
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
