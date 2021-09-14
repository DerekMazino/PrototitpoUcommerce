
/**
 * Write a description of class Servicio here.
 * 
 * @author (Camilo Marin, Deyci Toloza) 
 * @version (Version 1.0)
 */
public class Servicio extends Producto{
    
    private int cupos;
    private double costoPorCupo;

    public Servicio(int cupos, double costoPorCupo, String nombre, String descripcion, Categoria categoria) {
        super(nombre, descripcion, categoria);
        this.cupos = cupos;
        this.costoPorCupo = costoPorCupo;
    }

    public Servicio(int cupos, double costoPorCupo, String nombre, String descripcion, Categoria categoria, String[] imagen) {
        super(nombre, descripcion, categoria, imagen);
        this.cupos = cupos;
        this.costoPorCupo = costoPorCupo;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public double getCostoPorCupo() {
        return costoPorCupo;
    }

    public void setCostoPorCupo(double costoPorCupo) {
        this.costoPorCupo = costoPorCupo;
    }
    
    @Override
    public void mostrarProducto(){
        System.out.print("-------------------------");
        System.out.print("Nombre: "+this.getNombre());
        System.out.print("Descripción: "+this.getNombre());
        System.out.print("Precio: "+this.costoPorCupo);
        System.out.print("Cupos Disponibles: "+this.cupos);
    }
}

