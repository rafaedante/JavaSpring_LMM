package edu.educacionit.services;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;
import edu.educacionit.annotations.Loggeable;
import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GrabadorMulta;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EvaluadorMultas {

    private GrabadorMulta grabadorMulta;

    public EvaluadorMultas(GrabadorMulta grabadorMulta) {
        this.grabadorMulta = grabadorMulta;
    }

    @Loggeable
    public void evaluar(TipoClima tc, DatosVehiculo dv) {
        /*
        si se dan las condiciones
        hay que llamar a grabadorMulta
        * */
        //Auto
        if(tc == TipoClima.NORMAL && dv.tipoVehiculo == TipoVehiculo.Auto) {
            if(dv.velocidadMedida <= 130) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_MODERADAS && dv.tipoVehiculo == TipoVehiculo.Auto) {
            if(dv.velocidadMedida <= 110) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_TORRENCIALES && dv.tipoVehiculo == TipoVehiculo.Auto) {
            if(dv.velocidadMedida <= 90) {
                return;
            }
        }

        //Camion
        if(tc == TipoClima.NORMAL && dv.tipoVehiculo == TipoVehiculo.Camion) {
            if(dv.velocidadMedida <= 90) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_MODERADAS && dv.tipoVehiculo == TipoVehiculo.Camion) {
            if(dv.velocidadMedida <= 80) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_TORRENCIALES && dv.tipoVehiculo == TipoVehiculo.Camion) {
            if(dv.velocidadMedida <= 70) {
                return;
            }
        }

        //Moto
        if(tc == TipoClima.NORMAL && dv.tipoVehiculo == TipoVehiculo.Moto) {
            if(dv.velocidadMedida <= 130) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_MODERADAS && dv.tipoVehiculo == TipoVehiculo.Moto) {
            if(dv.velocidadMedida <= 110) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_TORRENCIALES && dv.tipoVehiculo == TipoVehiculo.Moto) {
            if(dv.velocidadMedida <= 90) {
                return;
            }
        }

        //Tractor
        if(tc == TipoClima.NORMAL && dv.tipoVehiculo == TipoVehiculo.Tractor) {
            if(dv.velocidadMedida <= 60) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_MODERADAS && dv.tipoVehiculo == TipoVehiculo.Tractor) {
            if(dv.velocidadMedida <= 60) {
                return;
            }
        }
        if(tc == TipoClima.LLUVIAS_TORRENCIALES && dv.tipoVehiculo == TipoVehiculo.Tractor) {
            if(dv.velocidadMedida <= 60) {
                return;
            }
        }

        // SI LLEGA HASTA ACA ES PORQUE ESTA EXCEDIDO DE VELOCIDAD
        Ticket t = new Ticket(
                UUID.randomUUID().toString(),
                System.currentTimeMillis()/1000,
                dv,
                tc.name(),
                100,
                dv.velocidadMedida
        );

        grabadorMulta.grabar(t);


    }
}
