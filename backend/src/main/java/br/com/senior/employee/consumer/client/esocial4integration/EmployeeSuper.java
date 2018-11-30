package br.com.senior.employee.consumer.client.esocial4integration;

import javax.persistence.Transient;
import java.util.List;

public class EmployeeSuper extends CommonEntity {

    /**
     * Deficiência do colaborador.
     */
    @Transient
    private List<DeficiencyEntity> deficiencies;

    public List<DeficiencyEntity> getDeficiencies() {
        return deficiencies;
    }

    public void setDeficiencies(List<DeficiencyEntity> deficiencies) {
        this.deficiencies = deficiencies;
    }
}
