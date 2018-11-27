package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.authentication.Credential;
import br.com.senior.employee.consumer.client.esocial.*;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategy;
import br.com.senior.employee.consumer.rest.Rest;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
     * @param xmlStatus Entidade referente ao status do envio do XML.
     */
    public void statusXml(ProviderXml xmlStatus) {
        try {
            companyCredentialsStrategy.getCredentials().forEach(c -> {
                esocialStrategy.eSocialStatusXml(xmlStatus);
                /**
                 * Neste ponto o código comunica para a SENIOR que recebeu o Status do XML.
                 * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
                 */
                XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlStatus.id, ProviderStatusType.ON_PROVIDER);
                rest.get(c).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
                LOGGER.info("O Status do xml ID: " + xmlStatus.id + " foi alterado.");
            });
        } catch (Exception e) {
            companyCredentialsStrategy.getCredentials().forEach(c -> {
                XmlUpdateStatusInput input = new XmlUpdateStatusInput(xmlStatus.id, ProviderStatusType.PROVIDER_ERROR);
                rest.get(c).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/xmlUpdateStatus", input);
                LOGGER.info("O Status do xml ID: " + xmlStatus.id + " foi alterado.");
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
    public void sendXml(Credential credential, EsocialEventXmlInput payload) {
        rest.get(credential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/actions/esocialEventXml", payload);
    }
}
