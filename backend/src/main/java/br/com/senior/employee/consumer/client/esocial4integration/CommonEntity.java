package br.com.senior.employee.consumer.client.esocial4integration;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class CommonEntity implements Entity {

    @Id
    @Column(name = "id", updatable = false)
    protected UUID id;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
