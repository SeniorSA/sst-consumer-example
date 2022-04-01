package br.com.senior.employee.consumer.controller.integration.esocial;

import org.springframework.stereotype.Component;

import br.com.senior.employee.consumer.client.esocial.GovernmentReturnType;
import br.com.senior.employee.consumer.client.esocial.StatusEsocialXmlDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class EsocialIntegrationStrategyImpl extends EsocialIntegrationStrategy {

    @Override
    public void eSocialStatusXml(StatusEsocialXmlDTO statusEsocialXmlDTO) {
        /*
         * O status dos eventos do eSocial (XML) enviados a plataforma SeniorX são
         * retornados ao sistema do prestador SST por esse método.
         */
        switch (statusEsocialXmlDTO.xmlStatus) {
            case SEND_XML_ERROR:
                /*
                 * Ao enviar o XML para a plataforma da Senior, caso ocorra algum
                 * erro (como por exemplo falha na autenticação), essa rotina será chamada.
                 * Nesse caso, atualize o status do envio do XML no sistema do
                 * prestador SST, indicando que houve erro e o XML não foi enviado a
                 * plataforma da Senior
                 */
                break;

            case IN_ANALYSIS:
                /*
                 * Ao enviar o XML para a plataforma da Senior, caso não ocorra nenhum
                 * problema no envio, a plataforma da Senior retornará que o XML está em
                 * análise, ou seja, a estrutura do XML e algumas informações estão sendo validadas.
                 * Se desejar, atualize o status do envio do XML no sistema do
                 * prestador SST, indicando que XML está sendo validado.
                 */
                break;
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

            case SENDING_TO_GOVERNMENT:
                /*
                 * O XML está sendo enviando para o governo.
                 * Se desejar, atualize o status do envio do XML no sistema do prestador SST, indicando
                 * que o XML não será enviado ao governo devido a problemas encontrados na validação.
                 */
                break;

            case WAITING_GOVERNMENT_RETURN:
                /*
                 * O XML já foi enviado para o governo e está aguardando um retorno.
                 * Se desejar, atualize o status do envio do XML no sistema do prestador SST, indicando
                 * que o XML não será enviado ao governo devido a problemas encontrados na validação.
                 */
                break;

            case CANCELED_BY_USER:
                /**
                 * O evento do esocial foi cancelado pelo usuário na plataforma Senior X.
                 * Nesse caso, atualize o status do envio do XML no sistema do
                 * prestador SST, indicando que o XML foi cancelado pelo usuário na
                 * plataforma da Senior
                 */
                break;

            case GOVERNMENT_RETURN:
                if (statusEsocialXmlDTO.governmentReturnType == GovernmentReturnType.RECEIPT_RETURNED) {
                    /*
                     * O governo retornou o recibo do XML do evento do eSocial.
                     * Atualize o status do envio do XML no sistema do prestador SST e atribua o recibo ao
                     * respectivo evento.
                     */
                } else if (statusEsocialXmlDTO.governmentReturnType == GovernmentReturnType.MESSAGE_RETURNED) {
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