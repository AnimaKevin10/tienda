package Tienda.Modelo;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Transaccion> transacciones;

    public Historial() {
        transacciones = new ArrayList<>();
        System.out.println("[HISTORIAL] Historial creado");
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        System.out.println("[HISTORIAL] Transacción añadida: " + transaccion.getProducto().getTitulo());
    }

    public List<Transaccion> getTransacciones() {
        System.out.println("[HISTORIAL] Obteniendo transacciones: " + transacciones.size());
        return transacciones;
    }
}
