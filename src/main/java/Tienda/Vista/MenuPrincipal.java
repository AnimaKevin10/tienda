package Tienda.Vista;

import Tienda.Controlador.ControladorListaProductos;
import Tienda.Controlador.ControladorCarritoCompras;
import Tienda.Controlador.ControladorGestionProductos;
import Tienda.Modelo.TiendaJuegos;
import Tienda.Modelo.CarrodeCompras;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private ControladorListaProductos controladorLista;
    private ControladorCarritoCompras controladorCarrito;
    private ControladorGestionProductos controladorGestion;

    public MenuPrincipal() {
        setTitle("Tienda de Videojuegos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Instancias de controladores
        TiendaJuegos tienda = TiendaJuegos.getInstancia();
        CarrodeCompras carrito = new CarrodeCompras();
        controladorLista = new ControladorListaProductos(tienda, carrito);
        controladorCarrito = new ControladorCarritoCompras(carrito);
        controladorGestion = new ControladorGestionProductos(tienda);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton btnVerProductos = new JButton("Ver Productos");
        JButton btnVerCarrito = new JButton("Ver Carrito");
        JButton btnGestionarProductos = new JButton("Gestionar Productos");

        btnVerProductos.addActionListener(e -> new VentanaListaProductos(controladorLista));
        btnVerCarrito.addActionListener(e -> controladorCarrito.mostrarCarrito());
        btnGestionarProductos.addActionListener(e -> new VentanaGestionProductos(controladorGestion, null));

        panelBotones.add(btnVerProductos);
        panelBotones.add(btnVerCarrito);
        panelBotones.add(btnGestionarProductos);

        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
