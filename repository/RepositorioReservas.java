package repository;

import model.Reserva;

import java.util.List;

public interface RepositorioReservas {
    public List<Reserva> obtenerTodas();
    public void guardarReserva(Reserva reserva);
    public void eliminarReserva(Reserva reserva);
}
