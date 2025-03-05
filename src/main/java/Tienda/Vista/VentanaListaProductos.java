package Tienda.Vista;

import Tienda.Controlador.ControladorListaProductos;
import Tienda.Modelo.Producto;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaListaProductos extends JFrame {
    private JPanel panelProductos;
    private ControladorListaProductos controlador;
    private JButton btnVerCarrito;

    public VentanaListaProductos(ControladorListaProductos controlador) {
        this.controlador = controlador;
        setTitle("Lista de Videojuegos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con título y botón de ver carrito
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Tienda de Videojuegos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        
        btnVerCarrito = new JButton("Ver Carrito");
        btnVerCarrito.addActionListener(e -> controlador.verCarrito());
        
        panelSuperior.add(titulo, BorderLayout.CENTER);
        panelSuperior.add(btnVerCarrito, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel con lista de productos
        panelProductos = new JPanel(new GridLayout(0, 2, 10, 10));
        JScrollPane scrollPane = new JScrollPane(panelProductos);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar productos
        cargarProductos(controlador.obtenerProductos());
    }

    private void cargarProductos(List<Producto> productos) {
        panelProductos.removeAll();

        for (Producto producto : productos) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            JLabel lblNombre = new JLabel(producto.getTitulo(), SwingConstants.CENTER);
            lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel lblPrecio = new JLabel("Precio: $" + producto.getPrecio(), SwingConstants.CENTER);
            JButton btnComprar = new JButton("Agregar al carrito");
            
            btnComprar.addActionListener(e -> controlador.agregarAlCarrito(producto));
            
            panel.add(lblNombre, BorderLayout.NORTH);
            panel.add(lblPrecio, BorderLayout.CENTER);
            panel.add(btnComprar, BorderLayout.SOUTH);
            
            panelProductos.add(panel);
        }
        panelProductos.revalidate();
        panelProductos.repaint();
    }
}