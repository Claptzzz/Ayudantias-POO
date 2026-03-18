public class solve {
    public static void main (String[] args) {
        int energiaObjetivo = 2200;
        int energiaActual = 0;
        int aumentoHabilidad =50; 
        int cantDias = 0;

        while(energiaActual<energiaObjetivo) {
            energiaActual += aumentoHabilidad;
            cantDias++;
        }
        System.out.printf("Los días que Miku necesita comer completo son: %d días.", cantDias);
    }
}
