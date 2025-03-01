package Tienda;

public class Main {
    public static void main(String[] args) {
        // 1. Crear usuarios ====================================
        Comprador ana = new Comprador(
                12,
                "Ana López",
                "ana@tienda.com",
                "clave123",
                "Calle Falsa 123"
        );

        Vendedor juan = new Vendedor(
                11,
                "Juan Pérez",
                "juan@tienda.com",
                "password456",
                "Av. Siempreviva 742"
        );

        System.out.println("✅ Usuarios creados:");
        System.out.println("Comprador: " + ana.getNombre());
        System.out.println("Vendedor: " + juan.getNombre() + "\n");

        // 2. Crear producto =====================================
        Producto laptop = new Producto("Laptop Gamer", "SKU-LP123",299,2);
        System.out.println("🛍️  Producto creado: " + "laptop"+ "\n"); //aqui va en vez de laptop producto.getname

        // 3. Simular transacción ================================
        ana.facturar(juan, 1500.0, "Tarjeta");
        System.out.println("✅ Transacción registrada\n");

        // 4. Crear reseña vinculada al producto =================
        Resena resena = new Resena(ana, laptop, 5, "Excelente rendimiento para juegos"
        );

        System.out.println("📝 Reseña creada:");
        System.out.println(resena);
    }
}