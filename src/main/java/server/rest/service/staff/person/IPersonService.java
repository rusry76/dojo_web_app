package server.rest.service.staff.person;

import server.model.staff.entity.Person;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface IPersonService {

    public void add(Person person);

    public void edit(Person person);

    public void delete(long id);

    public Person getById(long id);

    public Collection<Person> getAll();
}
