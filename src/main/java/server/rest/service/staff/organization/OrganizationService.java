package server.rest.service.staff.organization;

import server.dao.staff.organization.OrganizationDAOLocal;
import server.model.staff.entity.Organization;
import server.rest.service.staff.DBCreator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class OrganizationService implements IOrganizationService {

    @EJB
    private OrganizationDAOLocal organizationDAOLocal;

    @Override
    public void add(Organization organization) {
        organizationDAOLocal.add(organization);
    }

    @Override
    public void edit(Organization organization) {
        organizationDAOLocal.edit(organization);
    }

    @Override
    public void delete(long id) {
        organizationDAOLocal.delete(id);
    }

    @Override
    public Organization getById(long id) {
        return organizationDAOLocal.getById(id);
    }

    @Override
    public Collection<Organization> getAll() {
        return organizationDAOLocal.getAll();
    }
}
