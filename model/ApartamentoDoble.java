package model;

public class ApartamentoDoble extends Apartamento{

    public ApartamentoDoble(int numero, int capacidadMaxima, double precioBase, boolean isDisponible) {
        super(numero, capacidadMaxima, precioBase, isDisponible);
    }

    @Override
    double calcularPrecioMensual() {
        return (getPrecioBase() * 2);
    }
}
