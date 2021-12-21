package edu.educacionit.services;

import com.bolivarsoft.sensorclima.SensorClima;
import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import org.springframework.stereotype.Component;

@Component
public class SensorInEternum {

    private SensorClima sensorClima;
    private SensorVelocidad sensorVelocidad;
    private EvaluadorMultas evaluadorMultas;

    public SensorInEternum(SensorClima sensorClima, SensorVelocidad sensorVelocidad, EvaluadorMultas evaluadorMultas) {
        this.sensorClima = sensorClima;
        this.sensorVelocidad = sensorVelocidad;
        this.evaluadorMultas = evaluadorMultas;
    }

    public void sensar() {

        TipoClima tipoClima = sensorClima.sensar();

        System.out.println(tipoClima);

        for (;;) {
            DatosVehiculo datosVehiculo = sensorVelocidad.sensarVehiculo();
            System.out.println(datosVehiculo);
            evaluadorMultas.evaluar(tipoClima, datosVehiculo);
        }
    }
}
