package Tienda.Controlador;

import Tienda.Modelo.Comprador;
import Tienda.Modelo.Transaccion;
import Tienda.Vista.VistaComprador;

import javax.swing.table.DefaultTableModel;

public class CompradorController {
    private final Comprador comprador;
    private final VistaComprador vista;

    public CompradorController(Comprador comprador, VistaComprador vista) {
        this.comprador = comprador;
        this.vista = vista;
        cargarDatosUsuario();
    }

    public void cargarDatosUsuario() {
        vista.getUsuarioNombre().setText(comprador.getNombre());
        vista.getUsuarioID().setText(String.valueOf(comprador.getIdUsuario()));
        vista.getUsuarioCorreo().setText(comprador.getCorreo());
        vista.getUsuarioDireccion().setText(comprador.getDireccion());
        vista.getUsuarioNacimiento().setText(comprador.getFechaNacimiento());
        vista.getUsuarioTelefono().setText(comprador.getTelefono());
    }

    public void cargarHistorialCompras() {
        System.out.println("[DEBUG] Cargando historial...");
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaHistorial().getModel();
        modelo.setRowCount(0);

        if (comprador.getHistorial() == null) {
            System.out.println("[ERROR] Historial es null!");
            return;
        }

        for (Transaccion t : comprador.getHistorial().getTransacciones()) {
            System.out.println("[DEBUG] Añadiendo transacción: " + t.getProducto().getTitulo());
            modelo.addRow(new Object[]{
                    t.getFecha(),
                    t.getProducto() != null ? t.getProducto().getTitulo() : "N/A",
                    t.getCantidad(),
                    t.getTotal()
            });
        }
        System.out.println("[DEBUG] Filas en tabla: " + modelo.getRowCount());
    }
}