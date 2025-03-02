package Tienda.Modelo;

public class DLC extends Producto {
    private String tituloJuego; // Título del juego base
    private String contenidoAdicional; // Descripción del contenido adicional

    // Constructor
    public DLC(String titulo, String sku, double precio, int stock, String tituloJuego, String contenidoAdicional) {
        super(titulo, sku, precio, stock); // Llama al constructor de la clase base (Producto)
        this.tituloJuego = tituloJuego;
        this.contenidoAdicional = contenidoAdicional;
    }

    // ------------------ Getters ------------------
    public String getTituloJuego() {
        return tituloJuego;
    }

    public String getContenidoAdicional() {
        return contenidoAdicional;
    }

    // ------------------ Setters ------------------
    public void setTituloJuego(String tituloJuego) {
        this.tituloJuego = tituloJuego;
    }

    public void setContenidoAdicional(String contenidoAdicional) {
        this.contenidoAdicional = contenidoAdicional;
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "DLC: " + getTitulo() + " - $" + getPrecio() + " | Juego Base: " + tituloJuego + " | Contenido: " + contenidoAdicional;
    }
}