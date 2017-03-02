package server.rest.service.staff.department;

import server.dao.staff.department.DepartmentDAOLocal;
import server.model.staff.entity.Department;
import server.rest.service.staff.DBCreator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class DepartmentService implements IDepartmentService {

    @EJB
    private DepartmentDAOLocal departmentDAOLocal;

    @Override
    public void add(Department department) {
        departmentDAOLocal.add(department);
    }

    @Override
    public void edit(Department department) {
        departmentDAOLocal.edit(department);
    }

    @Override
    public void delete(long id) {
        departmentDAOLocal.delete(id);
    }

    @Override
    public Department getById(long id) {
        return departmentDAOLocal.getById(id);
    }

    @Override
    public Collection<Department> getAll() {
        return departmentDAOLocal.getAll();
    }
}
