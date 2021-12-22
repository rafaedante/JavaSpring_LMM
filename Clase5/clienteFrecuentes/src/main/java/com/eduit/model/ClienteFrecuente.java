package com.eduit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClienteFrecuentes")
public class ClienteFrecuente {

    @Id
    @Column(name ="idCli")
    public String idCliente;
    @Column(name ="nombre")
    public String nombre;
    @Column(name ="apellido")
    public String apellido;
    @Column(name ="tipoDescuento")
    public Integer tipoDescuento;


    public ClienteFrecuente(String idCliente, String nombre, String apellido, Integer tipoDescuento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDescuento = tipoDescuento;
    }

    public ClienteFrecuente() {
    }
}
