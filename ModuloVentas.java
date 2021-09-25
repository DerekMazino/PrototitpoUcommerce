
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

    public void tiempo(){
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cambiarNombreTienda(){
        sc.nextLine();
        System.out.println("Escribé el nuevo nombre de tu tienda");
        String nombreTienda = sc.nextLine();
        Tienda tienda = usuario.getTienda();
        tienda.setNombreTienda(nombreTienda);
        System.out.println("Nombre Cambiado con exito");
        tiempo();
        return;
    }

    public void agregarUnidadesProducto(Producto producto){
        System.out.println("");
        System.out.println("Producto: "+producto.getNombre());
        int cantidad;
        if(producto instanceof Regular){
            Regular regular = (Regular) producto;
            System.out.println("Stock Actual: "+regular.getStock());
            System.out.println("Digita la cantidad que deseas agregar");
            cantidad = sc.nextInt();
            regular.setStock(regular.getStock()+cantidad);
        }else{
            Servicio servicio = (Servicio) producto;
            System.out.println("Stock Actual: "+servicio.getCupos());
            System.out.println("Digita la cantidad que deseas agregar");
            cantidad = sc.nextInt();
            servicio.setCupos(servicio.getCupos()+cantidad);
        }
        System.out.println("Cantidad agregada correctamente");
    }

    public void verProducto(Producto producto){
        int opcion;
        producto.mostrarProducto();
        if (producto instanceof Clasificado) {
            tiempo();
            return;
        }
        System.out.println("1. Agregar stock/cupos");
        System.out.println("2. Activar/Desactivar");
        System.out.println("3. Volver a la seccion");
        opcion = sc.nextInt();
        switch(opcion)
        {
            case 1:
                agregarUnidadesProducto(producto);
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
            System.out.print("Digite el número de producto para entrar, o 0 para salir. ");
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

    public void VerSecciones(){
        int opcion = 0;
        do{
            System.out.println("");
            usuario.getTienda().ListarSecciones();
            System.out.print("Digite el número de sección para entrar, o 0 para salir.  ");

            opcion = sc.nextInt();
            opcion = opcion -1;
            if(opcion>=0 && opcion<usuario.getTienda().getCantidadSecciones()){
                AbrirSeccion(usuario.getTienda().getSecciones().get(opcion));
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

    public Categoria obtenerCategoria(){
        int index = 0;
        System.out.println("Elije la categoria");
        for(Categoria categoria: dt.getCategorias()){
            index++;
            System.out.println(index+". "+categoria.getNombre());
        }
        int op = sc.nextInt();
        return dt.getCategorias().get(op-1);
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

    public boolean agregarClasificado(Producto producto){
        Seccion seccion = usuario.getTienda().buscarSeccion("Mis Clasificados");
        if(seccion != null){
            seccion.agregarProducto(producto);
            return true;
        }
        Seccion nuevaSeccion = new Seccion("Mis Clasificados");
        usuario.getTienda().añadirSeccion(nuevaSeccion);
        nuevaSeccion.agregarProducto(producto);
        return false;
    }

    public void agregarASeccion(Producto producto, int opcion){
        System.out.println("");
        if(opcion == 3){
            agregarClasificado(producto);
            return;
        }
        do{
            System.out.println("");
            usuario.getTienda().ListarSecciones();
            int numero = usuario.getTienda().getCantidadSecciones() + 1;
            System.out.println("Indica la sección donde deseas agregar el producto");
            System.out.println("o marca "+numero +" para crear una nueva seccion");
            System.out.println("o 0 para salir.");
            opcion = sc.nextInt();
            opcion = opcion -1;
            if(opcion>=0 && opcion<usuario.getTienda().getCantidadSecciones()){
                usuario.getTienda().getSecciones().get(opcion).agregarProducto(producto);
                return;
            }else if(opcion+1 == numero){
                sc.nextLine();
                System.out.println("Escribe el nombre de la nueva seccion");
                String nuevoS = sc.nextLine();
                Seccion nuevaSeccion = new Seccion(nuevoS);
                usuario.getTienda().añadirSeccion(nuevaSeccion);
                nuevaSeccion.agregarProducto(producto);
                return;
            }
            else if(opcion == -1){
                break;
            }
            else{
                System.out.print("Digita un numero valido. \n");
            }
        }while(true);

        int opcion1 = sc.nextInt();
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
                agregarASeccion(regular, opcion);
                System.out.println("Producto creado Correctamente");
                break;
            case 2:
                System.out.println("Cupos:");
                int cupo = sc.nextInt();
                System.out.println("Costo por Cupo:");
                double precioCupo = sc.nextDouble();
                Servicio servicio = new Servicio(nombre, descripcion, categoria, cupo, precioCupo);
                agregarASeccion(servicio, opcion);
                System.out.println("Servicio creado Correctamente");
                break;   
            case 3:
                System.out.println("Precio:");
                double precio = sc.nextDouble();
                boolean estado = indicarEstado();
                Clasificado clasificado = new Clasificado(nombre, descripcion, categoria, precio, estado);
                agregarASeccion(clasificado, opcion);
                System.out.println("Clasificado creado Correctamente");
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
                System.out.println("Escribé el nombre de tu tienda");
                String nombreTienda = sc.nextLine();
                Tienda nuevaTienda = new Tienda(nombreTienda);
                usuario.setTienda(nuevaTienda);
            }
        }while(opcion!=4);
    }
}
