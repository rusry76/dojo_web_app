package server.rest.service.document.incoming;

import server.dao.document.incoming.IncomingDAOLocal;
import server.model.document.entity.Incoming;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class IncomingService implements IIncomingService {

    @EJB
    private IncomingDAOLocal incomingDAOLocal;

    @Override
    public void add(Incoming incoming) {
        incomingDAOLocal.add(incoming);
    }

    @Override
    public void edit(Incoming incoming) {
        incomingDAOLocal.edit(incoming);
    }

    @Override
    public void delete(long id) {
        incomingDAOLocal.delete(id);
    }

    @Override
    public Incoming getById(long id) {
        return getById(id);
    }

    @Override
    public Collection<Incoming> getAll() {
        return incomingDAOLocal.getAll();
    }
}
