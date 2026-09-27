package dominio;

public class Participante {
    private String nombre;
    private String apellido;
    private String rut;
    private int semestre;

    public Participante(String nombre, String apellido, String rut, int semestre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}