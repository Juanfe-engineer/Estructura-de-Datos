package CarritoGeneric_Taller;

import java.util.ArrayList;
import java.util.Iterator;

public class Carrito<T extends Producto> implements Iterable<T>{

    private ArrayList<T> productos;

    public Carrito(){
        productos = new ArrayList<>();
    }

    // Metodos

    public void agregar (T producto){
        productos.add(producto);
    }

    public T obtenerProductoMayor(){
        if (productos.isEmpty()){
            throw new RuntimeException("El carrito está vacío");
        }

        T mayor = productos.get(0);

        for (T producto : productos){
            if(producto.getPrecio() > mayor.getPrecio()){
                mayor = producto;
            }
        }

        return mayor;
    }

    public double calcularTotal(){

        double total = 0;

        for(T producto : productos){
            total += producto.getPrecio();
        }
        return total;
    }


    @Override
    public Iterator<T> iterator(){
        return new IteradorCarrito();
    }



    // Clase Iterador
    // Iterador propio: crea una copia ordenada por precio para recorrer los productos
    // de menor a mayor sin modificar el orden original del carrito.

    protected class IteradorCarrito implements Iterator<T>{

        private ArrayList<T> productosOrdenados;
        private int posicion;

        public IteradorCarrito(){
            productosOrdenados = new ArrayList<>(productos);         //Creamos copia de los productos

            productosOrdenados.sort((producto1, producto2) ->
                    Double.compare(producto1.getPrecio(),producto2.getPrecio()));

            posicion = 0;
        }


        @Override
        public boolean hasNext(){
            return posicion < productosOrdenados.size();
        }

        @Override
        public T next(){
            if(!hasNext()){
                throw new RuntimeException("No hay mas productos");
            }
            return productosOrdenados.get(posicion++);  // Obtiene el producto de su posicion actual y aumenta la posicion para su siguiente llamada
        }

        @Override
        public void remove(){
        }

    }
}
