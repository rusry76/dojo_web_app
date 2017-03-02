package server.dao.staff.organization;

import server.model.staff.entity.Organization;
import server.model.staff.entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Stateless
public class OrganizationDAO implements OrganizationDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Organization organization) {
        manager.persist(organization);
    }

    @Override
    public void edit(Organization organization) {
        manager.merge(organization);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public Organization getById(long id) {
        return manager.find(Organization.class, id);
    }

    @Override
    public Collection<Organization> getAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Organization> query = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = query.from(Organization.class);
        query.select(organizationRoot);
        TypedQuery<Organization> typedQuery = manager.createQuery(query);

        return typedQuery.getResultList();
    }
}
