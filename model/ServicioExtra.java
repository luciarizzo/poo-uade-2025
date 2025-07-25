package model;

/**
 * Representa un servicio adicional que puede ser solicitado por el inquilino,
 * como calefacción, luz solar, agua limpia, etc.
 */
public class ServicioExtra {

    private String nombre;
    private double precio;

    public ServicioExtra(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}