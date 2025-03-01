package Tienda;

import java.util.List;

public class Historial {
    private List<Transaccion> transacciones;
    private Comprador comprador;

    public Historial(Comprador comprador) {
        this.comprador = comprador;
        this.transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public void verHistorial() {
        for (Transaccion t : transacciones) {
            System.out.println(t);
        }
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
}
