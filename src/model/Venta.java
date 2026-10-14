package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    //Atributos de la clase Venta
    private String codigo;
    private Date fecha;

    //Relaciones de la clase Venta
    private List<DetalleVenta> listDetalleVentas;
    private Cliente cliente;
    private Empleado empleado;

    /**
     * Metodo constructor de la clase Venta
     * @param codigo de la Venta
     * @param empleado de la Venta
     * @param cliente de la Venta
     * @param fecha de la Venta
     */
    public Venta(String codigo, Empleado empleado, Cliente cliente, Date fecha) {
        this.codigo = codigo;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
        this.listDetalleVentas=new ArrayList<>();
    }

    /**
     * Funcion que permite calcular valor con el descuento
     * @param precioConRecargo
     * @return
     */
    public double calcularValorBoletaConDescuento(double precioConRecargo) {
        if (cliente != null && cliente.getPorcentajeDescuento() > 0) {
            return precioConRecargo - (precioConRecargo * (cliente.getPorcentajeDescuento() / 100.0));
        }
        return precioConRecargo;
    }

    /**
     * Metodo para generar comprobante de venta
     * @return
     */
    public String generarComprobante() {
        String recibo = "==================================\n" +
                "         CINEPLUS - RECIBO        \n" +
                "==================================\n" +
                "Código Venta: " + codigo + "\n" +
                "Fecha: " + fecha + "\n";

        if (cliente != null) {
            recibo = recibo + "Cliente: " + cliente.getNombreCompleto() + " (Afiliación: " + cliente.getCodigoAfiliacion() + ")\n";
        }
        if (empleado != null) {
            recibo = recibo + "Atendido por: " + empleado.getNombreCompleto() + "\n";
        }

        recibo = recibo + "----------------------------------\n" +
                "DETALLE DE BOLETAS ADQUIRIDAS:\n";

        double totalGeneral = 0;
        for (int i = 0; i < listDetalleVentas.size(); i++) {
            DetalleVenta detalle = listDetalleVentas.get(i);
            List<Boleta> boletas = detalle.listBoletasDetalleVenta();

            for (int j = 0; j < boletas.size(); j++) {
                Boleta b = boletas.get(j);
                recibo = recibo + " - Asiento [Fila " + b.getFila() + ", Asiento " + b.getNumAsiento() + "] | Valor: $" + b.getValor() + "\n";
            }
            totalGeneral = totalGeneral + detalle.costoTotal();
        }

        recibo = recibo + "----------------------------------\n" +
                "TOTAL PAGADO: $" + totalGeneral + "\n" +
                "==================================\n";

        return recibo;
    }

    /**
     * Metodo toString de la clase Venta
     * @return
     */
    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getListDetalleVentas() {
        return listDetalleVentas;
    }

    public void setListDetalleVentas(List<DetalleVenta> listDetalleVentas) {
        this.listDetalleVentas = listDetalleVentas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
