package edu.educacionit.model;

import com.bolivarsoft.sensorvelocidad.DatosVehiculo;

public class Ticket {

    public String iDTicket;
    public Long fechaYhora;
    public DatosVehiculo datosVehiculo;
    public String situacionClimatologica;
    public Integer limiteVelocidadPermitido;
    public Integer limiteMedido;


    public Ticket(String iDTicket, Long fechaYhora, DatosVehiculo datosVehiculo, String situacionClimatologica, Integer limiteVelocidadPermitido, Integer limiteMedido) {
        this.iDTicket = iDTicket;
        this.fechaYhora = fechaYhora;
        this.datosVehiculo = datosVehiculo;
        this.situacionClimatologica = situacionClimatologica;
        this.limiteVelocidadPermitido = limiteVelocidadPermitido;
        this.limiteMedido = limiteMedido;
    }

    /*
    IDTicket, FechaYhora, DatosDelVehiculo, SituacionClimatologica, LimiteVelocidadPermitido, limiteMedido.
    * */
}
