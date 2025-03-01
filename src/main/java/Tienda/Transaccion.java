import java.util.Date;

public class Transaccion {
    private Comprador comprador;
    private Vendedor vendedor;
    private double total;
    private Date fecha;
    private String metodoReembolso;

    // Constructor que recibe comprador, vendedor, total y método de reembolso
    public Transaccion(Comprador comprador, Vendedor vendedor, double total, String metodoReembolso) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.total = total;
        this.fecha = new Date(); // Fecha actual automática
        this.metodoReembolso = metodoReembolso;
    }

    // Procesa la transacción validando pago, stock y actualizando registros
    public boolean procesar() {
        // 1. Validar método de pago
        if (!comprador.getMetodoPago().procesarPago(total)) {
            System.out.println("Error: Pago no procesado");
            return false;
        }

        // 2. Verificar stock en el inventario del vendedor
        for (Producto producto : comprador.getCarrito().getProductos()) {
            Producto productoEnInventario = vendedor.buscarProducto(producto.getSku());
            if (productoEnInventario == null || productoEnInventario.getStock() <= 0) {
                System.out.println("Error: Stock insuficiente para " + producto.getTitulo());
                return false;
            }
        }

        // 3. Actualizar inventario y saldo
        comprador.getCarrito().getProductos().forEach(producto -> {
            vendedor.actualizarStock(producto.getSku(), producto.getStock() - 1);
        });
        vendedor.agregarSaldo(total);

        // 4. Registrar en historiales
        comprador.getHistorial().agregarTransaccion(this);
        vendedor.getHistorial().agregarTransaccion(this);

        System.out.println("Transacción completada exitosamente");
        return true;
    }

    // Getters para acceso a los datos de la transacción
    public Comprador getComprador() { return comprador; }
    public Vendedor getVendedor() { return vendedor; }
    public double getTotal() { return total; }
    public Date getFecha() { return fecha; }
    public String getMetodoReembolso() { return metodoReembolso; }
}