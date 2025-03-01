package Tienda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Producto ps5 = new Producto("PlayStation 5", "SKU-PS5", 499.99, 10);
        Producto zelda = new Producto("The Legend of Zelda", "SKU-ZELDA", 59.99, 5);

        Vendedor vendedor = new Vendedor(1001, "GameShop", "tienda@example.com", "pass123", "Calle Falsa 123");
        vendedor.publicarProducto(ps5);
        vendedor.publicarProducto(zelda);

        Comprador comprador = new Comprador(2001, "Ana", "ana@example.com", "clave123", "Av. Siempreviva 742");
        comprador.getCarrito().agregarProducto(ps5, 1);
        comprador.getCarrito().agregarProducto(zelda, 2);

        Transaccion transaccion = new Transaccion(comprador, vendedor, comprador.getCarrito().calcularTotal(), "Efectivo");
        boolean exito = transaccion.procesar();

        System.out.println("Stock PS5: " + ps5.getStock());
        System.out.println("Stock Zelda: " + zelda.getStock());
    }
}
