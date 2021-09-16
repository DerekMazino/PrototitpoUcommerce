
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

    public void agregarUnidadesProducto(Regular regular){
        System.out.println("Producto: "+regular.getNombre());
        System.out.println("Stock Actual: "+regular.getStock());
        System.out.println("");
    }

    public void verProducto(Producto producto){
        int opcion;
        producto.mostrarProducto();
        System.out.println("1. Agregar más unidades");
        System.out.println("2. Activar/Desactivar");
        System.out.println("3. Volver a la seccion");
        opcion = sc.nextInt();
        switch(opcion)
        {
            case 1:
                System.out.println("Mantenimiento");
                break;
            case 2:
                System.out.println("Mantenimiento");
                break;   
            case 3:
                System.out.println("\nRegresando...");
                break;
            default:
                System.out.println("Opcion invalida, serás redirigido al menu anterior");
                break;
        }
        return;
    }

    public void AbrirSeccion(Seccion seccion){
        int opcion;
        do{
            System.out.println("---"+seccion.getNombre()+"---");
            System.out.println();
            seccion.listarSeccion();
            System.out.println();
            System.out.print("Digite el número de sección para entrar,\no cualquier otra valor para salir  ");
            opcion = sc.nextInt();
            opcion = opcion -1;
            if(opcion>=0 && opcion<seccion.getCantidadProductos()){
                verProducto(seccion.getProductos().get(opcion));
                continue;
            }
            break;
        }while(true);
    }

    public void VerSecciones(){
        int opcion = 0;
        do{
            System.out.println("");
            usuario.getTienda().ListarSecciones();
            System.out.print("Digite el número de sección para entrar,\no cualquier otra valor para salir  ");

            opcion = sc.nextInt();
            opcion = opcion -1;
            if(opcion>=0 && opcion<usuario.getTienda().getCantidadSecciones()){
                AbrirSeccion(usuario.getTienda().getSecciones().get(opcion));
                continue;
            }
            break;
        }while(true);
    }
    
    public Categoria obtenerCategoria(){
        int index = 0;
        System.out.println("Elije la categoria");
        for(Categoria categoria: dt.getCategorias()){
            index++;
            System.out.println(index+". "+categoria.getNombre());
        }
        int op = sc.nextInt();
        return dt.getCategorias().get(op);
    }
    
    public boolean indicarEstado(){
        int opcion;
        boolean retorno = false;
        System.out.println("Es nuevo o usado?");
        System.out.println("1. Nuevo");
        System.out.println("2. usado");
        opcion = sc.nextInt();
        switch(opcion){
            case 1:
                retorno =  true;
            case 2:
                retorno = false;
        }
        return retorno;
    }
    
    public void vender(){
        int opcion;
        sc.nextLine();
        System.out.println("");
        System.out.println("Creación de Producto nuevo");
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Descripción:");
        String descripcion = sc.nextLine();
        Categoria categoria = obtenerCategoria();
        System.out.println("Que tipo de Producto es? :");
        System.out.println("1. Regular");
        System.out.println("2. Servicio");
        System.out.println("3. Clasificado");
        System.out.println("4. Regresar al menu principal");
        opcion = sc.nextInt();
        switch(opcion)
        {
            case 1:
                System.out.println("Stock:");
                int stock = sc.nextInt();
                System.out.println("Precio Unitario:");
                double precioUnitario = sc.nextDouble();
                Regular regular = new Regular(nombre, descripcion, categoria, stock, precioUnitario);
                System.out.println("Mantenimiento");
                break;
            case 2:
                System.out.println("Cupos:");
                int cupo = sc.nextInt();
                System.out.println("Costo por Cupo:");
                double precioCupo = sc.nextDouble();
                Servicio servicio = new Servicio(nombre, descripcion, categoria, cupo, precioCupo);
                System.out.println("Mantenimiento");
                break;   
            case 3:
                System.out.println("Precio:");
                double precio = sc.nextDouble();
                boolean estado = indicarEstado();
                Clasificado clasificado = new Clasificado(nombre, descripcion, categoria, precio, estado);
                System.out.println("Mantenimiento");
                break; 
            case 4:
                System.out.println("\n¡ADIOS!");
                break;
            default:
                System.out.println("Opcion invalida!");
                break;
        }
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
                System.out.println("2. Ver mis Secciones");
                System.out.println("3. Vender");
                System.out.println("4. Volver a menu principal");
                opcion = sc.nextInt();
                switch(opcion)
                {
                    case 1:
                        cambiarNombreTienda();
                        break;
                    case 2:
                        VerSecciones();
                        break;   
                    case 3:
                        vender();
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
