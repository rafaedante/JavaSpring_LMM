package com.eduit;

import com.eduit.service.BusquedaClienteFrecuente;
import com.eduit.service.CalculoDescuentos;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class VentasApplicationTests {
/*
	@Test
	void contextLoads() {

		Double importeFinal = CalculoDescuentos
				.build()
				.setearIdCliente("")
				.setearImporte(1000d)
				.setearBusquedaCliFrec(z -> 1)
				.calcular();

		Assert.isTrue(importeFinal == 900, "Atencion el importe final No esta bien calculado");
	}

	@Test
	void seLLamaAlServicio(){
		BusquedaClienteFrecuente busquedaClienteMock = Mockito.mock(BusquedaClienteFrecuente.class);

		CalculoDescuentos
				.build()
				.setearIdCliente("ABC")
				.setearImporte(0d)
				.setearBusquedaCliFrec(busquedaClienteMock)
				.calcular();

		Mockito.verify(busquedaClienteMock, Mockito.times(1)).descuento("ABC");


	}

 */

}
