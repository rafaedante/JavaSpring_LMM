package com.eduit.controller;

import com.eduit.model.Venta;
import com.eduit.service.BusquedaClienteFrecuenteMs;
import com.eduit.service.CalculoDescuentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    BusquedaClienteFrecuenteMs busquedaClienteFrecuenteMs;

    @RequestMapping(path = "/vender/{id}", method = RequestMethod.GET)
    public Venta vender(@PathVariable String id) {
        /*return new Venta(
                UUID.randomUUID().toString(),
                1000d,
                100d,
                900d
        );*/

        Double desc = CalculoDescuentos
                .build()
                .setearIdCliente(id)
                .setearImporte(1000d)
                .setearBusquedaCliFrec(z ->
                        busquedaClienteFrecuenteMs.descuento(id))
                .calcular();

        return new Venta(
                UUID.randomUUID().toString(),
                1000d,
                desc
        );
    }

    @RequestMapping(path = "/verificar/{id}", method = RequestMethod.GET)
    public Object verificar(@PathVariable String id) {
        return busquedaClienteFrecuenteMs.descuento(id);
    }


}
