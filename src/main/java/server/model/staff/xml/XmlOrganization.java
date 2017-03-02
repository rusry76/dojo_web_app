package server.model.staff.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Organization")
@XmlAccessorType(XmlAccessType.FIELD) //Если не указать эту аннотацию, то программа подумает что все поля дублируются из-за гетторов и сетторов
public class XmlOrganization extends XmlAbstractStaff {

    @XmlElement(name = "orgFullName")
    private String orgFullName; //Полное наименование организации

    @XmlElement(name = "orgShortName")
    private String orgShortName; //Краткое наименование организации

    @XmlElement(name = "Person")
    private XmlPerson person; //Руководитель

    @XmlElement(name = "phone")
    @XmlElementWrapper
    private List<Long> phones;

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
