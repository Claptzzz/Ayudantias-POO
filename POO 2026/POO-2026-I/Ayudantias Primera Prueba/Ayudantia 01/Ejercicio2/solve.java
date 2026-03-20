import java.util.Scanner;

public class solve{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); 
        System.out.print("- Nombre: ");
        String nombre = scanner.nextLine();

        boolean entradaValida = false;
        do{
            System.out.print("- Correo ucn: ");
            String correo = scanner.nextLine();
            String[] datos = correo.split("@");
            String dominio = datos[1];
            if(dominio.equalsIgnoreCase("alumnos.ucn.cl")){
                System.out.printf("¡Bienvenid@ %s! Acceso a plataforma estudiantil.", nombre);                
                entradaValida = true;
            } else if(dominio.equalsIgnoreCase("ucn.cl")){
                System.out.printf("¡Bienvenid@ %s! Acceso a plataforma docente.", nombre);
                entradaValida = true;
            }else{
                System.out.println("Acceso denegado, intente nuevamente.");
            }
        }while(!entradaValida);
        scanner.close();
    }
}