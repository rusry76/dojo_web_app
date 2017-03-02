package server;


import server.model.parser.JaxbParser;
import server.model.staff.XmlDepartmentCollection;
import server.model.staff.XmlOrganizationCollection;
import server.model.staff.XmlPersonCollection;
import server.model.staff.xml.XmlDepartment;
import server.model.staff.xml.XmlOrganization;
import server.model.staff.xml.XmlPerson;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class XmlGetter {

    private JaxbParser jaxbParser = new JaxbParser();

    public List<XmlPerson> getListOfPersons() {
        File xmlPersonFile = getClassLoader("xml/persons.xml");

        List<XmlPerson> persons = null;
        try {
            XmlPersonCollection xmlPersonCollection = (XmlPersonCollection) jaxbParser.getObject(xmlPersonFile, XmlPersonCollection.class);
            persons = xmlPersonCollection.getPersons();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public List<XmlDepartment> getListOfDepartments() {
        File xmlDepartmentFile = getClassLoader("xml/departments.xml");

        List<XmlDepartment> departments = null;
        try {
            XmlDepartmentCollection xmlDepartmentCollection = (XmlDepartmentCollection) jaxbParser.getObject(xmlDepartmentFile, XmlDepartmentCollection.class);
            departments = xmlDepartmentCollection.getDepartments();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return departments;
    }

    public List<XmlOrganization> getListOfOrganizations() {
        File xmlOrganizationsFile = getClassLoader("xml/organizations.xml");

        List<XmlOrganization> organizations = null;
        try {
            XmlOrganizationCollection xmlOrganizationCollection = (XmlOrganizationCollection) jaxbParser.getObject(xmlOrganizationsFile, XmlOrganizationCollection.class);
            organizations = xmlOrganizationCollection.getOrganizations();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return organizations;
    }

    private File getClassLoader(String fileName) {
        File file = null;

        try {
            file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        } catch (NullPointerException e) {
            System.out.println("Нет такого файла");
        }

        return file;
    }
}
