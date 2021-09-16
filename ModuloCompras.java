
/**
 * Write a description of class U_commerce here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.ProcessBuilder;
import java.util.Collections;

public class ModuloCompras
{
    static Scanner sc = new Scanner(System.in);
    private CarritoDeCompras carrito;
    private Usuario usuario;
    private DataSource dt;
    
    public ModuloCompras(DataSource dt, Usuario usuario){
        this.dt = dt;
        this.usuario = usuario;
    }
    
    public void agregarAlCarrito(Producto producto){
        System.out.println("Digite la cantidad a agregar");
        Integer cantidad = sc.nextInt();
        carrito.agregarProducto(producto, cantidad);
    }

    public void verProducto(Producto producto){
        int opcion;
        producto.mostrarProducto();
        System.out.println("1. Agregar al carrito de compras");
        System.out.println("2. Volver a la sección anterior");
        opcion = sc.nextInt();
        if(opcion == 1)
            agregarAlCarrito(producto);
        return;
    }

    public void verSeccion(Seccion seccion){
        int opcion;
        do{
            System.out.println("---"+seccion.getNombre()+"---");
            System.out.println();
            System.out.println("Carrito de Compras: "+carrito.getCarrito().size());
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
    
    public void verInformaciónTienda(Tienda tienda){
        int opcion;
        carrito = new CarritoDeCompras(usuario, tienda);
        do{
            System.out.println("");
            System.out.println("Bienvenid@s a "+tienda.getNombreTienda());
            System.out.println("Carrito de Compras: "+carrito.getCarrito().size());
            System.out.println("Mira nuestras Secciones");
            tienda.ListarSecciones();
            System.out.print("Digite el número de sección para entrar\n");
            System.out.print("o cualquier otra valor para salir");
            opcion = sc.nextInt();
            opcion = opcion - 1;
            if(opcion>=0 && opcion<tienda.getCantidadSecciones()){
                verSeccion(tienda.getSecciones().get(opcion));
                continue;
            }
            break;
        }while(true);
    }

    public void imprimirTiendas(){
        int i = 0;
        System.out.println("");
        for(Tienda tienda: dt.getTiendas()){
            i++;
            System.out.println(i+". "+tienda.getNombreTienda());
        }
    }

    public void verTiendas(){
        int opcion;
        do{
            imprimirTiendas();
            System.out.println("");
            System.out.print("Digite el número de tienda a la que deseas visitar \n");
            System.out.print("o cualquier otro valor para regresar al menu principal: ");
            opcion = sc.nextInt();
            opcion = opcion - 1;
            if(opcion>=0 && opcion<(dt.getTiendas().size())){
                verInformaciónTienda(dt.getTiendas().get(opcion));
                continue;
            }
            break;
        }while(true);
    }
}
