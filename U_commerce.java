
/**
 * Write a description of class U_commerce here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class U_commerce{
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
    private ArrayList<Producto> productosAPP = new ArrayList<Producto>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private CarritoDeCompras carrito;
    private Usuario usuario = new Usuario();
    public void insertarDatosUcommerce()
    {  
        //Usuarios Vendedores String nombre, String apellido, int codigo, String email, long celular, char genero, String password
        Usuario usuario1 = new Usuario("Camilo", "Marín", "2172368", "juan2172368@gmail.com", "3123731199", 'M', "123456");
        Usuario usuario2 = new Usuario("Alejandra", "Estevez", "2175345", "maria2175345@gmail.com", "3172139828", 'F', "123456");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        //Tiendas de cada usuario vendendor
        Tienda tienda1 = new Tienda("Postres! lml");
        Tienda tienda2 = new Tienda("Ele-accesorios");
        tiendas.add(tienda1);
        tiendas.add(tienda2);
        //Relacionar cada tienda con su dueño
        usuario1.setTienda(tienda1);
        usuario2.setTienda(tienda1);
        //Agregar Secciones para cada Tienda
        //Secciones Tienda 1
        Seccion s1 = new Seccion("Galletas");
        Seccion s2 = new Seccion("Brownies");
        Seccion s3 = new Seccion("Donas");
        tienda1.añadirSeccion(s1);
        tienda1.añadirSeccion(s2);
        tienda1.añadirSeccion(s3);
        //Secciones Tienda 2
        Seccion s4 = new Seccion("Aretes");
        Seccion s5 = new Seccion("Manillas");
        Seccion s6 = new Seccion("Anillos");
        Seccion s7 = new Seccion("Tobilleras");
        tienda2.añadirSeccion(s4);
        tienda2.añadirSeccion(s5);
        tienda2.añadirSeccion(s6);
        tienda2.añadirSeccion(s7);
        //Categorias
        Categoria c1 = new Categoria("Reposteria", "Productos de Reposteria, tortas, galletas, brownies, etc");
        Categoria c2 = new Categoria("Moda y Accesorios", "Productos como ropa, collares, pulseras, etc");
        //Crear Productos para cada tienda
        //Productos Tienda 1
        Producto p1 = new Regular("Galletas Rojas!", "Galletas red velvet con chispas de chocolate",c1 , 150, 1200);
        Producto p2 = new Regular("Galletas de coco", "Galletas hechas a base de coco", c1, 100, 1000);
        Producto p3 = new Regular("Donas de Chocolate", "Donas cubiertas de Chocolate", c1, 120, 2000);
        Producto p4 = new Regular("Brownie de Nuez", "Brownis red velvet con corteza de nuez", c1, 50, 2500);
        Producto p5 = new Regular("Manilla Hombre", "Manilla negra con terminaciones doradas",c2 , 5, 15000);
        Producto p6 = new Regular("Tobillera Arcoiris", "Tobillera con pepitas de colores", c2, 9, 20000);
        Producto p7 = new Regular("Aretes artesanales", "Super Aretes!!", c2, 10, 12000);
        Producto p8 = new Regular("Tobillera Melody", "Elaborada en acero y pedrería", c2, 12, 18000);
        //Asignar productos
        s1.agregarProducto(p1);
        s1.agregarProducto(p2);
        s2.agregarProducto(p4);
        s3.agregarProducto(p3);
        s5.agregarProducto(p5);
        s7.agregarProducto(p6);
        s4.agregarProducto(p7);
        s7.agregarProducto(p8);
    }

    public void verProducto(Producto producto, Seccion seccion){
        int opcion;
        producto.mostrarProducto();
        System.out.println("1. Agregar al carrito de compras");
        System.out.println("2. Volver a la sección anterior");
        opcion = sc.nextInt();
        if(opcion == 1){
            carrito.agregarProducto(producto);
        }
        verSeccion(seccion);
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
            if(opcion<1 || opcion>seccion.getProductos().size()-1){
                break;
            }
            verProducto(seccion.getProductos().get(opcion-1), seccion);
        }while(true);
    }

    public void verInformaciónTienda(Tienda tienda){
        int opcion;
        if(carrito == null){
            carrito = new CarritoDeCompras(usuario, tienda);
        }
        do{
            System.out.println("Bienvenid@s a "+tienda.getNombreTienda());
            System.out.println("Carrito de Compras: "+carrito.getCarrito().size());
            System.out.println("Mira nuestras Secciones");
            tienda.ListarSecciones();
            System.out.print("Digite el número de sección para entrar\n");
            System.out.print("o cualquier otra valor para salir");
            opcion = sc.nextInt();
            if(opcion<1 || opcion>tienda.getSecciones().size()-1){
                break;
            }
            verSeccion(tienda.getSecciones().get(opcion-1));
        }while(true);
    }

    public void verTiendas(){
        int opcion;
        do{
            int i = 0;
            for(Tienda tienda: tiendas){
                i++;
                System.out.println(i+". "+tienda.getNombreTienda());
            }
            System.out.print("Digite el número de tienda a la que deseas visitar\n ");
            System.out.print("o cualquier otra valor para salir");
            opcion = sc.nextInt();
            if(opcion<1 || opcion>tiendas.size()-1){
                break;
            }
            verInformaciónTienda(tiendas.get(opcion-1));
        }while(true);
    }

    public void menuPrincipal()
    {
        int opcion;
        do
        {   System.out.println("\nU-COMMERCE!!!");
            System.out.println("\nMENU DE OPCIONES");
            System.out.println("1. Ver Tiendas");
            System.out.println("2. Ver productos");
            System.out.println("3. Menu de Usuario");
            System.out.println("4. Salir");
            System.out.print("Digite la opcion que desea realizar: ");
            opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:
                    verTiendas();
                    break;
                case 2:
                    System.out.print("Mantenimiento...");
                    break;   
                case 3:
                    System.out.print("Mantenimiento...");
                    break; 
                case 4:
                    System.out.println("\n¡ADIOS!");
                    break;
                default:

            }
        }while(opcion!=4);
    }
}
