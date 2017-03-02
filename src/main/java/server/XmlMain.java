package server;

import server.convertor.ConvertXmlToEntity;
import server.model.staff.entity.Department;
import server.model.staff.entity.Organization;
import server.model.staff.entity.Person;

import java.util.List;

public class XmlMain {

    public static void main(String[] args) throws Exception {

        ConvertXmlToEntity convertXmlToEntity = new ConvertXmlToEntity();

        List<Person> persons = convertXmlToEntity.getPersons();

        List<Department> departments = convertXmlToEntity.getDepartments();

        List<Organization> organizations = convertXmlToEntity.getOrganizations();

        for (Person person: persons) {
            System.out.println(person.getFirstName());
        }

        for (Department department: departments) {
            System.out.println(department.getDepFullName());
        }

        for (Organization organization: organizations) {
            System.out.println(organization.getOrgShortName());
        }

    }


}
