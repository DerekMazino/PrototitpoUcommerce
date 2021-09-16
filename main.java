
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public abstract class main
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {   
        DataSource dt = new DataSource();
        Sesion si = new Sesion();
        
        ModuloCompras mc = new ModuloCompras(dt);
        ModuloVentas mv = new ModuloVentas();
        ModuloUsuario mu = new ModuloUsuario(dt, si);
        
        int opcion;
        do
        {   
            System.out.println("\nU-COMMERCE!!!");
            System.out.println("\nMENU DE OPCIONES");
            System.out.println("1. Módulo de Compras");
            System.out.println("2. Módulo de Ventas");
            System.out.println("3. Menu de Usuario");
            System.out.println("4. Salir");
            System.out.print("Digite la opcion que desea realizar: ");
            opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:
                    mc.verTiendas();
                    break;
                case 2:
                    System.out.print("Mantenimiento...");
                    break;   
                case 3:
                    mu.MenuUsuario();
                    break; 
                case 4:
                    System.out.println("\n¡ADIOS!");
                    break;
                default:
                    System.out.println("Opcion invalida, intentalo de nuevo");
                    break;
            }
        }while(opcion!=4);
        
    }
}
