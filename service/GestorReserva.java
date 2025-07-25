package service;

import model.*;
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

    public Reserva crearReserva(Camarada camarada, Alojamiento alojamiento, List<ServicioExtra> servicios) {
        // Validación de tipo según el camarada
        if (camarada instanceof MiembroActivo && !(alojamiento instanceof Apartamento)) {
            System.out.println("Un MiembroActivo solo puede ocupar un Apartamento.");
        }

        if (camarada instanceof CamaradaEnFormacion && !(alojamiento instanceof HabitacionCompartida)) {
            System.out.println(("Un CamaradaEnFormacion solo puede ocupar una Habitación Compartida."));
        }

        // Si es habitación compartida, validar capacidad
        if (alojamiento instanceof HabitacionCompartida) {
            HabitacionCompartida habitacion = (HabitacionCompartida) alojamiento;

            if (!habitacion.estaDisponible()) {
                System.out.println("La habitación está completa.");
            }

            habitacion.agregarCamarada(camarada); // suma a la lista de ocupantes
        } else {
            // Si es apartamento, lo ocupamos directamente
            alojamiento.ocuparAlojamiento();
        }

        // Crear reserva
        Reserva reserva = new Reserva(alojamiento, camarada, servicios, 3);

        // Guardar en el repositorio
        repositorioReservas.guardarReserva(reserva);

        return reserva;
    }


    public boolean validarDisponibilidad(int numeroAlojamiento) {
        List<Reserva> reservas = repositorioReservas.obtenerTodas();
        for (Reserva r : reservas) {
            if (r.getAlojamiento().getNumeroUnico() == numeroAlojamiento) {
                return false;
            }
        }
        return true;
    }


    public void eliminarReserva(Reserva reserva) {
        Alojamiento alojamiento = reserva.getAlojamiento();
        Camarada camarada = reserva.getCamarada();

        // Liberar alojamiento según tipo
        if (alojamiento instanceof HabitacionCompartida) {
            HabitacionCompartida habitacion = (HabitacionCompartida) alojamiento;
            habitacion.removerCamarada(camarada);
        } else {
            alojamiento.desocuparAlojamiento();
        }

        // Eliminar reserva del repositorio
        repositorioReservas.eliminarReserva(reserva);
    }



}