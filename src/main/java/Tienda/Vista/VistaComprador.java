/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tienda.Vista;

import Tienda.Controlador.CompradorController;
import Tienda.Modelo.Comprador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class VistaComprador extends javax.swing.JFrame {
    private Comprador comprador;
    private CompradorController controlador; // Nuevo campo para el controlador

    public VistaComprador(Comprador comprador) {
        this.comprador = comprador;
        initComponents();
        this.controlador = new CompradorController(comprador, this);
        this.setLocationRelativeTo(this);
        SetImageLabel(fotoperfil, "C:/Users/AnimaKevin/OneDrive/Desktop/codigo/tienda/src/main/resources/foto.png");
        configurarMenuDeslizable();
        configurarCamposSoloLectura();
    }
    public CompradorController getControlador() {
        return controlador;
    }
    private void configurarCamposSoloLectura() {
        // Campos de usuario (no editables)
        usuarioNombre.setEditable(false);
        usuarioID.setEditable(false);
        usuarioCorreo.setEditable(false);
        usuarioDireccion.setEditable(false);
        usuarioNacimiento.setEditable(false);
        usuarioTelefono.setEditable(false);

        // Estilo visual para campos no editables
        Color colorFondo = new Color(240, 240, 240); // Gris claro
        usuarioNombre.setBackground(colorFondo);
        usuarioID.setBackground(colorFondo);
        usuarioCorreo.setBackground(colorFondo);
        usuarioDireccion.setBackground(colorFondo);
        usuarioNacimiento.setBackground(colorFondo);
        usuarioTelefono.setBackground(colorFondo);

        // Campos de título (comportamiento como JLabel)
        tituloNombre.setEditable(false);
        tituloID.setEditable(false);
        tituloCorreo.setEditable(false);
        tituloDireccion.setEditable(false);
        tituloNacimiento.setEditable(false);
        tituloTelefono.setEditable(false);

        // Quitar bordes y fondo de títulos
        Color colorTitulo = new Color(153, 255, 153); // Verde claro del panel
        for (JTextField titulo : new JTextField[]{
                tituloNombre, tituloID, tituloCorreo,
                tituloDireccion, tituloNacimiento, tituloTelefono
        }) {
            titulo.setBorder(null);
            titulo.setBackground(colorTitulo);
            titulo.setFocusable(false);
        }
    }
       // Campos de texto
    private javax.swing.JTextField usuarioNombreField;
    private javax.swing.JTextField usuarioIdField;
    private javax.swing.JTextField usuarioCorreoField;
    private javax.swing.JTextField usuarioDireccionField;

    // Getters para los campos
    public JTextField getUsuarioNombre() { return usuarioNombre; }
    public JTextField getUsuarioID() { return usuarioID; }
    public JTextField getUsuarioCorreo() { return usuarioCorreo; }
    public JTextField getUsuarioDireccion() { return usuarioDireccion; }
    public JTextField getUsuarioNacimiento() { return usuarioNacimiento; }
    public JTextField getUsuarioTelefono() { return usuarioTelefono; }
private void configurarMenuDeslizable() {
    // Crear un nuevo panel para el menú
    javax.swing.JPanel panelMenu = new javax.swing.JPanel();
    panelMenu.setBackground(new Color(240, 240, 240));
    panelMenu.setLayout(new javax.swing.BoxLayout(panelMenu, javax.swing.BoxLayout.Y_AXIS));

    // Configurar el scroll
    slidemenu.setBorder(null);
    slidemenu.setViewportView(panelMenu); // Usar el nuevo panel
    slidemenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    // Personalizar barra de scroll
    JScrollBar verticalScrollBar = slidemenu.getVerticalScrollBar();
    verticalScrollBar.setUI(new CustomScrollBarUI());
    verticalScrollBar.setPreferredSize(new Dimension(12, 0));

    // Añadir elementos al nuevo panel
    Color colorBoton = new Color(0, 153, 153);
    // Añadir elementos al nuevo panel
    for(int i = 1; i <= 20; i++) {
        String textoBoton = switch(i) {
            case 1 -> "Información Básica";
            case 2 -> "Historial de Compras";
            case 3 -> "Métodos de Pago";
            default -> "Opción " + i;
        };

        JButton boton = new JButton(textoBoton);

        if (i == 1) {
            boton.addActionListener(e -> {
                // Usar el controlador existente en lugar de crear uno nuevo
                controlador.cargarDatosUsuario();
            });
        }
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
        usuarioID = new javax.swing.JTextField();
        usuarioDireccion = new javax.swing.JTextField();
        usuarioNombre = new javax.swing.JTextField();
        usuarioCorreo = new javax.swing.JTextField();
        tituloNacimiento = new javax.swing.JTextField();
        usuarioNacimiento = new javax.swing.JTextField();
        tituloTelefono = new javax.swing.JTextField();
        usuarioTelefono = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 255, 153));

        fotoperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto.png"))); // NOI18N
        fotoperfil.setText("fo");

        slidemenu.setBackground(new java.awt.Color(0, 153, 204));

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

        usuarioID.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        usuarioID.setText("usuarioID");
        usuarioID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioIDActionPerformed(evt);
            }
        });

        usuarioDireccion.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        usuarioDireccion.setText("usuarioDirección");
        usuarioDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioDireccionActionPerformed(evt);
            }
        });

        usuarioNombre.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        usuarioNombre.setText("usuarioNombre");
        usuarioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioNombreActionPerformed(evt);
            }
        });

        usuarioCorreo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        usuarioCorreo.setText("usuarioCorreo");
        usuarioCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioCorreoActionPerformed(evt);
            }
        });

        tituloNacimiento.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloNacimiento.setText("FECHA DE NACIMIENTO:");
        tituloNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloNacimientoActionPerformed(evt);
            }
        });

        usuarioNacimiento.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        usuarioNacimiento.setText("usuarioNacimiento");
        usuarioNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioNacimientoActionPerformed(evt);
            }
        });

        tituloTelefono.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tituloTelefono.setText("TELEFONO:");
        tituloTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloTelefonoActionPerformed(evt);
            }
        });

        usuarioTelefono.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        usuarioTelefono.setText("usuarioTelefono");
        usuarioTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTelefonoActionPerformed(evt);
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
                        .addComponent(usuarioDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(tituloTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void usuarioIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioIDActionPerformed

    private void usuarioDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioDireccionActionPerformed

    private void usuarioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioNombreActionPerformed

    private void usuarioCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioCorreoActionPerformed

    private void tituloNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloNacimientoActionPerformed

    private void usuarioNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioNacimientoActionPerformed

    private void tituloTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloTelefonoActionPerformed

    private void usuarioTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTelefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoperfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextField usuarioCorreo;
    private javax.swing.JTextField usuarioDireccion;
    private javax.swing.JTextField usuarioID;
    private javax.swing.JTextField usuarioNacimiento;
    private javax.swing.JTextField usuarioNombre;
    private javax.swing.JTextField usuarioTelefono;
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