package server.rest.service.staff.department;


import server.model.staff.entity.Department;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface IDepartmentService {

    public void add(Department department);

    public void edit(Department department);

    public void delete(long id);

    public Department getById(long id);

    public Collection<Department> getAll();
}
