public class Visitante{
    private String nombre;
    private String apellido;
    private long numDoc;
    private String evento;

    public Visitante(String nombre, String apellido, long numDoc, String evento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numDoc = numDoc;
        this.evento = evento;
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
    public long getNumDoc() {
        return numDoc;
    }
    public void setNumDoc(long numDoc) {
        this.numDoc = numDoc;
    }
    public String getEvento() {
        return evento;
    }
    public void setEvento(String evento) {
        this.evento = evento;
    }
    
}