package server.convertor;

import server.XmlGetter;
import server.model.staff.entity.Department;
import server.model.staff.entity.Organization;
import server.model.staff.entity.Person;
import server.model.staff.xml.XmlDepartment;
import server.model.staff.xml.XmlOrganization;
import server.model.staff.xml.XmlPerson;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertXmlToEntity {

    private List<XmlPerson> xmlPersons;
    private List<XmlDepartment> xmlDepartments;
    private List<XmlOrganization> xmlOrganizations;

    public ConvertXmlToEntity() {
        XmlGetter xmlGetter = new XmlGetter();
        this.xmlPersons = xmlGetter.getListOfPersons();
        this.xmlDepartments = xmlGetter.getListOfDepartments();
        this.xmlOrganizations = xmlGetter.getListOfOrganizations();
    }

    private Person personConvert(XmlPerson xmlPerson) {
        Person person = new Person();

        person.setLastName(xmlPerson.getLastName());
        person.setFirstName(xmlPerson.getFirstName());
        person.setPatronymicName(xmlPerson.getPatronymicName());
        person.setWorkPosition(xmlPerson.getWorkPosition());

        return person;
    }

    private Organization organizationConvert(XmlOrganization xmlOrganization) {
        Organization organization = new Organization();

        organization.setOrgFullName(xmlOrganization.getOrgFullName());
        organization.setOrgShortName(xmlOrganization.getOrgShortName());
        organization.setPerson(personConvert(xmlOrganization.getPerson()));
        organization.setPhones(xmlOrganization.getPhones());

        return organization;
    }

    private Department departmentConvert(XmlDepartment xmlDepartment) {
        Department department = new Department();

        department.setDepFullName(xmlDepartment.getDepFullName());
        department.setDepShortName(xmlDepartment.getDepShortName());
        department.setPerson(personConvert(xmlDepartment.getPerson()));
        department.setPhones(xmlDepartment.getPhones());

        return department;
    }

    public List<Person> getPersons() {
        return xmlPersons.stream().map(this::personConvert).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<Department> getDepartments() {
        return xmlDepartments.stream().map(this::departmentConvert).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<Organization> getOrganizations() {
        return xmlOrganizations.stream().map(this::organizationConvert).collect(Collectors.toCollection(LinkedList::new));
    }
}
