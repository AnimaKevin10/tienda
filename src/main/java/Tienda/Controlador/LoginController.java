package Tienda.Controlador;

import Tienda.Modelo.*;
import Tienda.Vista.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
public class LoginController extends MouseAdapter {
    private InicioSesion vista;

    public LoginController(InicioSesion vista) {
        this.vista = vista;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String usuario = vista.getUsuario();
        String contrasena = vista.getContrasena();

        // Simulación de autenticación (reemplazar con lógica real)
        if (usuario.equals("comprador") && contrasena.equals("123")) {
            // Crear comprador con datos reales
            Comprador compradorAutenticado = new Comprador(
                    123, // ID
                    "Ana Pérez", // Nombre
                    "ana@tienda.com", // Correo
                    "Calle Falsa 123", // Dirección
                    "555-1234" // Teléfono
            );
            abrirVistaComprador(compradorAutenticado);
        } else if (usuario.equals("vendedor") && contrasena.equals("456")) {
            abrirVistaVendedor();
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirVistaComprador(Comprador comprador) {
        // Cerrar vista actual y abrir nueva vista
        vista.dispose();
        VistaComprador compradorPantalla = new VistaComprador(comprador);
        new CompradorController(comprador, compradorPantalla); // Pasar comprador autenticado
        compradorPantalla.setVisible(true);
    }

    private void abrirVistaVendedor() {
        vista.dispose();
        EnvioGUI vendedorPantalla = new EnvioGUI();
        vendedorPantalla.setVisible(true);
    }
}