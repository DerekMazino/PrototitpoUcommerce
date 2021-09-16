
/**
 * Write a description of class ModuloVentas here.
 * 
 * @author (Camilo Marín - Deyci Toloza) 
 * @version (Version 1.0.1)
 */
import java.util.Scanner;
public class ModuloVentas
{
    private Usuario usuario;
    private DataSource dt;
    static Scanner sc = new Scanner(System.in);
    public ModuloVentas(DataSource dt, Usuario usuario){
        this.dt = dt;
        this.usuario = usuario;
    }
    
    public void cambiarNombreTienda(){
        sc.nextLine();
        System.out.println("Escribé el nuevo nombre de tu tienda");
        String nombreTienda = sc.nextLine();
        Tienda tienda = usuario.getTienda();
        tienda.setNombreTienda(nombreTienda);
        System.out.println("Nombre Cambiado con exito");
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2*1000);
         } catch (Exception e) {
            System.out.println(e);
         }
        return;
    }
    
    public void MenuPrincipalVentas(){
        int opcion = 0;
        do{
            System.out.println("");
            System.out.println("U-COMMERCE! - Modulo de Ventas");
            System.out.println("");
            if(usuario.getTienda()!=null){
                System.out.println("Hola de nuevo! "+ usuario.getTienda().getNombreTienda());
                System.out.println("");
                System.out.println("1. Cambiar nombre de mi tienda");
                System.out.println("2. Editar Secciones");
                System.out.println("3. Vender");
                System.out.println("4. Volver a menu principal");
                opcion = sc.nextInt();
                switch(opcion)
                {
                    case 1:
                        cambiarNombreTienda();
                        break;
                    case 2:
                        System.out.println("Mantenimiento");
                        break;   
                    case 3:
                        System.out.println("Mantenimiento");
                        break; 
                    case 4:
                        System.out.println("\n¡ADIOS!");
                        break;
                    default:
                        System.out.println("Opcion invalida, intentalo de nuevo");
                        break;
                }
            }
            else{
                
                System.out.println("Aun no tienes una tienda! vamos a crearla lml");
                System.out.println("Escribé el nombre de ti tienda");
                String nombreTienda = sc.nextLine();
                Tienda nuevaTienda = new Tienda(nombreTienda);
                usuario.setTienda(nuevaTienda);
            }
        }while(opcion!=4);
    }
}
