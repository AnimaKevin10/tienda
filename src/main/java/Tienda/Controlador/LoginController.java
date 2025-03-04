package Tienda.Controlador;

import Tienda.Modelo.Comprador;
import Tienda.Modelo.Historial;
import Tienda.Modelo.Vendedor;
import Tienda.Vista.EnvioGUI;
import Tienda.Vista.InicioSesion;
import Tienda.Vista.VistaComprador;
import Tienda.Vista.VistaVendedor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class LoginController extends MouseAdapter {
    private final InicioSesion vista;

    public LoginController(InicioSesion vista) {
        this.vista = vista;
        configurarAccesos();
    }

    private void configurarAccesos() {
        //vista.getJLabel3().setEnabled(false);
        vista.agregarControlador(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String usuario = vista.getUsuario();
        String contrasena = vista.getContrasena();

        if (autenticarComprador(usuario, contrasena)) {
            abrirVistaComprador(crearCompradorEjemplo());
        } else if (autenticarVendedor(usuario, contrasena)) {
            abrirVistaVendedor(crearVendedorEjemplo());
        } else {
            mostrarErrorCredenciales();
        }
    }

    private boolean autenticarComprador(String usuario, String contrasena) {
        return usuario.equals("comprador") && contrasena.equals("123");
    }

    private boolean autenticarVendedor(String usuario, String contrasena) {
        return usuario.equals("vendedor") && contrasena.equals("456");
    }

    private Comprador crearCompradorEjemplo() {
        return new Comprador(
                123,
                "Ana Pérez",
                "ana@tienda.com",
                "contraseña",
                "2000-01-01",
                "Calle Falsa 123",
                "555-1234", // Fecha de nacimiento
                new Historial()
        );
    }
    private Vendedor crearVendedorEjemplo() {
        return new Vendedor(
                123,
                "Ronald Pérez",
                "Rana@tienda.com",
                "c2ontraseña",
                 "2000-01-01",
                 "323231123",
                new Historial()
        );
    }

    private void abrirVistaComprador(Comprador comprador) {
        vista.dispose();
        new VistaComprador(comprador).setVisible(true);
    }

    private void abrirVistaVendedor(Vendedor vendedor) {
        vista.dispose();
        new VistaVendedor(vendedor).setVisible(true);
    }

    private void mostrarErrorCredenciales() {
        JOptionPane.showMessageDialog(
                vista,
                "Credenciales incorrectas",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}