package model;

/**
 * Representa a un camarada (inquilino) que solicita un apartamento.
 * Contiene información personal básica, como nombre y número de libreta.
 */
public class Inquilino {
    // TODO: definir atributos como nombre, numeroLibreta
    // TODO: agregar constructor, getters y setters si es necesario

    private String nombre;
    private int numeroLibreta;

    public Inquilino(String nombre, int numeroLibreta) {
        this.nombre = nombre;
        this.numeroLibreta = numeroLibreta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroLibreta() {
        return numeroLibreta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroLibreta(int numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }
}