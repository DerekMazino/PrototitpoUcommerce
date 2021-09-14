
/**
 * Write a description of class Regular here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Versión 1)
 */
public class Regular extends Producto{
    
    private int stock;
    private double precioUnitario;

    public Regular(String nombre, String descripcion, Categoria categoria, int stock, double precioUnitario ) {
        super(nombre, descripcion, categoria);
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    public Regular(String nombre, String descripcion, Categoria categoria, String[] imagen, int stock, double precioUnitario) {
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
    public void mostrarProducto(){
        System.out.println("-------------------------");
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Descripción: "+this.getDescripcion());
        System.out.println("Precio: "+this.precioUnitario);
        System.out.println("Unidades Disponibles: "+this.stock);
    }
}
