package Tienda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 1. Crear instancias básicas ==========================================
        MetodoDePago tarjeta = new TarjetaDeCredito("1234-5678-9012-3456");
        Historial historialComprador = new Historial();
        Historial historialVendedor = new Historial();

        // 2. Crear usuarios ===================================================
        Vendedor vendedor = new Vendedor(
                1001,
                "GameShop",
                "tienda@gameshop.com",
                "password123",
                "Calle Mayor 5, Madrid"
        );

        Comprador comprador = new Comprador(
                2001,
                "Ana López",
                "ana@email.com",
                "claveSegura",
                "Av. Libertad 20, Barcelona"
        );
        comprador.setMetodoPago(tarjeta);
        comprador.setHistorial(historialComprador);
        vendedor.setHistorial(historialVendedor);

        // 3. Vendedor publica productos =======================================
        Producto ps5 = new Producto(
                "PlayStation 5",
                "PS5",
                "SKU-PS5",
                499.99,
                10
        );

        vendedor.publicarProducto(ps5);
        vendedor.publicarProducto(new Producto(
                "The Legend of Zelda",
                "Nintendo Switch",
                "SKU-ZELDA",
                59.99,
                5
        ));

        // 4. Comprador interactúa con el carrito ==============================
        comprador.getCarrito().agregarProducto(ps5, 1);  // Compra 1 PS5
        comprador.getCarrito().agregarProducto(vendedor.getInventario().get(1), 2);  // Compra 2 copias de Zelda

        // 5. Procesar transacción =============================================
        Transaccion transaccion = new Transaccion(
                comprador,
                vendedor,
                comprador.getCarrito().calcularTotal(),
                "Tarjeta de crédito"
        );

        System.out.println("=== ANTES DE LA TRANSACCIÓN ===");
        System.out.println("Stock PS5: " + ps5.getStock());
        System.out.println("Saldo vendedor: $" + vendedor.getSaldo());
        System.out.println("Carrito total: $" + comprador.getCarrito().calcularTotal());

        boolean exito = transaccion.procesar();  // ¡Momento clave!

        System.out.println("\n=== DESPUÉS DE LA TRANSACCIÓN ===");
        System.out.println("Resultado: " + (exito ? "ÉXITO" : "FALLO"));
        System.out.println("Stock PS5: " + ps5.getStock());
        System.out.println("Saldo vendedor: $" + vendedor.getSaldo());
        System.out.println("Transacciones en historial: " + historialComprador.getTransacciones().size());
    }
}

// Clases auxiliares necesarias
class TarjetaDeCredito implements MetodoDePago {
    private String numero;

    public TarjetaDeCredito(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean procesarPago(double monto) {
        // Simulación: Siempre aprobado
        System.out.println("Cobrando $" + monto + " a tarjeta " + numero.substring(15));
        return true;
    }
}