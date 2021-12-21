package edu.educacionit;

import com.bolivarsoft.sensorclima.TipoClima;
import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;
import edu.educacionit.repository.GrabadorMulta;
import edu.educacionit.services.EvaluadorMultas;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimaveraApplicationTests {

	@Test
	void contextLoads() {

		// GIVEN - WHEN - THEN

		// GIVEN
		GrabadorMulta grabadorMulta = Mockito.mock(GrabadorMulta.class);
		EvaluadorMultas evaluadorMultas = new EvaluadorMultas(grabadorMulta);

		DatosVehiculo dv = new DatosVehiculo();
		dv.patente = "PAT";
		dv.tipoVehiculo = TipoVehiculo.Auto;
		dv.velocidadMedida = 300;

		//WHEN
		evaluadorMultas.evaluar(TipoClima.LLUVIAS_MODERADAS, dv);

		//THEN
		Mockito.verify(grabadorMulta,
						Mockito.times(1)).grabar(Mockito.any());


	}

}
