
/**
 * Write a description of class Categoria here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
public class Categoria {
    private String nombre;
    private String descripción;

    public Categoria(String nombre, String descripción) {
        this.nombre = nombre;
        this.descripción = descripción;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripción() {
        return descripción;
    }
    
    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", descripci\u00f3n=" + descripción + '}';
    }
    
    
    
    
    
}
