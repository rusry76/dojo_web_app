package server.rest.service.document.outgoing;

import server.dao.document.outgoing.OutgoingDAOLocal;
import server.model.document.entity.Outgoing;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class OutgoingService implements IOutgoingService {

    @EJB
    private OutgoingDAOLocal outgoingDAOLocal;

    @Override
    public void add(Outgoing outgoing) {
        outgoingDAOLocal.add(outgoing);
    }

    @Override
    public void edit(Outgoing outgoing) {
        outgoingDAOLocal.edit(outgoing);
    }

    @Override
    public void delete(long id) {
        outgoingDAOLocal.delete(id);
    }

    @Override
    public Outgoing getById(long id) {
        return outgoingDAOLocal.getById(id);
    }

    @Override
    public Collection<Outgoing> getAll() {
        return outgoingDAOLocal.getAll();
    }
}
