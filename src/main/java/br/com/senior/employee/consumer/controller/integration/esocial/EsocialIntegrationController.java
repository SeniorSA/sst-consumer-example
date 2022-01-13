package br.com.senior.employee.consumer.controller.integration.esocial;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
import br.com.senior.employee.consumer.client.esocial.ProviderStatusType;
import br.com.senior.employee.consumer.client.esocial.SendEsocialXmlInput;
import br.com.senior.employee.consumer.client.esocial.SendEsocialXmlOutput;
import br.com.senior.employee.consumer.client.esocial.StatusEsocialXmlDTO;
import br.com.senior.employee.consumer.client.esocial.StatusEsocialXmlInput;
import br.com.senior.employee.consumer.client.esocial.StatusEsocialXmlOutput;
import br.com.senior.employee.consumer.client.esocial.StatusEsocialXmlReceivedInput;
import br.com.senior.employee.consumer.client.esocial.XmlStatusType;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.rest.Rest;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class EsocialIntegrationController {

    @Autowired
    private Rest rest;
    @Autowired
    private EsocialIntegrationStrategy esocialStrategy;
    @Autowired
    private ApplicationProperties applicationProperties;

    /**
     * Método responsável receber as publicações do senior x
     * da alteração do status do XML na plataforma senior x.
     *
     * @param accessKey Chave de acesso da aplicação.
     * @param statusEsocialXmlDTO dto referente ao status do envio do XML.
     */
    public void statusXml(String accessKey, StatusEsocialXmlDTO statusEsocialXmlDTO) {
        KeyCredential keyCredential = rest.getCredentialFromAccessKey(accessKey,statusEsocialXmlDTO.providerCompanyId);
        if (keyCredential == null) {
            LOGGER.error("Não foi encontrada uma credencial para a chave de acesso: " + accessKey + ". A resposta do governo para o evento do eSocial com ID: " + statusEsocialXmlDTO.eventId + " não será consumida.");
            return;
        }

        try {
            esocialStrategy.eSocialStatusXml(statusEsocialXmlDTO);
            /**
            * Neste ponto o código comunica para a SENIOR que recebeu o Status do XML.
            * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
            */
            StatusEsocialXmlReceivedInput input = new StatusEsocialXmlReceivedInput(statusEsocialXmlDTO.id, ProviderStatusType.ON_PROVIDER);
            rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/statusEsocialXmlReceived", input);
            LOGGER.info("O Status do xml ID: " + statusEsocialXmlDTO.id + " foi alterado.");
        } catch (Exception e) {
            LOGGER.error("Erro na integração do xml ID: " + statusEsocialXmlDTO.id, e);
            StatusEsocialXmlReceivedInput input = new StatusEsocialXmlReceivedInput(statusEsocialXmlDTO.id, ProviderStatusType.PROVIDER_ERROR, e.getMessage());
            rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/signals/statusEsocialXmlReceived", input);
        }
    }

    /**
     * Envia o XML para a plataforma senior x.
     *
     * @param credential Credenciais.
     * @param payload    Payload.
     * @return dto com as informações do xml na plataforma senior x
     */
    public StatusEsocialXmlDTO sendXml(KeyCredential credential, SendEsocialXmlInput payload) {
        HttpEntity<SendEsocialXmlInput> request = new HttpEntity<>(payload);
        SendEsocialXmlOutput sendEsocialXmlOutput = new SendEsocialXmlOutput(new StatusEsocialXmlDTO());

        if (credential == null || StringUtils.isBlank(credential.accessKey)) {
            logInfo(sendEsocialXmlOutput.result, XmlStatusType.SEND_XML_ERROR, "Não foi informada uma credencial contendo uma chave de acesso para envio do evento do eSocial.");
        } else if (rest.getCredentialFromAccessKey(credential.accessKey) == null) {
            logInfo(sendEsocialXmlOutput.result, XmlStatusType.SEND_XML_ERROR, "Não foi encontrada uma credencial para a chave de acesso: " + credential.accessKey + ".");
        } else if (payload == null || StringUtils.isBlank(payload.xml)) {
            logInfo(sendEsocialXmlOutput.result, XmlStatusType.SEND_XML_ERROR, "Não foi informado o XML referente ao evento do eSocial.");
        } else {
            try {
                sendEsocialXmlOutput = rest.getWithKey(credential).postForObject(applicationProperties.getG7Location() + "/hcm/esocial/actions/sendEsocialXml", //
                                                                                                      request, //
                                                                                                      SendEsocialXmlOutput.class);

                LOGGER.info("O XML do eSocial de id:" + sendEsocialXmlOutput.result.id + " foi enviado para a plataforma SeniorX.");
            } catch (HttpClientErrorException e) {
                logInfo(sendEsocialXmlOutput.result, XmlStatusType.SEND_XML_ERROR, "Falha no envio do evento do eSocial para a plataforma da Senior. Erro: " + e.getMessage());
            } catch (ResourceAccessException e) {
                logInfo(sendEsocialXmlOutput.result, XmlStatusType.SEND_XML_ERROR, "Não foi possível enviar o evento do eSocial a plataforma da Senior. Erro: " + e.getMessage());
            }
        }

        try{
            esocialStrategy.eSocialStatusXml(sendEsocialXmlOutput.result);
        }catch (Exception e) {
            LOGGER.error("Erro na integração do XML ID: " + sendEsocialXmlOutput.result.providerXmlId, e);
        }

        return sendEsocialXmlOutput.result;
    }

    /**
     * Busca pelo status de um xml na plataforma senior x.
     *
     * @param credential credencias de acesso ao senior x
     * @param statusEsocialXmlInput payload com o id do xml que se quer sabe o status
     * @return status do xml na plataforma senior x
     */
    public List<StatusEsocialXmlDTO> statusEsocialXml(KeyCredential credential, StatusEsocialXmlInput statusEsocialXmlInput) {
        HttpEntity<StatusEsocialXmlInput> request = new HttpEntity<>(statusEsocialXmlInput);
        StatusEsocialXmlOutput statusEsocialXmlOutput = new StatusEsocialXmlOutput();

        try {
            statusEsocialXmlOutput = rest.getWithKey(credential).postForObject(applicationProperties.getG7Location() + "/hcm/esocial/queries/statusEsocialXml", //
                                                                                                      request, //
                                                                                                      StatusEsocialXmlOutput.class);
        } catch (HttpClientErrorException e) {
            LOGGER.info("Credencial inválida para o usuário: " + credential.tenantName);
        } catch (ResourceAccessException e) {
            LOGGER.info("URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.");
        }

        if (statusEsocialXmlOutput.result != null) {
            for(StatusEsocialXmlDTO statusEsocialXmlDTO : statusEsocialXmlOutput.result) {
                try{
                    esocialStrategy.eSocialStatusXml(statusEsocialXmlDTO);
                }catch (Exception e) {
                    LOGGER.error("Erro na integração do XML ID: " + statusEsocialXmlDTO.providerXmlId, e);
                }
            }
        }

        return statusEsocialXmlOutput.result;
    }

    private void logInfo(StatusEsocialXmlDTO statusEsocialXmlDTO, XmlStatusType xmlStatusType, String message) {
        statusEsocialXmlDTO.xmlStatus = xmlStatusType;
        statusEsocialXmlDTO.validationMessage = message;
        LOGGER.info(message);
    }

}
