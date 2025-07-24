package model;

public class ApartamentoProletario extends Apartamento{

    public ApartamentoProletario(int numero, int capacidadMaxima, double precioBase, boolean isDisponible) {
        super(numero, capacidadMaxima, precioBase, isDisponible);
    }

    @Override
    double calcularPrecioMensual() {
        return (getPrecioBase() * 4);
    }
}
