package repository;

import model.Apartamento;
import model.ApartamentoDoble;
import model.ApartamentoProletario;
import model.ApartamentoSimple;

import java.util.ArrayList;
import java.util.List;

public class RepositorioApartamentoEnMemoria implements RepositorioApartamentos{
    //private RepositorioApartamentos repositorioApartamentos;
    List<Apartamento> apartamentos;


    public RepositorioApartamentoEnMemoria() {
        apartamentos = new ArrayList<>();
        apartamentos.add(new ApartamentoSimple(101, 1, 1000, true));
        apartamentos.add(new ApartamentoDoble(102, 2, 2000, true));
        apartamentos.add(new ApartamentoDoble(103, 2, 2000, true));
        apartamentos.add(new ApartamentoProletario(201, 4, 2500, true));
        apartamentos.add(new ApartamentoProletario(202, 4, 2500, true));
    }


    @Override
    public List<Apartamento> obtenerTodos() {
        return apartamentos;
    }

    @Override
    public Apartamento buscarPorNumero(int numeroApartamento) {
        for(Apartamento a : apartamentos){
            if(a.getNumero() == numeroApartamento){
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Apartamento> obtenerApartamentosDisponibles() {
        List<Apartamento> disponibles = new ArrayList<>();
        for(Apartamento a : apartamentos){
            if(a.isDisponible()){
                disponibles.add(a);
            }
        }
        return disponibles;
    }
}
