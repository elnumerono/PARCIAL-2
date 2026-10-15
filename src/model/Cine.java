package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cine {
    //Atributos de la clase cine
    private String nombre,nit,direccion;

    //Relaciones de la clase Cine
    private List<Persona> listCinePersonas;
    private List<Venta> listCineVentas;
    private List<Funcion> listCineFunciones;
    private List<Pelicula> listCinePeliculas;
    private List<Sala> listCineSalas;

    /**
     * Metodo constructor de la clase Cine
     * @param nombre del cine
     * @param nit del cine
     * @param direccion del cine
     */
    public Cine(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;

        this.listCinePersonas = new ArrayList<>();
        this.listCineVentas = new ArrayList<>();
        this.listCineFunciones = new ArrayList<>();
        this.listCinePeliculas = new ArrayList<>();
        this.listCineSalas = new ArrayList<>();
    }
    // ================= CRUD PELÍCULAS =================

    /**
     * Metodo para registrar una pelicula
     * @param codigo de la pelicula
     * @param titulo de la pelicula
     * @param generoStr de la pelicula
     * @param clasificacion de la pelicula
     * @param duracion de la pelicula
     * @param codigoSala de la Sala
     * @return
     */
    public boolean registrarPelicula(String codigo, String titulo, String generoStr, String clasificacion, int duracion, String codigoSala) {
        if (buscarPelicula(codigo) != null) {
            return false;
        }
        Sala sala = buscarSala(codigoSala);
        if (sala == null) {
            return false;
        }

        Genero generoEnum = null;
        String generoMayus = generoStr.toUpperCase();

        if (generoMayus.equals("ACCION")) {
            generoEnum = Genero.ACCION;
        } else if (generoMayus.equals("COMEDIA")) {
            generoEnum = Genero.COMEDIA;
        } else if (generoMayus.equals("DRAMA")) {
            generoEnum = Genero.DRAMA;
        } else if (generoMayus.equals("TERROR")) {
            generoEnum = Genero.TERROR;
        } else if (generoMayus.equals("ANIMACION")) {
            generoEnum = Genero.ANIMACION;
        } else {
            return false;
        }

        Pelicula pelicula = new Pelicula(codigo, titulo, generoStr, clasificacion, duracion, sala, generoEnum);
        listCinePeliculas.add(pelicula);
        sala.getListSalaPeliculas().add(pelicula);
        return true;
    }

    /**
     * Metodo para buscar una pelicula
     * @param codigo de la pelicula
     * @return
     */
    public Pelicula buscarPelicula(String codigo) {
        for (int i = 0; i < listCinePeliculas.size(); i++) {
            Pelicula p = listCinePeliculas.get(i);
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Metodo para actualizar una pelicula
     * @param codigo de la pelicula
     * @param nuevoTitulo de la pelicula
     * @param nuevaClasificacion de la pelicula
     * @param nuevaDuracion de la pelicula
     * @return
     */
    public boolean actualizarPelicula(String codigo, String nuevoTitulo, String nuevaClasificacion, int nuevaDuracion) {
        Pelicula p = buscarPelicula(codigo);
        if (p == null) {
            return false;
        }
        p.setTitulo(nuevoTitulo);
        p.setClasificacionEdad(nuevaClasificacion);
        p.setDuracion(nuevaDuracion);
        return true;
    }

    /**
     * Metodo para eliminar una pelicula
     * @param codigo de la pelicula
     * @return
     */
    public boolean eliminarPelicula(String codigo) {
        Pelicula p = buscarPelicula(codigo);
        if (p == null) {
            return false;
        }
        listCinePeliculas.remove(p);
        return true;
    }

    // ================= CRUD SALAS =================

    /**
     * Metodo para registrar Sala
     * @param tipo de la Sala
     * @param codigo de la Sala
     * @param nombre de la Sala
     * @param capacidad de la Sala
     * @param filas de la Sala
     * @param columnas de la Sala
     * @return
     */
    public boolean registrarSala(String tipo, String codigo, String nombre, int capacidad, int filas, int columnas) {
        if (buscarSala(codigo) != null) {
            return false;
        }
        Sala sala;
        if (tipo.equalsIgnoreCase("VIP")) {
            sala = new SalaVip(codigo, nombre, capacidad, filas, columnas);
        } else if (tipo.equalsIgnoreCase("3D")) {
            sala = new Sala3D(codigo, nombre, capacidad, filas, columnas);
        } else {
            sala = new SalaTradicional(codigo, nombre, capacidad, filas, columnas);
        }
        listCineSalas.add(sala);
        return true;
    }

    /**
     * Metodo para buscar una Sala
     * @param codigo de la Sala
     * @return
     */

    public Sala buscarSala(String codigo) {
        for (int i = 0; i < listCineSalas.size(); i++) {
            Sala s = listCineSalas.get(i);
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        return null;
    }

    // ================= CRUD FUNCIONES =================

    /**
     * Metodo para Registrar una funcion
     * @param codigo de la funcion
     * @param horaInicioStr de la funcion
     * @param fecha de la funcion
     * @param precioBase de la funcion
     * @param codPelicula de la funcion
     * @param codSala de la funcion
     * @return
     */
    public boolean registrarFuncion(String codigo, String horaInicioStr, Date fecha, double precioBase, String codPelicula, String codSala) {
        if (buscarFuncion(codigo) != null) {
            return false;
        }
        Pelicula pelicula = buscarPelicula(codPelicula);
        Sala sala = buscarSala(codSala);

        if (pelicula == null || sala == null) {
            return false;
        }

        if (sala.tieneCruceHorario(horaInicioStr, pelicula.getDuracion())) {
            return false;
        }

        Funcion funcion = new Funcion(codigo, horaInicioStr, fecha, precioBase, pelicula, sala);
        listCineFunciones.add(funcion);
        sala.getListSalaFunciones().add(funcion);
        pelicula.getListPeliculaFunciones().add(funcion);
        return true;
    }

    /**
     * Metodo para buscar una funcion
     * @param codigo de la funcion
     * @return
     */
    public Funcion buscarFuncion(String codigo) {
        for (int i = 0; i < listCineFunciones.size(); i++) {
            Funcion f = listCineFunciones.get(i);
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                return f;
            }
        }
        return null;
    }

    // ================= REGISTRO PERSONAS =================

    /**
     * Metodo para registrar un cliente
     * @param documento del cliente
     * @param nombre del cliente
     * @param correo del cliente
     * @param telefono del cliente
     * @param codigoAfiliacion del cliente
     * @param descuento del cliente
     * @return
     */
    public boolean registrarCliente(String documento, String nombre, String correo, String telefono, String codigoAfiliacion, double descuento) {
        if (buscarPersona(documento) != null) {
            return false;
        }
        Cliente cliente = new Cliente(correo, telefono, nombre, documento, codigoAfiliacion, descuento);
        listCinePersonas.add(cliente);
        return true;
    }

    /**
     * Metodo para registrar un empleado
     * @param documento del empleado
     * @param nombre del empleado
     * @param correo del empleado
     * @param telefono del empleado
     * @param codigoEmpleado del empleado
     * @param fechaContratacion del empleado
     * @param salario del empleado
     * @return
     */
    public boolean registrarEmpleado(String documento, String nombre, String correo, String telefono, String codigoEmpleado, Date fechaContratacion, double salario) {
        if (buscarPersona(documento) != null) {
            return false;
        }
        Empleado empleado = new Empleado(correo, telefono, nombre, documento, codigoEmpleado, fechaContratacion, salario);
        listCinePersonas.add(empleado);
        return true;
    }

    /**
     * Metodo para buscar una persona
     * @param documento de la persona
     * @return
     */
    public Persona buscarPersona(String documento) {
        for (int i = 0; i < listCinePersonas.size(); i++) {
            Persona p = listCinePersonas.get(i);
            if (p.getDocumento().equalsIgnoreCase(documento)) {
                return p;
            }
        }
        return null;
    }

    // ================= GESTIÓN DE VENTAS Y BOLETAS =================

    /**
     * Metodo para realizar una venta
     * @param codVenta de la venta
     * @param docEmpleado del empleado
     * @param docCliente del cliente
     * @param codFuncion de la funcion
     * @param asientosDeseados por el cliente
     * @return
     */
    public String realizarVenta(String codVenta, String docEmpleado, String docCliente, String codFuncion, List<int[]> asientosDeseados) {
        Persona pEmp = buscarPersona(docEmpleado);
        Persona pCli = buscarPersona(docCliente);
        Funcion funcion = buscarFuncion(codFuncion);

        if (pEmp == null || !(pEmp instanceof Empleado)) {
            return "Error: Empleado no válido.";
        }
        if (pCli == null || !(pCli instanceof Cliente)) {
            return "Error: Cliente no válido.";
        }
        if (funcion == null) {
            return "Error: Función no encontrada.";
        }

        Empleado empleado = (Empleado) pEmp;
        Cliente cliente = (Cliente) pCli;
        Sala sala = funcion.getSala();

        // 1. Verificar disponibilidad y duplicados en la misma solicitud
        for (int i = 0; i < asientosDeseados.size(); i++) {
            int[] asientoActual = asientosDeseados.get(i);
            int fila = asientoActual[0];
            int col = asientoActual[1];

            // Validar límites de la sala
            if (fila < 0 || fila >= sala.getFilas() || col < 0 || col >= sala.getColumnas()) {
                return "Error: Asiento fuera de los límites de la sala.";
            }

            // Validar si ya está ocupado en funciones anteriores
            if (funcion.verificarAsientoOcupado(fila, col)) {
                return "Error: El asiento Fila " + fila + ", Col " + col + " ya está ocupado para esta función.";
            }

            // Validar si el usuario repitió el mismo asiento dentro de su propia lista de compra
            for (int j = 0; j < i; j++) {
                int[] asientoAnterior = asientosDeseados.get(j);
                if (asientoAnterior[0] == fila && asientoAnterior[1] == col) {
                    return "Error: Está intentando comprar el asiento Fila " + fila + ", Col " + col + " dos veces en la misma venta.";
                }
            }
        }

        // 2. Crear la venta si todo está correcto
        Venta venta = new Venta(codVenta, empleado, cliente, new Date());
        double precioConRecargo = sala.calcularPrecioConRecargo(funcion.getPrecioBase());

        List<Boleta> boletasVenta = new ArrayList<>();
        double costoTotalDetalle = 0;

        int contador = 1;
        for (int i = 0; i < asientosDeseados.size(); i++) {
            int[] asiento = asientosDeseados.get(i);
            int fila = asiento[0];
            int col = asiento[1];

            double valorFinalBoleta = venta.calcularValorBoletaConDescuento(precioConRecargo);

            String codBoleta = codVenta + "-B" + contador;
            contador = contador + 1;

            Boleta boleta = new Boleta(null, funcion, valorFinalBoleta, col, fila, codBoleta);
            boletasVenta.add(boleta);
            funcion.getListFuncionBoletas().add(boleta);
            costoTotalDetalle = costoTotalDetalle + valorFinalBoleta;
        }

        DetalleVenta detalle = new DetalleVenta(asientosDeseados.size(), costoTotalDetalle, codVenta + "-DET", boletasVenta);
        venta.getListDetalleVentas().add(detalle);

        listCineVentas.add(venta);
        empleado.getListEmpleadoVentas().add(venta);
        cliente.getListClienteVentas().add(venta);

        return venta.generarComprobante();
    }
    // ================= REPORTES Y LISTADOS =================

    /**
     * Metodo para obtener reporte de la funcion
     * @param codFuncion de la funcion
     * @return
     */
    public String obtenerReporteFuncion(String codFuncion) {
        Funcion f = buscarFuncion(codFuncion);
        if (f == null) {
            return "Función no encontrada.";
        }

        int capacidadTotal = f.getSala().getCapacidadMaxima();
        int boletasVendidas = f.getListFuncionBoletas().size();
        double ingresosTotal = 0;
        for (int i = 0; i < f.getListFuncionBoletas().size(); i++) {
            ingresosTotal = ingresosTotal + f.getListFuncionBoletas().get(i).getValor();
        }

        double porcentajeOcupacion = capacidadTotal > 0 ? ((double) boletasVendidas / capacidadTotal) * 100 : 0;

        return "--- REPORTE DE FUNCIÓN ---" +
                "\nPelícula: " + (f.getPelicula() != null ? f.getPelicula().getTitulo() : "N/A") +
                "\nSala: " + f.getSala().getNombre() +
                "\nBoletas Vendidas: " + boletasVendidas + "/" + capacidadTotal +
                "\nOcupación: " + porcentajeOcupacion + "%" +
                "\nIngresos Generados: $" + ingresosTotal;
    }

    /**
     * Metodo para listar las peliculas
     * @return
     */
    public String listarPeliculas() {
        if (listCinePeliculas.isEmpty()) {
            return "No hay películas registradas.";
        }
        String lista = "=== PELÍCULAS ===\n";
        for (int i = 0; i < listCinePeliculas.size(); i++) {
            Pelicula p = listCinePeliculas.get(i);
            lista = lista + "Código: " + p.getCodigo() + " | Título: " + p.getTitulo() + "\n";
        }
        return lista;
    }

    /**
     * Metodo para listar las salas
     * @return
     */
    public String listarSalas() {
        if (listCineSalas.isEmpty()) {
            return "No hay salas registradas.";
        }
        String lista = "=== SALAS ===\n";
        for (int i = 0; i < listCineSalas.size(); i++) {
            Sala s = listCineSalas.get(i);
            lista = lista + "Código: " + s.getCodigo() + " | Nombre: " + s.getNombre() + " | Tipo: " + s.getClass().getSimpleName() + "\n";
        }
        return lista;
    }

    /**
     * Metodo para listar las funciones
     * @return
     */
    public String listarFunciones() {
        if (listCineFunciones.isEmpty()) {
            return "No hay funciones programadas.";
        }
        String lista = "=== FUNCIONES ===\n";
        for (int i = 0; i < listCineFunciones.size(); i++) {
            Funcion f = listCineFunciones.get(i);
            lista = lista + "Código: " + f.getCodigo() + " | Película: " + f.getPelicula().getTitulo() + " | Hora: " + f.getHoraInicio() + "\n";
        }
        return lista;
    }
    /**
     * Metodo toString de la clase Hotel
     * @return
     */
    @Override
    public String toString() {
        return "Cine{" +
                "nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Persona> getListCinePersonas() {
        return listCinePersonas;
    }

    public void setListCinePersonas(List<Persona> listCinePersonas) {
        this.listCinePersonas = listCinePersonas;
    }

    public List<Venta> getListCineVentas() {
        return listCineVentas;
    }

    public void setListCineVentas(List<Venta> listCineVentas) {
        this.listCineVentas = listCineVentas;
    }

    public List<Funcion> getListCineFunciones() {
        return listCineFunciones;
    }

    public void setListCineFunciones(List<Funcion> listCineFunciones) {
        this.listCineFunciones = listCineFunciones;
    }

    public List<Pelicula> getListCinePeliculas() {
        return listCinePeliculas;
    }

    public void setListCinePeliculas(List<Pelicula> listCinePeliculas) {
        this.listCinePeliculas = listCinePeliculas;
    }

    public List<Sala> getListCineSalas() {
        return listCineSalas;
    }

    public void setListCineSalas(List<Sala> listCineSalas) {
        this.listCineSalas = listCineSalas;
    }
}

