package Tienda.Controlador;

import Tienda.Modelo.*;
import Tienda.Vista.VistaTienda;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ControladorTienda {
    private VistaTienda vista;
    private Comprador compradorActual;
    private Vendedor vendedorActual;
    private Historial historial;
    private List<Producto> productosDisponibles;

    public ControladorTienda() {
        // Inicializar productos disponibles
        productosDisponibles = Arrays.asList(
                new Producto("The Legend of Zelda", "SKU-ZELDA", 59000,2),
                new Producto("FIFA 2024", "SKU-FIFA24", 69000,2),
                new Producto("Call of Duty", "SKU-COD", 49000,2)
        );
        this.vista = new VistaTienda();
        this.historial = new Historial();
        iniciarAplicacion();
    }

    private void iniciarAplicacion() {
        int opcion;
        do {
            opcion = vista.mostrarMenuPrincipal();
            switch (opcion) {
                case 0: registrarComprador(); break;
                case 1: registrarVendedor(); break;
                case 2: realizarTransaccion(); break;
                case 3: verHistorial(); break;
                case 4: vista.mostrarMensaje("¡Gracias por usar la tienda!"); break;
            }
        } while (opcion != 4);
    }

    private void registrarVendedor() {
        String[] datos = vista.pedirDatosVendedor();
        vendedorActual = new Vendedor(
                0, // ID generado automáticamente en un caso real
                datos[0], // Nombre
                datos[1], // Correo
                "contraseñaTemporal", // Contraseña por defecto
                datos[2] // Dirección
        );
        vista.mostrarMensaje("Vendedor registrado: " + vendedorActual.getNombre());
    }

    private void registrarComprador() {
        String[] datos = vista.pedirDatosComprador();
        compradorActual = new Comprador(
                0, // ID generado automáticamente en un caso real
                datos[0],
                datos[1],
                "contraseñaTemporal",
                datos[2]
        );
        vista.mostrarMensaje("Comprador registrado: " + compradorActual.getNombre());
    }

    private void realizarTransaccion() {
        if (compradorActual == null || vendedorActual == null) {
            vista.mostrarMensaje("Debe registrar comprador y vendedor primero");
            return;
        }

        // Selección de productos
        List<Producto> productosSeleccionados = vista.seleccionarProductos(productosDisponibles);

        if(productosSeleccionados.isEmpty()) {
            vista.mostrarMensaje("No seleccionó ningún producto");
            return;
        }

        // Calcular total
        double total = productosSeleccionados.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();

        vista.mostrarTotal(total);

        // Confirmar compra
        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Confirmar compra por $" + String.format("%.2f", total) + "?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if(confirmacion == JOptionPane.YES_OPTION) {
            Transaccion t = new Transaccion(
                    compradorActual,
                    vendedorActual,
                    total, // Total real calculado
                    "Tarjeta" // añadir selector de metodo de pago
            );

            historial.agregarTransaccion(t);
            vista.mostrarMensaje("¡Compra exitosa!");
        }
    }

    private void verHistorial() {
        StringBuilder sb = new StringBuilder("Historial:\n");
        for (Transaccion t : historial.getTransacciones()) {
            sb.append(t.getComprador().getNombre())
                    .append(" -> ")
                    .append(t.getVendedor().getNombre())
                    .append(" | $")
                    .append(t.getTotal())
                    .append("\n");
        }
        vista.mostrarHistorial(sb.toString());
    }
}