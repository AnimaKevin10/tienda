package Tienda;

public class Resena {
    private Comprador comprador;    // Composición (diamante blanco)
    private Producto producto;  // Agregación (diamante negro) - Omitido temporalmente
    private int calificacion;
    private String comentario;

    // Constructor sin Producto (se omite por ahora)
    public Resena(Usuario comprador, Producto laptop, int calificacion, String comentario) {
        this.comprador = (Comprador) comprador;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }


    // Getters
    public Usuario getComprador() { return comprador; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }

    @Override
    public String toString() {
        return "Reseña de " + comprador.getNombre() +
                "\nCalificación: " + "★".repeat(calificacion) +
                "\nComentario: \"" + comentario + "\"";
    }
}