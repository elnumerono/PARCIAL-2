package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Sala {
    //Atributos de la clase Sala
    private String codigo, nombre;
    private int capacidadMaxima,filas,columnas;

    //Relaciones de la clase Sala
    private List<Pelicula> listSalaPeliculas;
    private List<Funcion> listSalaFunciones;

    /**
     * Codigo constructor de la clase Sala
     * @param codigo de la Sala
     * @param nombre de la Sala
     * @param capacidadMaxima de la Sala
     * @param filas de la Sala
     * @param columnas de la Sala
     */

    public Sala(String codigo, String nombre, int capacidadMaxima, int filas, int columnas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.filas = filas;
        this.columnas = columnas;
        this.listSalaPeliculas = new ArrayList<>();
        this.listSalaFunciones = new ArrayList<>();
    }

    /**
     * Metodo que heredan las clases hijas
     * @param precioBase de la sala
     * @return
     */
    public abstract double calcularPrecioConRecargo(double precioBase);

    /**
     * Metodo para verificar si los horarios se cruzan
     * @param horaInicioNueva de la pelicula
     * @param duracionNueva de la pelicula
     * @return
     */
    public boolean tieneCruceHorario(String horaInicioNueva, int duracionNueva) {
        int inicioNuevoMin = convertirHoraAMinutos(horaInicioNueva);
        int finNuevoMin = inicioNuevoMin + duracionNueva;

        for (int i = 0; i < listSalaFunciones.size(); i++) {
            Funcion f = listSalaFunciones.get(i);
            int inicioExistenteMin = convertirHoraAMinutos(f.getHoraInicio());
            Pelicula p = f.getPelicula();
            int duracionExistente = (p != null) ? p.getDuracion() : 120;
            int finExistenteMin = inicioExistenteMin + duracionExistente;

            if (inicioNuevoMin < finExistenteMin && finNuevoMin > inicioExistenteMin) {
                return true; // Hay cruce
            }
        }
        return false;
    }

    /**
     * Funcion para convertir hora en minutos
     * @param horaStr de la pelicula
     * @return
     */
    private int convertirHoraAMinutos(String horaStr) {
        String[] partes = horaStr.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return horas * 60 + minutos;
    }

    /**
     * Metodo toString de la clase Sala
     * @return
     */
    @Override
    public String toString() {
        return "Sala{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", filas=" + filas +
                ", columnas=" + columnas +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public List<Pelicula> getListSalaPeliculas() {
        return listSalaPeliculas;
    }

    public void setListSalaPeliculas(List<Pelicula> listSalaPeliculas) {
        this.listSalaPeliculas = listSalaPeliculas;
    }

    public List<Funcion> getListSalaFunciones() {
        return listSalaFunciones;
    }

    public void setListSalaFunciones(List<Funcion> listSalaFunciones) {
        this.listSalaFunciones = listSalaFunciones;
    }
}
