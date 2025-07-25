package model;

import java.util.ArrayList;
import java.util.List;

public abstract class HabitacionCompartida extends Alojamiento{
    private List<Camarada> ocupantes = new ArrayList<>();

    public HabitacionCompartida(int capacidadMaxima, int numeroUnico, double precioBase, boolean isDisponible) {
        super(capacidadMaxima, numeroUnico, precioBase, isDisponible);
    }

    public boolean estaDisponible() {
        return ocupantes.size() < capacidadMaxima;
    }

    public void agregarCamarada(Camarada c) {
        if (estaDisponible()) {
            ocupantes.add(c);
        } else {
            System.out.println("La habitación ya está llena");
        }
    }

    public int cantidadDisponible() {
        return capacidadMaxima - ocupantes.size();
    }

    public void removerCamarada(Camarada c) {
        ocupantes.remove(c);
    }



}
