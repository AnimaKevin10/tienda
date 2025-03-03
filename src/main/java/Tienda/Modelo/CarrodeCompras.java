package Tienda.Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarrodeCompras {
    private List<Producto> productos;  // Lista de productos en el carrito

    public CarrodeCompras() {
        productos = new ArrayList<>();
    }
    // Añade un producto al carrito (soporta cantidad)
    public void agregarProducto(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            productos.add(producto);
        }
    }
    // Calcula el total sumando el precio de cada producto en la lista
    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    // Devuelve la lista de productos (para procesar la transacción)
    public List<Producto> getProductos() {
        return productos;
    }

    public void limpiarCarrito() {
    }
}