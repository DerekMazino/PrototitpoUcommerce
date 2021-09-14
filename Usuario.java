
/**
 * Write a description of class Usuario here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (version 1.0)
 */

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String codigo;
    private String password;
    //private int cc;
    private String email;
    private String celular;
    private char genero;
    private boolean rol;//Si es 0, solo es cliente, si es 1, es ambos
    private double puntuacionCliente;
    private double puntuacionVendedor;
    private Tienda tienda;
    
    public Usuario(){
    }
    
    public Usuario(String nombre, String apellido, String codigo, String email, String celular, char genero, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.password = password;
        this.email = email;
        this.celular = celular;
        this.rol = false;
        this.genero = genero;
        puntuacionCliente = 0;
        puntuacionVendedor = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isRol() {
        return rol;
    }

    public void cambiarRol() {
        if(!this.rol)
            this.rol = true;
    }

    public Tienda getTienda() {
        if(this.tienda != null)
            return tienda;  
        else
            return null;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    
    public ArrayList<Object> historialCompras(){
        
        return null;
    }
    
    public ArrayList<Object> historialVentas(){
        
        return null;
    }
    
    
}
