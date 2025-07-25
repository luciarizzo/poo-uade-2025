package repository;

import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class RepositorioReservasEnMemoria implements RepositorioReservas{
    private RepositorioReservas repositorioReservas;
    private List<Reserva> reservas = new ArrayList<>();

    public RepositorioReservasEnMemoria(RepositorioReservas repositorioReservas, List<Reserva> reservas) {
        this.repositorioReservas = repositorioReservas;
        this.reservas = reservas;
    }

    public RepositorioReservasEnMemoria() {
    }

    @Override
    public List<Reserva> obtenerTodas() {
        return reservas;
    }

    @Override
    public void guardarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    @Override
    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }




}
