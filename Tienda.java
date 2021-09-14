
/**
 * Write a description of class Tienda here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;

public class Tienda {
    private String nombreTienda;
    private ArrayList<Seccion> secciones;

    public Tienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
        secciones = new ArrayList();
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public ArrayList<Seccion> ListarSecciones() {
        return secciones;
    }
    
    public void añadirSeccion(Seccion seccion){
        this.secciones.add(seccion);
    } 
    
    public void modificarSeccion(Seccion seccion){
        
    } 
    
    public void eliminarSeccion(Seccion seccion){
        
    } 
    
    public Object buscarProducto(String nombre){
        return null;
    }
    
}

