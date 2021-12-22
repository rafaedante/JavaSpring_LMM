package com.eduit.controller;

import com.eduit.components.ContenedorJPA;
import com.eduit.model.ClienteFrecuente;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @RequestMapping(value="/inventar", method = RequestMethod.GET)
    public List<ClienteFrecuente> getInventaos() {
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

    @RequestMapping(method = RequestMethod.GET)
    public List<ClienteFrecuente> getTodos() {
        List<ClienteFrecuente> retValue = new ArrayList<>();

        try {

            EntityManager em = contenedorJPA.getEm();
            TypedQuery<ClienteFrecuente> clifre = em.createQuery("FROM ClienteFrecuente c", ClienteFrecuente.class);
            retValue = clifre.getResultList();

        }catch(Exception ex) {
            System.out.println("error en GET: " + ex.getMessage());
        }

        return retValue;
    }

    @RequestMapping(path ="/{id}", method = RequestMethod.GET)
    public List<ClienteFrecuente> obtenerUnClienteFrecuente(@PathVariable String id) {
       return getTodos()
               .stream()
               .filter(z -> z.idCliente.equals(id))
               .collect(Collectors.toList());
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
