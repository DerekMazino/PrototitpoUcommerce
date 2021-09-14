
/**
 * Write a description of class Regular here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Versión 1)
 */
public class Regular extends Producto{
    
    private int stock;
    private double precioUnitario;

    public Regular(int stock, double precioUnitario, String nombre, String descripcion, Categoria categoria) {
        super(nombre, descripcion, categoria);
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    public Regular(int stock, double precioUnitario, String nombre, String descripcion, Categoria categoria, String[] imagen) {
        super(nombre, descripcion, categoria, imagen);
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
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
