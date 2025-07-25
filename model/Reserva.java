package model;

import java.util.List;

/**
 * Representa una reserva realizada por un inquilino.
 * Contiene la información del apartamento asignado, el inquilino,
 * el mes de ingreso, los servicios extra seleccionados y la lógica para calcular el total.
 */
public class Reserva {
    // TODO: definir atributos: apartamento, inquilino, mes, serviciosExtra
    // TODO: agregar constructor y métodos para calcular el total mensual (incluyendo impuesto)
    Alojamiento alojamiento;
    Camarada camarada;
    List<ServicioExtra> servicioExtras;
    int mes;

    public Reserva(Alojamiento alojamiento, Camarada camarada, List<ServicioExtra> servicioExtras, int mes) {
        this.alojamiento = alojamiento;
        this.camarada = camarada;
        this.servicioExtras = servicioExtras;
        this.mes = mes;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public Camarada getCamarada() {
        return camarada;
    }

    public List<ServicioExtra> getServicioExtras() {
        return servicioExtras;
    }
}