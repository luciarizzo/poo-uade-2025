package model;

/**
 * Clase base para representar un apartamento del edificio.
 * Se espera que sea extendida por clases como ApartamentoSimple, ApartamentoDoble, etc.
 * Cada apartamento tiene un número único, una capacidad máxima y un precio base por mes.
 */
public abstract class Apartamento {
    // TODO: definir atributos privados: numero, capacidadMaxima, precioBase
    // TODO: agregar constructor, getters y método calcularPrecioMensual()

    private int numero;
    private int capacidadMaxima;
    private double precioBase;
    private boolean isDisponible;

    public Apartamento(int numero, int capacidadMaxima, double precioBase, boolean isDisponible) {
        this.numero = numero;
        this.capacidadMaxima = capacidadMaxima;
        this.precioBase = precioBase;
        this.isDisponible = isDisponible;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void ocupar(){
        this.isDisponible = false;
    }

    @Override
    public String toString() {
        return "Apartamento: " + getNumero() + " (" + getClass().getSimpleName() + ")";
    }


    abstract double calcularPrecioMensual();

}