package br.com.senior.employee.consumer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "employee")
public class EmployeeThird {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private Long code;
    private String name;
    @Column(name = "integration_type")
    private String integrationType;
    @Column(name = "integration_id")
    private String integrationId;
    @Column(name = "date_when")
    private LocalDateTime dateWhen;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public LocalDateTime getDateWhen() {
        return dateWhen;
    }

    public void setDateWhen(LocalDateTime dateWhen) {
        this.dateWhen = dateWhen;
    }

    @Override
    public String toString() {
        return "Data: " + dateWhen + "<br />" +
                "Código do colaborador: " + code + "<br />" +
                "Nome do colaborador: " + name + "<br />" +
                "Id de integração: " + integrationId + "<br />" +
                "Tipo de integração: " + integrationType;
    }
}
