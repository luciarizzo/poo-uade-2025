package org.example;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Hospital Dr Favaloro", "Avenida Salud 12345");

        //Composición - un hospital CONTIENE areas:
        Area pediatria = new Area("Pediatria", 2);
        hospital.agregarArea(pediatria);

        //Agregacion - el area tiene habitaciones
        Habitacion h101 = new Habitacion(101, 2);
        pediatria.agregarHabitaciones(h101);

        System.out.println("Se creó el hospital " + hospital.getNombre() + " con el area " + pediatria.getNombre() + " y la habitacion " + h101.getNumero() + " con " + h101.getCamasDisponibles() + " camas disponibles.");
    }
}
