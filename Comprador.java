package Model;

public class Comprador extends Usuario {
    private MetodoDePago metodoPago;
    private CarritoDeCompras carrito;
    private MetodoEnvio metodoEnvio;

    public Comprador(String nombre, MetodoDePago metodoPago) {
        super(nombre);
        if (metodoPago == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo.");
        }
        this.metodoPago = metodoPago;
        this.carrito = new CarritoDeCompras();
    }

    public MetodoDePago getMetodoPago() {
        return metodoPago;
    }

    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    public void setMetodoEnvio(MetodoEnvio metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
    }

    public MetodoEnvio getMetodoEnvio() {
        return metodoEnvio;
    }
}