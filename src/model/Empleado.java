package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empleado extends Persona{
    //Atributos de la clase Empleado
    private String codigoEmpleado;
    private Date fechaContratacion;
    private double salarioBasico;

    //Relaciones de la clase Empleado
    private List<Venta> listEmpleadoVentas;

    /**
     *
     * @param correo del Empleado
     * @param telefono del Empleado
     * @param nombreCompleto del Empleado
     * @param documento del Empleado
     * @param codigoEmpleado del Empleado
     * @param fechaContratacion del Empleado
     * @param salarioBasico del Empleado
     */
    public Empleado(String correo, String telefono, String nombreCompleto, String documento, String codigoEmpleado, Date fechaContratacion, double salarioBasico) {
        super(correo, telefono, nombreCompleto, documento);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
        this.listEmpleadoVentas = new ArrayList<>();
    }

    /**
     * Metodo toString de la clase Empleado
     * @return
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", salarioBasico=" + salarioBasico +
                '}';
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public List<Venta> getListEmpleadoVentas() {
        return listEmpleadoVentas;
    }

    public void setListEmpleadoVentas(List<Venta> listEmpleadoVentas) {
        this.listEmpleadoVentas = listEmpleadoVentas;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
