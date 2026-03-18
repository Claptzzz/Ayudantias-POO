import java.util.Scanner;

public class solveExtra {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        double[][] temperaturas = new double[2][2];

        System.out.println("--- Registro de temperaturas ---");
        System.out.print("- Ingrese temperatura La Serena Centro: ");
        temperaturas[0][0] = scanner.nextDouble();
        System.out.print("- Ingrese temperatura de Cuatro esquinas: ");
        temperaturas[0][1] = scanner.nextDouble();
        System.out.print("- Ingrese temperatura Puerto Coquimbo: ");
        temperaturas[1][0] = scanner.nextDouble();
        System.out.print("- Ingrese temperatura Guanaqueros: ");
        temperaturas[1][1] = scanner.nextDouble();

        scanner.nextLine();

        double promSerena =(temperaturas[0][0] + temperaturas[0][1])/2;
        double promCoquimbo =(temperaturas[1][0] + temperaturas[1][1])/2;
        double promGeneral =(promSerena + promCoquimbo)/2;

        System.out.print("\n--- Resultados Locales ---");
        System.out.printf("\n- Promedio La Serena: %.2f °C", promSerena);
        System.out.printf("\n- Promedio Coquimbo: %.2f °C", promCoquimbo);
        System.out.println();
        //EXTRA
        System.out.print("\n-----Resultados generales-----");
        System.out.print("\n- ¿Desea el reporte general en Celsius, fahrenheit o kelvin?: ");
        String reporte = scanner.nextLine();
        //se puede realizar también con if/else
        switch(reporte.toLowerCase()){
                case "fahrenheit":
                    promGeneral = (promGeneral*1.8)+32;
                    System.out.printf("\n- Promedio general en Fahrenheit %.2f °F", promGeneral);
                    break;
                case "celsius":
                    System.out.printf("\n- Promedio general en Celsius: %.2f °C", promGeneral);
                    break;
                case "kelvin":
                    promGeneral = promGeneral+273.1;
                    System.out.printf("\n- Promedio general en Kelvin: %.2f °K", promGeneral);
                    break;
                default:
                    System.out.print("\nOpción inválida");
                    break;
        }
        System.out.println("\n¡Muchas gracias por utilizar el programa!");
        scanner.close();
    }
}
