package server.dao.staff.person;


import server.model.staff.entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Stateless
public class PersonDAO implements PersonDAOLocal {

    @PersistenceContext(unitName = "dojoAppPersistence")
    private EntityManager manager;

    @Override
    public void add(Person person) {
        if (person.getId() == 0) {
            manager.persist(person);
        } else {
            edit(person);
        }
    }

    @Override
    public void edit(Person person) {
        manager.merge(person);
    }

    @Override
    public void delete(long id) {
        manager.remove(getById(id));
    }

    @Override
    public Person getById(long id) {
        return manager.find(Person.class, id);
    }

    @Override
    public Collection<Person> getAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> personRoot = query.from(Person.class);
        query.select(personRoot);
        TypedQuery<Person> typedQuery = manager.createQuery(query);

        return typedQuery.getResultList();
    }
}
