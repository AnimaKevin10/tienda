package Tienda.Modelo;

public class VideojuegoFisico extends Videojuego {
    private double peso; // en kg
    private String dimensiones; // en cm

    // Constructor
    public VideojuegoFisico(String titulo, String sku, double precio, int stock, String genero, String desarrollador, double peso, String dimensiones) {
        super(titulo, sku, precio, stock, genero, desarrollador); // Llama al constructor de Videojuego
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    // ------------------ Getters ------------------
    public double getPeso() {
        return peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    // ------------------ Setters ------------------
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    // Método para verificar si el envío está disponible
    public boolean envioDisponible() {
        return peso <= 5; // Ejemplo: solo se envía si pesa menos de 5 kg
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "Físico: " + getTitulo() + " - $" + getPrecio() + " | Género: " + getGenero() + " | Desarrollador: " + getDesarrollador();
    }
}