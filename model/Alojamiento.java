package model;

public abstract class Alojamiento {
    public int capacidadMaxima;
    private int numeroUnico;
    private double precioBase;
    private boolean isDisponible;

    public Alojamiento(int capacidadMaxima, int numeroUnico, double precioBase, boolean isDisponible) {
        this.capacidadMaxima = capacidadMaxima;
        this.numeroUnico = numeroUnico;
        this.precioBase = precioBase;
        this.isDisponible = true;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getNumeroUnico() {
        return numeroUnico;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = !isDisponible;
    }

    public void ocuparAlojamiento() {
        isDisponible = false;
    }

    public void desocuparAlojamiento() {
        isDisponible = true;
    }

    public boolean estaDisponible() {
        return isDisponible;
    }




}
