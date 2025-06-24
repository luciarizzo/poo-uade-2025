package org.example;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
     /* Asociación simple: Habitación no depende fuertemente de otras clases.*/
    private int numero;
    private int camasTotales;
    private int camasDisponibles;
    private Area area;

    public Habitacion(int numero, int camasTotales, Area area){
        this.numero = numero;
        this.camasTotales = camasTotales;
        this.camasDisponibles = camasTotales;
        this.area = area;
    }

    public boolean ocuparCama(){
        if(camasDisponibles > 0){
            camasDisponibles--;
            return true;
        }
        return false;
    }

    public int getCamasDisponibles(){
        return camasDisponibles;
    }

    public int getNumero(){
        return numero;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Area getArea() {
        return area;
    }
}
