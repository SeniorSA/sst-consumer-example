package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.authentication.Credential;
import br.com.senior.employee.consumer.client.esocial.*;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategy;
import br.com.senior.employee.consumer.rest.Rest;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
     * Este método é executado ao iniciar este sistema para verificar se existem recibos / criticas não consumidas.
     */
    public void consumePendenciesReturnGovernment() {
        LOGGER.info("Consumindo recibos pendentes.");
        companyCredentialsStrategy.getCredentials().forEach(c -> {
            LayoutSituation.PagedResults list;
            do {
                list = getDataReturnGovernment(c).getBody();
                list.contents.forEach(this::returnGovernment);
            } while (containsPendenciesReturnGovernment(list));
        });
    }

    /**
     * Este método é executado ao iniciar este sistema para verificar se existem status dos envios de XML não consumidos.
     */
    public void consumePendenciesStatusIntegration() {
        LOGGER.info("Consumindo status pendentes.");
        companyCredentialsStrategy.getCredentials().forEach(c -> {
            XmlStatus.PagedResults list;
            do {
                list = getDataStatusXml(c).getBody();
                list.contents.forEach(this::statusXml);
            } while (containsPendenciesStatusXml(list));
        });
    }

    /**
     * Método responsável receber o status do XML.
     *
     * @param xmlStatus Entidade referente ao status do envio do XML.
     */
    public void statusXml(XmlStatus xmlStatus) {
        esocialStrategy.eSocialStatusXml(xmlStatus);
    }

    /**
     * Método responsável receber o numero do recibo / critica.
     *
     * @param esocialEvent Retorno do numero do recibo  criticas do evento do esocial enviado.
     */
    public void returnGovernment(LayoutSituation esocialEvent) {
        esocialStrategy.returnGovernment(esocialEvent);
    }

    /**
     * Busca as pendências com status de recibo recebido..
     *
     * @return {@Link ResponseEntity<LayoutSituation.PagedResults>}
     */
    private ResponseEntity<LayoutSituation.PagedResults> getDataReturnGovernment(Credential credential) {
        String filter = "statusType eq RECEIPT_RETURNED";
        return rest.get(credential).exchange(applicationProperties.getG7Location() + "/hcm/esocial/entities/layouSituation?filter=" + filter,
                HttpMethod.GET,
                null,
                LayoutSituation.PagedResults.class);
    }

    /**
     * Busca as pendências com status de erro e de sucesso.
     *
     * @return {@Link ResponseEntity<XmlSituation.PagedResults>}
     */
    private ResponseEntity<XmlStatus.PagedResults> getDataStatusXml(Credential credential) {
        String filter = "statusType eq ERROR_XML or statusType eq SUCESS";
        return rest.get(credential).exchange(applicationProperties.getG7Location() + "/hcm/esocial/entities/statusIntegration?filter=" + filter,
                HttpMethod.GET,
                null,
                XmlStatus.PagedResults.class);
    }

    /**
     * Método responsável por verificar se existem pendencias com recibos não consumidos.
     *
     * @param response
     * @return @{@link boolean}
     */
    private boolean containsPendenciesReturnGovernment(LayoutSituation.PagedResults response) {
        return response.totalElements > 0;
    }

    /**
     * Método responsável por verificar se existem pendências com status ero e sucesso não consumidos.
     *
     * @param response
     * @return @{@link boolean}
     */
    private boolean containsPendenciesStatusXml(XmlStatus.PagedResults response) {
        return response.totalElements > 0;
    }

    /**
     * Envia o XML.
     *
     * @param credential Credenciais.
     * @param payload
     */
    public void sendXml(Credential credential, EsocialEventXmlInput payload) {
        rest.get(credential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/actions/esocialEventXml", payload);
    }
}
