package org.example;
import java.util.ArrayList;
import java.util.List;
public class Hospital {
    private String nombre;
    private String direccion;
    private List<Area> areas;

    public Hospital(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = new ArrayList<>();
    }

    public void agregarArea(Area area){
        areas.add(area);
    }

    public List<Area> getAreas(){
        return areas;
    }

    public String getNombre(){
        return nombre;
    }
}
