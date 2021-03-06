
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
    private Sesion sesion;
    public ModuloCompras(DataSource dt, Usuario usuario, Sesion sesion){
        this.dt = dt;
        this.usuario = usuario;
        this.sesion = sesion;

    }

    public void tiempo(){
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void descontarUnidadesCarrito(Producto producto, int cantidad){
        if(producto instanceof Regular){
            Regular regular = (Regular) producto;
            regular.setStock(regular.getStock()-cantidad);
        }else{
            Servicio servicio = (Servicio) producto;
            servicio.setCupos(servicio.getCupos()-cantidad);
        }
    }

    public void agregarAlCarrito(Producto producto){
        do{
            int cantidad1 = 0;
            Integer cantidad = 1;
            if(!(producto instanceof Clasificado)){
                System.out.println("Digite la cantidad a agregar");
                cantidad = sc.nextInt();
                if(producto instanceof Regular){
                    Regular regular = (Regular) producto;
                    cantidad1 = regular.getStock();
                }else{
                    Servicio servicio = (Servicio) producto;
                    cantidad1 = servicio.getCupos();
                }
            }
            else{
                carrito.agregarProducto(producto, cantidad);
                System.out.println("");
                System.out.println("¡Elemento agregado con exito¡");
                System.out.println("");
                break;
            }
            if(cantidad>cantidad1){
                System.out.println("");
                System.out.println("Error! estas seleccionando más de la cantidad disponible");
                System.out.println("Intentalo de nuevo");
                System.out.println("");
            }else{
                carrito.agregarProducto(producto, cantidad);
                descontarUnidadesCarrito(producto, cantidad);
                System.out.println("");
                System.out.println("Elemento agregado con exito");
                System.out.println("");
                break;
            }
        }while(true);
    }

    public void verProducto(Producto producto){
        int opcion;
        producto.mostrarProducto();
        System.out.println("");
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
            System.out.print("Digite el número de producto para entrar o 0 para salir. ");
            opcion = sc.nextInt();
            opcion = opcion -1;
            if(opcion>=0 && opcion<seccion.getCantidadProductos()){
                verProducto(seccion.getProductos().get(opcion));
                continue;
            }
            else if(opcion == -1){
                break;
            }
            else{
                System.out.print("Digita un numero valido. \n");
            }
        }while(true);
    }

    public void completarCompra(){
        System.out.println("");
        System.out.println("Se notificará al vendedor de su intención de compra");
        System.out.println("Será contactado por este en el menor tiempo posible");
        
        carrito.vaciarCarrito();
        System.out.println("Regresando...");
        tiempo();
    }

    public void borrarElementoCarrito(){
        for(Producto producto: carrito.getCarrito().keySet()){
            if(!(producto instanceof Clasificado)){
                if(producto instanceof Regular){
                    Regular regular = (Regular) producto;
                    regular.setStock(regular.getStock()+carrito.getCarrito().get(producto));
                }else{
                    Servicio servicio = (Servicio) producto;
                    servicio.setCupos(servicio.getCupos()+carrito.getCarrito().get(producto));
                }

            }
        }
        carrito.vaciarCarrito();
    }

    public boolean verCarrito(){
        if(sesion.getSesionStatus()){
            int opcion = 0 ;
            do{ 
                if(carrito.getCantidadProductos() == 0){return false;}
                System.out.println("");
                System.out.println("CARRITO DE COMPRAS");
                carrito.mostrarCarrito();
                System.out.println("");
                System.out.println("1. Completar compra");
                System.out.println("2. Borrar elemento del carrito");
                System.out.println("3. Vaciar carrito");
                System.out.println("4. Regresar al menu anterior");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        completarCompra();
                        opcion = 4;
                        break;
                    case 2:
                        System.out.println("Mantemiento");
                        /*System.out.println("Indica el número del producto a eliminar");
                        int valor = sc.nextInt();
                        carrito.eliminarProducto(carrito.getCarrito().get(valor));*/
                        break;
                    case 3:
                        borrarElementoCarrito();
                        System.out.println("El carrito ha sido limpiado");
                        break;
                    case 4:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Error, intentalo de nuevo");
                        break;
                }
            }while(opcion!=4);
            return true;
        }
        return false;
    }

    public void verInformaciónTienda(Tienda tienda){
        int opcion;
        carrito = new CarritoDeCompras(usuario, tienda);
        do{
            System.out.println("");
            System.out.println("Bienvenid@s a "+tienda.getNombreTienda()+"\n");
            System.out.println("**********************");
            System.out.println("CARRITO DE COMPRAS: "+carrito.getCarrito().size());
            System.out.println("**********************");
            System.out.println("Mira nuestras Secciones");
            tienda.ListarSecciones();
            System.out.println("");
            System.out.print("Digite el número de sección para entrar\n");
            if(carrito.getCarrito().size()>0){
                int valor = tienda.getCantidadSecciones() +1;
                System.out.println("Digite "+valor+" para entrar al carrito de compras");

            }
            System.out.println("o cualquier 0 para salir.");
            opcion = sc.nextInt();
            opcion = opcion - 1;
            if(opcion>=0 && opcion<tienda.getCantidadSecciones()){
                verSeccion(tienda.getSecciones().get(opcion));
                continue;
            }else if(opcion == tienda.getCantidadSecciones() && carrito.getCarrito().size()>0){
                if(sesion.getSesionStatus()){
                    verCarrito();    
                    continue;
                }
                System.out.println("");
                System.out.println("Debes estar logueado para continuar con esta actividad");
                ModuloUsuario mu = new ModuloUsuario(dt, sesion, usuario);
                mu.MenuUsuario();
                continue;
            }
            else if(opcion == -1){
                break;
            }
            else{
                System.out.print("Digita un numero valido. \n");
            }
        }while(true);
    }

    public void imprimirTiendas(){
        int i = 0;
        System.out.println("");
        System.out.println("U-Commerce: Modulo de Compras. \n");
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
            System.out.print("o 0 para regresar al menu principal: ");
            opcion = sc.nextInt();
            opcion = opcion - 1;
            if(opcion>=0 && opcion<(dt.getTiendas().size())){
                verInformaciónTienda(dt.getTiendas().get(opcion));
                continue;
            }
            else if(opcion == -1){
                break;
            }
            else{
                System.out.print("Digita un numero valido. \n");
            }
        }while(true);
    }
}
