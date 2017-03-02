package server.dao.staff.organization;

import server.model.staff.entity.Organization;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface OrganizationDAOLocal {

    public void add(Organization organization);

    public void edit(Organization organization);

    public void delete(long id);

    public Organization getById(long id);

    public Collection<Organization> getAll();
}
