package Tienda.Modelo;
import java.util.List;
import java.util.ArrayList;
public class Vendedor extends Usuario {
    private List<Producto> inventario;
    private double saldo;

    // Constructor con autenticación
    public Vendedor(int idUsuario, String nombre, String correo, String contrasena, String direccion) {
        super(idUsuario, nombre, correo, contrasena, direccion);
        this.inventario = new ArrayList<>();
        this.saldo = 0.0;
    }
    public Vendedor(int idUsuario, String nombre) {
        super(idUsuario, nombre);
        this.inventario = new ArrayList<>();
        this.saldo = 0.0;
    }

    // Publicar un producto en el inventario
    public void publicarProducto(Producto producto) {
        if (producto != null && producto.getStock() > 0) {
            inventario.add(producto);
            System.out.println("Producto publicado: " + producto.getTitulo());
        }
    }

    // Gestionar inventario (añadir/eliminar/actualizar)
    public void gestionarInventario(String sku, int nuevoStock) {
        for (Producto p : inventario) {
            if (p.getSku().equals(sku)) {
                p.setStock(nuevoStock);
                System.out.println("Stock actualizado: " + p.getTitulo() + " → " + nuevoStock);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Añadir saldo tras una venta exitosa
    public void agregarSaldo(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("💰 Saldo actualizado: $" + saldo);
        }
    }

    // Getter para el inventario (usado en la GUI)
    public List<Producto> getInventario() {
        return inventario;
    }
}