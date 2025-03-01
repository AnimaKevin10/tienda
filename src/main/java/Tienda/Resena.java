package Tienda;


public class Resena {
    private Comprador comprador;
    private Vendedor vendedor;
    private String comentario;
    private int calificacion; // Ej: 1 a 5 estrellas

    public Resena(Comprador comprador, Vendedor vendedor, String comentario, int calificacion) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public String getComentario() {
        return comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }
}