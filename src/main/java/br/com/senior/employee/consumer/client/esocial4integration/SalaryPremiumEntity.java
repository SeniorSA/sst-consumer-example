package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="salary_premium")
public class SalaryPremiumEntity {

    /**
     * Id interno da entidade.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
	private java.util.UUID id;

    /**
     * Data de inicio
     */
    @Column(name = "date_when")
    private java.time.LocalDate dateWhen;

    /**
     * Data fim
     */
    @Column(name = "end_date")
    private java.time.LocalDate endDate;

    /**
     * Insalubridade
     */
    @Column(name = "insalubrity")
    private Double insalubrity;

    /**
     * Periculosidade
     */
    @Column(name = "hazard")
    private Double hazard;

    /**
     * Fator tempo de serviço
     */
    @Column(name = "length_of_service")
    private Double lengthOfService;

    /**
     * Aposentadoria especial
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "special_retirement_type")
    private SpecialRetirementType specialRetirementType;

	public java.util.UUID getId() {
		return id;
	}

    public java.time.LocalDate getDateWhen() {
        return dateWhen;
    }

    public java.time.LocalDate getEndDate() {
        return endDate;
    }

    public Double getInsalubrity() {
        return insalubrity;
    }

    public Double getHazard() {
        return hazard;
    }

    public Double getLengthOfService() {
        return lengthOfService;
    }

    public SpecialRetirementType getSpecialRetirementType() {
        return specialRetirementType;
    }

	public void setId(java.util.UUID id) {
		this.id = id;
	}

    public void setDateWhen(java.time.LocalDate dateWhen) {
        this.dateWhen = dateWhen;
    }

    public void setEndDate(java.time.LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setInsalubrity(Double insalubrity) {
        this.insalubrity = insalubrity;
    }

    public void setHazard(Double hazard) {
        this.hazard = hazard;
    }

    public void setLengthOfService(Double lengthOfService) {
        this.lengthOfService = lengthOfService;
    }

    public void setSpecialRetirementType(SpecialRetirementType specialRetirementType) {
        this.specialRetirementType = specialRetirementType;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SalaryPremiumEntity)) {
            return false;
        }
        SalaryPremiumEntity other = (SalaryPremiumEntity) obj;
        if (id == null) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen).append(", ");
        sb.append("endDate=").append(endDate == null ? "null" : endDate).append(", ");
        sb.append("insalubrity=").append(insalubrity == null ? "null" : insalubrity).append(", ");
        sb.append("hazard=").append(hazard == null ? "null" : hazard).append(", ");
        sb.append("lengthOfService=").append(lengthOfService == null ? "null" : lengthOfService).append(", ");
        sb.append("specialRetirementType=").append(specialRetirementType == null ? "null" : specialRetirementType);
        sb.append(']');
        return sb.toString();
    }

}
