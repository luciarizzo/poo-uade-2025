package model;

public class ApartamentoSimple extends Apartamento{
    public ApartamentoSimple(int numero, int capacidadMaxima, double precioBase, boolean isDisponible) {
        super(numero, capacidadMaxima, precioBase, isDisponible);
    }

    @Override
    double calcularPrecioMensual() {
        return getPrecioBase();
    }
}
