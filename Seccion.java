
/**
 * Write a description of class Seccion here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */

import java.util.ArrayList;

public class Seccion {
    
    private String nombre;
    private ArrayList<Producto> productos;

    public Seccion(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Producto> getProductos(){
        return productos;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    
    public void editarProducto(Producto producto){
        productos.set(productos.indexOf(producto), producto);
    }
    
    public boolean eliminarProducto(String nombreProducto){
        Producto pe = buscarProducto(nombreProducto);
        if(pe!=null){
            productos.remove(pe);
            return true;
        }
        return false;
    }
    
    public Producto buscarProducto(String nombreProducto){
        for(Producto producto:productos){
            if(producto.getNombre().equals(nombreProducto)){
                return producto;
            }
        }
        return null;
    }
    
    public void listarSeccion() {
        int index = 1;
        for(Producto producto: productos){
            System.out.println(index+": "+producto.getNombre());
            index++;
        }
    }
    
    public int getCantidadProductos(){
        return this.productos.size();
    }
    
}

