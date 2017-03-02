package server.rest.service.document.task;

import server.model.document.entity.Task;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface ITaskService {

    public void add(Task task);

    public void edit(Task task);

    public void delete(long id);

    public Task getById(long id);

    public Collection<Task> getAll();
}
