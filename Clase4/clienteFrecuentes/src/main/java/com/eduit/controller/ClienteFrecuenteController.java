package com.eduit.controller;

import com.eduit.components.ContenedorJPA;
import com.eduit.model.ClienteFrecuente;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clifrec")
public class ClienteFrecuenteController {

    @Autowired
    private ContenedorJPA contenedorJPA;

    private int[] crearArray(int n) {

        int[] arrEnteros = new int[n];
        for(int x=0; x<n; x++) {
            arrEnteros[x] = x;
        }

        return arrEnteros;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ClienteFrecuente> getTodos() {
        ArrayList<ClienteFrecuente> retValue = new ArrayList<>();

        for(int z : crearArray(10)) {
            retValue.add(new ClienteFrecuente(
                    UUID.randomUUID().toString(),
                    Faker.instance().address().firstName(),
                    Faker.instance().address().lastName(),
                    (z%2) + 1
                    ));
        }

        return retValue;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void agregar(@RequestBody ClienteFrecuente clienteFrecuente) {
        System.out.println("Agregamos a:");
        System.out.println(clienteFrecuente.nombre);
        System.out.println(clienteFrecuente.apellido);

        EntityTransaction tx = null;

        try {

            EntityManager em = contenedorJPA.getEm();
            tx = em.getTransaction();
            tx.begin();
            em.persist(clienteFrecuente);
            tx.commit();

        } catch (Exception ex) {
            tx.rollback();
            System.out.println(ex.getMessage());
        }
    }
}
