package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.esocial.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EsocialIntegrationStrategyImpl extends EsocialIntegrationStrategy {

    @Override
    public void eSocialStatusXml(XmlEventData status) {
        // Programe aqui a rotina responsável por atualizar o status do XML enviado ou atualizar o recibo/críticas do governo.

        switch (status.xmlStatusType) {
            case GOVERNMENT_RETURN: // Retorno do governo
                if (status.statusType == StatusType.RECEIPT_RETURNED) {
                    // Tratar o retorno do recibo
                } else if (status.statusType == StatusType.ERROR_RETURNED) {
                    // Tratar as críticas/erros retornados pelo governo
                }
                break;
            case VALIDATION_ERROR: // Erro na validação do XML

                break;
            case VALIDATION_SUCCESS: // XML validado com sucesso

                break;
            case IN_ANALISYS: // XML em análise

        }
    }
}
