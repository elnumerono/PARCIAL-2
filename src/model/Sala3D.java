package model;

public class Sala3D extends Sala {
    /**
     * Metodo constructor de la clase Sala3D
     * @param codigo de la Sala
     * @param nombre de la Sala
     * @param capacidadMaxima de la Sala
     * @param filas de la Sala
     * @param columnas de la Sala
     */
    public Sala3D(String codigo, String nombre, int capacidadMaxima, int filas, int columnas) {
        super(codigo, nombre, capacidadMaxima, filas, columnas);
    }

    /**
     * Metodo para calcular precio con la recarga
     * @param precioBase de la sala
     * @return
     */
    @Override
    public double calcularPrecioConRecargo(double precioBase) {
        return precioBase * 1.20;
    }
}