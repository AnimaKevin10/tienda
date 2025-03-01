package Tienda;

public class Comprador extends Usuario {
    private Carrito carrito;

    public Comprador(String nombre, String direccion, String numeroTarjeta, String telefono) {
        super(nombre, direccion, numeroTarjeta, telefono);
        this.carrito = new Carrito();  // Inicializa el carrito siempre
    }
    // Constructor para registro con autenticación (id, nombre, correo, contraseña, fecha de nacimiento)
    public Comprador(int idUsuario, String nombre, String correo, String contrasena, String fechaNacimiento) {
        super(idUsuario, nombre, correo, contrasena, fechaNacimiento);
        this.carrito = new Carrito();  // Inicializa el carrito siempre
    }
    //  Métodos Específicos
    public Carrito getCarrito() {
        return this.carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}