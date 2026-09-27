package dominio;

public class Equipo {
    private String nombre;
    private String universidad;
    private Participante[] integrantes;

    public Equipo(String nombre, String universidad) {
        this.nombre = nombre;
        this.universidad = universidad;
        this.integrantes = new Participante[3];
    }

    public String getNombre() {
        return nombre;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setIntegrante(int posicion, Participante participante) {
        integrantes[posicion] = participante;
    }

    public boolean tieneIntegrante(Participante participante) {
        for (int i = 0; i < integrantes.length; i++) {
            if (integrantes[i] == participante) {
                return true;
            }
        }
        return false;
    }

    public boolean reemplazarIntegrante(Participante sale, Participante entra) {
        for (int i = 0; i < integrantes.length; i++) {
            if (integrantes[i] == sale) {
                integrantes[i] = entra;
                return true;
            }
        }
        return false;
    }

    public String getNombresIntegrantes() {
        String texto = "";
        for (int i = 0; i < integrantes.length; i++) {
            if (i > 0) {
                texto += ", ";
            }
            if (integrantes[i] == null) {
                texto += "(no registrado)";
            } else {
                texto += integrantes[i].getNombreCompleto();
            }
        }
        return texto;
    }
}