/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "company_branch")
public class CompanyBranchEntity {

    /**
     * Id interno da entidade.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private java.util.UUID id;

    /**
     * Código da filial.
     */
    @Column(name = "code")
    private Long code;

    /**
     * Nome da filial.
     */
    @Column(name = "name")
    private String name;

    /**
     * Inscrição da filial.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type")
    private SubscriptionType subscriptionType;

    /**
     * Número da inscrição.
     */
    @Column(name = "subscription_number", length = 14)
    private String subscriptionNumber;

    /**
     * Data do histórico da filial (A partir de).
     */
    @Column(name = "date_when")
    private java.time.LocalDate dateWhen;

    public java.util.UUID getId() {
        return this.id;
    }

    public Long getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public SubscriptionType getSubscriptionType() {
        return this.subscriptionType;
    }

    public String getSubscriptionNumber() {
        return this.subscriptionNumber;
    }

    public java.time.LocalDate getDateWhen() {
        return this.dateWhen;
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

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public void setSubscriptionNumber(String subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    public void setDateWhen(java.time.LocalDate dateWhen) {
        this.dateWhen = dateWhen;
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
        if (!(obj instanceof CompanyBranchEntity)) {
            return false;
        }
        CompanyBranchEntity other = (CompanyBranchEntity) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("name=").append(name == null ? "null" : name).append(", ");
        sb.append("subscriptionType=").append(subscriptionType == null ? "null" : subscriptionType).append(", ");
        sb.append("subscriptionNumber=").append(subscriptionNumber == null ? "null" : subscriptionNumber).append(", ");
        sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
        sb.append(']');
        return sb.toString();
    }

}
