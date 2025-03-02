package Tienda.Modelo;

public class Promocion {
    private String codigo;
    private double descuento;
    private String fechaExpiracion;

    // Constructor
    public Promocion(String codigo, double descuento, String fechaExpiracion) {
        this.codigo = codigo;
        this.descuento = descuento;
        this.fechaExpiracion = fechaExpiracion;
    }

    // ------------------ Getters ------------------
    public String getCodigo() {
        return codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    // ------------------ Setters ------------------
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    // Método para aplicar el descuento a un producto
    public void aplicarDescuento(Producto producto) {
        if (descuento < 0 || descuento > 100) {
            System.out.println("Error: El descuento debe estar entre 0 y 100.");
            return;
        }
        double nuevoPrecio = producto.getPrecio() * (1 - descuento / 100);
        producto.setPrecio(nuevoPrecio); // Ahora este método existe en Producto
        System.out.println("Descuento aplicado: " + descuento + "% en " + producto.getTitulo() + ". Nuevo precio: $" + nuevoPrecio);
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "Promoción: Código " + codigo + " | Descuento: " + descuento + "% | Válido hasta: " + fechaExpiracion;
    }
}