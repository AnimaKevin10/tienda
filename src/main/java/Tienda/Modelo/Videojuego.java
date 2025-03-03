package Tienda.Modelo;

public class Videojuego extends Producto {
    private String genero;
    private String desarrollador;

    // Constructor
    public Videojuego(String titulo, String sku, double precio, int stock, String genero, String desarrollador) {
        super(titulo, sku, precio, stock); // Llama al constructor de la clase base (Producto)
        this.genero = genero;
        this.desarrollador = desarrollador;
    }

    public Videojuego(String titulo, double precio) {
        super(titulo, precio);
    }

    // ------------------ Getters ------------------
    public String getGenero() {
        return genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    // ------------------ Setters ------------------
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return super.toString() + " | Género: " + genero + " | Desarrollador: " + desarrollador;
    }
}