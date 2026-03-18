import java.util.Scanner;

public class solve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] temperaturasMx = new double[2][2];

        System.out.println("--- Registro de temperaturas ---");
        int numRegistro= 1;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.printf("Registro n°%d", numRegistro);
                double temperatura =-1;
                System.out.println();
                do{
                    System.out.println("- Ingrese la temperatura en grados celsius:");
                    temperatura = scanner.nextDouble();
                    scanner.nextLine(); //limpiar el buffer
                    if(temperatura<0.0 || temperatura>100.0){
                        System.out.println("Entrada invalida, intente nuevamente.");
                    }else{
                        temperaturasMx[i][j] = temperatura;
                        System.out.println("Temperatura registrada correctamente!");
                    }
                }while(temperatura<0.0 || temperatura>100.0);
                numRegistro++;
            }
        }
        double promSerena =(temperaturasMx[0][0] + temperaturasMx[0][1])/2;
        double promCoquimbo =(temperaturasMx[1][0] + temperaturasMx[1][1])/2;
        double promGeneral =(promSerena + promCoquimbo)/2;

        System.out.print("--- Resultados Locales ---");
        System.out.printf("\n- Promedio La Serena: %.2f °C", promSerena);
        System.out.printf("\n- Promedio Coquimbo: %.2f °C", promCoquimbo);
        System.out.printf("\n- Promedio general: %.2f °C", promGeneral);

        scanner.close();
   }
}
