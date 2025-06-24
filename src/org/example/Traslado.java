package org.example;

public class Traslado {
    private Paciente paciente;
    private Area areaInicial;
    private Area areaFinal;

    public Traslado(Paciente paciente, Area areaInicial) {
        this.paciente = paciente;
        this.areaInicial = areaInicial;
    }

    public void setAreaFinal(Area areaFinal) {
        this.areaFinal = areaFinal;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Area getAreaInicial() {
        return areaInicial;
    }

    public Area getAreaFinal(){
        return areaFinal;
    }

}
