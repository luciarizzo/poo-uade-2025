package org.example;

import java.util.ArrayList;
import java.util.List;

public class Area {
    /* Agregación: un Área tiene varias habitaciones, pero puede existir por separado del Hospital.*/
    private String nombre;
    private int piso;
    private List<Habitacion> habitaciones;

    public Area(String nombre, int piso){
        this.nombre = nombre;
        this.piso = piso;
        this.habitaciones = new ArrayList<>();
    }
    public void agregarHabitaciones(Habitacion habitacion){
        habitaciones.add(habitacion);
    }
    public List<Habitacion> getHabitaciones(){
        return habitaciones;
    }
    public String getNombre(){
        return nombre;
    }
}

