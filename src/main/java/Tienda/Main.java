package Tienda;

import Tienda.Vista.*;
import Tienda.Controlador.*;
import Tienda.Modelo.*;

public class Main {
    public static void main(String[] args) {
        InicioSesion vistaLogin = new InicioSesion();
        LoginController controlador = new LoginController(vistaLogin); // El controlador ya se vincula automáticamente
        vistaLogin.setVisible(true);
    }
}