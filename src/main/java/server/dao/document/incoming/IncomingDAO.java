package server.dao.document.incoming;

import server.model.document.entity.Incoming;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class IncomingDAO implements IncomingDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Incoming incoming) {
        manager.persist(incoming);
    }

    @Override
    public void edit(Incoming incoming) {
        manager.merge(incoming);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public Incoming getById(long id) {
        return manager.find(Incoming.class, id);
    }

    @Override
    public Collection<Incoming> getAll() {
        return null;
    }
}
