package Logica;

import Dominio.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Juguete> juguetes = new ArrayList<>();
        ArrayList<Juguete> juguetesValidos = new ArrayList<>();
        ArrayList<Niño> niños = new ArrayList<>();

        try (Scanner lector = new Scanner(new File("txts/juguetes.txt"))) {

            while (lector.hasNextLine()) {

                String linea = lector.nextLine();
                String[] datos = linea.split(", ");

                int id = Integer.parseInt(datos[0]);
                String tamaño = datos[1];
                String tipo = datos[2];

                switch (tipo.toLowerCase()) {

                    case "muñeca":
                        int calidad = Integer.parseInt(datos[3]);
                        String colorRopa = datos[4];
                        juguetes.add(new Muñeca(id, tamaño, calidad, colorRopa)
                        );
                        break;

                    case "peluche":
                        String categoria = datos[3];
                        int relleno = Integer.parseInt(datos[4]);
                        juguetes.add(new Peluche(id, tamaño, categoria, relleno)
                        );
                        break;

                    case "auto":
                        String colorAuto = datos[3];
                        int ruedas = Integer.parseInt(datos[4]);
                        boolean control = datos[5].equalsIgnoreCase("si");
                        juguetes.add(new Auto(id, tamaño, colorAuto, ruedas, control)
                        );
                        break;

                    case "pelota":
                        String colorPelota = datos[3];
                        boolean desinflada = datos[4].equalsIgnoreCase("si");
                        juguetes.add(new Pelota(id, tamaño, colorPelota, desinflada)
                        );
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró juguetes.txt");
        }

        for (Juguete j : juguetes) {
        	j.puedeRegalar();

            if (j.isEstado()) {
                juguetesValidos.add(j);
            }
        }

        try (Scanner lector = new Scanner(new File("txts/deseos.txt"))) {

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(", ");
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String tipoDeseo = datos[2];
                Niño niño = new Niño(nombre, edad);

                for (int i = 0; i < juguetesValidos.size(); i++) {

                    Juguete j = juguetesValidos.get(i);
                    if (tipoDeseo.equalsIgnoreCase("muñeca") && j instanceof Muñeca) {
                        Muñeca m = (Muñeca) j;
                        if (m.getColor().equalsIgnoreCase(datos[3])) {
                            niño.getRegalos().add(m);
                            juguetesValidos.remove(i);
                            break;
                        }
                    }

                    else if (tipoDeseo.equalsIgnoreCase("peluche") && j instanceof Peluche) {
                        Peluche p = (Peluche) j;
                        if (p.getTipo().equalsIgnoreCase(datos[3])) {
                            niño.getRegalos().add(p);
                            juguetesValidos.remove(i);
                            break;
                        }
                    }

                    else if (tipoDeseo.equalsIgnoreCase("auto") && j instanceof Auto) {
                        Auto a = (Auto) j;
                        boolean remoto = datos[4].equalsIgnoreCase("si");
                        if (a.getColor().equalsIgnoreCase(datos[3]) && a.isControl() == remoto) {
                            niño.getRegalos().add(a);
                            juguetesValidos.remove(i);
                            break;
                        }
                    }
                }
                niños.add(niño);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró deseos.txt");
        }

        Random random = new Random();

        for (int ronda = 1; ronda <= 3; ronda++) {
            for (Niño n : niños) {
                if (n.getRegalos().size() < ronda && !juguetesValidos.isEmpty()) {
                    int indice = random.nextInt(juguetesValidos.size());
                    n.getRegalos().add(juguetesValidos.get(indice));
                    juguetesValidos.remove(indice);
                }
            }
        }

        System.out.println("Resultados:");

        for (Niño n : niños) {
            System.out.println();
            System.out.println("Niño: " + n.getNombre());
            if (n.getRegalos().isEmpty()) {
                System.out.println("No recibió regalos");
            } else {
                for (Juguete j : n.getRegalos()) {
                    System.out.println("- " + j);
                }
            }
        }
    }
}