package server.rest.service.document;

import server.model.document.entity.AbstractDocument;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface IDocumentService {

    public void add(AbstractDocument document);

    public void edit(AbstractDocument document);

    public void delete(long id);

    public AbstractDocument getById(long id);

    public Collection<AbstractDocument> getAll();
}
