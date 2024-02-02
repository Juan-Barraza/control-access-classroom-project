public class Estudiante {        
    private String nombre;
    private String apellido; 
    private String programaAcademico;
    private long numDocumento;
    
    public Estudiante(){
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public long getNumdocumento() {
        return numDocumento;
    }
    public String getProgramaAcademico() {
        return programaAcademico;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
    public long getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(long numDocumento) {
        this.numDocumento = numDocumento;
    }
}