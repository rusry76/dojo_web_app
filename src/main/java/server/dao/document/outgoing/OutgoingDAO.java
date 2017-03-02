package server.dao.document.outgoing;

import server.model.document.entity.Outgoing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class OutgoingDAO implements OutgoingDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Outgoing outgoing) {
        manager.persist(outgoing);
    }

    @Override
    public void edit(Outgoing outgoing) {
        manager.merge(outgoing);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public Outgoing getById(long id) {
        return manager.find(Outgoing.class, id);
    }

    @Override
    public Collection<Outgoing> getAll() {
        return null;
    }
}
