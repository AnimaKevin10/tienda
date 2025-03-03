package Vista;

import javax.swing.*;
import java.awt.*;

public class AdminPanelGUI extends JFrame {
    public AdminPanelGUI() {
        setTitle("Panel de Administración");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel botonesPanel = new JPanel(new FlowLayout());
        JButton gestionarProductos = new JButton("Gestionar Productos");
        JButton gestionarUsuarios = new JButton("Gestionar Usuarios");
        JButton verVentas = new JButton("Ver Ventas");

        botonesPanel.add(gestionarProductos);
        botonesPanel.add(gestionarUsuarios);
        botonesPanel.add(verVentas);

        add(botonesPanel, BorderLayout.NORTH);

    }
}