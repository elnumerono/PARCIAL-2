package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    //Atributos de la clase Cliente
    private String codigoAfiliacion;
    private double porcentajeDescuento;

    //Relaciones de la clase Cliente
    private List<Venta> listClienteVentas;

    /**
     * Metodo constructor de la clase Cliente
     * @param correo del Cliente
     * @param telefono del Cliente
     * @param nombreCompleto del Cliente
     * @param documento del Cliente
     * @param codigoAfiliacion del Cliente
     * @param porcentajeDescuento del Cliente
     */
    public Cliente(String correo, String telefono, String nombreCompleto, String documento, String codigoAfiliacion, double porcentajeDescuento) {
        super(correo, telefono, nombreCompleto, documento);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.listClienteVentas = new ArrayList<>();
    }

    /**
     * Metodo toString de la clase Cliente
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "codigoAfiliacion='" + codigoAfiliacion + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public List<Venta> getListClienteVentas() {
        return listClienteVentas;
    }

    public void setListClienteVentas(List<Venta> listClienteVentas) {
        this.listClienteVentas = listClienteVentas;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
