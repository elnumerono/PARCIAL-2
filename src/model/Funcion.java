package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcion {
    //Atributos de la clase Funcion
    private String codigo, horaInicio;
    private Date fecha;
    private double precioBase;

    //Relaciones de la clase Funcion
    private Pelicula pelicula;
    private Sala sala;
    private List<Boleta> listFuncionBoletas;

    /**
     * Metodo constructor de la clase Funcion
     * @param codigo de la funcion
     * @param horaInicio de la funcion
     * @param fecha de la funcion
     * @param precioBase de la funcion
     * @param pelicula de la funcion
     * @param sala de la funcion
     */
    public Funcion(String codigo, String horaInicio, Date fecha, double precioBase, Pelicula pelicula, Sala sala) {
        this.codigo = codigo;
        this.horaInicio = horaInicio;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.pelicula = pelicula;
        this.sala = sala;
        this.listFuncionBoletas = new ArrayList<>();
    }
    /**
     * Metodo toString de la clase Funcion
     * @return
     */
    @Override
    public String toString() {
        return "Funcion{" +
                "codigo='" + codigo + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", fecha=" + fecha +
                ", precioBase=" + precioBase +
                ", pelicula=" + pelicula +
                ", sala=" + sala +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Boleta> getListFuncionBoletas() {
        return listFuncionBoletas;
    }

    public void setListFuncionBoletas(List<Boleta> listFuncionBoletas) {
        this.listFuncionBoletas = listFuncionBoletas;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
}
