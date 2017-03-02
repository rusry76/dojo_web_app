package server.rest.service.document.task;

import server.dao.document.task.TaskDAOLocal;
import server.model.document.entity.Task;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class TaskService implements ITaskService {

    @EJB
    private TaskDAOLocal taskDAOLocal;

    @Override
    public void add(Task task) {
        taskDAOLocal.add(task);
    }

    @Override
    public void edit(Task task) {
        taskDAOLocal.edit(task);
    }

    @Override
    public void delete(long id) {
        taskDAOLocal.delete(id);
    }

    @Override
    public Task getById(long id) {
        return taskDAOLocal.getById(id);
    }

    @Override
    public Collection<Task> getAll() {
        return taskDAOLocal.getAll();
    }
}
