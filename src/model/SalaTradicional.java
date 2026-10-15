package model;

public class SalaTradicional extends Sala{
    /**
     * Codigo constructor de la clase Sala
     *
     * @param codigo          de la Sala
     * @param nombre          de la Sala
     * @param capacidadMaxima de la Sala
     * @param filas           de la Sala
     * @param columnas        de la Sala
     */
    public SalaTradicional(String codigo, String nombre, int capacidadMaxima, int filas, int columnas) {
        super(codigo, nombre, capacidadMaxima, filas, columnas);
    }

    /**
     * Calcular el precio con el recargo
     * @param precioBase de la sala
     * @return
     */
    @Override
    public double calcularPrecioConRecargo(double precioBase) {
        return precioBase;
    }
}
