package edu.educacionit.components;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class ContenedorJPA {

    private EntityManager em = null;

    public ContenedorJPA() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mariadb");
        em = factory.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }
}
