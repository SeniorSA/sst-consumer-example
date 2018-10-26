package br.com.senior.employee.consumer.handler;

import br.com.senior.employee.consumer.entity.LayoutThird;
import br.com.senior.employee.consumer.pojos.esocial.LayoutSituationEventPayload;
import br.com.senior.employee.consumer.repository.LayoutThirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.StringJoiner;
import java.util.UUID;

@RestController
@RequestMapping(path = "/layout")
public class LayoutEventHandler {

    @Autowired
    private LayoutThirdRepository repository;

    /**
     * Método responsável por listar os dados cadastrados na entidade {@link LayoutThird}.
     *
     * @return Pseudo HTML com os dados dos layouts cadastrados.
     */
    @GetMapping(path = "/list")
    public @ResponseBody
    String list() {
        StringJoiner result = new StringJoiner("<br />");

        repository.findAllByOrderByDateWhenDesc()
                .forEach(f -> {
                    result.add(f.toString());
                    result.add("---");
                });

        return result.toString();
    }

    /**
     * Endpoint que recebe um POST.
     * Uma REGRA deve ser cadastrada no EVENTO layoutSituationEvent.
     * Este endpoint será invocado quando uma ação de cadastro de layout (S-1060, S-1065 ETC) ocorrer.
     *
     * @param payload Dados do layout.
     */
    @PostMapping(path = "/event")
    public void layoutEvent(@RequestBody LayoutSituationEventPayload payload) {
        LayoutThird layoutThird = new LayoutThird();
        layoutThird.setDateWhen(LocalDateTime.now());
        layoutThird.setId(UUID.randomUUID());
        layoutThird.setLayoutId(payload.layoutId);
        layoutThird.setReceiptNumber(payload.receiptNumber);
        layoutThird.setMessage(payload.message);

        repository.save(layoutThird);
    }
}
