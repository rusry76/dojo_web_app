package server.dao.staff.person;

import server.model.staff.entity.Person;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface PersonDAOLocal {

    public void add(Person person);

    public void edit(Person person);

    public void delete(long id);

    public Person getById(long id);

    public Collection<Person> getAll();
}
