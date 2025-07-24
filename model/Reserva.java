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

    private Apartamento apartamento;
    private Inquilino inquilino;
    private int mes;
    private List<ServiciosExtras> serviciosExtras;

    public Reserva(Apartamento apartamento, Inquilino inquilino, int mes, List<ServiciosExtras> serviciosExtras) {
        this.apartamento = apartamento;
        this.inquilino = inquilino;
        this.mes = mes;
        //this.serviciosExtras = serviciosExtras; para evitar error
        this.serviciosExtras = (serviciosExtras != null) ? serviciosExtras : new java.util.ArrayList<>();
    }

    public double calcularCostoTotal(){
        double costoTotal = 0.0;
        double precioApart = apartamento.calcularPrecioMensual();
        double totalPrecioServicios = 0.0;
        for(ServiciosExtras s : serviciosExtras) {
            totalPrecioServicios += s.getPrecio();
        }
        costoTotal = precioApart + totalPrecioServicios;
        return costoTotal;
    }

    public void agregarServicioExtra(ServiciosExtras servicio){
        serviciosExtras.add(servicio);
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void ocuparApartamento(int numero){
        apartamento.ocupar();
    }

    public List<ServiciosExtras> getServiciosExtras() {
        return serviciosExtras;
    }


}