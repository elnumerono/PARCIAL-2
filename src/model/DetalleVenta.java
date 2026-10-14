package model;

import java.util.List;

public record DetalleVenta(int cantidad, double costoTotal, String codDetalle, List<Boleta> listBoletasDetalleVenta) {

}
