import model.Cine;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        Cine cine = new Cine("CinePlus", "900123456-1", "Cra 14 Armenia Quindio");

        // Datos de prueba iniciales
        cine.registrarSala("Tradicional", "S01", "Sala 1", 50, 5, 10);
        cine.registrarPelicula("P01", "Avatar 2", "ACCION", "13+", 180, "S01");
        cine.registrarCliente("12345", "Carlos Gomez", "carlos@mail.com", "3111111111", "CLI-01", 10.0);
        cine.registrarEmpleado("98765", "Ana Maria", "ana@mail.com", "3222222222", "EMP-01", new Date(), 1500000);

        boolean continuar = true;
        while (continuar) {
            String menu = "=== MENÚ PRINCIPAL CINEPLUS ===\n" +
                    "1. Gestionar Películas\n" +
                    "2. Gestionar Salas\n" +
                    "3. Programar Funciones\n" +
                    "4. Registrar Personas (Clientes / Empleados)\n" +
                    "5. Realizar Venta de Boletas\n" +
                    "6. Consultar Ocupación e Ingresos\n" +
                    "7. Salir\n\n" +
                    "Seleccione una opción:";

            String opcionStr = JOptionPane.showInputDialog(null, menu);
            if (opcionStr == null) {
                break;
            }

            int opcion = Integer.parseInt(opcionStr);

            if (opcion == 1) {
                String subMenu = "--- GESTIÓN DE PELÍCULAS ---\n" +
                        "1. Registrar Película\n" +
                        "2. Listar Películas\n" +
                        "Seleccione una opción:";
                String subOpStr = JOptionPane.showInputDialog(null, subMenu);
                if (subOpStr != null) {
                    int subOp = Integer.parseInt(subOpStr);
                    if (subOp == 1) {
                        String codigo = JOptionPane.showInputDialog("Código:");
                        String titulo = JOptionPane.showInputDialog("Título:");
                        String genero = JOptionPane.showInputDialog("Género (ACCION, COMEDIA, DRAMA, TERROR, ANIMACION):");
                        String clasificacion = JOptionPane.showInputDialog("Clasificación de edad:");
                        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración en minutos:"));
                        String codSala = JOptionPane.showInputDialog("Código de sala asignada:");

                        boolean exito = cine.registrarPelicula(codigo, titulo, genero, clasificacion, duracion, codSala);
                        if (exito) {
                            JOptionPane.showMessageDialog(null, "Película registrada con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrar.");
                        }
                    } else if (subOp == 2) {
                        JOptionPane.showMessageDialog(null, cine.listarPeliculas());
                    }
                }
            } else if (opcion == 2) {
                String subMenu = "--- GESTIÓN DE SALAS ---\n" +
                        "1. Registrar Sala\n" +
                        "2. Listar Salas\n" +
                        "Seleccione una opción:";
                String subOpStr = JOptionPane.showInputDialog(null, subMenu);
                if (subOpStr != null) {
                    int subOp = Integer.parseInt(subOpStr);
                    if (subOp == 1) {
                        String tipo = JOptionPane.showInputDialog("Tipo de Sala (Tradicional, VIP, 3D):");
                        String codigo = JOptionPane.showInputDialog("Código:");
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad máxima:"));
                        int filas = Integer.parseInt(JOptionPane.showInputDialog("Filas:"));
                        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Columnas:"));

                        boolean exito = cine.registrarSala(tipo, codigo, nombre, capacidad, filas, columnas);
                        if (exito) {
                            JOptionPane.showMessageDialog(null, "Sala registrada con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrar sala.");
                        }
                    } else if (subOp == 2) {
                        JOptionPane.showMessageDialog(null, cine.listarSalas());
                    }
                }
            } else if (opcion == 3) {
                String subMenu = "--- PROGRAMAR FUNCIONES ---\n" +
                        "1. Registrar Función\n" +
                        "2. Listar Funciones\n" +
                        "Seleccione una opción:";
                String subOpStr = JOptionPane.showInputDialog(null, subMenu);
                if (subOpStr != null) {
                    int subOp = Integer.parseInt(subOpStr);
                    if (subOp == 1) {
                        String codigo = JOptionPane.showInputDialog("Código de función:");
                        String hora = JOptionPane.showInputDialog("Hora de inicio (ej. 14:30):");
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio base:"));
                        String codPeli = JOptionPane.showInputDialog("Código de película:");
                        String codSala = JOptionPane.showInputDialog("Código de sala:");

                        boolean exito = cine.registrarFuncion(codigo, hora, new Date(), precio, codPeli, codSala);
                        if (exito) {
                            JOptionPane.showMessageDialog(null, "Función programada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Verifique datos o cruce de horarios.");
                        }
                    } else if (subOp == 2) {
                        JOptionPane.showMessageDialog(null, cine.listarFunciones());
                    }
                }
            } else if (opcion == 4) {
                String subMenu = "--- REGISTRO DE PERSONAS ---\n" +
                        "1. Registrar Cliente\n" +
                        "2. Registrar Empleado\n" +
                        "Seleccione una opción:";
                String subOpStr = JOptionPane.showInputDialog(null, subMenu);
                if (subOpStr != null) {
                    int subOp = Integer.parseInt(subOpStr);
                    if (subOp == 1) {
                        String doc = JOptionPane.showInputDialog("Documento:");
                        String nombre = JOptionPane.showInputDialog("Nombre completo:");
                        String correo = JOptionPane.showInputDialog("Correo:");
                        String tel = JOptionPane.showInputDialog("Teléfono:");
                        String afi = JOptionPane.showInputDialog("Código afiliación:");
                        double desc = Double.parseDouble(JOptionPane.showInputDialog("Porcentaje descuento:"));

                        boolean exito = cine.registrarCliente(doc, nombre, correo, tel, afi, desc);
                        if (exito) {
                            JOptionPane.showMessageDialog(null, "Cliente registrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Ya existe.");
                        }
                    } else if (subOp == 2) {
                        String doc = JOptionPane.showInputDialog("Documento:");
                        String nombre = JOptionPane.showInputDialog("Nombre completo:");
                        String correo = JOptionPane.showInputDialog("Correo:");
                        String tel = JOptionPane.showInputDialog("Teléfono:");
                        String emp = JOptionPane.showInputDialog("Código empleado:");
                        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario básico:"));

                        boolean exito = cine.registrarEmpleado(doc, nombre, correo, tel, emp, new Date(), salario);
                        if (exito) {
                            JOptionPane.showMessageDialog(null, "Empleado registrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Ya existe.");
                        }
                    }
                }
            } else if (opcion == 5) {
                String codVenta = JOptionPane.showInputDialog("Código único de venta:");
                String docEmp = JOptionPane.showInputDialog("Documento del empleado:");
                String docCli = JOptionPane.showInputDialog("Documento del cliente:");
                String codFunc = JOptionPane.showInputDialog("Código de función:");

                int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de boletas a comprar:"));
                List<int[]> asientos = new ArrayList<>();
                for (int i = 0; i < cant; i++) {
                    int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila boleta " + (i + 1) + ":"));
                    int col = Integer.parseInt(JOptionPane.showInputDialog("Número de asiento boleta " + (i + 1) + ":"));
                    asientos.add(new int[]{fila, col});
                }

                String resultado = cine.realizarVenta(codVenta, docEmp, docCli, codFunc, asientos);
                JOptionPane.showMessageDialog(null, resultado);
            } else if (opcion == 6) {
                String codFunc = JOptionPane.showInputDialog("Código de la función a consultar:");
                String reporte = cine.obtenerReporteFuncion(codFunc);
                JOptionPane.showMessageDialog(null, reporte);
            } else if (opcion == 7) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Saliendo del sistema CinePlus.");
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }

    }
}
