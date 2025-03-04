/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tienda.Vista;

import Tienda.Controlador.VendedorController;
import Tienda.Modelo.Vendedor;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaVendedor extends javax.swing.JFrame {
    private Vendedor vendedor;
    private VendedorController controlador; // Controlador asociado
    private JPanel mainContentPanel; // Panel contenedor con CardLayout
    private JPanel infoBasicaPanel;   // Panel de información básica
    private JPanel ventasPanel;       // Panel de historial de ventas
    private JPanel panelProductos;    // Panel para productos disponibles
    private JTable tablaVentas;       // Tabla para historial de ventas
    private DefaultTableModel modeloTabla; // Modelo de la tabla de ventas

    // Nueva tabla para el inventario (productos disponibles)
    private JTable tablaInventario;
    private DefaultTableModel modeloInventario;

    // Componentes de la sección de información básica
    // Se reutiliza jPanel1 para esta sección (infoBasicaPanel)
    // Además, se añade el campo de saldo
    private javax.swing.JTextField tituloSaldo;
    private javax.swing.JTextField vendedorSaldo;

    // Componentes generados (no modificables)
    private javax.swing.JLabel fotoperfil;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane slidemenu;
    private javax.swing.JTextField tituloCorreo;
    private javax.swing.JTextField tituloDireccion;
    private javax.swing.JTextField tituloID;
    private javax.swing.JTextField tituloNacimiento;
    private javax.swing.JTextField tituloNombre;
    private javax.swing.JTextField tituloTelefono;
    private javax.swing.JTextField vendedorCorreo;
    private javax.swing.JTextField vendedorDireccion;
    private javax.swing.JTextField vendedorID;
    private javax.swing.JTextField vendedorNacimiento;
    private javax.swing.JTextField vendedorNombre;
    private javax.swing.JTextField vendedorTelefono;

    public VistaVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        initComponents();

        // Usaremos jPanel1 para la información básica
        infoBasicaPanel = jPanel1;

        crearPanelVentas();
        crearPanelProductos();
        configurarContenedorPrincipal();

        this.controlador = new VendedorController(vendedor, this);
        this.setLocationRelativeTo(this);
        SetImageLabel(fotoperfil, "C:/Users/AnimaKevin/OneDrive/Desktop/codigo/tienda/src/main/resources/foto.png");
        configurarMenuDeslizable();
        configurarCamposSoloLectura();
    }

    public VendedorController getControlador() {
        return controlador;
    }

    private void configurarContenedorPrincipal() {
        // Creamos el contenedor principal con CardLayout y agregamos las 3 tarjetas
        mainContentPanel = new JPanel(new CardLayout());
        mainContentPanel.add(infoBasicaPanel, "infoBasica");
        mainContentPanel.add(ventasPanel, "ventas");
        mainContentPanel.add(panelProductos, "productos");

        // Creamos un panel para el menú que incluya la foto y el slidemenu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        // Agregamos la foto (asegúrate que fotoperfil tenga un tamaño definido o use setPreferredSize)
        menuPanel.add(fotoperfil);
        // Agregamos un espacio
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Agregamos el slidemenu
        menuPanel.add(slidemenu);
        // Opcional: fija el tamaño preferido para el menuPanel
        menuPanel.setPreferredSize(new Dimension(200, menuPanel.getPreferredSize().height));

        // Configuramos jPanel6 con BorderLayout para ubicar el menú y el panel principal
        jPanel6.removeAll();
        jPanel6.setLayout(new BorderLayout());

        // Se agrega el menuPanel en el lado izquierdo (WEST)
        jPanel6.add(menuPanel, BorderLayout.WEST);

        // Se agrega el mainContentPanel en el centro (CENTER)
        jPanel6.add(mainContentPanel, BorderLayout.CENTER);

        jPanel6.revalidate();
        jPanel6.repaint();
    }

    private void crearPanelVentas() {
        // Panel para historial de ventas
        ventasPanel = new JPanel(new BorderLayout());

        // Modelo de tabla con columna "Comprador"
        String[] columnas = {"Fecha", "Producto", "Cantidad", "Total", "Comprador"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaVentas = new JTable(modeloTabla);

        // Estilo a la tabla
        tablaVentas.setRowHeight(30);
        tablaVentas.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));

        JScrollPane scrollVentas = new JScrollPane(tablaVentas);
        scrollVentas.setPreferredSize(new Dimension(700, 400));

        ventasPanel.add(scrollVentas, BorderLayout.CENTER);
    }

    private void crearPanelProductos() {
        // Panel para "Productos disponibles"
        panelProductos = new JPanel(new BorderLayout());

        // Crear tabla de inventario
        String[] columnasInventario = {"Producto", "Precio", "Stock", "Categoría"};
        modeloInventario = new DefaultTableModel(columnasInventario, 0);
        tablaInventario = new JTable(modeloInventario);

        tablaInventario.setRowHeight(30);
        tablaInventario.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));

        JScrollPane scrollInventario = new JScrollPane(tablaInventario);
        scrollInventario.setPreferredSize(new Dimension(700, 400));

        JLabel labelTitulo = new JLabel("Productos disponibles", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Roboto", Font.BOLD, 24));
        panelProductos.add(labelTitulo, BorderLayout.NORTH);
        panelProductos.add(scrollInventario, BorderLayout.CENTER);
    }

    private void configurarCamposSoloLectura() {
        // Campos de información básica (no editables)
        vendedorNombre.setEditable(false);
        vendedorID.setEditable(false);
        vendedorCorreo.setEditable(false);
        vendedorDireccion.setEditable(false);
        vendedorNacimiento.setEditable(false);
        vendedorTelefono.setEditable(false);
        // Suponemos que ya se agregó vendedorSaldo en el panel
        vendedorSaldo.setEditable(false);

        Color colorFondo = new Color(240, 240, 240);
        vendedorNombre.setBackground(colorFondo);
        vendedorID.setBackground(colorFondo);
        vendedorCorreo.setBackground(colorFondo);
        vendedorDireccion.setBackground(colorFondo);
        vendedorNacimiento.setBackground(colorFondo);
        vendedorTelefono.setBackground(colorFondo);
        vendedorSaldo.setBackground(colorFondo);

        // Los títulos se comportan como etiquetas
        tituloNombre.setEditable(false);
        tituloID.setEditable(false);
        tituloCorreo.setEditable(false);
        tituloDireccion.setEditable(false);
        tituloNacimiento.setEditable(false);
        tituloTelefono.setEditable(false);
        tituloSaldo.setEditable(false);

        Color colorTitulo = new Color(153, 255, 153);
        for (JTextField titulo : new JTextField[]{
                tituloNombre, tituloID, tituloCorreo,
                tituloDireccion, tituloNacimiento, tituloTelefono, tituloSaldo
        }) {
            titulo.setBorder(null);
            titulo.setBackground(colorTitulo);
            titulo.setFocusable(false);
        }
    }

    // Getters para la sección de información básica
    public JTextField getVendedorNombre() { return vendedorNombre; }
    public JTextField getVendedorID() { return vendedorID; }
    public JTextField getVendedorCorreo() { return vendedorCorreo; }
    public JTextField getVendedorDireccion() { return vendedorDireccion; }
    public JTextField getVendedorNacimiento() { return vendedorNacimiento; }
    public JTextField getVendedorTelefono() { return vendedorTelefono; }
    public JTextField getVendedorSaldo() { return vendedorSaldo; }

    // Nuevo getter para la tabla de inventario
    public JTable getTablaInventario() { return tablaInventario; }

    private void configurarMenuDeslizable() {
        // Panel para el menú deslizable
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(240, 240, 240));
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        slidemenu.setBorder(null);
        slidemenu.setViewportView(panelMenu);
        slidemenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollBar verticalScrollBar = slidemenu.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());
        verticalScrollBar.setPreferredSize(new Dimension(12, 0));

        // Se agregan 4 opciones: Información Básica, Historial de Ventas, Productos disponibles y Cerrar Sesión
        Color colorBoton = new Color(0, 153, 153);
        String[] opciones = {"Información Básica", "Historial de Ventas", "Productos disponibles", "Cerrar Sesión"};
        for (String textoBoton : opciones) {
            JButton boton = new JButton(textoBoton);
            boton.addActionListener(e -> {
                if (textoBoton.equals("Información Básica")) {
                    mostrarPanel("infoBasica");
                } else if (textoBoton.equals("Historial de Ventas")) {
                    controlador.cargarHistorialVentas();
                    mostrarPanel("ventas");
                } else if (textoBoton.equals("Productos disponibles")) {
                    // Aquí se podría invocar un metodo del controlador para cargar inventario
                    mostrarPanel("productos");
                } else if (textoBoton.equals("Cerrar Sesión")) {
                    new InicioSesion().setVisible(true);
                    this.dispose();
                }
            });
            boton.setMaximumSize(new Dimension(180, 40));
            boton.setAlignmentX(0.5f);
            boton.setBackground(colorBoton);
            boton.setForeground(Color.WHITE);
            boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            boton.setFocusPainted(false);
            panelMenu.add(boton);
            panelMenu.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                labelName.getWidth(),
                labelName.getHeight(),
                Image.SCALE_DEFAULT
        ));
        labelName.setIcon(icon);
        this.repaint();
    }

    private void mostrarPanel(String nombrePanel) {
        CardLayout cl = (CardLayout) mainContentPanel.getLayout();
        cl.show(mainContentPanel, nombrePanel);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    // NO MODIFICAR NADA DEBAJO DE ESTA LÍNEA (CÓDIGO GENERADO POR NETBEANS)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        fotoperfil = new javax.swing.JLabel();
        slidemenu = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tituloNombre = new javax.swing.JTextField();
        tituloID = new javax.swing.JTextField();
        tituloCorreo = new javax.swing.JTextField();
        tituloDireccion = new javax.swing.JTextField();
        tituloSaldo = new javax.swing.JTextField();
        vendedorID = new javax.swing.JTextField();
        vendedorDireccion = new javax.swing.JTextField();
        vendedorNombre = new javax.swing.JTextField();
        vendedorCorreo = new javax.swing.JTextField();
        tituloNacimiento = new javax.swing.JTextField();
        vendedorNacimiento = new javax.swing.JTextField();
        tituloTelefono = new javax.swing.JTextField();
        vendedorTelefono = new javax.swing.JTextField();
        vendedorSaldo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 255, 153));

        fotoperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto.png"))); // NOI18N
        fotoperfil.setText("foto");

        slidemenu.setBackground(new java.awt.Color(0, 153, 204));
        slidemenu.setPreferredSize(new Dimension(200, slidemenu.getHeight()));

        jScrollPane1.setBackground(new java.awt.Color(0, 153, 204));
        jScrollPane1.setForeground(new java.awt.Color(0, 153, 204));

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 3, 36)); // NOI18N
        jLabel1.setText("Información Básica");
        jScrollPane1.setViewportView(jLabel1);

        tituloNombre.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloNombre.setText("NOMBRE:");
        tituloNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloNombreActionPerformed(evt);
            }
        });

        tituloID.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloID.setText("ID:");
        tituloID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloIDActionPerformed(evt);
            }
        });

        tituloCorreo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloCorreo.setText("CORREO:");
        tituloCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloCorreoActionPerformed(evt);
            }
        });

        tituloDireccion.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloDireccion.setText("DIRECCIÓN:");
        tituloDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloDireccionActionPerformed(evt);
            }
        });

        tituloSaldo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloSaldo.setText("SALDO:");
        tituloSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloSaldoActionPerformed(evt);
            }
        });

        vendedorID.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorID.setText("vendedorID");
        vendedorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorIDActionPerformed(evt);
            }
        });

        vendedorDireccion.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorDireccion.setText("vendedorDirección");
        vendedorDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorDireccionActionPerformed(evt);
            }
        });

        vendedorNombre.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorNombre.setText("vendedorNombre");
        vendedorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorNombreActionPerformed(evt);
            }
        });

        vendedorCorreo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorCorreo.setText("vendedorCorreo");
        vendedorCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorCorreoActionPerformed(evt);
            }
        });

        tituloNacimiento.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloNacimiento.setText("FECHA DE NACIMIENTO:");
        tituloNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloNacimientoActionPerformed(evt);
            }
        });

        vendedorNacimiento.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorNacimiento.setText("vendedorNacimiento");
        vendedorNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorNacimientoActionPerformed(evt);
            }
        });

        tituloTelefono.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloTelefono.setText("TELEFONO:");
        tituloTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloTelefonoActionPerformed(evt);
            }
        });

        vendedorTelefono.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorTelefono.setText("vendedorTelefono");
        vendedorTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorTelefonoActionPerformed(evt);
            }
        });

        vendedorSaldo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        vendedorSaldo.setText("vendedorSaldo");
        vendedorSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorSaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tituloDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(vendedorDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(99, 99, 99)
                                                .addComponent(tituloTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vendedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tituloID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tituloNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tituloCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tituloNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tituloSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(vendedorSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(vendedorNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(vendedorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(vendedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(vendedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tituloTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vendedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(slidemenu)
                                        .addComponent(fotoperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(fotoperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(slidemenu)
                                .addContainerGap())
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 460));

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloNombreActionPerformed

    private void tituloIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloIDActionPerformed

    private void tituloCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloCorreoActionPerformed

    private void tituloDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloDireccionActionPerformed

    private void tituloSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloSaldoActionPerformed

    private void vendedorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorIDActionPerformed

    private void vendedorDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorDireccionActionPerformed

    private void vendedorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorNombreActionPerformed

    private void vendedorCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorCorreoActionPerformed

    private void tituloNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloNacimientoActionPerformed

    private void vendedorNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorNacimientoActionPerformed

    private void tituloTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloTelefonoActionPerformed

    private void vendedorTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorTelefonoActionPerformed

    private void vendedorSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorSaldoActionPerformed

    // NUEVO GETTER para el modelo de tabla de ventas
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    // NUEVO GETTER para la tabla de ventas
    public JTable getTablaVentas() {
        return tablaVentas;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    static class CustomScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {
        private final Color colorFondo = new Color(200, 200, 200); // Gris claro
        private final Color colorBarra = new Color(153, 255, 153); // Verde claro

        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = colorBarra;
            this.trackColor = colorFondo;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createBotonInvisible();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createBotonInvisible();
        }

        private JButton createBotonInvisible() {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(0, 0));
            btn.setMinimumSize(new Dimension(0, 0));
            btn.setMaximumSize(new Dimension(0, 0));
            return btn;
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(thumbColor);
            g2.fillRoundRect(
                    thumbBounds.x + 2,
                    thumbBounds.y + 2,
                    thumbBounds.width - 4,
                    thumbBounds.height - 4,
                    8,
                    8
            );
            g2.dispose();
        }
    }
}
