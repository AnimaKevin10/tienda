package Tienda;

import Tienda.Vista.*;
import Tienda.Controlador.*;
import Tienda.Modelo.*;

public class Main {
    public static void main(String[] args) {

        InicioSesion vistaLogin = new InicioSesion();
        LoginController controlador = new LoginController(vistaLogin); // El controlador ya se vincula automáticamente
        Comprador comprador = new Comprador(12,"Juan", "juan@example.com", "123456", "Calle 123", "01/01/1990", "555-1234",new Historial());
        VistaComprador vista = new VistaComprador(comprador);

        // Añadir datos de prueba
        agregarDatosPrueba(comprador);

        // Mostrar la vista
        vista.setVisible(true);
    }

    private static void agregarDatosPrueba(Comprador comprador) {
        // Crear productos de prueba
        Producto producto1 = new VideojuegoDigital("Cyberpunk 2077", 59.99);
        Producto producto2 = new VideojuegoFisico("The Legend of Zelda", 69.99);

        Transaccion t1 = new Transaccion(comprador, new Vendedor(10,"kev","kedan","123","123"), producto1, 59.99, "Tarjeta");
        Transaccion t2 = new Transaccion(comprador, new Vendedor(120,"dan","ken","1233","1223"), producto2, 69.99, "Efectivo");

        comprador.getHistorial().agregarTransaccion(t1);
        comprador.getHistorial().agregarTransaccion(t2);

        System.out.println("[PRUEBA] 2 transacciones añadidas al historial");
    }
}