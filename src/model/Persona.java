package model;

public class Persona {

    //Atributos de la clase Persona
    private String documento, nombreCompleto, correo, telefono;

    /**
     * Metodo constructor de la clase Persona
     * @param correo de la Persona
     * @param telefono de la Persona
     * @param nombreCompleto de la Persona
     * @param documento de la Persona
     */
    public Persona(String correo, String telefono, String nombreCompleto, String documento) {
        this.correo = correo;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
    }

    /**
     * Metodo constructor de la clase Persona
     * @return
     */
    @Override
    public String toString() {
        return "Persona{" +
                "documento='" + documento + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
