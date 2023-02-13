package br.com.senior.employee.consumer.client.esocial4integration;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="work_environment")
public class WorkEnvironmentEntity {

    /**
     * Id interno da entidade.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private java.util.UUID id;

    /**
     * Local de trabalho.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    public WorkEnvironmentType location;

    /**
     * Código do ambiente de trabalho.
     */
    @Column(name = "code")
    public String code;

    /**
     * Nome do ambiente de trabalho.
     */
    @Column(name = "name")
    public String name;

    /**
     * Tipo de inscrição do ambiente de trabalho.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type")
    public SubscriptionType subscriptionType;

    /**
     * Número de inscrição do ambiente de trabalho.
     */
    @Column(name = "subscription_number")
    public String subscriptionNumber;

    /**
     * Data do histórico de ambiente de trabalho (A partir de).
     */
    @Column(name = "date_when")
    public java.time.LocalDate dateWhen;

    public java.util.UUID getId() {
        return id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public WorkEnvironmentType getLocation() {
        return location;
    }

    public void setLocation(WorkEnvironmentType location) {
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(String subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    public java.time.LocalDate getDateWhen() {
        return dateWhen;
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
        if (!(obj instanceof WorkEnvironmentEntity)) {
            return false;
        }
        WorkEnvironmentEntity other = (WorkEnvironmentEntity) obj;
        if ((id == null) != (other.id == null)) {
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
        sb.append("location=<").append(location == null ? "null" : location).append('>').append(", ");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("name=").append(name == null ? "null" : name).append(", ");
        sb.append("subscriptionType=<").append(subscriptionType == null ? "null" : subscriptionType).append('>').append(", ");
        sb.append("subscriptionNumber=").append(subscriptionNumber == null ? "null" : subscriptionNumber).append(", ");
        sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
        sb.append(']');
        return sb.toString();
    }

}
