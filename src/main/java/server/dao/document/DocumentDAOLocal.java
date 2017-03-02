package server.dao.document;


import server.model.document.entity.AbstractDocument;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface DocumentDAOLocal {

    public void add(AbstractDocument abstractDocument);

    public void edit(AbstractDocument abstractDocument);

    public void delete(long id);

    public AbstractDocument getById(long id);

    public Collection<AbstractDocument> getAll();
}
