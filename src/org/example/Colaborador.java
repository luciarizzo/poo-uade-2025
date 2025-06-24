package org.example;

public class Colaborador {
    private int legajo;
    private String nombreCompleto;
    private String especialidad;
    private enum TIPOCOLABORADOR {
        MEDICO,
        ENFERMERO,
        KINESIOLOGO
    }

    private TIPOCOLABORADOR tipo;

    public Colaborador(int legajo, String nombreCompleto, String especialidad, TIPOCOLABORADOR tipo) {
        this.legajo = legajo;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.tipo = tipo;
    }



}
