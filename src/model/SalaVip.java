package model;

public class SalaVip extends Sala{
    /**
     * Metodo constructor de la clase SalaVip
     * @param codigo de la sala
     * @param nombre de la sala
     * @param capacidadMaxima de la sala
     * @param filas de la sala
     * @param columnas de la sala
     */
    public SalaVip(String codigo, String nombre, int capacidadMaxima, int filas, int columnas) {
        super(codigo, nombre, capacidadMaxima, filas, columnas);
    }

    /**
     * Metodo para calcular el precio con recargo
     * @param precioBase de la sala
     * @return
     */
    @Override
    public double calcularPrecioConRecargo(double precioBase) {
        return precioBase * 1.30;
    }
}
