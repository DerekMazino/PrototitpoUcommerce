
/**
 * Write a description of class Clasificado here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
public class Clasificado extends Producto{
    
    private double costo;
    private boolean estado;

    public Clasificado(double costo, boolean estado, String nombre, String descripcion, Categoria categoria) {
        super(nombre, descripcion, categoria);
        this.costo = costo;
        this.estado = estado;
    }

    public Clasificado(double costo, boolean estado, String nombre, String descripcion, Categoria categoria, String[] imagen) {
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
    public void registrarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
