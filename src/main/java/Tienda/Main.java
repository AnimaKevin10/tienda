package Tienda;

import Tienda.Vista.InicioSesion;
import Tienda.Controlador.LoginController;

public class Main {
    public static void main(String[] args) {
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