package org.example;

public class Main {


    public static void main(String[] args) {
        Hospital hospital = new Hospital("Hospital Dr Favaloro", "Avenida Salud 12345");

        //Composición - un hospital CONTIENE areas:
        Area pediatria = new Area("Pediatria", 2);
        hospital.agregarArea(pediatria);

        //Agregacion - el area tiene habitaciones
        Habitacion h101 = new Habitacion(101, 2, pediatria);
        pediatria.agregarHabitaciones(h101);

        System.out.println("Se creó el hospital " + hospital.getNombre() + " con el area " + pediatria.getNombre() + " y la habitacion " + h101.getNumero() + " con " + h101.getCamasDisponibles() + " camas disponibles.");

        Internacion internacion;
        Area areaActual = null;
        Paciente paciente = new Paciente("Monica Geller", 34542477, "COVID 19");
        Colaborador colaborador = new Colaborador(45424, "Joey Tribbiani", "Pediatra", TIPOCOLABORADOR.MEDICO);
        if (h101.ocuparCama()) {
            internacion = new Internacion(h101, paciente, colaborador);
            areaActual = internacion.getHabitacion().getArea();
            System.out.println("Se internó al paciente " + paciente.getNombre()
                    + " en la habitación " + internacion.getHabitacion().getNumero()
                    + " bajo responsabilidad del " + colaborador.getTipo()
                    + " " + colaborador.getNombreCompleto()
                    + ". Quedan " + h101.getCamasDisponibles() + " camas disponibles.");
        } else {
            System.out.println("No hay camas disponibles en la habitación.");
        }

        Area clinica = new Area("Clinica Medica", 5);
        hospital.agregarArea(clinica);

        Habitacion h503 = new Habitacion(503, 4, clinica);
        clinica.agregarHabitaciones(h503);

        Traslado traslado = new Traslado(paciente, areaActual);
        traslado.setAreaFinal(clinica);

        Internacion internacion1 = null;
        if(h503.ocuparCama()){
            internacion1 = new Internacion(h503, paciente,colaborador);
            areaActual = internacion1.getHabitacion().getArea();
            System.out.println("Se traslado al paciente " + paciente.getNombre() + " del area " + traslado.getAreaInicial().getNombre() + " al area " + traslado.getAreaFinal().getNombre()
                    + " en la habitación " + internacion1.getHabitacion().getNumero()
                    + " bajo responsabilidad del " + colaborador.getTipo()
                    + " " + colaborador.getNombreCompleto()
                    + ". Quedan " + h503.getCamasDisponibles() + " camas disponibles.");
        } else {
            System.out.println("No hay camas disponibles en la habitación.");
        }

    }
}
