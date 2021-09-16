
/**
 * Write a description of class CarritoDeCompras here.
 * 
 * @author (Camilo Marin, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarritoDeCompras {
    Tienda tienda;
    Usuario usuario;
    HashMap<Producto, Integer> productos;

    public CarritoDeCompras(Usuario usuario, Tienda tienda) {
        this.usuario = usuario;
        this.tienda = tienda;
        productos = new HashMap<Producto, Integer>();
    }

    public void agregarProducto(Producto producto, Integer nuevaCantidad){
        if(productos.containsKey(producto)){
            Integer cantidad = productos.get(producto) + nuevaCantidad;
            this.productos.put(producto, cantidad);
        }else{
            this.productos.put(producto, nuevaCantidad);
        }
    }

    public void eliminarProducto(Producto producto){
        this.productos.remove(producto);
    }

    public void vaciarCarrito(Producto producto){
        this.productos.clear();
    }

    public HashMap<Producto, Integer> getCarrito(){
        return productos;
    }
    
    public int getCantidadProductos(){
        return productos.size();
    }
    
    public void mostrarCarrito(){
        for(Producto producto: productos.keySet()){
            System.out.println("key: " + producto.getNombre() + " Cantidad: " + productos.get(producto));
        }
    }
}

