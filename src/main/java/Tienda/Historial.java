package Tienda;
import java.util.List;
import java.util.ArrayList; // Importación faltante

public class Historial {
    private List<Transaccion> transacciones;
    private Comprador comprador;

    public Historial(Comprador comprador) {
        this.comprador = comprador;
        this.transacciones = new ArrayList<>(); // Requiere java.util.ArrayList
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public void verHistorial() {
        for (Transaccion t : transacciones) {
            System.out.println(t); // Asegúrate de que Transaccion tenga toString()
        }
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
}