package server.dao.document;


import server.model.document.entity.AbstractDocument;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class DocumentDAO implements DocumentDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(AbstractDocument abstractDocument) {
        manager.persist(abstractDocument);
    }

    @Override
    public void edit(AbstractDocument abstractDocument) {
        manager.merge(abstractDocument);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public AbstractDocument getById(long id) {
        return manager.find(AbstractDocument.class, id);
    }

    @Override
    public Collection<AbstractDocument> getAll() {
        return null;
    }
}
