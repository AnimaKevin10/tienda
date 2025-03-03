/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.Controlador;

import Tienda.Modelo.Comprador;
import Tienda.Vista.VistaComprador;
public class CompradorController {
    private final Comprador comprador;
    private final VistaComprador vista;

    public CompradorController(Comprador comprador, VistaComprador vista) {
        this.comprador = comprador;
        this.vista = vista;
        cargarDatosUsuario();
    }

        vista.getUsuarioNombreField().setText(comprador.getNombre());
        vista.getUsuarioIdField().setText(String.valueOf(comprador.getIdUsuario()));
        vista.getUsuarioCorreoField().setText(comprador.getCorreo());
        vista.getUsuarioDireccionField().setText(comprador.getDireccion());
        vista.getUsuarioNacimiento().setText(comprador.getFechaNacimiento());
        vista.getUsuarioTelefono().setText(comprador.getTelefono());
    }
}