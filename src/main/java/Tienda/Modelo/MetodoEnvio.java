package Tienda.Modelo;

public class MetodoEnvio {
    private String tipo;
    private double costo;
    private int tiempoEntrega;

    public MetodoEnvio(String tipo, double costo, int tiempoEntrega) {
        this.tipo = tipo;
        this.costo = costo;
        this.tiempoEntrega = tiempoEntrega;
    }

    public double calcularCosto() {
        return costo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }
}
