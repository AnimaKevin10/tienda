package Tienda;
public class Main {
    public static void main(String[] args) {
        // Crear comprador y vendedor
        Comprador ana = new Comprador(12, "C-001");
        Vendedor juan = new Vendedor(11, "V-001");

        // Simular datos de una transacción (el carrito lo maneja otro)
        double totalCompra = 150.0;
        String metodoReembolso = "Tarjeta";

        // Facturar
        ana.facturar(juan, totalCompra, metodoReembolso);

        // Crear reseña
        Resena resena = new Resena(ana, juan, "Excelente servicio", 5);
    }
}