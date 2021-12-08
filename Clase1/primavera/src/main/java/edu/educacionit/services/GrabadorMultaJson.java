package edu.educacionit.services;

import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GrabadorMulta;

public class GrabadorMultaJson implements GrabadorMulta {

    @Override
    public void grabar(Ticket t) {
        System.out.println("Grabando ticket en formato JSON");
    }
}
