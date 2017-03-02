package server.model.staff.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department extends AbstractStaff {

    @Column(name = "full_name")
    private String depFullName; //Полное наименование департамента

    @Column(name = "short_name")
    private String depShortName; //Краткое наименование департамента

    @OneToOne(cascade=CascadeType.ALL)
    private Person person; //Руководитель

    @ElementCollection
    private List<Long> phones; //Список контактов

    public String getDepFullName() {
        return depFullName;
    }

    public void setDepFullName(String depFullName) {
        this.depFullName = depFullName;
    }

    public String getDepShortName() {
        return depShortName;
    }

    public void setDepShortName(String depShortName) {
        this.depShortName = depShortName;
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
