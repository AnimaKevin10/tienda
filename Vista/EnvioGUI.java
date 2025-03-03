package View;

import Model.MetodoEnvio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvioGUI extends JFrame {
    private JComboBox<String> envioOptions;
    private MetodoEnvio metodoEnvio;

    public EnvioGUI() {
        setTitle("Seleccionar Método de Envío");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        envioOptions = new JComboBox<>(new String[]{"Normal", "Express", "Ultra Rápido"});
        JButton seleccionarEnvio = new JButton("Seleccionar");

        seleccionarEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoEnvio = (String) envioOptions.getSelectedItem();
                double costo = 0;
                int tiempo = 0;

                switch (tipoEnvio) {
                    case "Normal":
                        costo = 3.99;
                        tiempo = 5;
                        break;
                    case "Express":
                        costo = 7.99;
                        tiempo = 2;
                        break;
                    case "Ultra Rápido":
                        costo = 12.99;
                        tiempo = 1;
                        break;
                }

                metodoEnvio = new MetodoEnvio(tipoEnvio, costo, tiempo);
                JOptionPane.showMessageDialog(EnvioGUI.this, "Método de envío seleccionado: " + tipoEnvio);
            }
        });

        add(new JLabel("Seleccione un método de envío"));
        add(envioOptions);
        add(seleccionarEnvio);
    }

    public MetodoEnvio getMetodoEnvio() {
        return metodoEnvio;
    }
}
