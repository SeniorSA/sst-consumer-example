package br.com.senior.employee.consumer.handler;

import br.com.senior.employee.consumer.entity.EmployeeThird;
import br.com.senior.employee.consumer.repository.EmployeeThirdRepository;
import br.com.senior.employee.consumer.repository.LayoutThirdRepository;
import br.com.senior.employee.consumer.util.Rest;
import br.com.senior.hcm.esocial.*;
import br.com.senior.hcm.esocial4integration.EmployeeEventPayload;
import br.com.senior.hcm.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.hcm.esocial4integration.ProviderStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringJoiner;
import java.util.UUID;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeEventController {

    @Autowired
    private EmployeeThirdRepository employeeThirdRepository;
    @Autowired
    private LayoutThirdRepository layoutThirdRepository;
    @Autowired
    private Rest rest;

    /**
     * Método responsável por listar os dados cadastrados na entidade {@link EmployeeThird}.
     *
     * @return Pseudo HTML com os dados dos colaboradores cadastrados.
     */
    @GetMapping(path = "/list")
    public @ResponseBody String list() {
        StringJoiner result = new StringJoiner("<br />");

        employeeThirdRepository.findAllByOrderByDateWhenDesc()
                .forEach(f -> {
                    result.add(f.toString());
                    result.add("---");
                });

        return result.toString();
    }

    /**
     * Endpoint que recebe um POST.
     * Uma REGRA deve ser cadastrada no EVENTO employeeEvent.
     * Este endpoint será invocado quando uma ação de admissão, alteração de admissão e movimentações (Centro de custo, Local, Cargo, Posto de trabalho e Afastamentos) do colaborador ocorrer.
     *
     * @param payload Dados do colaborador.
     */
    @PostMapping(path = "/event")
    public void employeeEvent(@RequestBody EmployeeEventPayload payload) {
        /*
            O payload virá com todos os dados do colaborador independente do tipo de integração (integrationType).
            Enviamos o integrationType para o provedor SST decidir alterar apenas o que foi alterado do colaborador, ou, por controle do provedor SST salvar sempre todos os dados do colaborador.
            Aqui é feito o 'parse' dos dados do payload para a base interna do provedor SST.
         */
        EmployeeThird employeeThird = new EmployeeThird();
        employeeThird.setDateWhen(LocalDateTime.now());
        employeeThird.setId(UUID.randomUUID());
        employeeThird.setCode(payload.employee.code);
        employeeThird.setName(payload.employee.name);
        employeeThird.setIntegrationType(payload.integrationType.name());
        employeeThird.setIntegrationId(payload.integrationId);

        // Salva os dados do colaborador
        employeeThirdRepository.save(employeeThird);

        /*
            Neste ponto o código comunica para a SENIOR que recebeu o evento e que os dados estão salvos na base do prestador SST.
            Desta forma o cliente saberá que o dado está no provedor SST.
         */
        IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(payload.integrationId, ProviderStatusType.ON_PROVIDER);
        rest.get().postForLocation("https://pcbnu002050.interno.senior.com.br:8243/t/senior.com.br/bridge/1.0/rest/hcm/esocial4integration/signals/integrationUpdateStatus", input);

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
        eSocialS1060.evtTabAmbiente.infoAmbiente.inclusao.dadosAmbiente.dscAmb = "Ambiente " + employeeThird.getName();
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
        rest.get().postForLocation("https://pcbnu002050.interno.senior.com.br:8243/t/senior.com.br/bridge/1.0/rest/hcm/esocial/entities/layoutS1060", layoutS1060);
    }

    private String getTemporaryId() {
        String value = String.valueOf(Math.abs(new Random().nextLong()));
        if (value.length() < 19) return getTemporaryId();
        return value;
    }
}
