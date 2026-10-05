package CarritoGeneric_Taller;

public class MainCarrito {

    public static void main(String[] args) {

        Carrito<Producto> carrito = new Carrito<>();

        Producto mouse = new Producto("Mouse", 80000);
        Producto teclado = new Producto("Teclado", 150000);
        Producto monitor = new Producto("Monitor", 900000);
        Producto audifonos = new Producto("Audífonos", 120000);

        carrito.agregar(mouse);
        carrito.agregar(teclado);
        carrito.agregar(monitor);
        carrito.agregar(audifonos);

        System.out.println("Producto de mayor precio:");
        System.out.println(carrito.obtenerProductoMayor());

        System.out.println("\nTotal del carrito:");
        System.out.println(carrito.calcularTotal());

        System.out.println("\nProductos ordenados por precio:");

        for(Producto producto : carrito){
            System.out.println(producto);
        }
    }

}
