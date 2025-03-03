package Tienda.Modelo;

public class VideojuegoDigital extends Videojuego {
    private double tamanoDescarga; // en GB
    private String drm; // Sistema de gestión de derechos digitales

    // Constructor
    public VideojuegoDigital(String titulo, String sku, double precio, int stock, String genero, String desarrollador, double tamanioDescarga, String drm) {
        super(titulo, sku, precio, stock, genero, desarrollador); // Llama al constructor de Videojuego
        this.tamanoDescarga = tamanioDescarga;
        this.drm = drm;
    }

    public VideojuegoDigital(String titulo, double precio) {
        super(titulo, precio);
    }

    // ------------------ Getters ------------------
    public double getTamanioDescarga() {
        return tamanoDescarga;
    }

    public String getDrm() {
        return drm;
    }

    // ------------------ Setters ------------------
    public void setTamanioDescarga(double tamanioDescarga) {
        this.tamanoDescarga = tamanioDescarga;
    }

    public void setDrm(String drm) {
        this.drm = drm;
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
    return "Digital: " + getTitulo() + " - $" + getPrecio() + " | Género: " + getGenero() + " | Desarrollador: " + getDesarrollador();
    }
}
