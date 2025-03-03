package Tienda.Vista;

import Model.MetodoDePago;
import Model.TarjetaRegalo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoGUI extends JFrame {
    private MetodoDePago metodoPago;

    public PagoGUI() {
        setTitle("Seleccionar Método de Pago");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton tarjetaButton = new JButton("Tarjeta de Crédito");
        JButton tarjetaRegaloButton = new JButton("Tarjeta Regalo");

        tarjetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para tarjeta de crédito
                JOptionPane.showMessageDialog(PagoGUI.this, "Tarjeta de crédito seleccionada");
            }
        });

        tarjetaRegaloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog(PagoGUI.this, "Ingrese el código de la tarjeta de regalo:");
                if (codigo != null && !codigo.isEmpty()) {
                    metodoPago = new TarjetaRegalo(50, codigo, "digital");
                    JOptionPane.showMessageDialog(PagoGUI.this, "Tarjeta de regalo seleccionada");
                }
            }
        });

        add(new JLabel("Seleccione un método de pago:"));
        add(tarjetaButton);
        add(tarjetaRegaloButton);
    }

    public MetodoDePago getMetodoPago() {
        return metodoPago;
    }
}
