/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="reason_leave")
public class ReasonLeaveEntity {

    /**
     * Id interno da entidade.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private java.util.UUID id;

    /**
     * Código do motivo.
     */
    @Column(name = "code")
    private Long code;

    /**
     * Nome do motivo.
     */
    @Column(name = "name")
    private String name;

    /**
     * Data de início do afastamento.
     */
    @Column(name = "start_date")
    private java.time.Instant startDate;

    /**
     * Data de previsão de término do afastamento.
     */
    @Column(name = "estimated_end_date")
    private java.time.LocalDate estimatedEndDate;

    /**
     * Data de término do afastamento.
     */
    @Column(name = "end_date")
    private java.time.Instant endDate;

    public java.util.UUID getPk() {
        return this.id;
    }

    public String getServiceEntityName() {
        return "reasonLeave";
    }

    public java.util.UUID getId() {
        return id;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public java.time.Instant getStartDate() {
        return startDate;
    }

    public java.time.LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public java.time.Instant getEndDate() {
        return endDate;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(java.time.Instant startDate) {
        this.startDate = startDate;
    }

    public void setEstimatedEndDate(java.time.LocalDate estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
    }

    public void setEndDate(java.time.Instant endDate) {
        this.endDate = endDate;
    }

    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReasonLeaveEntity)) {
            return false;
        }
        ReasonLeaveEntity other = (ReasonLeaveEntity) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("name=").append(name == null ? "null" : name).append(", ");
        sb.append("startDate=").append(startDate == null ? "null" : startDate).append(", ");
        sb.append("estimatedEndDate=").append(estimatedEndDate == null ? "null" : estimatedEndDate).append(", ");
        sb.append("endDate=").append(endDate == null ? "null" : endDate);
        sb.append(']');
        return sb.toString();
    }

}