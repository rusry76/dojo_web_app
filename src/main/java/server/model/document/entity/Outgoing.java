package server.model.document.entity;

import server.model.staff.entity.Person;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "outgoing_document")
public class Outgoing extends AbstractDocument {

    @ManyToOne
    private Person recipient; //адресат

    @Column(name = "method")
    private String deliveryMethod; //способ доставки

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public String toString() {
        return "Outgoing{" +
                "recipient='" + recipient + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }
}
