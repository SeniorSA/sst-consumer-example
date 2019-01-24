package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.esocial.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EsocialIntegrationStrategyImpl extends EsocialIntegrationStrategy {

    @Override
    public void eSocialStatusXml(XmlOutput xmlOutput) {
        /*
         * O status dos eventos do eSocial (XML) enviados a plataforma SeniorX são
         * retornados ao sistema do prestador SST por esse método.
         */
        switch (xmlOutput.xmlStatus) {
            case VALIDATION_SUCCESS:
                /*
                 * Antes do envio ao governo, todos os XML recebidos do prestador SST são validados.
                 * Essa rotina será chamada se o XML foi validado com sucesso e está pronto para envio ao governo.
                 * Se desejar, atualize o status do envio do XML no sistema do prestador SST
                 * com a indicação que ele está pronto para envio ao governo pela plataforma SeniorX.
                 */
                break;

            case VALIDATION_ERROR:
                /*
                 * Foram encontrados erros na validação do XML do eSocial.
                 * Se desejar, atualize o status do envio do XML no sistema do prestador SST, indicando
                 * que o XML não será enviado ao governo devido a problemas encontrados na validação.
                 * O erro encontrado na validação pode ser consultado através do atributo xmlOutput.message.
                 */
                break;

            case GOVERNMENT_RETURN:
                if (xmlOutput.esocialReturnType == StatusType.RECEIPT_RETURNED) {
                    /*
                     * O governo retornou o recibo do XML do evento do eSocial.
                     * Atualize o status do envio do XML no sistema do prestador SST e atribua o recibo ao
                     * respectivo evento.
                     */
                } else if (xmlOutput.esocialReturnType == StatusType.ERROR_RETURNED) {
                    /*
                     * O governo retornou críticas/erros referente ao XML do evento do eSocial.
                     * Atualize o status do envio do XML no sistema do prestador SST. As críticas/erros retornados
                     * podem ser consultados através do atributo xmlOutput.message.
                     */
                }
                break;
        }
    }
}