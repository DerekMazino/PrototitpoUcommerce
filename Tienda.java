
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
    
    public ArrayList<Seccion> getSecciones (){
        return this.secciones;
    }
    
    public void añadirSeccion(Seccion seccion){
        this.secciones.add(seccion);
    } 
    
    public void modificarSeccion(Seccion seccion){
        secciones.set(secciones.indexOf(seccion), seccion);
    } 
    
    public boolean eliminarSeccion(String nombreSeccion){
        Seccion se = buscarSeccion(nombreSeccion);
        if(se!=null){
            secciones.remove(se);
            return true;
        }
        return false;
    } 
    
    public Seccion buscarSeccion(String nombreSeccion){
        for(Seccion seccion:secciones){
            if(seccion.getNombre().equals(nombreSeccion)){
                return seccion;
            }
        }
        return null;
    }
    
    public void ListarSecciones() {
        int index = 1;
        for(Seccion seccion: secciones){
            System.out.println(index+": "+seccion.getNombre());
            index++;
        }
    }
}

