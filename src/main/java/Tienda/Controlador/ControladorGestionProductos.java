package Tienda.Controlador;

import Tienda.Modelo.Producto;
import Tienda.Modelo.TiendaJuegos;
import javax.swing.*;

public class ControladorGestionProductos {
    private TiendaJuegos tienda;

    public ControladorGestionProductos(TiendaJuegos tienda) {
        this.tienda = tienda;
    }

    public void agregarProducto(Producto producto) {
        tienda.agregarProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto agregado con éxito");
    }

    public void editarProducto(Producto producto, String nuevoTitulo, double nuevoPrecio, int nuevoStock) {
        producto.setTitulo(nuevoTitulo);
        producto.setPrecio(nuevoPrecio);
        producto.setStock(nuevoStock);
        JOptionPane.showMessageDialog(null, "Producto editado con éxito");
    }
}
