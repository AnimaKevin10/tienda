package Tienda.Controlador;

import Tienda.Modelo.Producto;
import Tienda.Modelo.CarrodeCompras;
import Tienda.Vista.VentanaCarrito;
import javax.swing.*;
import java.util.List;

public class ControladorCarritoCompras {
    private CarrodeCompras carrito;

    public ControladorCarritoCompras(CarrodeCompras carrito) {
        this.carrito = carrito;
    }

    public void mostrarCarrito() {
        new VentanaCarrito(this);
    }

    public List<Producto> obtenerProductos() {
        return carrito.getProductos();
    }

    public void eliminarProducto(Producto producto) {
        carrito.getProductos().remove(producto);
        JOptionPane.showMessageDialog(null, "Producto eliminado del carrito");
    }

    public double obtenerTotal() {
        return carrito.calcularTotal();
    }

    public void realizarCompra() {
        if (carrito.getProductos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío");
            return;
        }
        JOptionPane.showMessageDialog(null, "Compra realizada con éxito!");
        carrito.limpiarCarrito();
    }
}
