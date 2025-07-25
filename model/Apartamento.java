package model;

/**
 * Clase base para representar un apartamento del edificio.
 * Se espera que sea extendida por clases como ApartamentoSimple, ApartamentoDoble, etc.
 * Cada apartamento tiene un número único, una capacidad máxima y un precio base por mes.
 */
public abstract class Apartamento extends Alojamiento{
    public Apartamento(int capacidadMaxima, int numeroUnico, double precioBase, boolean isDisponible) {
        super(capacidadMaxima, numeroUnico, precioBase, isDisponible);
    }
    // TODO: definir atributos privados: numero, capacidadMaxima, precioBase
    // TODO: agregar constructor, getters y método calcularPrecioMensual()

}