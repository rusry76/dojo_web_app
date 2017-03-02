package server.model.staff;

import server.model.staff.xml.XmlOrganization;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlOrganizationCollection {

    @XmlElement
    @XmlElementWrapper
    private List<XmlOrganization> organizations;

    public List<XmlOrganization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<XmlOrganization> organizations) {
        this.organizations = organizations;
    }

    /*public void createOrganizationCollection() {
        organizations = new LinkedList<>();

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

        XmlOrganization transneft = new XmlOrganization();
        transneft.setOrgFullName("Transneft");
        transneft.setOrgShortName("TN");
        transneft.setPerson(ivanov);
        transneft.setPhones(phones);

        XmlOrganization gazneft = new XmlOrganization();
        gazneft.setOrgFullName("Gazneft");
        gazneft.setOrgShortName("GZ");
        gazneft.setPerson(sidorov);
        gazneft.setPhones(phones);

        XmlOrganization gazprom = new XmlOrganization();
        gazprom.setOrgFullName("Gazprom");
        gazprom.setOrgShortName("GP");
        gazprom.setPerson(petrov);
        gazprom.setPhones(phones);

        XmlOrganization uralneft = new XmlOrganization();
        uralneft.setOrgFullName("Uralneft");
        uralneft.setOrgShortName("UN");
        uralneft.setPerson(smolnov);
        uralneft.setPhones(phones);

        organizations.add(transneft);
        organizations.add(gazneft);
        organizations.add(gazprom);
        organizations.add(uralneft);
    }*/
}
