package Tienda.Controlador;

import Tienda.Modelo.Producto;
import Tienda.Modelo.TiendaJuegos;
import Tienda.Modelo.CarrodeCompras;
import Tienda.Vista.VentanaCarrito;
import java.util.List;

public class ControladorListaProductos {
    private TiendaJuegos tienda;
    private CarrodeCompras carrito;
    private ControladorCarritoCompras controladorCarrito;

    public ControladorListaProductos(TiendaJuegos tienda, CarrodeCompras carrito) {
        this.tienda = tienda;
        this.carrito = carrito;
        this.controladorCarrito = new ControladorCarritoCompras(carrito);
    }

    public List<Producto> obtenerProductos() {
        return tienda.getProductos();
    }

    public void agregarAlCarrito(Producto producto) {
        carrito.agregarProducto(producto, 1);
        System.out.println("Producto agregado al carrito: " + producto.getTitulo());
    }
    
    public void verCarrito() {
        controladorCarrito.mostrarCarrito();
    }
}
