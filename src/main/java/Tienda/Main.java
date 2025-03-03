package Tienda;

import Tienda.Vista.*;
import Tienda.Controlador.*;
import Tienda.Modelo.*;

public class Main {

    public static void main(String[] args) {
        Comprador compradorEjemplo = new Comprador(
                123,
                "Ana Pérez",
                "ana@tienda.com",
                "password123",
                "Calle Falsa"
        );
        compradorEjemplo.setFechaNacimiento("1995-05-15"); // Establecer fecha

        VistaComprador vista = new VistaComprador();
        new CompradorController(compradorEjemplo, vista);
        vista.setVisible(true);

    
    // Vincular controlador
    new CompradorController(compradorEjemplo, vista);
    
        // Crear la vista de inicio de sesión
        InicioSesion vistaLogin = new InicioSesion();

        // Crear el controlador y vincularlo con la vista
        LoginController controlador = new LoginController(vistaLogin);

        // Configurar el controlador en la vista (si es necesario)
        vistaLogin.agregarControlador(controlador);

        // Mostrar la vista
        vistaLogin.setVisible(true);
    }
}