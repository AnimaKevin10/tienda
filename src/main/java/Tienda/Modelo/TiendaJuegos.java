package Tienda.Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiendaJuegos {
    private static TiendaJuegos instancia;
    private Map<String, Producto> productos = new HashMap<>();
    private List<Usuario> usuarios = new ArrayList<>();

    private TiendaJuegos() {
    }

    public static TiendaJuegos getInstancia() {
        if (instancia == null) {
            instancia = new TiendaJuegos();
        }
        return instancia;
    }

    public void agregarProducto(Producto producto) {
        productos.put(producto.getTitulo().toLowerCase(), producto);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void iniciarSesion(Usuario usuario) {
        System.out.println("Sesión iniciada para: " + usuario.getNombre());
    }

    public ResultadoBusqueda buscar(String keyword) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos.values()) {
            if (producto.getTitulo().toLowerCase().contains(keyword.toLowerCase())) {
                resultados.add(producto);
            }
        }
        return new ResultadoBusqueda(resultados);
    }

    public void cerrarSesion() {
        System.out.println("Sesión cerrada.");
    }

    public void procesarCompra(Comprador comprador) {
        double total = comprador.getCarrito().calcularTotal();
        if (comprador.getMetodoPago().procesarPago(total)) {
            System.out.println("Compra procesada con éxito.");
            comprador.getCarrito().limpiarCarrito();
        } else {
            System.out.println("Pago rechazado.");
        }
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos.values()); // Devuelve una copia para evitar modificaciones externas
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios); // Devuelve una copia para evitar modificaciones externas
    }
}
