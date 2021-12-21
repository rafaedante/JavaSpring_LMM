package edu.educacionit.repository;

import edu.educacionit.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class GrabadorEnJsonMasSql implements GrabadorMulta{

    @Autowired
    private GrabadorMultaJson grabadorMultaJson;

    @Autowired
    private GrabadorMultaSQL grabadorMultaSQL;


    @Override
    public void grabar(Ticket t) {
        try {
            grabadorMultaJson.grabar(t);
        } catch (Exception ex) {
            System.out.println("No se puede grabar en json");
        }

        try {
            grabadorMultaSQL.grabar(t);
        } catch (Exception ex) {
            System.out.println("No se puede grabar en sql");
        }
    }
}
