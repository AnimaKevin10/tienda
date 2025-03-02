import Model.*;
import View.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TiendaJuegos tienda = TiendaJuegos.getInstancia();

        tienda.agregarProducto(new Producto("The Witcher 3", 29.99, "Aventura"));
        tienda.agregarProducto(new Producto("Cyberpunk 2077", 49.99, "Acción"));
        tienda.agregarProducto(new Producto("FIFA 23", 59.99, "Deportes"));
        tienda.agregarProducto(new Producto("Civilization VI", 39.99, "Estrategia"));

        SwingUtilities.invokeLater(() -> {
            BusquedaGUI busquedaGUI = new BusquedaGUI(tienda);
            PagoGUI pagoGUI = new PagoGUI();
            EnvioGUI envioGUI = new EnvioGUI();
            AdminPanelGUI adminPanelGUI = new AdminPanelGUI();

            busquedaGUI.setVisible(true);
            pagoGUI.setVisible(true);
            envioGUI.setVisible(true);
            adminPanelGUI.setVisible(true);
        });
    }
}