package org.example;

public class Internacion {
    private Habitacion habitacion;
    private Paciente paciente;
    private Colaborador colaborador;

    public Internacion(Habitacion habitacion, Paciente paciente, Colaborador colaborador) {
        this.habitacion = habitacion;
        this.paciente = paciente;
        this.colaborador = colaborador;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }
}
