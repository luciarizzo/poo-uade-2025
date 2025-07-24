package repository;

import java.util.List;
import model.Reserva;

public interface RepositorioReservas {
    void agregarReserva(Reserva reserva);
    List<Reserva> obtenerTodas();
    Reserva buscarReservaPorApartamento(int numeroApartamento);
    Reserva buscarReservaPorInquilino(int numeroLibreta);
}
