package server.model.staff.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Department")
@XmlAccessorType(XmlAccessType.FIELD) //Если не указать эту аннотацию, то программа подумает что все поля дублируются из-за гетторов и сетторов
public class XmlDepartment extends XmlAbstractStaff {

    @XmlElement(name = "depFullName")
    private String depFullName; //Полное наименование департамента

    @XmlElement(name = "depShortName")
    private String depShortName; //Краткое наименование департамента

    @XmlElement(name = "Person")
    private XmlPerson person; //Руководитель

    @XmlElement(name = "phone")
    @XmlElementWrapper
    private List<Long> phones;

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

    public XmlPerson getPerson() {
        return person;
    }

    public void setPerson(XmlPerson person) {
        this.person = person;
    }

    public List<Long> getPhones() {
        return phones;
    }

    public void setPhones(List<Long> phones) {
        this.phones = phones;
    }
}
