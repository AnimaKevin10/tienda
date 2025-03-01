package Tienda;

public class Producto {
    private String titulo;
    private String sku;
    private double precio;
    private int stock;

    // Constructor básico
    public Producto(String titulo, String sku, double precio, int stock) {
        this.titulo = titulo;
        this.sku = sku;
        this.precio = precio;
        this.stock = stock;
    }

    // ------------------ Getters necesarios ------------------
    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getSku() {
        return sku;
    }
    public String getTitulo() {
        return titulo;
    }
    // ------------------ Setter para stock ------------------
    public void setStock(int nuevoStock) {
        this.stock = nuevoStock;
    }
}