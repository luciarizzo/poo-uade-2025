package org.example;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
     /* Asociación simple: Habitación no depende fuertemente de otras clases.*/
    private int numero;
    private int camasTotales;
    private int camasDisponibles;

    public Habitacion(int numero, int camasTotales){
        this.numero = numero;
        this.camasTotales = camasTotales;
        this.camasDisponibles = camasTotales;
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
}
