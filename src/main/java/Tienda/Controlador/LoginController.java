package Tienda.Controlador;

import Tienda.Modelo.*;
import Tienda.Vista.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class LoginController extends MouseAdapter {
    private InicioSesion vista;
    private Usuario usuario1;

    public LoginController(InicioSesion vista) {
        this.vista = vista;
        // Aquí iría la carga de usuarios desde una base de datos o archivo
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String usuario = vista.getUsuario();
        String contrasena = vista.getContrasena();

        // Simulación de autenticación (reemplazar con lógica real)
        if (usuario.equals("comprador") && contrasena.equals("123")) {
            abrirVistaComprador();
        } else if (usuario.equals("vendedor") && contrasena.equals("456")) {
            abrirVistaVendedor();
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void abrirVistaComprador() {
        // Cerrar vista actual y abrir nueva vista
        vista.dispose();
        VistaComprador compradorPantalla = new VistaComprador();
        new CompradorController(compradorPantalla); // Controlador para el comprador
        compradorPantalla.setVisible(true);
    }

    private void abrirVistaVendedor() {
        vista.dispose();
        VistaVendedor vendedorPantalla = new VistaVendedor();
        new VendedorController(vendedorPantalla); // Controlador para el vendedor
        vendedorPantalla.setVisible(true);
    }
}

