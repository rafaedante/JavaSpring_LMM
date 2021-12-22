package com.eduit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class BusquedaClienteFrecuenteMs implements  BusquedaClienteFrecuente{

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Autowired
    RestTemplate restTemplate;

    @Override
    public int descuento(String idCliente) {
        // dado un cliente obtener el tipo de descuento
        String url = "http://localhost:8080/clifrec/" + idCliente;

       // Object resp = restTemplate.getForObject(url, Object.class);
       // return 1;

        List<HashMap<String, Object>> resp = (List<HashMap<String, Object>>) restTemplate.getForObject(url, Object.class);
        if (resp.size() == 0) {
            System.out.println("No se encontro cliente frecuente");
            return 0;
        }

        return Integer.parseInt(resp.get(0).get("tipoDescuento").toString());
    }
}
