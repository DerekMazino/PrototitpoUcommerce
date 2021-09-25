
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
    Usuario usuario;
    public ModuloUsuario(DataSource dt, Sesion sesion, Usuario usuario){
        this.dt = dt;
        this.sesion = sesion;
        this.usuario = usuario;
    }

    public boolean buscarUsuario(String identificacion){
        for(Usuario usuario: dt.getUsuarios()){
            if(usuario.getCodigo().equals(identificacion)){
                return true;
            }
        }
        return false;
    }

    public void RegistroUsuario(){
        sc.nextLine();
        Usuario usuarioNuevo = new Usuario();
        System.out.println("REGISTRO DE USUARIO!");
        System.out.println("");
        System.out.println("-Escribe a continuación tu nombre.-");
        System.out.println("Nombre:");
        usuarioNuevo.setNombre(sc.nextLine());
        System.out.println("-Ahora tu apellido.-");
        System.out.println("Apellido:");
        usuarioNuevo.setApellido(sc.nextLine());
        System.out.println("-Tu Email.-");
        System.out.println("Email:");
        usuarioNuevo.setEmail(sc.nextLine());
        System.out.println("-Luego tu celular.-");
        System.out.println("Celular:");
        usuarioNuevo.setCelular(sc.nextLine());
        while(true){
            System.out.println("");
            System.out.println("Identificacion:");
            String identificacion = sc.nextLine();
            if(!buscarUsuario(identificacion)){
                usuarioNuevo.setCodigo(identificacion);
                break;
            }else{
                System.out.println("");
                System.out.println("Error, la identificación ya esta registrada:");
                System.out.println("Digita una valida");
            }
        }

        System.out.println("Contraseña:");
        usuarioNuevo.setPassword(sc.nextLine());
        dt.registarUsuario(usuarioNuevo);
        return;
    }

    public void cargarDatosSesion(Usuario usuario){
        this.usuario.setNombre(usuario.getNombre());
        this.usuario.setApellido(usuario.getApellido());
        this.usuario.setCodigo(usuario.getCodigo());
        this.usuario.setEmail(usuario.getEmail());
        this.usuario.setCelular(usuario.getCelular());
        this.usuario.setPassword(usuario.getPassword());
        this.usuario.cambiarRol(usuario.isRol());
        this.usuario.setPuntuacionCliente(usuario.getPuntuacionCliente());
        this.usuario.setPuntuacionVendedor(usuario.getPuntuacionVendedor());
        this.usuario.setTienda(usuario.getTienda());
    }

    public void IniciarSesion(){
        boolean exito = false;
        int intentos = 3;
        do{
            sc.nextLine();
            System.out.println("Hola!");
            System.out.println("Digite su identifiación");
            String identificacion = sc.nextLine();
            System.out.println("Digite su contraseña");
            String password = sc.nextLine();
            for(Usuario usuario: dt.getUsuarios()){
                if(usuario.getCodigo().equals(identificacion) && usuario.getPassword().equals(password)){
                    //this.usuario = usuario;
                    exito = true;
                    cargarDatosSesion(usuario);
                    break;
                }
            }
            if(exito == true){
                sesion.iniciarSesion();
                System.out.println("Sesion iniciada con exito");
                break;
            }else{
                intentos--;
                System.out.println("Datos incorrectos, te quedan "+intentos+" intentos.");
            }
        }while(!exito && intentos>0);
        return;
    }

    public void MostrarPerfilUsuario(){
        System.out.println("");
        System.out.println(usuario);
        System.out.println("");
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(3*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        return;
    }

    public boolean PasarModoVendedor(){
        if(sesion.getSesionStatus()){
            if(usuario.isRol()){
                System.out.println("Ya eres vendedor! Regresa al menu principal");
            }else{
                usuario.cambiarRol(true);
                System.out.println("Ahora eres un vendedor! Regresa al menu principal:");
            }
            return true;
        }
        return false;
    }

    public void MenuUsuario(){
        int opcion = 0;
        do{
            System.out.println("");
            System.out.println("U-Commerce: Modulo de Usuario.");
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
                        PasarModoVendedor();
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
