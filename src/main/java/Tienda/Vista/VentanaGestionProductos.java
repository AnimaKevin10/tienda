package Tienda.Vista;

import Tienda.Controlador.ControladorGestionProductos;
import Tienda.Modelo.Producto;
import javax.swing.*;
import java.awt.*;

public class VentanaGestionProductos extends JFrame {
    private ControladorGestionProductos controlador;
    private JTextField txtTitulo, txtPrecio, txtStock;
    private JButton btnGuardar, btnCancelar;
    private Producto producto;

    public VentanaGestionProductos(ControladorGestionProductos controlador, Producto producto) {
        this.controlador = controlador;
        this.producto = producto;
        setTitle(producto == null ? "Agregar Producto" : "Editar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        
        add(new JLabel("Título:"));
        txtTitulo = new JTextField(producto != null ? producto.getTitulo() : "");
        add(txtTitulo);
        
        add(new JLabel("Precio:"));
        txtPrecio = new JTextField(producto != null ? String.valueOf(producto.getPrecio()) : "");
        add(txtPrecio);
        
        add(new JLabel("Stock:"));
        txtStock = new JTextField(producto != null ? String.valueOf(producto.getStock()) : "");
        add(txtStock);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarProducto());
        add(btnGuardar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);
        
        setVisible(true);
    }
    
    private void guardarProducto() {
        String titulo = txtTitulo.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());
        
        if (producto == null) {
            controlador.agregarProducto(new Producto(titulo, "SKU-" + System.currentTimeMillis(), precio, stock));
        } else {
            controlador.editarProducto(producto, titulo, precio, stock);
        }
        dispose();
    }
}
