package Model;

public class Producto {
    private String titulo;
    private double precio;
    private String categoria;

    public Producto(String titulo, double precio, String categoria) {
        this.titulo = titulo;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }
}