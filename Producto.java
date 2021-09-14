
/**
 * Write a description of class Producto here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;
public abstract class Producto {
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private String[] imagen;
    private ArrayList<Comentario> comentarios;

    public Producto(String nombre, String descripcion, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        comentarios = new ArrayList();
    }

    public Producto(String nombre, String descripcion, Categoria categoria, String[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
        comentarios = new ArrayList();
    }

    public void mostrarComentarios() {
        int index = 1;
        for(Comentario comentario: comentarios){
            System.out.println(comentario);
            index++;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria.getNombre();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String[] getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen[imagen.length()] = imagen;
    }
    
    public abstract void mostrarProducto();
    
}

