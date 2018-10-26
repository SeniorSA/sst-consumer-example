package br.com.senior.employee.consumer.controller;

import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.entity.EmployeeEntity;
import br.com.senior.employee.consumer.pojos.common.SubscriptionType;
import br.com.senior.employee.consumer.pojos.esocial.*;
import br.com.senior.employee.consumer.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class LayoutS1060Controller {

    @Autowired
    private Rest rest;
    @Autowired
    private ApplicationProperties applicationProperties;

    public void layout1060Event(EmployeeEntity employee) {
        /*
            Aqui vemos a compilação de um layout do e-Social e o seu cadastro no sistema Senior, neste exemplo enviamos um S-1060.
         */
        ESocialS1060 eSocialS1060 = new ESocialS1060();
        eSocialS1060.evtTabAmbiente = new EvtTabAmbienteS1060();
        eSocialS1060.evtTabAmbiente.id = "ID448420131245490" + getTemporaryId();
        eSocialS1060.evtTabAmbiente.ideEmpregador = new IdeEmpregadorS1060();
        eSocialS1060.evtTabAmbiente.ideEmpregador.nrInsc = "028";
        eSocialS1060.evtTabAmbiente.ideEmpregador.tpInsc = SubscriptionType.CNPJ;
        eSocialS1060.evtTabAmbiente.ideEvento = new IdeEventoS1060();
        eSocialS1060.evtTabAmbiente.ideEvento.procEmi = EventEmissionType.EMPLOYER;
        eSocialS1060.evtTabAmbiente.ideEvento.tpAmb = EnvironmentIdType.PRODUCTION;
        eSocialS1060.evtTabAmbiente.ideEvento.verProc = "1.0.2";
        eSocialS1060.evtTabAmbiente.infoAmbiente = new InfoAmbienteS1060();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao = new InclusaoS1060();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.ideAmbiente = new IdeAmbienteS1060();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.ideAmbiente.codAmb = "1010" + getTemporaryId();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.ideAmbiente.iniValid = "2018-12";
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente = new DadosAmbienteS1060();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.dscAmb = "Ambiente " + employee.getName();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.localAmb = EnvironmentModeType.EMPLOYER;
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.nrInsc = "028";
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.tpInsc = SubscriptionType.CNPJ;
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.fatorRisco = new ArrayList<>();
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.fatorRisco.add(new FatorRiscoS1060(new GovernmentTable("01.01.001", "Infrassom e sons de baixa frequência")));

        LayoutS1060 layoutS1060 = new LayoutS1060();
        layoutS1060.operationType = OperationType.INSERT;
        layoutS1060.layoutSourceType = LayoutSourceType.THIRD_PARTY_INTEGRATION;
        layoutS1060.receiptNumber = "abc" + getTemporaryId();
        layoutS1060.jsonText = eSocialS1060;

        // Cadastra o layout S-1060 na Senior
        rest.get().postForLocation(applicationProperties.getG7Location() + "/hcm/esocial/entities/layoutS1060", layoutS1060);
    }

    private String getTemporaryId() {
        String value = String.valueOf(Math.abs(new Random().nextLong())); //NOSONAR
        if (value.length() < 19) return getTemporaryId();
        return value;
    }
}
