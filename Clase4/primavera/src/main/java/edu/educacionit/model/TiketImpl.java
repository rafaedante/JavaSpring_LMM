package edu.educacionit.model;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class TiketImpl {

    @PersistenceContext
    private EntityManager em;

    public Long cuantosTckets() {
        Query query = em.createQuery("select count(p) from tickets p");
        Long result = (Long) query.getSingleResult();
        em.close();
        return  result;
    }
}


// public interface TicketDAO implements CrudRepository<Ticket, String>