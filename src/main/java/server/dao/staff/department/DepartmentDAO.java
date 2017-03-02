package server.dao.staff.department;

import server.model.staff.entity.Department;
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
public class DepartmentDAO implements DepartmentDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Department department) {
        manager.persist(department);
    }

    @Override
    public void edit(Department department) {
        manager.merge(department);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public Department getById(long id) {
        return manager.find(Department.class, id);
    }

    @Override
    public Collection<Department> getAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Department> query = cb.createQuery(Department.class);
        Root<Department> departmentRoot = query.from(Department.class);
        query.select(departmentRoot);
        TypedQuery<Department> typedQuery = manager.createQuery(query);

        return typedQuery.getResultList();
    }
}
