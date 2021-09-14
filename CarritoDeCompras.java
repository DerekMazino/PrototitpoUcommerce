
/**
 * Write a description of class CarritoDeCompras here.
 * 
 * @author (Camilo Marin, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;

public class CarritoDeCompras {
    Tienda tienda;
    Usuario usuario;
    ArrayList<Producto> elementos;

    public CarritoDeCompras(Usuario usuario, Tienda tienda) {
        this.usuario = usuario;
        this.tienda = tienda;
        elementos = new ArrayList<Producto>();
    }
    
    public void agregarProducto(Producto producto){
        this.elementos.add(producto);
    }
    public void eliminarProducto(Producto producto){
        this.elementos.remove(producto);
    }
    public void vaciarCarrito(Producto producto){
        this.elementos.clear();
    }
    public ArrayList<Producto> getCarrito(){
        return elementos;
    }
}

