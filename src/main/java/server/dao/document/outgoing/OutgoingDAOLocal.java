package server.dao.document.outgoing;

import server.model.document.entity.Outgoing;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface OutgoingDAOLocal {

    public void add(Outgoing outgoing);

    public void edit(Outgoing outgoing);

    public void delete(long id);

    public Outgoing getById(long id);

    public Collection<Outgoing> getAll();
}
