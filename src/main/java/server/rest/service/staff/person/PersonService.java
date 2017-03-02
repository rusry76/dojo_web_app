package server.rest.service.staff.person;

import server.dao.staff.person.PersonDAOLocal;
import server.model.staff.entity.Person;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class PersonService implements IPersonService {

    @EJB
    private PersonDAOLocal personDAOLocal;

    @Override
    public void add(Person person) {
        personDAOLocal.add(person);
    }

    @Override
    public void edit(Person person) {
        personDAOLocal.edit(person);
    }

    @Override
    public void delete(long id) {
        personDAOLocal.delete(id);
    }

    @Override
    public Person getById(long id) {
        return personDAOLocal.getById(id);
    }

    @Override
    public Collection<Person> getAll() {
        return personDAOLocal.getAll();
    }
}
