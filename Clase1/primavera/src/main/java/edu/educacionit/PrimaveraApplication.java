package edu.educacionit;

import com.bolivarsoft.sensorclima.SensorClima;
import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.SensorVelocidad;
import edu.educacionit.services.EvaluadorMultas;
import edu.educacionit.services.GrabadorMultaJson;
import edu.educacionit.services.SensorInEternum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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

	private static SensorInEternum factory(){
		return new SensorInEternum(
				new SensorClima(),
				new SensorVelocidad(),
				new EvaluadorMultas(
						new GrabadorMultaJson()
				)
		);
	}

	public static void main(String[] args) {

		//pruebaSensor();
		factory().sensar();

		// SpringApplication.run(PrimaveraApplication.class, args);
	}

}
