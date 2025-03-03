package View;

import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.List;

public class BusquedaGUI extends JFrame {
    private JTextField searchField;
    private TiendaJuegos tienda;
    private JComboBox<String> categoriaFiltro;
    private JSlider precioFiltro;
    private JLabel precioValorLabel;

    public BusquedaGUI(TiendaJuegos tienda) {
        this.tienda = tienda;
        setTitle("Buscar Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel filtroPanel = new JPanel(new FlowLayout());
        categoriaFiltro = new JComboBox<>(new String[]{"Todos", "Acción", "Aventura", "Estrategia", "Deportes"});
        precioFiltro = new JSlider(0, 100, 50);
        precioFiltro.setPaintTicks(true);
        precioFiltro.setPaintLabels(true);

        precioValorLabel = new JLabel("50");
        precioFiltro.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                precioValorLabel.setText(String.valueOf(precioFiltro.getValue()));
            }
        });

        filtroPanel.add(new JLabel("Categoría:"));
        filtroPanel.add(categoriaFiltro);
        filtroPanel.add(new JLabel("Precio:"));
        filtroPanel.add(precioFiltro);
        filtroPanel.add(precioValorLabel);

        JPanel busquedaPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductos();
            }
        });

        busquedaPanel.add(new JLabel("Ingrese el producto: "));
        busquedaPanel.add(searchField);
        busquedaPanel.add(searchButton);

        add(filtroPanel, BorderLayout.NORTH);
        add(busquedaPanel, BorderLayout.CENTER);
    }

    private void buscarProductos() {
        String keyword = searchField.getText();
        ResultadoBusqueda resultado = tienda.buscar(keyword);

        String categoriaSeleccionada = (String) categoriaFiltro.getSelectedItem();
        if (!categoriaSeleccionada.equals("Todos")) {
            resultado = resultado.filtrarPorCategoria(categoriaSeleccionada);
        }

        double precioMaximo = precioFiltro.getValue();
        resultado = resultado.filtrarPorPrecio(0, precioMaximo);

        List<Producto> productos = resultado.getResultados();

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron productos.");
        } else {
            String[] columnNames = {"Título", "Categoría", "Precio"};
            Object[][] data = new Object[productos.size()][3];
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                data[i][0] = producto.getTitulo();
                data[i][1] = producto.getCategoria();
                data[i][2] = producto.getPrecio();
            }
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            JOptionPane.showMessageDialog(this, scrollPane, "Resultados de la Búsqueda", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
