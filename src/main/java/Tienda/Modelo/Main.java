package Tienda.Modelo;

import Tienda.Controlador.ControladorTienda;

package Tienda;

import Tienda.vista.InicioSesion;
import Tienda.controlador.LoginController;

public class Main {
    public static void main(String[] args) {
        // Crear la vista
        InicioSesion vistaLogin = new InicioSesion();
        
        // Crear el controlador y vincularlo con la vista
        LoginController controlador = new LoginController(vistaLogin);
        vistaLogin.setControlador(controlador);
        
        // Mostrar la vista
        vistaLogin.setVisible(true);
    }
}