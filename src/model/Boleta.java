package model;

public class Boleta {
    //Atributos de la clase Boleta
    private String codigo;
    private int fila, numAsiento;
    private double valor;

    //Relaciones de la clase Boleta
    private Funcion funcion;
    private DetalleVenta detalleVenta;

    /**
     * Metodo constructor de la clase Boleta
     * @param detalleVenta de la Boleta
     * @param funcion de la Boleta
     * @param valor de la Boleta
     * @param numAsiento de la Boleta
     * @param fila de la Boleta
     * @param codigo de la Boleta
     */
    public Boleta(DetalleVenta detalleVenta, Funcion funcion, double valor, int numAsiento, int fila, String codigo) {
        this.detalleVenta = detalleVenta;
        this.funcion = funcion;
        this.valor = valor;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.codigo = codigo;
    }

    /**
     * Metodo toString de la clase Boleta
     * @return
     */
    @Override
    public String toString() {
        return "Boleta{" +
                "codigo='" + codigo + '\'' +
                ", fila=" + fila +
                ", numAsiento=" + numAsiento +
                ", valor=" + valor +
                ", funcion=" + funcion +
                ", detalleVenta=" + detalleVenta +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
}
