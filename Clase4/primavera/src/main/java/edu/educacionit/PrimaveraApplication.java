package edu.educacionit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PrimaveraApplication {

	/*private static void pruebaSensor() {

		SensorClima sensorClima = new SensorClima();
		SensorVelocidad sensorVelocidad = new SensorVelocidad();
		TipoClima tipoClima = sensorClima.sensar();

		System.out.println(tipoClima);

		for (;;) {
			DatosVehiculo datosVehiculo = sensorVelocidad.sensarVehiculo();
			System.out.println(datosVehiculo);
		}


	}*/



	public static void main(String[] args) {

		//pruebaSensor();


		SpringApplication.run(PrimaveraApplication.class, args);
	}

}
