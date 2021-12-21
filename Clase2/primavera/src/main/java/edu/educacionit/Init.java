package edu.educacionit;

import com.bolivarsoft.sensorclima.SensorClima;
import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import edu.educacionit.services.EvaluadorMultas;
import edu.educacionit.repository.GrabadorMultaJson;
import edu.educacionit.services.SensorInEternum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    @Autowired
    SensorInEternum sensorInEternum;

    @Override
    public void run(String... args) throws Exception {
       sensorInEternum.sensar();
    }
}
