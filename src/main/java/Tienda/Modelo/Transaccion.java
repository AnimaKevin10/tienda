package Tienda.Modelo;

public class Transaccion {
    private Comprador comprador;
    private Vendedor vendedor;
    private double total;
    private String metodoReembolso;

    public Transaccion(Comprador comprador, Vendedor vendedor, double total, String metodoReembolso) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.total = total;
        this.metodoReembolso = metodoReembolso;
    }

    // Getters básicos
    public Comprador getComprador() { return comprador; }
    public Vendedor getVendedor() { return vendedor; }
    public double getTotal() { return total; }
}