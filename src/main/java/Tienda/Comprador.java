package Tienda;

public class Comprador extends Usuario {
    //private MetodoDePago metodoPago;
    private CarrodeCompras carrito;
    private Historial historial;

    public Comprador(String nombre, String idUsuario, String correo, String contraseña, String direccion) {//no olvdar que aqui va metodo de pago
        super(nombre, idUsuario, correo, contraseña, direccion);
      //  this.metodoPago = metodoPago;
        this.carrito = new CarrodeCompras();
        this.historial = new Historial(this);
    }

    public void obtenerCarrito() {
        return carrito;
    }

    public void facturar() {
        Transaccion transaccion = new Transaccion(this, carrito.calcularTotal());
        historial.agregarTransaccion(transaccion);
        carrito.vaciar();
    }

    public void comprarComoRegalo(Producto producto, Usuario destinatario) {
        System.out.println("Comprando " + producto.getTitulo() + " como regalo para " + destinatario.getNombre());
    }

    public Historial getHistorial() {
        return historial;
    }
}
