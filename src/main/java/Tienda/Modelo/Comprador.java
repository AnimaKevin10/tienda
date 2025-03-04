
package Tienda.Modelo;

public class Comprador extends Usuario {
    private Historial historial;

    // Constructor completo
    public Comprador(
            int idUsuario,
            String nombre,
            String correo,
            String contrasena,
            String fechaNacimiento,
            String direccion,
            String telefono,
            Historial historial
    ) {
        super(idUsuario, nombre, correo, contrasena, fechaNacimiento);
        super.setDireccion(direccion);
        super.setTelefono(telefono);
        this.historial = historial;
    }

    // Constructor simplificado
    public Comprador(
            int idUsuario,
            String nombre,
            String correo,
            String direccion,
            String telefono
    ) {
        super(idUsuario, nombre);
        super.setCorreo(correo);
        super.setDireccion(direccion);
        super.setTelefono(telefono);
        this.historial = new Historial();
    }

    public void facturar(Vendedor vendedor, double total, String metodoReembolso, Producto producto) {
        Transaccion transaccion = new Transaccion(this, vendedor, producto, total, metodoReembolso);
        historial.agregarTransaccion(transaccion);
        // El carrito lo maneja otro, así que no lo tocamos aquí
    }

    public Historial getHistorial() {
        return historial;
    }

    public CarrodeCompras getCarrito() {
        return null;
    }

    public MetodoDePago getMetodoPago() {
        return null;
    }
}