package server.model.staff;

import server.model.staff.xml.XmlDepartment;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDepartmentCollection {

    @XmlElement
    @XmlElementWrapper
    private List<XmlDepartment> departments;

    public List<XmlDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<XmlDepartment> departments) {
        this.departments = departments;
    }

    /*public void createDepartmentCollection() {
        departments = new LinkedList<>();

        XmlPerson ivanov = new XmlPerson();
        ivanov.setLastName("Ivanov");
        ivanov.setFirstName("Ivan");
        ivanov.setPatronymicName("Ivanovich");
        ivanov.setWorkPosition("Director");

        XmlPerson sidorov = new XmlPerson();
        sidorov.setLastName("Sidorov");
        sidorov.setFirstName("Sidor");
        sidorov.setPatronymicName("Sidorovich");
        sidorov.setWorkPosition("Director");

        XmlPerson petrov = new XmlPerson();
        petrov.setLastName("Petrov");
        petrov.setFirstName("Petr");
        petrov.setPatronymicName("Petrovich");
        petrov.setWorkPosition("Director");

        XmlPerson smolnov = new XmlPerson();
        smolnov.setLastName("Smolnov");
        smolnov.setFirstName("Smol");
        smolnov.setPatronymicName("Smolovich");
        smolnov.setWorkPosition("Director");

        List<Long> phones = new LinkedList<>();
        phones.add(111111L);
        phones.add(222222L);
        phones.add(333333L);
        phones.add(444444L);

        XmlDepartment it = new XmlDepartment();
        it.setDepFullName("Information Technology");
        it.setDepShortName("IT");
        it.setPerson(ivanov);
        it.setPhones(phones);

        XmlDepartment transportDep = new XmlDepartment();
        transportDep.setDepFullName("Department of Transport");
        transportDep.setDepShortName("TD");
        transportDep.setPerson(sidorov);
        transportDep.setPhones(phones);

        XmlDepartment economicDep = new XmlDepartment();
        economicDep.setDepFullName("Department of Economic");
        economicDep.setDepShortName("ED");
        economicDep.setPerson(petrov);
        economicDep.setPhones(phones);

        XmlDepartment securityDep = new XmlDepartment();
        securityDep.setDepFullName("Department of Security");
        securityDep.setDepShortName("SD");
        securityDep.setPerson(smolnov);
        securityDep.setPhones(phones);

        departments.add(it);
        departments.add(transportDep);
        departments.add(economicDep);
        departments.add(securityDep);
    }*/
}
