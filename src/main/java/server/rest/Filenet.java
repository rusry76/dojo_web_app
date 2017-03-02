package server.rest;


import com.google.gson.Gson;
import server.model.document.entity.Folder.Folder;
import server.model.staff.entity.Person;
import server.rest.service.folder.IFolderService;
import server.rest.service.staff.department.IDepartmentService;
import server.rest.service.staff.organization.IOrganizationService;
import server.rest.service.staff.person.IPersonService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/ecm")
public class Filenet {

    @EJB
    private IPersonService personService;

    @EJB
    private IDepartmentService departmentService;

    @EJB
    private IOrganizationService organizationService;

    @EJB
    private IFolderService folderService;

    @GET
    @Path("/employees")
    @Produces("application/json")
    public Collection<Person> getPersons() {
        return personService.getAll();
    }

    @POST
    @Path("/edit")
    public void addPerson(String str) {
        Gson gson = new Gson();
        Person person = gson.fromJson(str, Person.class);

        personService.add(person);

        getPersons();
    }


    @POST
    @Path("/delete")
    public void deletePerson(String str) {
        Gson gson = new Gson();
        Person person = gson.fromJson(str, Person.class);

        personService.delete(person.getId());

        getPersons();
    }

    @GET
    @Path("/folders")
    @Produces("application/json")
    public Collection<Folder> getFolders() {
        return folderService.getAll();
    }

    @GET
    @Path("/folders")
    @Produces(MediaType.APPLICATION_JSON)
    public Folder getFolder(@QueryParam("id") long id) {
        return folderService.findById(id);
    }
}
