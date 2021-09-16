
/**
 * Write a description of class Sesion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sesion
{
    private boolean logueado;
    public Sesion(){
        this.logueado = false;
    }
    
    public void iniciarSesion(){
        this.logueado = true;
    }
    
    public void cerrarSesion(){
        this.logueado = false;
    }
    
    public boolean getSesionStatus(){
        return this.logueado;
    }
}
