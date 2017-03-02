package server.dao.folder;


import server.model.document.entity.Folder.Folder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Stateless
public class FolderDAO implements FolderDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Folder folder) {
        manager.persist(folder);
    }

    @Override
    public void edit(Folder folder) {
        manager.merge(folder);
    }

    @Override
    public void remove(long id) {
        manager.remove(findById(id));
    }

    @Override
    public Folder findById(long id) {
        return manager.find(Folder.class, id);
    }

    @Override
    public Collection<Folder> getAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Folder> query = cb.createQuery(Folder.class);
        Root<Folder> folderRoot = query.from(Folder.class);
        query.select(folderRoot);
        TypedQuery<Folder> typedQuery = manager.createQuery(query);

        return typedQuery.getResultList();
    }
}
