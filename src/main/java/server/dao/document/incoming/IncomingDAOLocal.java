package server.dao.document.incoming;

import server.model.document.entity.Incoming;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface IncomingDAOLocal {

    public void add(Incoming incoming);

    public void edit(Incoming incoming);

    public void delete(long id);

    public Incoming getById(long id);

    public Collection<Incoming> getAll();

}
