
/**
 * Write a description of class DataSource here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Versión 1.0.1)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.ProcessBuilder;
import java.util.Collections;
public class DataSource
{
    
    private ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    public DataSource(){
        insertarDatosUcommerce();
    }
    
    public ArrayList<Tienda> getTiendas(){
        return this.tiendas;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }
    
    public ArrayList<Categoria> getCategorias(){
        return this.categorias;
    }
    
    public void registarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    
    public void insertarDatosUcommerce()
    {  
        //Usuarios Vendedores String nombre, String apellido, int codigo, String email, long celular, char genero, String password
        Usuario usuario1 = new Usuario("Camilo", "Marín", "2172969", "juan2172368@gmail.com", "3123731199", "123456");
        Usuario usuario2 = new Usuario("Alejandra", "Estevez", "2175345", "maria2175345@gmail.com", "3172139828", "123456");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        //Tiendas de cada usuario vendendor
        Tienda tienda1 = new Tienda("Postres! lml");
        Tienda tienda2 = new Tienda("Ele-accesorios");
        usuario1.cambiarRol(true);
        usuario2.cambiarRol(true);
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
        categorias.add(c1);
        categorias.add(c2);
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
}
