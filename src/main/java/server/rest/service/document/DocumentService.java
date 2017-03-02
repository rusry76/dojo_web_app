package server.rest.service.document;

import server.dao.document.DocumentDAOLocal;
import server.model.document.entity.AbstractDocument;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class DocumentService implements IDocumentService {

    @EJB
    private DocumentDAOLocal documentDAOLocal;

    @Override
    public void add(AbstractDocument document) {
        documentDAOLocal.add(document);
    }

    @Override
    public void edit(AbstractDocument document) {
        documentDAOLocal.edit(document);
    }

    @Override
    public void delete(long id) {
        documentDAOLocal.delete(id);
    }

    @Override
    public AbstractDocument getById(long id) {
        return documentDAOLocal.getById(id);
    }

    @Override
    public Collection<AbstractDocument> getAll() {
        return documentDAOLocal.getAll();
    }
}
