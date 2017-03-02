package server.model.document.xml;


import server.model.staff.entity.Person;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlAbstractDocument {

    @XmlElement
    private long id;

    @XmlElement
    private String name;

    @XmlElement
    private String text;

    @XmlElement
    private long registrationNumber;

    @XmlElement
    private Date registrationDate;

    @XmlElement
    private Person author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }
}
