import java.util.Scanner; // siempre importar 
public class solveExtra {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner para ingresar los datos desde consola
        int energiaObjetivo;
        boolean entradaValida = false;
        do{
            System.out.print("Ingresa la energía que necesita Miku para volver a SEKAI: ");
            energiaObjetivo = scanner.nextInt();
            if(energiaObjetivo>0){
                entradaValida = true;
            } else{
                System.out.println("El número debe ser mayor a 0.");
            }
            scanner.nextLine();
        }while(!entradaValida);
    
        int energiaActual = 0;
        int aumentoHabilidad = 50; 
        int bonusXL = 80;
        int cantDias = 0;
        while(energiaActual<energiaObjetivo){
            cantDias++;
            if(cantDias %4== 0){
                energiaActual += bonusXL;
            }else{
                energiaActual += aumentoHabilidad;
            }
        }
       System.out.printf("Los días que Miku necesita comer completo son %d días para lograr %d UEM.",cantDias,energiaObjetivo);
       scanner.close();
    }
}
