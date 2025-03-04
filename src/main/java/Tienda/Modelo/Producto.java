package Tienda.Modelo;

public class Producto {
    private String titulo;
    private String sku;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String titulo, String sku, double precio, int stock) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.titulo = titulo;
        this.sku = sku;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String titulo, double precio) {
        this.titulo=titulo;
        this.precio=precio;
    }

    public Producto(String titulo, String sku, double precio, String genero, int stock) {
        this.titulo=titulo;
        this.sku=sku;
        this.precio=precio;
        this.stock=stock;
    }

    // ------------------ Getters ------------------
    public int getStock() {
        return stock;
    }

    public String getSku() {
        return sku;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    // ------------------ Setter para stock ------------------
    public void setStock(int nuevoStock) {
        if (nuevoStock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = nuevoStock;
    }

    public void setPrecio(double precio) { // Método agregado
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
    
    // Método para reducir el stock
    public void reducirStock(int cantidad) {
        if (cantidad > stock) {
            throw new IllegalArgumentException("No hay suficiente stock disponible.");
        }
        this.stock -= cantidad;
    }

    // Método para calcular el precio con descuento
    public double calcularPrecioConDescuento(double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
        return precio * (1 - descuento / 100);
    }

    // Sobrescribir equals() y hashCode() para comparar productos por SKU
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return sku.equals(producto.sku);
    }

    @Override
    public int hashCode() {
        return sku.hashCode();
    }

    // Sobrescribir toString()
    @Override
    public String toString() {
        return titulo + " - $" + String.format("%.2f", precio) + " (SKU: " + sku + ", Stock: " + stock + ")";
    }

    Object getCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}