package Tienda;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;
    private String fechaNacimiento;
    private String direccion;
    private String numeroTarjeta;
    private String telefono;
    //Constructores
    //Constructor para datos básicos
    public Usuario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTarjeta = numeroTarjeta;
        this.telefono = telefono;
    }
    // Constructor para registro con autenticación
    public Usuario(int idUsuario, String nombre, String correo, String contrasena, String fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = "";
        this.telefono = "";
        this.numeroTarjeta = "";
    }
    //Constructor Id
    public Usuario(int idnombre, String nombre) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.numeroTarjeta = numeroTarjeta;
    this.telefono = telefono;
}
    // Getters (Accesores)
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    // ------------------ Setters (Mutadores) ------------------
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}