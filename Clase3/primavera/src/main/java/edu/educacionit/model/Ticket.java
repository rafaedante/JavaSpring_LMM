package edu.educacionit.model;

import com.bolivarsoft.sensorvelocidad.DatosVehiculo;
import com.bolivarsoft.sensorvelocidad.TipoVehiculo;

import javax.persistence.*;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @Column(name = "iDTicket")
    public String iDTicket;
    @Column(name = "fechaYhora")
    public Long fechaYhora;
    @Column(name = "patente")
    public String patente;
    @Column(name = "tipoVehiculo")
    public String tipoVehiculo;
    @Column(name = "velocidad")
    public int velocidadMedida;
    @Column(name = "situacionClimatologica")
    public String situacionClimatologica;
    @Column(name = "limiteVelocidadPermitido")
    public Integer limiteVelocidadPermitido;
    @Column(name = "limiteMedido")
    public Integer limiteMedido;


    public Ticket(String iDTicket, Long fechaYhora, DatosVehiculo datosVehiculo, String situacionClimatologica, Integer limiteVelocidadPermitido, Integer limiteMedido) {
        this.iDTicket = iDTicket;
        this.fechaYhora = fechaYhora;
        this.patente = datosVehiculo.patente;
        this.tipoVehiculo = datosVehiculo.tipoVehiculo.name();
        this.velocidadMedida = datosVehiculo.velocidadMedida;
        this.situacionClimatologica = situacionClimatologica;
        this.limiteVelocidadPermitido = limiteVelocidadPermitido;
        this.limiteMedido = limiteMedido;
    }

}
