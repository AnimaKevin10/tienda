package Tienda.Modelo;
import java.util.Date;

public class Transaccion {
    private Comprador comprador;
    private Vendedor vendedor;
    private Producto producto;
    private double total;
    private String metodoPago;
    private String metodoReembolso;
    private Date fecha;
    private int cantidad;

    public Transaccion(Comprador comprador, Vendedor vendedor, Producto producto,
                       double total, String metodoReembolso) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.producto = producto;
        this.total = total;
        this.metodoReembolso = metodoReembolso;
        this.fecha = new Date();
    }
    public Transaccion(Comprador comprador,
                       Vendedor vendedor,
                       Producto producto,
                       int cantidad,
                       double total,
                       String metodoPago) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.metodoPago = metodoPago;
        this.fecha = new Date();
    }
    // Getters
    public Producto getProducto() { return producto; }
    public Date getFecha() { return fecha; }
    public double getTotal() { return total; }
    public int getCantidad() { return 1; } // Suponiendo 1 unidad por transacción
    public Comprador getComprador() { return comprador; }
}