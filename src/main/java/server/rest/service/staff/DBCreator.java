package server.rest.service.staff;

import server.convertor.ConvertXmlToEntity;
import server.model.document.entity.Folder.Folder;
import server.model.staff.entity.Department;
import server.model.staff.entity.Organization;
import server.model.staff.entity.Person;
import server.rest.service.folder.IFolderService;
import server.rest.service.staff.department.IDepartmentService;
import server.rest.service.staff.organization.IOrganizationService;
import server.rest.service.staff.person.IPersonService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;


@Singleton
@Startup
public class DBCreator {

    private ConvertXmlToEntity convertXmlToEntity = new ConvertXmlToEntity();

    @EJB
    private IPersonService personService;

    @EJB
    private IDepartmentService departmentService;

    @EJB
    private IOrganizationService organizationService;

    @EJB
    private IFolderService folderService;

    public DBCreator() {
    }

    @PostConstruct
    private void create() {
        createPersonDBTable();
        createDepartmentDBTable();
        createOrganizationDBTable();
        createFolderDBTable();
    }


    private void createPersonDBTable() {
        List<Person> persons = convertXmlToEntity.getPersons();

        for (Person person: persons) {
            personService.add(person);
        }
    }

    private void createDepartmentDBTable() {
        List<Department> departments = convertXmlToEntity.getDepartments();

        for (Department department: departments) {
            departmentService.add(department);
        }
    }

    private void createOrganizationDBTable() {
        List<Organization> organizations = convertXmlToEntity.getOrganizations();

        for (Organization organization: organizations) {
            organizationService.add(organization);
        }
    }

    private void createFolderDBTable() {

        Folder rootFolder = new Folder(0, "root", "root");
        folderService.add(rootFolder);

        Folder folder_2_1 = new Folder(rootFolder.getId(), "folder_2_1", "folder_2_1");
        Folder folder_2_2 = new Folder(rootFolder.getId(), "folder_2_2", "folder_2_2");
        folderService.add(folder_2_1);
        folderService.add(folder_2_2);

        Folder folder_2_1_1 = new Folder(folder_2_1.getId(), "folder_2_1_1", "folder_2_1_1");
        Folder folder_2_1_2 = new Folder(folder_2_1.getId(), "folder_2_1_2", "folder_2_1_2");
        folderService.add(folder_2_1_1);
        folderService.add(folder_2_1_2);

        Folder folder_2_2_1 = new Folder(folder_2_2.getId(), "folder_2_2_1", "folder_2_2_1");
        folderService.add(folder_2_2_1);
    }
}
