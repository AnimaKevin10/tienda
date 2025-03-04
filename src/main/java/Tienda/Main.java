package Tienda;

import Tienda.Vista.*;
import Tienda.Controlador.*;
import Tienda.Modelo.*;

public class Main {
    public static void main(String[] args) {
        // Configurar vista y controlador de login
        InicioSesion vistaLogin = new InicioSesion();
        LoginController loginController = new LoginController(vistaLogin);

        // Crear datos demo
        crearDatosDemo(vistaLogin);
    }

    private static void crearDatosDemo(InicioSesion vistaLogin) {
        // ================== CREAR COMPRADOR ================== //
        Comprador compradorDemo = new Comprador(
                1,                          // idUsuario
                "Juan Pérez",               // nombre
                "juan@comprador.com",       // correo
                "clave123",                 // contraseña
                "1990-01-01",               // fechaNacimiento
                "Calle Falsa 123",          // dirección
                "555-1234",                 // teléfono
                new Historial()             // historial
        );

        // ================== CREAR VENDEDOR ================== //
        Vendedor vendedorDemo = new Vendedor(
                2,                          // idUsuario
                "Ana López",                // nombre
                "ana@vendedor.com",         // correo
                "clave456",                 // contraseña
                "1985-05-15",               // fechaNacimiento
                "555-9876",                 // teléfono
                new Historial()             // historialVentas
        );
        vendedorDemo.agregarSaldo(1500.00);

        // ================== PRODUCTOS DEMO ================== //
        VideojuegoDigital cyberpunk = new VideojuegoDigital(
                "CP2077",
                "Cyberpunk 2077",
                59.99,
                "Juego de rol futurista",
                50
        );

        VideojuegoFisico zelda = new VideojuegoFisico(
                "ZELDA1",
                "The Legend of Zelda",
                69.99,
                "Aventura épica",
                30
        );

        // Publicar productos en el inventario del vendedor
        vendedorDemo.publicarProducto(cyberpunk);
        vendedorDemo.publicarProducto(zelda);

        // ================== TRANSACCIÓN DEMO ================== //
        Transaccion transaccionDemo = new Transaccion(
                compradorDemo,
                vendedorDemo,
                cyberpunk,
                1,          // cantidad
                59.99,      // total
                "Tarjeta"   // método de pago
        );

        // Registrar en ambos historiales
        compradorDemo.getHistorial().agregarTransaccion(transaccionDemo);
        vendedorDemo.getHistorialVentas().agregarTransaccion(transaccionDemo);

        // ================== CONFIGURAR VISTAS ================== //
        VistaComprador vistaComprador = new VistaComprador(compradorDemo);
        new CompradorController(compradorDemo, vistaComprador);

        VistaVendedor vistaVendedor = new VistaVendedor(vendedorDemo);
        new VendedorController(vendedorDemo, vistaVendedor);

        // Mostrar login
        vistaLogin.setVisible(true);
    }
}