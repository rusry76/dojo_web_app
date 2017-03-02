package server.model.staff;

import server.model.staff.xml.XmlPerson;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlPersonCollection {

    @XmlElement(name = "person")
    @XmlElementWrapper(name = "persons")
    private List<XmlPerson> persons;

    public List<XmlPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<XmlPerson> persons) {
        this.persons = persons;
    }
}
