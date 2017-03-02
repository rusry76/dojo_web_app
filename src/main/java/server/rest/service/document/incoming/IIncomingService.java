package server.rest.service.document.incoming;

import server.model.document.entity.Incoming;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface IIncomingService {

    public void add(Incoming incoming);

    public void edit(Incoming incoming);

    public void delete(long id);

    public Incoming getById(long id);

    public Collection<Incoming> getAll();
}
