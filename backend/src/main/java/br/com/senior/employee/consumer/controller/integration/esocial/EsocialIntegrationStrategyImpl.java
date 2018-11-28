package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.esocial.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EsocialIntegrationStrategyImpl extends EsocialIntegrationStrategy {

    @Override
    public void eSocialStatusXml(XmlOutput xmlOutput) {
        switch (xmlOutput.xmlStatus) {
            case GOVERNMENT_RETURN: // Retorno do governo
                if (xmlOutput.esocialReturnType == StatusType.RECEIPT_RETURNED) {
                    // Tratar o retorno do recibo
                } else if (xmlOutput.esocialReturnType == StatusType.ERROR_RETURNED) {
                    // Tratar as críticas/erros retornados pelo governo
                }
                break;
            case VALIDATION_ERROR: // Erro na validação do XML
                break;
            case VALIDATION_SUCCESS: // XML validado com sucesso
                break;
        }
    }
}
