package server.model.document.xml;

import server.model.staff.entity.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Outgoing")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlOutgoing extends XmlAbstractDocument {

    private Person recipient; //адресат

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
}
