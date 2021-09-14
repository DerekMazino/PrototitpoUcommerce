
/**
 * Write a description of class Comentario here.
 * 
 * @author (Camilo Marín, Deyci Toloza) 
 * @version (Version 1.0)
 */
public class Comentario {
    private Usuario mensajeCliente;
    private String mensaje;
    private Comentario mensajeRespuesta; 

    public Comentario(Usuario mensajeCliente, String mensaje) {
        this.mensajeCliente = mensajeCliente;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Comentario{" + "mensajeCliente=" + mensajeCliente + ", mensaje=" + mensaje + ", mensajeRespuesta=" + mensajeRespuesta.mensaje + '}';
    }

    public void setMensajeRespuesta(Comentario mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }
    
}

