package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.esocial.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j
@Component
public class EsocialIntegrationStrategyImpl extends EsocialIntegrationStrategy {

    @Override
    public void eSocialStatusXml(XmlStatus status) {
        // Programe aqui a rotina responsável por atualizar o status do XML enviado.
    }

    @Override
    public void returnGovernment(LayoutSituation government) {
        // Programe aqui a rotina responsável por atualizar o recibo/críticas do governo.
    }
}
