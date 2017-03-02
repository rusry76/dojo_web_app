package server.model.staff.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization extends AbstractStaff {

    @Column(name = "full_name")
    private String orgFullName; //Полное наименование организации

    @Column(name = "short_name")
    private String orgShortName; //Краткое наименование организации

    @OneToOne(cascade=CascadeType.ALL)
    private Person person; //Руководитель

    @ElementCollection
    private List<Long> phones;  //Список контактов

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Long> getPhones() {
        return phones;
    }

    public void setPhones(List<Long> phones) {
        this.phones = phones;
    }
}
