package Tienda.Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private List<Producto> productos; // Lista de productos en el carrito
    private List<Integer> cantidades; // Lista de cantidades de cada producto

    // Constructor
    public CarritoDeCompras() {
        productos = new ArrayList<>();
        cantidades = new ArrayList<>();
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            productos.add(producto);
            cantidades.add(cantidad);
            producto.setStock(producto.getStock() - cantidad); // Reducir el stock del producto
            System.out.println(cantidad + " unidad(es) de " + producto.getTitulo() + " agregada(s) al carrito.");
        } else {
            System.out.println("No hay suficiente stock para " + producto.getTitulo());
        }
    }

    // Método para eliminar un producto del carrito
    public void eliminarProducto(Producto producto) {
        int index = productos.indexOf(producto);
        if (index != -1) {
            int cantidad = cantidades.get(index);
            producto.setStock(producto.getStock() + cantidad); // Restaurar el stock del producto
            productos.remove(index);
            cantidades.remove(index);
            System.out.println(producto.getTitulo() + " eliminado del carrito.");
        } else {
            System.out.println("El producto no está en el carrito.");
        }
    }

    // Método para calcular el total de la compra
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }

    // Método para mostrar el contenido del carrito
    public void mostrar() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("=== Contenido del Carrito ===");
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                int cantidad = cantidades.get(i);
                System.out.println(producto.getTitulo() + " - $" + producto.getPrecio() + " x " + cantidad + " = $" + (producto.getPrecio() * cantidad));
            }
            System.out.println("Total: $" + calcularTotal());
        }
    }

    // Método para guardar el carrito (simulado)
    public void guardar() {
        System.out.println("Carrito guardado correctamente.");
        // Aquí podrías implementar la lógica para guardar el carrito en una base de datos o archivo
    }
    
    // Método para aplicar una promoción a un producto en el carrito
    public void aplicarPromocion(Producto producto, Promocion promocion) {
        if (productos.contains(producto)) {
            promocion.aplicarDescuento(producto);
        } else {
            System.out.println("El producto no está en el carrito.");
        }
    }
}