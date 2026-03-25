import java.util.Scanner;
import java.io.*;

public class solveA02 {
    static String[] closet = new String[10];
    static String[][] porta = new String[4][2];
    static String[][][] comoda = new String[3][3][2];

    public static boolean existe(String prenda, String color) {

        if (prenda.equalsIgnoreCase("traje")) {
            for (int i = 0; i < 10; i++) {
                if (closet[i] != null && closet[i].equalsIgnoreCase(color)) return true;
            }
        } else if (prenda.equalsIgnoreCase("zapato")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    if (porta[i][j] != null && porta[i][j].equalsIgnoreCase(color)) return true;
            }
        }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (comoda[i][j][k] != null && comoda[i][j][k].equalsIgnoreCase(color)) return true;
                    }
                }
            }
        }

        return false;
    }
    
    public static boolean opciones(Scanner s, int opcion, boolean cargado) {
        switch(opcion) {
                case 1 : {
                    try {
                        cargado = cargarArchivo(cargado);
                    } catch (Exception e) {
                        System.out.println("No se encuentra el archivo");
                        cargado = false;
                    }
                    return cargado;
                }

                case 2: {
                    if (!cargado) {
                        System.out.println("No hay ningún archivo cargado");
                    } else consultarColor(s);
                    return cargado;
                }

                case 3: {
                    if (!cargado) {
                        System.out.println("No hay ningún archivo cargado");
                    } else agregarPrenda(s);
                    return cargado;
                }

                case 4: {
                    if (!cargado) {
                        System.out.println("No hay ningún archivo cargado");
                    } else verVacios();
                    return cargado;
                }

                case 5: {
                    System.out.println("Hasta pronto Saul!");
                    return cargado;
                }

                default: System.out.println("Ingrese una opción válida");
                return cargado;
            }
    }

    public static boolean cargarArchivo(boolean cargado) throws IOException{
        if (cargado) {
            System.out.println("El archivo ya fue cargado");
            return true;
        } else {
            File file = new File("ropa.txt");

            Scanner s = new Scanner(file);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] parts = line.split(",");

                String prenda = parts[0];

                if (prenda.equals("traje")) {
                    int x = Integer.parseInt(parts[1]);
                    String color = parts[2];

                    closet[x] = color; 

                } else if (prenda.equals("zapato")) {
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    String color = parts[3];

                    porta[x][y] = color;

                } else {
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    int z = Integer.parseInt(parts[3]);
                    String color = parts[4];

                    comoda[x][y][z] = color;
                }

            }

            s.close();
            return true;
        }
    }

    public static void consultarColor(Scanner s) {
        
        System.out.println("Ingrese la prenda a buscar");
        System.out.print("> ");
        String entrada = s.nextLine();
        System.out.println();

        if (entrada.equalsIgnoreCase("traje")) {
            int x = -1;

            do {
                System.out.println("Ingrese el valor en X");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    x = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    x = -1;
                }

                if (x < 0 || x > 9) System.out.println("Ingrese valores dentro del rango del closet\n");
            } while (x < 0 || x > 9);

            if (closet[x] != null) System.out.printf("El color del traje en la posición (x = %d) es %s%n", x, closet[x]);
            else System.out.println("No hay ningún traje en esa posición");

        } else if (entrada.equalsIgnoreCase("zapato")) {
            int x = -1;

            do {
                System.out.println("Ingrese el valor en X");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    x = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    x = -1;
                }

                if (x < 0 || x > 3) System.out.println("Ingrese valores dentro del rango del portazapatos\n");
            } while (x < 0 || x > 3);

            int y = -1;

            do {
                System.out.println("Ingrese el valor en Y");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    y = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    y = -1;
                }

                if (y < 0 || y > 1) System.out.println("Ingrese valores dentro del rango del portazapatos\n");
            } while (y < 0 || y > 1);

            if (porta[x][y] != null) System.out.printf("El color de los zapatos en la posición (x = %d), (y = %d) es %s%n", x, y, porta[x][y]);
            else System.out.println("No hay ningún zapato en esa posición");

        } else if (entrada.equalsIgnoreCase("camisa")) {
            int x = -1;

            do {
                System.out.println("Ingrese el valor en X");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    x = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    x = -1;
                }

                if (x < 0 || x > 2) System.out.println("Ingrese valores dentro del rango de la cómoda\n");
            } while (x < 0 || x > 2);

            int y = -1;

            do {
                System.out.println("Ingrese el valor en Y");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    y = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    y = -1;
                }

                if (y < 0 || y > 2) System.out.println("Ingrese valores dentro del rango de la cómoda\n");
            } while (y < 0 || y > 2);

            int z = -1;

            do {
                System.out.println("Ingrese el valor en Z");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    z = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    z = -1;
                }

                if (z < 0 || z > 1) System.out.println("Ingrese valores dentro del rango de la cómoda\n");
            } while (z < 0 || z > 1);

            if (comoda[x][y][z] != null) System.out.printf("El color de la camisa en la posición (x = %d), (y = %d), (z = %d) es %s%n", x, y, z, comoda[x][y][z]);
            else System.out.println("No hay ninguna camisa en esa posición");

        } else System.out.println("No existe esa prenda... Saliendo\n");

        System.out.println();
    }

    public static void agregarPrenda(Scanner s) {
        System.out.println("Ingrese la prenda a agregar");
        System.out.print("> ");
        String entrada = s.nextLine();
        System.out.println();

        if (entrada.equalsIgnoreCase("traje")) {
            int x = -1;

            do {
                System.out.println("Ingrese el valor en X");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    x = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    x = -1;
                }

                if (x < 0 || x > 9) System.out.println("Ingrese valores dentro del rango del closet\n");
            } while (x < 0 || x > 9);

            if (closet[x] != null) System.out.println("Ya hay un traje en esa posición");
            else {

                System.out.println("Ingrese color");
                System.out.print("> ");

                String color = s.nextLine();

                if (existe("traje",color)) System.out.println("Ya existe ese color de traje");
                else {
                    closet[x] = color;
                    System.out.println("Traje agregado con éxito");
                }
            } 
        } else if (entrada.equalsIgnoreCase("zapato")) {
            int x = -1;

            do {
                System.out.println("Ingrese el valor en X");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    x = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    x = -1;
                }

                if (x < 0 || x > 3) System.out.println("Ingrese valores dentro del rango del portazapatos\n");
            } while (x < 0 || x > 3);

            int y = -1;

            do {
                System.out.println("Ingrese el valor en Y");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    y = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    y = -1;
                }

                if (y < 0 || y > 1) System.out.println("Ingrese valores dentro del rango del portazapatos\n");
            } while (y < 0 || y > 1);

            if (porta[x][y] != null) System.out.println("Ya hay un par de zapatos en esa posición");
            else {

                System.out.println("Ingrese color");
                System.out.print("> ");

                String color = s.nextLine();

                if (existe("zapato",color)) System.out.println("Ya existe ese color de zapatos");
                else {
                    porta[x][y] = color;
                    System.out.println("Zapatos ingresados con éxito");
                }
            } 

        } else if (entrada.equalsIgnoreCase("camisa")) {
            int x = -1;

            do {
                System.out.println("Ingrese el valor en X");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    x = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    x = -1;
                }

                if (x < 0 || x > 2) System.out.println("Ingrese valores dentro del rango de la cómoda\n");
            } while (x < 0 || x > 2);

            int y = -1;

            do {
                System.out.println("Ingrese el valor en Y");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    y = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    y = -1;
                }

                if (y < 0 || y > 2) System.out.println("Ingrese valores dentro del rango de la cómoda\n");
            } while (y < 0 || y > 2);

            int z = -1;

            do {
                System.out.println("Ingrese el valor en Z");
                System.out.print("> ");
                entrada = s.nextLine();
                System.out.println();

                try {
                    z = Integer.parseInt(entrada);

                } catch (Exception e) {
                    System.out.println("Por favor ingrese solamente números.");
                    z = -1;
                }

                if (z < 0 || z > 1) System.out.println("Ingrese valores dentro del rango de la cómoda\n");
            } while (z < 0 || z > 1);

            if (comoda[x][y][z] != null) System.out.println("Ya hay una camisa en esa posición");
            else {

                System.out.println("Ingrese color");
                System.out.print("> ");

                String color = s.nextLine();

                if (existe("camisa",color)) System.out.println("Ya existe ese color de camisa");
                else {
                    comoda[x][y][z] = color;
                    System.out.println("Camisa ingresada con éxito");
                }
            } 

        } else System.out.println("No existe esa prenda... Saliendo\n");

        System.out.println();
    }

    public static void verVacios() {
        System.out.println("Espacios en el closet vacíos: ");
        for (int i = 0; i < 10; i++) {
            if (closet[i] == null) {
                System.out.printf("x = %d%n", i);
            }
        }

        System.out.println("==========================");
        System.out.println("Espacios en el portazapatos vacíos: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (porta[i][j] == null) {
                    System.out.printf("x = %d, y = %d%n", i, j);
                }
            }
        }

        System.out.println("==========================");
        System.out.println("Espacios en la cómoda vacíos: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    if (comoda[i][j][k] == null) {
                        System.out.printf("x = %d, y = %d, z = %d%n", i, j, k);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean cargado = false; 

        int opcion = 0;

        System.out.println("Bienvenido al menú de ropa");
        do {
            System.out.println();
            System.out.println("1) Cargar archivo");
            System.out.println("2) Consultar color");
            System.out.println("3) Agregar prenda");
            System.out.println("4) Ver espacios vacíos");
            System.out.println("5) Salir");
            System.out.print("> ");

            String entrada = s.nextLine();
            System.out.println();

            try {
                opcion = Integer.parseInt(entrada);

            } catch (Exception e) {
                System.out.println("Por favor ingrese solamente números.");
                opcion = 0;
            }

            cargado = opciones(s, opcion, cargado);

        } while (opcion != 5);
    }
}