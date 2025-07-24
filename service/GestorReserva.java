package service;

import model.Apartamento;
import model.Reserva;
import model.ServiciosExtras;
import repository.RepositorioApartamentos;
import repository.RepositorioReservas;
import java.util.List;

/**
 * Clase encargada de gestionar la lógica de las reservas:
 * - Asignación de apartamento disponible
 * - Cálculo del total mensual
 * - Validaciones de capacidad
 */
public class GestorReserva {
    // TODO: implementar métodos como crearReserva, calcularTotal, validarDisponibilidad, etc.
    private RepositorioReservas repositorioReservas;

    public GestorReserva(RepositorioReservas repositorioReservas) {
        this.repositorioReservas = repositorioReservas;
    }

    public boolean crearReserva(Reserva reserva){
        if(!validarDisponibilidad(reserva.getApartamento().getNumero())) {
            System.out.println("Apartamento ya ocupado");
            return false;
        }
        System.out.println("Reserva creada exitosamente");
        repositorioReservas.agregarReserva(reserva);
        return true;
    }

    public boolean validarDisponibilidad(int numeroApartamento){
        List<Reserva> reserva = repositorioReservas.obtenerTodas();
        for (Reserva r : reserva){
            if(r.getApartamento().getNumero() == numeroApartamento){
                return false;
            }
        }
        return true;
    }


    /*public double calculoTotalReservaMensual(int numeroApartamento){
        Reserva reserva = repositorioReservas.buscarReservaPorApartamento(numeroApartamento);
        if(existeReserva(numeroApartamento)){
            return reserva.calcularCostoTotal();
        } else {
            return 0.0;
        }
    }
     */

    public double calculoTotalReservaMensual(int numeroApartamento){
        if (existeReserva(numeroApartamento)) {
            Reserva reserva = repositorioReservas.buscarReservaPorApartamento(numeroApartamento);
            return reserva.calcularCostoTotal();
        } else {
            return 0.0;
        }
    }


    public void agregarServicioExtra(int numeroApartamento, ServiciosExtras serviciosExtras){
        Reserva reserva = repositorioReservas.buscarReservaPorApartamento(numeroApartamento);
        if(existeReserva(numeroApartamento)){
            System.out.println("Servicio agregado correctamente.");
            reserva.agregarServicioExtra(serviciosExtras);
        }
    }

    public void ocuparApartamento(int numeroApartamento){
        Reserva reserva = repositorioReservas.buscarReservaPorApartamento(numeroApartamento);
        if(existeReserva(numeroApartamento)){
            System.out.println("Habitacion ." + numeroApartamento + "ocupada correctamente");
            reserva.ocuparApartamento(numeroApartamento);
        }
    }

    public boolean existeReserva(int numeroApartamento){
        Reserva reserva = repositorioReservas.buscarReservaPorApartamento(numeroApartamento);
        if(reserva == null){
            System.out.println("No existe una reserva para ese departamento");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return repositorioReservas.obtenerTodas().toString();
    }
}