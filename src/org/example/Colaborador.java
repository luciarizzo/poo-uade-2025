package org.example;

public class Colaborador {
    private int legajo;
    private String nombreCompleto;
    private String especialidad;


    private TIPOCOLABORADOR tipo;

    public Colaborador(int legajo, String nombreCompleto, String especialidad, TIPOCOLABORADOR tipo) {
        this.legajo = legajo;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.tipo = tipo;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public TIPOCOLABORADOR getTipo() {
        return tipo;
    }
}
