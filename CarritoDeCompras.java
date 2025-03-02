package Model;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            productos.add(producto);
        }
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public void limpiarCarrito() {
        productos.clear();
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}