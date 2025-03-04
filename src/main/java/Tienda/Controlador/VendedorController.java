package Tienda.Controlador;

import Tienda.Modelo.*;
import Tienda.Vista.VistaVendedor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VendedorController {
    private final Vendedor vendedor;
    private final VistaVendedor vista;

    public VendedorController(Vendedor vendedor, VistaVendedor vista) {
        this.vendedor = vendedor;
        this.vista = vista;
        cargarDatosUsuario();
        cargarInventario();
    }

    public void cargarDatosUsuario() {
        vista.getVendedorNombre().setText(vendedor.getNombre());
        vista.getVendedorID().setText(String.valueOf(vendedor.getIdUsuario()));
        vista.getVendedorCorreo().setText(vendedor.getCorreo());
        vista.getVendedorDireccion().setText(vendedor.getDireccion());
        vista.getVendedorSaldo().setText(String.format("$%.2f", vendedor.getSaldo()));
    }

    public void cargarHistorialVentas() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaVentas().getModel();
        modelo.setRowCount(0);

        for (Transaccion t : vendedor.getHistorialVentas().getTransacciones()) {
            modelo.addRow(new Object[]{
                    t.getFecha(),
                    t.getProducto().getTitulo(),
                    t.getCantidad(),
                    String.format("$%.2f", t.getTotal()),
                    t.getComprador().getNombre()
            });
        }
    }

    public void cargarInventario() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaInventario().getModel();
        modelo.setRowCount(0);

        for (Producto p : vendedor.getInventario()) {
            modelo.addRow(new Object[]{
                    p.getSku(),
                    p.getTitulo(),
                    String.format("$%.2f", p.getPrecio()),
                    p.getStock()
            });
        }
    }

    public void gestionarInventario() {
        try {
            String sku = JOptionPane.showInputDialog("Ingrese SKU del producto:");
            int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock:"));

            vendedor.gestionarInventario(sku, nuevoStock);
            cargarInventario();
            JOptionPane.showMessageDialog(vista, "Inventario actualizado!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error: Ingrese un valor numérico válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarSaldo() {
        try {
            double monto = Double.parseDouble(JOptionPane.showInputDialog("Monto a añadir:"));
            if (monto > 0) {
                vendedor.agregarSaldo(monto);
                cargarDatosUsuario();
                JOptionPane.showMessageDialog(vista, "Saldo actualizado: $" + vendedor.getSaldo());
            } else {
                JOptionPane.showMessageDialog(vista, "El monto debe ser positivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}