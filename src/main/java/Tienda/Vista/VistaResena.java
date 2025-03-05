package Tienda.Vista;

import Tienda.Modelo.Resena;
import Tienda.Modelo.Comprador;
import Tienda.Modelo.Producto;
import Tienda.Modelo.Historial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaResena extends JPanel {
    private JTextField compradorField;
    private JTextField calificacionField;
    private JTextArea comentarioArea;
    private JButton submitButton;
    private JPanel reviewListPanel;
    private JScrollPane reviewScrollPane;

    public VistaResena() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Comprador:"), gbc);
        compradorField = new JTextField();
        gbc.gridx = 1;
        formPanel.add(compradorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Calificacion (1-5):"), gbc);
        calificacionField = new JTextField();
        gbc.gridx = 1;
        formPanel.add(calificacionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        formPanel.add(new JLabel("Comentario:"), gbc);
        comentarioArea = new JTextArea(4, 20);
        JScrollPane scrollComentario = new JScrollPane(comentarioArea);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        formPanel.add(scrollComentario, gbc);

        submitButton = new JButton("Enviar Reseña");

        reviewListPanel = new JPanel();
        reviewListPanel.setLayout(new BoxLayout(reviewListPanel, BoxLayout.Y_AXIS));
        reviewScrollPane = new JScrollPane(reviewListPanel);
        reviewScrollPane.setPreferredSize(new Dimension(700, 200));

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(submitButton, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(reviewScrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resena resena = createResena(null, null);
                if (resena != null) {
                    addReview(resena);
                    clearFields();
                }
            }
        });
    }

    public String getCompradorNombre() {
        return compradorField.getText();
    }

    public int getCalificacion() {
        try {
            return Integer.parseInt(calificacionField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getComentario() {
        return comentarioArea.getText();
    }

    public void clearFields() {
        compradorField.setText("");
        calificacionField.setText("");
        comentarioArea.setText("");
    }

    public Resena createResena(Comprador comprador, Producto producto) {
        int calificacion = getCalificacion();
        String comentario = getComentario();
        Comprador c = new Comprador(0, getCompradorNombre(), "", "", "", "", "", new Historial());
        return new Resena(c, producto, calificacion, comentario);
    }

    public void addReview(Resena resena) {
        JLabel reviewLabel = new JLabel(resena.toString());
        reviewLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        reviewLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        reviewListPanel.add(reviewLabel);
        reviewListPanel.revalidate();
        reviewListPanel.repaint();
    }


}
