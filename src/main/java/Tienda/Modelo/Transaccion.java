package Tienda.Modelo;

import java.util.Date;

public class Transaccion {
    private Comprador comprador;
    private Vendedor vendedor;
    private double total;
    private String metodoReembolso;
    private Date fecha;

    public Transaccion(Comprador comprador, Vendedor vendedor, double total, String metodoReembolso) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.total = total;
        this.metodoReembolso = metodoReembolso;
        this.fecha = new Date();
    }

    // Getters completos
    public Comprador getComprador() { return comprador; }
    public Vendedor getVendedor() { return vendedor; }
    public double getTotal() { return total; }
    public String getMetodoReembolso() { return metodoReembolso; } // Añadido
    public Date getFecha() { return fecha; } // Añadido
}