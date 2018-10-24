package br.com.senior.employee.consumer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "layout")
public class LayoutThird {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @Column(name = "layout_situation_id")
    private String layoutId;
    @Column(name = "receipt_number")
    private String receiptNumber;
    private String message;
    @Column(name = "date_when")
    private LocalDateTime dateWhen;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public LocalDateTime getDateWhen() {
        return dateWhen;
    }

    public void setDateWhen(LocalDateTime dateWhen) {
        this.dateWhen = dateWhen;
    }

    @Override
    public String toString() {
        return "Data: " + dateWhen + "<br />" + //NOSONAR
                "Id do layout: " + layoutId + "<br />" +
                "Número do recibo: " + receiptNumber + "<br />" +
                "Mensagem de erro: " + message;
    }
}
