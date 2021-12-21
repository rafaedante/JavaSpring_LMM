package edu.educacionit.repository;

import com.google.gson.Gson;
import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GrabadorMulta;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public class GrabadorMultaJson implements GrabadorMulta {

    @Value("${pathTickets}")
    private String pathTickets;

    @Override
    public void grabar(Ticket t) {

        try {
            String nomArch = String.join(
                    "",
                    pathTickets,
                    t.iDTicket,
                    ".json"
            );

            File arch = new File(nomArch);
            Gson gson = new Gson();
            String strJson = gson.toJson(t);
            System.out.println("data: " + strJson);
            FileUtils.writeStringToFile(arch, strJson, "UTF-8");

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}
