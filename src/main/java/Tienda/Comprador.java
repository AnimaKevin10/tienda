package Tienda;
public class Comprador extends Usuario {
    private Historial historial;

    public Comprador(int idUsuario,String nombre) {
        super( idUsuario,nombre);
        this.historial = new Historial();
    }

    public void facturar(Vendedor vendedor, double total, String metodoReembolso) {
        Transaccion transaccion = new Transaccion(this, vendedor, total, metodoReembolso);
        historial.agregarTransaccion(transaccion);
        // El carrito lo maneja otro, así que no lo tocamos aquí
    }

    public Historial getHistorial() {
        return historial;
    }
}