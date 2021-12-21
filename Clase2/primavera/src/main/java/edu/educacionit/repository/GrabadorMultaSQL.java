package edu.educacionit.repository;

import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GrabadorMulta;

public class GrabadorMultaSQL implements GrabadorMulta {

    @Override
    public void grabar(Ticket t) {
        System.out.println("Grabando ticket en SQL");
    }
}
