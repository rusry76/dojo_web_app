package server.model.document.xml;

import server.model.staff.entity.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "Incoming")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlIncoming extends XmlAbstractDocument {

    private Person sender; //отправитель

    private Person recipient; //адресат

    private long outgoingNumber; //исходящий номер

    private Date outgoingDate; //дата отправления

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
}
