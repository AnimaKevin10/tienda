package Tienda.Vista;

import Tienda.Controlador.ControladorCarritoCompras;
import Tienda.Modelo.Producto;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaCarrito extends JFrame {
    private ControladorCarritoCompras controlador;
    private JPanel panelCarrito;
    private JLabel lblTotal;

    public VentanaCarrito(ControladorCarritoCompras controlador) {
        this.controlador = controlador;
        setTitle("Carrito de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de productos en el carrito
        panelCarrito = new JPanel(new GridLayout(0, 1, 10, 10));
        JScrollPane scrollPane = new JScrollPane(panelCarrito);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con total y botón de compra
        JPanel panelInferior = new JPanel(new FlowLayout());
        lblTotal = new JLabel("Total: $" + controlador.obtenerTotal());
        JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(e -> realizarCompra());
        panelInferior.add(lblTotal);
        panelInferior.add(btnComprar);
        add(panelInferior, BorderLayout.SOUTH);

        cargarCarrito();
        setVisible(true);
    }

    private void cargarCarrito() {
        panelCarrito.removeAll();
        List<Producto> productos = controlador.obtenerProductos();

        for (Producto producto : productos) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            JLabel lblNombre = new JLabel(producto.getTitulo(), SwingConstants.CENTER);
            JLabel lblPrecio = new JLabel("Precio: $" + producto.getPrecio(), SwingConstants.CENTER);
            JButton btnEliminar = new JButton("Eliminar");
            
            btnEliminar.addActionListener(e -> eliminarProducto(producto));
            
            panel.add(lblNombre, BorderLayout.NORTH);
            panel.add(lblPrecio, BorderLayout.CENTER);
            panel.add(btnEliminar, BorderLayout.SOUTH);
            
            panelCarrito.add(panel);
        }
        actualizarTotal();
        panelCarrito.revalidate();
        panelCarrito.repaint();
    }

    private void eliminarProducto(Producto producto) {
        controlador.eliminarProducto(producto);
        cargarCarrito();
    }

    private void realizarCompra() {
        controlador.realizarCompra();
        cargarCarrito();
    }

    private void actualizarTotal() {
        lblTotal.setText("Total: $" + controlador.obtenerTotal());
    }
}
