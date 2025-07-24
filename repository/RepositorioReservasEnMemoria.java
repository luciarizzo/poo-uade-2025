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
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public List<Reserva> obtenerTodas() {
        return reservas;
    }

    @Override
    public Reserva buscarReservaPorApartamento(int numeroApartamento){
        for(Reserva r : repositorioReservas.obtenerTodas()){
            if(r.getApartamento().getNumero() == numeroApartamento){
                return r;
            }
        }
        return null;
    }

    @Override
    public Reserva buscarReservaPorInquilino(int numeroLibreta) {
        for(Reserva r : repositorioReservas.obtenerTodas()){
            if(r.getInquilino().getNumeroLibreta() == numeroLibreta){
                return r;
            }
        }
        return null;
    }


}
