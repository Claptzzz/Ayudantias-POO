package dominio;

//Representa el desempeño de UN equipo en UNA competencia
public class Resultado {
 private Equipo equipo;
 private String[] ejercicios;
 private int cantEjercicios;

 public Resultado(Equipo equipo) {
     this.equipo = equipo;
     this.ejercicios = new String[26];
     this.cantEjercicios = 0;
 }

 public Equipo getEquipo() {
     return equipo;
 }

 public int getCantidadResueltos() {
     return cantEjercicios;
 }

 public String getEjercicio(int posicion) {
     return ejercicios[posicion];
 }

 public boolean tieneEjercicio(String ejercicio) {
     for (int i = 0; i < cantEjercicios; i++) {
         if (ejercicios[i].equals(ejercicio)) {
             return true;
         }
     }
     return false;
 }

 public void agregarEjercicio(String ejercicio) {
     if (cantEjercicios < ejercicios.length && !tieneEjercicio(ejercicio)) {
         ejercicios[cantEjercicios] = ejercicio;
         cantEjercicios++;
     }
 }

 public String getTextoCantidad() {
     if (cantEjercicios == 1) {
         return "1 ejercicio";
     }
     return cantEjercicios + " ejercicios";
 }

 // Retorna los ejercicios con el formato [A, B, C]
 public String getTextoEjercicios() {
     String texto = "[";
     for (int i = 0; i < cantEjercicios; i++) {
         if (i > 0) {
             texto += ", ";
         }
         texto += ejercicios[i];
     }
     return texto + "]";
 }
}