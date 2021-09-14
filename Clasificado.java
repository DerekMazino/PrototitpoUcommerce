
/**
 * Write a description of class Clasificado here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
public class Clasificado extends Producto{
    
    private double costo;
    private boolean estado;

    public Clasificado(String nombre, String descripcion, Categoria categoria, double costo, boolean estado) {
        super(nombre, descripcion, categoria);
        this.costo = costo;
        this.estado = estado;
    }

    public Clasificado(String nombre, String descripcion, Categoria categoria, String[] imagen, double costo, boolean estado) {
        super(nombre, descripcion, categoria, imagen);
        this.costo = costo;
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isestado() {
        return estado;
    }

    public void setestado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public void mostrarProducto(){
        System.out.println("-------------------------");
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Descripción: "+this.getDescripcion());
        System.out.println("Precio: "+this.costo);
        System.out.print("Estado: ");
        System.out.print(this.estado ? "Nuevo" : "Usado");
    }
}
