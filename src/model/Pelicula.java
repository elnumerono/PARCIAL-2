package model;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    //Atributos de la clase Pelicula
    private String codigo,titulo,genero,clasificacionEdad;
    private int duracion;

    //Relaciones de la clase pelicula
    private List<Funcion> listPeliculaFunciones;
    private Sala sala;
    private Genero generoPelicula;

    /**
     * Metodo constructor de la clase Pelicula
     * @param codigo de la pelicula
     * @param titulo de la pelicula
     * @param genero de la pelicula
     * @param clasificacionEdad de la pelicula
     * @param duracion de la pelicula
     * @param sala de la pelicula
     * @param generoPelicula de la pelicula
     */
    public Pelicula(String codigo, String titulo, String genero, String clasificacionEdad, int duracion, Sala sala, Genero generoPelicula) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
        this.duracion = duracion;
        this.sala = sala;
        this.generoPelicula = generoPelicula;
        this.listPeliculaFunciones = new ArrayList<>();
    }

    /**
     * Metodo toString de la clase pelicula
     * @return
     */
    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                ", duracion=" + duracion +
                ", sala=" + sala +
                ", generoPelicula=" + generoPelicula +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Funcion> getListPeliculaFunciones() {
        return listPeliculaFunciones;
    }

    public void setListPeliculaFunciones(List<Funcion> listPeliculaFunciones) {
        this.listPeliculaFunciones = listPeliculaFunciones;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Genero getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(Genero generoPelicula) {
        this.generoPelicula = generoPelicula;
    }
}
