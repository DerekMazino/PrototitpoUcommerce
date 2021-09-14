
/**
 * Write a description of class U_commerce here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;

public class U_commerce {
    private int ref_compra;
    private boolean terminado;
    private ArrayList<Producto> elementos;
    public U_commerce(int ref_compra, CarritoDeCompras carrito) {
        this.ref_compra = ref_compra;
        this.elementos = carrito.elementos;
        this.terminado = false;
    }
    
    public void generarCompra(){
        
    }
    
    public double calcularCosto(){
        return 0.0;
    }
    
    public void confirmarEntrega(boolean confirmacion){
        if(confirmacion)
            terminado = true;
    }
    
    public void notificarAlVendedor(){
    
    }
    
    public void calificarVendedor(){
        
    }
    
    public void calificarCliente(){
        
    }
    
}
