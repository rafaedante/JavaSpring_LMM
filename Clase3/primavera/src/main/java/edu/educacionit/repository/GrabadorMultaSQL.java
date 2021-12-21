package edu.educacionit.repository;

import edu.educacionit.components.ContenedorJPA;
import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GrabadorMulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class GrabadorMultaSQL implements GrabadorMulta {

    @Autowired
    ContenedorJPA contenedorJPA;

    @Override
    public void grabar(Ticket t) {
        System.out.println("Grabando ticket en SQL");

        EntityManager entityManager = contenedorJPA.getEm();
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(t);
            tx.commit();

        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();

        }



    }
}
