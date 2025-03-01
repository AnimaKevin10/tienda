package Tienda.Vista;

import javax.swing.*;

import Tienda.Modelo.*;
import java.util.List;
import java.util.Vector;

public class VistaTienda {

    // Muestra un menú principal y devuelve la opción seleccionada
    public int mostrarMenuPrincipal() {
        String[] opciones = {
                "Registrar Comprador",
                "Registrar Vendedor",
                "Realizar Transacción",
                "Ver Historial",
                "Salir"
        };

        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Tienda de Videojuegos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
    }
    public String[] pedirDatosVendedor() {
        String nombre = JOptionPane.showInputDialog("Nombre del vendedor:");
        String correo = JOptionPane.showInputDialog("Correo electrónico:");
        String direccion = JOptionPane.showInputDialog("Dirección:");
        return new String[]{nombre, correo, direccion};
    }
    // En Tienda.vista.VistaTienda
    public List<Producto> seleccionarProductos(List<Producto> productos) {
        JList<Producto> lista = new JList<>(new Vector<>(productos));
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(lista);

        int opcion = JOptionPane.showConfirmDialog(
                null,
                scrollPane,
                "Seleccione productos",
                JOptionPane.OK_CANCEL_OPTION
        );

        if(opcion == JOptionPane.OK_OPTION) {
            return lista.getSelectedValuesList();
        }
        return List.of(); // Lista vacía si cancela
    }

    public void mostrarTotal(double total) {
        JOptionPane.showMessageDialog(null,
                "Total a pagar: $" + String.format("%.2f", total));
    }
    // Solicita datos para registrar un Comprador
    public String[] pedirDatosComprador() {
        String nombre = JOptionPane.showInputDialog("Nombre del comprador:");
        String correo = JOptionPane.showInputDialog("Correo electrónico:");
        String direccion = JOptionPane.showInputDialog("Dirección:");
        return new String[]{nombre, correo, direccion};
    }

    // Muestra un mensaje de éxito/error
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Muestra el historial de transacciones
    public void mostrarHistorial(String historial) {
        JOptionPane.showMessageDialog(
                null,
                new javax.swing.JScrollPane(new javax.swing.JTextArea(historial)),
                "Historial",
                JOptionPane.PLAIN_MESSAGE
        );
    }

}