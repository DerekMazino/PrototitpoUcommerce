
/**
 * Write a description of class ModuloUsuario here.
 * 
 * @author (Camilo Marín - Deyci Toloza) 
 * @version (Version 1.0.1)
 */
import java.util.Scanner;
public class ModuloUsuario
{
    DataSource dt;
    Sesion sesion;
    static Scanner sc = new Scanner(System.in);
    Usuario u = new Usuario();
    public ModuloUsuario(DataSource dt, Sesion sesion){
        this.dt = dt;
        this.sesion = sesion;
    }

    public void RegistroUsuario(){
        sc.nextLine();
        Usuario usuarioNuevo = new Usuario();
        System.out.println("REGISTRO DE USUARIO!");
        System.out.println("");
        System.out.println("Nombre:");
        usuarioNuevo.setNombre(sc.nextLine());
        System.out.println("Apellido:");
        usuarioNuevo.setApellido(sc.nextLine());
        System.out.println("Email:");
        usuarioNuevo.setEmail(sc.nextLine());
        System.out.println("Celular:");
        usuarioNuevo.setCelular(sc.nextLine());
        System.out.println("Identificacion:");
        usuarioNuevo.setCodigo(sc.nextLine());
        System.out.println("Contraseña:");
        usuarioNuevo.setPassword(sc.nextLine());
        dt.registarUsuario(usuarioNuevo);
        return;
    }
    
    public void IniciarSesion(){
        boolean exito = false;
        
        do{
            sc.nextLine();
            System.out.println("Hola!");
            System.out.println("Digite su identifiación");
            String identificacion = sc.nextLine();
            System.out.println("Digite su contraseña");
            String password = sc.nextLine();
            for(Usuario usuario: dt.getUsuarios()){
                if(usuario.getCodigo().equals(identificacion) && usuario.getPassword().equals(password)){
                    u = usuario;
                    exito = true;
                    break;
                }
            }
            if(exito == true){
                sesion.iniciarSesion();
                System.out.println("Sesion iniciada con exito");
                break;
            }else{
                System.out.println("Datos incorrectos, intentelo de nuevo");
            }
        }while(!exito);
        return;
    }
    
    
    public void MostrarPerfilUsuario(){
        System.out.println("");
        System.out.println(u);
        System.out.println("");
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(3*1000);
         } catch (Exception e) {
            System.out.println(e);
         }
        return;
    }
    
    public void MenuUsuario(){
        int opcion = 0;
        do{
            System.out.println("");
            System.out.println("U-Commerce: Modulo de Usuario");
            System.out.println("");
            if(sesion.getSesionStatus()){
                System.out.println("1. Ver perfil de usuario");
                System.out.println("2. Pasar a Vendedor");
                System.out.println("3. Volver al menu principal");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        MostrarPerfilUsuario();
                        break;
                    case 2:
                        System.out.println("Mantenimiento");
                        break;
                    case 3:
                        System.out.println("Regresando...");
                        return;
                    default:
                        System.out.println("Opcion invalida, intentalo de nuevo");
                        break;
                }
            }else{
                System.out.println("1. Iniciar Sesion");
                System.out.println("2. Registrarse");
                System.out.println("3. Volver al menu principal");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        IniciarSesion();
                        break;
                    case 2:
                        RegistroUsuario();
                        break;
                    case 3:
                        System.out.println("Regresando...");
                        return;
                    default:
                        System.out.println("Opcion invalida, intentalo de nuevo");
                        break;
                }
            }
        }while(opcion!=3);
    }
}
