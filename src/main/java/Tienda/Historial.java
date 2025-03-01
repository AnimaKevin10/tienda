package Tienda;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Transaccion> transacciones;

    public Historial() {
        transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
}