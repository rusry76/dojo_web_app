package server.model.document.entity;

import server.model.staff.entity.Person;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "incoming_document")
public class Incoming extends AbstractDocument {

    @ManyToOne
    //@Column(name = "sender") //отправитель
    private Person sender;

    @ManyToOne
    //@Column(name = "recipint") //адресат
    private Person recipient;

    @Column(name = "outgoing_number") //исходящий номер
    private long outgoingNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "outgoing_date") //исходящая дата регистрации
    private Date outgoingDate;


    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public long getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(long outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public Date getOutgoingDate() {
        return outgoingDate;
    }

    public void setOutgoingDate(Date outgoingDate) {
        this.outgoingDate = outgoingDate;
    }

    @Override
    public String toString() {
        return "Incoming{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", outgoingNumber=" + outgoingNumber +
                ", outgoingDate=" + outgoingDate +
                '}';
    }
}
