package org.example;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private int documento;
    private String diagnostico;

    public Paciente(String nombre, int documento, String diagnostico){
        this.nombre = nombre;
        this.documento = documento;
        this.diagnostico = diagnostico;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDiagnostico(){
        return diagnostico;
    }

    public int getDocumento(){
        return documento;
    }
}
