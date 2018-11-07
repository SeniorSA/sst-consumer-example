package br.com.senior.employee.consumer.controller.integration.esocial;


import br.com.senior.employee.consumer.client.esocial.LayoutSituation;
import br.com.senior.employee.consumer.client.esocial.LayoutSituationEventPayload;
import br.com.senior.employee.consumer.client.esocial.XmlSituation;
import br.com.senior.employee.consumer.client.esocial.XmlStatus;

import java.util.List;

public abstract class EsocialIntegrationStrategy {

    abstract void eSocialStatusXml(XmlStatus statusXml);

    abstract void returnGovernment(LayoutSituation government);
}
