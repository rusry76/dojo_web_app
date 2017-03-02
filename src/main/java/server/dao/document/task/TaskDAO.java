package server.dao.document.task;

import server.model.document.entity.Task;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class TaskDAO implements TaskDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Task task) {
        manager.persist(task);
    }

    @Override
    public void edit(Task task) {
        manager.merge(task);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public Task getById(long id) {
        return manager.find(Task.class, id);
    }

    @Override
    public Collection<Task> getAll() {
        return null;
    }
}
