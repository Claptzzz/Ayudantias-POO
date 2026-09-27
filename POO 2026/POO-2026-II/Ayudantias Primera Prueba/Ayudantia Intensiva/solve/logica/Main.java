package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dominio.Competencia;
import dominio.Equipo;
import dominio.Participante;
import dominio.Resultado;

public class Main {

    static final int MAX = 100;

    static Participante[] participantes = new Participante[MAX];
    static int cantParticipantes = 0;

    static Equipo[] equipos = new Equipo[MAX];
    static int cantEquipos = 0;

    static Competencia[] competencias = new Competencia[MAX];
    static int cantCompetencias = 0;

    static Scanner teclado;

    public static void main(String[] args) throws FileNotFoundException {
        cargarParticipantes();
        cargarEquipos();
        cargarRegistros();
        menu();
        teclado.close();
    }

    // ======================= MENU =======================

    private static void menu() {
        int opcion;
        teclado = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("===== PROG-COMP =====");
            System.out.println("1) Ver competencias");
            System.out.println("2) Ver equipos por competencia");
            System.out.println("3) Ver historial de un participante");
            System.out.println("4) Ranking de universidades");
            System.out.println("5) Estadisticas de ejercicios");
            System.out.println("6) Actualizar semestre de un participante");
            System.out.println("7) Reemplazar integrante de un equipo");
            System.out.println("8) Registrar nueva competencia");
            System.out.println("9) Salir");
            System.out.print("Ingrese opcion: ");
            opcion = leerEntero();
            System.out.println();

            switch (opcion) {
            case 1:
                verCompetencias();
                break;
            case 2:
                verEquiposPorCompetencia();
                break;
            case 3:
                verHistorialParticipante();
                break;
            case 4:
                rankingUniversidades();
                break;
            case 5:
                estadisticasEjercicios();
                break;
            case 6:
                actualizarSemestre();
                break;
            case 7:
                reemplazarIntegrante();
                break;
            case 8:
                registrarCompetencia();
                break;
            case 9:
                System.out.println("Hasta luego!");
                break;
            default:
                System.out.println("Opcion incorrecta. Reingrese");
                break;
            }
        } while (opcion != 9);
    }

    // ======================= LECTURA DE ARCHIVOS =======================

    private static void cargarParticipantes() throws FileNotFoundException {
        // Martin;Droguett;22.111.111-2;6
        Scanner arch = new Scanner(new File("Participantes.txt"));
        while (arch.hasNextLine() && cantParticipantes < MAX) {
            String linea = arch.nextLine();
            if (!linea.isEmpty()) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String apellido = partes[1];
                String rut = partes[2];
                int semestre = Integer.parseInt(partes[3]);

                participantes[cantParticipantes] = new Participante(nombre, apellido, rut, semestre);
                cantParticipantes++;
            }
        }
        arch.close();
    }

    private static void cargarEquipos() throws FileNotFoundException {
        // Os-Poropos;22.222.222-1;22.111.111-1;22.333.333-1;Universidad Catolica del Norte
        Scanner arch = new Scanner(new File("Equipos.txt"));
        while (arch.hasNextLine() && cantEquipos < MAX) {
            String linea = arch.nextLine();
            if (!linea.isEmpty()) {
                String[] partes = linea.split(";");
                Equipo equipo = new Equipo(partes[0], partes[4]);

                // Los RUT estan en las posiciones 1, 2 y 3
                for (int i = 1; i <= 3; i++) {
                    Participante encontrado = buscarParticipante(partes[i]);
                    if (encontrado == null) {
                        System.out.println("[Aviso] El RUT " + partes[i] + " del equipo "
                                + partes[0] + " no esta registrado.");
                    }
                    // Se guarda la referencia al participante que ya existe (o null)
                    equipo.setIntegrante(i - 1, encontrado);
                }
                equipos[cantEquipos] = equipo;
                cantEquipos++;
            }
        }
        arch.close();
    }

    private static void cargarRegistros() throws FileNotFoundException {
        // ICPC-2025
        // 3
        // Os-Poropos;A;B;D
        Scanner arch = new Scanner(new File("Registros.txt"));
        while (arch.hasNextLine() && cantCompetencias < MAX) {
            String nombreCompetencia = arch.nextLine();
            if (!nombreCompetencia.isEmpty()) {
                int cantidad = Integer.parseInt(arch.nextLine());
                Competencia competencia = new Competencia(nombreCompetencia, cantidad);

                for (int i = 0; i < cantidad; i++) {
                    String[] partes = arch.nextLine().split(";");
                    String nombreEquipo = partes[0];
                    Equipo equipo = buscarEquipo(nombreEquipo);

                    if (equipo == null) {
                        System.out.println("[Aviso] El equipo " + nombreEquipo + " de "
                                + nombreCompetencia + " no existe. Se ignora su resultado.");
                    } else {
                        Resultado resultado = new Resultado(equipo);
                        // Los ejercicios parten desde la posicion 1
                        for (int j = 1; j < partes.length; j++) {
                            resultado.agregarEjercicio(partes[j]);
                        }
                        competencia.agregarResultado(resultado);
                    }
                }
                competencias[cantCompetencias] = competencia;
                cantCompetencias++;
            }
        }
        arch.close();
    }

    // ======================= FUNCIONES DE APOYO =======================

    private static Participante buscarParticipante(String rut) {
        for (int i = 0; i < cantParticipantes; i++) {
            if (participantes[i].getRut().equals(rut)) {
                return participantes[i];
            }
        }
        return null;
    }

    private static Equipo buscarEquipo(String nombre) {
        for (int i = 0; i < cantEquipos; i++) {
            if (equipos[i].getNombre().equalsIgnoreCase(nombre)) {
                return equipos[i];
            }
        }
        return null;
    }

    private static Competencia buscarCompetencia(String nombre) {
        for (int i = 0; i < cantCompetencias; i++) {
            if (competencias[i].getNombre().equalsIgnoreCase(nombre)) {
                return competencias[i];
            }
        }
        return null;
    }

    // Retorna el equipo al que pertenece el participante, o null si no tiene
    private static Equipo buscarEquipoDe(Participante participante) {
        for (int i = 0; i < cantEquipos; i++) {
            if (equipos[i].tieneIntegrante(participante)) {
                return equipos[i];
            }
        }
        return null;
    }

    // Lee un entero por teclado. Si no se ingresa un numero, retorna -1
    private static int leerEntero() {
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    // ======================= OPCIONES DEL MENU =======================

    // 1) Ver competencias
    private static void verCompetencias() {
        if (cantCompetencias == 0) {
            System.out.println("No hay competencias registradas.");
        }
        for (int i = 0; i < cantCompetencias; i++) {
            Competencia c = competencias[i];
            Resultado ganador = c.getGanador();
            String textoGanador = "Sin equipos";
            if (ganador != null) {
                textoGanador = ganador.getEquipo().getNombre() + " (" + ganador.getTextoCantidad() + ")";
            }
            System.out.println(c.getNombre() + " | " + c.getCantidadEquipos()
                    + " equipos | Ganador: " + textoGanador);
        }
    }

    // 2) Ver equipos por competencia
    private static void verEquiposPorCompetencia() {
        System.out.print("Nombre de la competencia: ");
        Competencia competencia = buscarCompetencia(teclado.nextLine().trim());

        if (competencia == null) {
            System.out.println("La competencia no existe.");
            return;
        }

        System.out.println("Competencia: " + competencia.getNombre());
        Resultado[] ranking = competencia.getRanking();
        for (int i = 0; i < ranking.length; i++) {
            Resultado r = ranking[i];
            Equipo e = r.getEquipo();
            System.out.println((i + 1) + ". " + e.getNombre() + " (" + e.getUniversidad() + ") - "
                    + r.getTextoCantidad() + " " + r.getTextoEjercicios());
            System.out.println("   Integrantes: " + e.getNombresIntegrantes());
        }
    }

    // 3) Ver historial de un participante
    private static void verHistorialParticipante() {
        System.out.print("RUT del participante: ");
        Participante participante = buscarParticipante(teclado.nextLine().trim());

        if (participante == null) {
            System.out.println("El participante no existe.");
            return;
        }

        System.out.println(participante.getNombreCompleto() + " (" + participante.getRut()
                + ") - Semestre " + participante.getSemestre());

        Equipo equipo = buscarEquipoDe(participante);
        if (equipo == null) {
            System.out.println("No pertenece a ningun equipo.");
            return;
        }

        System.out.println("Equipo: " + equipo.getNombre() + " - " + equipo.getUniversidad());
        int total = 0;
        boolean participo = false;

        for (int i = 0; i < cantCompetencias; i++) {
            Competencia c = competencias[i];
            Resultado r = c.buscarResultado(equipo);
            if (r != null) {
                System.out.println(c.getNombre() + ": " + r.getTextoCantidad() + " - Posicion "
                        + c.getPosicion(equipo) + " de " + c.getCantidadEquipos());
                total += r.getCantidadResueltos();
                participo = true;
            }
        }

        if (!participo) {
            System.out.println("Su equipo no ha participado en competencias.");
        }
        System.out.println("Total de ejercicios resueltos: " + total);
    }

    // 4) Ranking de universidades
    private static void rankingUniversidades() {
        // Vectores paralelos: universidades[i] tiene totales[i] ejercicios
        String[] universidades = new String[cantEquipos];
        int[] totales = new int[cantEquipos];
        int cantUniversidades = 0;

        // Se registran todas las universidades (aunque tengan 0 ejercicios)
        for (int i = 0; i < cantEquipos; i++) {
            boolean existe = false;
            for (int j = 0; j < cantUniversidades; j++) {
                if (universidades[j].equals(equipos[i].getUniversidad())) {
                    existe = true;
                }
            }
            if (!existe) {
                universidades[cantUniversidades] = equipos[i].getUniversidad();
                totales[cantUniversidades] = 0;
                cantUniversidades++;
            }
        }

        // Se suman los ejercicios de todas las competencias
        for (int i = 0; i < cantCompetencias; i++) {
            for (int j = 0; j < competencias[i].getCantidadEquipos(); j++) {
                Resultado r = competencias[i].getResultado(j);
                for (int k = 0; k < cantUniversidades; k++) {
                    if (universidades[k].equals(r.getEquipo().getUniversidad())) {
                        totales[k] += r.getCantidadResueltos();
                    }
                }
            }
        }

        // Ordenamiento burbuja: mayor total primero, empate por nombre
        for (int i = 0; i < cantUniversidades - 1; i++) {
            for (int j = 0; j < cantUniversidades - 1 - i; j++) {
                boolean cambiar = false;
                if (totales[j] < totales[j + 1]) {
                    cambiar = true;
                } else if (totales[j] == totales[j + 1]
                        && universidades[j].compareTo(universidades[j + 1]) > 0) {
                    cambiar = true;
                }

                if (cambiar) {
                    int auxTotal = totales[j];
                    totales[j] = totales[j + 1];
                    totales[j + 1] = auxTotal;

                    String auxUniversidad = universidades[j];
                    universidades[j] = universidades[j + 1];
                    universidades[j + 1] = auxUniversidad;
                }
            }
        }

        for (int i = 0; i < cantUniversidades; i++) {
            System.out.println((i + 1) + ". " + universidades[i] + " - " + totales[i] + " ejercicios");
        }
    }

    // 5) Estadisticas de ejercicios
    private static void estadisticasEjercicios() {
        System.out.print("Nombre de la competencia: ");
        Competencia competencia = buscarCompetencia(teclado.nextLine().trim());

        if (competencia == null) {
            System.out.println("La competencia no existe.");
            return;
        }

        // conteo[i] = cuantos equipos resolvieron la letra letras.charAt(i)
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] conteo = new int[letras.length()];

        for (int i = 0; i < competencia.getCantidadEquipos(); i++) {
            Resultado r = competencia.getResultado(i);
            for (int j = 0; j < r.getCantidadResueltos(); j++) {
                int posicion = letras.indexOf(r.getEjercicio(j));
                if (posicion != -1) {
                    conteo[posicion]++;
                }
            }
        }

        String linea = "";
        int maximo = 0;
        int minimo = -1;
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] > 0) {
                if (!linea.isEmpty()) {
                    linea += " | ";
                }
                linea += letras.charAt(i) + ": " + conteo[i] + " equipo";
                if (conteo[i] != 1) {
                    linea += "s";
                }

                if (conteo[i] > maximo) {
                    maximo = conteo[i];
                }
                if (minimo == -1 || conteo[i] < minimo) {
                    minimo = conteo[i];
                }
            }
        }

        System.out.println(competencia.getNombre());
        if (linea.isEmpty()) {
            System.out.println("Ningun ejercicio fue resuelto en esta competencia.");
            return;
        }

        String masResueltos = "";
        String menosResueltos = "";
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] > 0 && conteo[i] == maximo) {
                if (!masResueltos.isEmpty()) {
                    masResueltos += ", ";
                }
                masResueltos += letras.charAt(i);
            }
            if (conteo[i] > 0 && conteo[i] == minimo) {
                if (!menosResueltos.isEmpty()) {
                    menosResueltos += ", ";
                }
                menosResueltos += letras.charAt(i);
            }
        }
        System.out.println(linea);
        System.out.println("Mas resuelto: " + masResueltos);
        System.out.println("Menos resueltos: " + menosResueltos);
    }

    // 6) Actualizar semestre de un participante
    private static void actualizarSemestre() {
        System.out.print("RUT del participante: ");
        Participante participante = buscarParticipante(teclado.nextLine().trim());

        if (participante == null) {
            System.out.println("El participante no existe.");
            return;
        }

        System.out.print("Nuevo semestre (1-12): ");
        int semestre = leerEntero();

        if (semestre < 1 || semestre > 12) {
            System.out.println("Semestre invalido.");
        } else {
            // Basta con modificar este objeto: todos los equipos
            // que lo referencian veran el cambio.
            participante.setSemestre(semestre);
            System.out.println("Semestre actualizado.");
        }
    }

    // 7) Reemplazar integrante de un equipo
    private static void reemplazarIntegrante() {
        System.out.print("Nombre del equipo: ");
        Equipo equipo = buscarEquipo(teclado.nextLine().trim());

        if (equipo == null) {
            System.out.println("El equipo no existe.");
            return;
        }

        System.out.print("RUT del integrante que sale: ");
        Participante sale = buscarParticipante(teclado.nextLine().trim());

        if (!equipo.tieneIntegrante(sale)) {
            System.out.println("Ese participante no pertenece al equipo.");
            return;
        }

        System.out.print("RUT del participante que entra: ");
        Participante entra = buscarParticipante(teclado.nextLine().trim());

        if (entra == null) {
            System.out.println("El participante que entra no esta registrado.");
        } else if (buscarEquipoDe(entra) != null) {
            System.out.println("El participante que entra ya pertenece a un equipo.");
        } else {
            equipo.reemplazarIntegrante(sale, entra);
            System.out.println(sale.getNombreCompleto() + " fue reemplazado por "
                    + entra.getNombreCompleto() + " en " + equipo.getNombre() + ".");
        }
    }

    // 8) Registrar nueva competencia
    private static void registrarCompetencia() {
        if (cantCompetencias == MAX) {
            System.out.println("No hay espacio para mas competencias.");
            return;
        }

        System.out.print("Nombre de la competencia: ");
        String nombre = teclado.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }
        if (buscarCompetencia(nombre) != null) {
            System.out.println("Ya existe una competencia con ese nombre.");
            return;
        }

        System.out.print("Cantidad de equipos: ");
        int cantidad = leerEntero();

        if (cantidad < 1 || cantidad > cantEquipos) {
            System.out.println("Cantidad invalida (debe estar entre 1 y " + cantEquipos + ").");
            return;
        }

        Competencia nueva = new Competencia(nombre, cantidad);

        while (nueva.getCantidadEquipos() < cantidad) {
            System.out.print("Nombre del equipo " + (nueva.getCantidadEquipos() + 1) + ": ");
            Equipo equipo = buscarEquipo(teclado.nextLine().trim());

            if (equipo == null) {
                System.out.println("El equipo no existe, intente nuevamente.");
            } else if (nueva.buscarResultado(equipo) != null) {
                System.out.println("Ese equipo ya fue ingresado, intente nuevamente.");
            } else {
                System.out.print("Ejercicios resueltos separados por ';' (vacio si ninguno): ");
                String linea = teclado.nextLine().trim().toUpperCase();

                Resultado resultado = new Resultado(equipo);
                if (!linea.isEmpty()) {
                    String[] ejercicios = linea.split(";");
                    for (int i = 0; i < ejercicios.length; i++) {
                        String ejercicio = ejercicios[i].trim();
                        if (!ejercicio.isEmpty()) {
                            resultado.agregarEjercicio(ejercicio);
                        }
                    }
                }
                nueva.agregarResultado(resultado);
            }
        }

        competencias[cantCompetencias] = nueva;
        cantCompetencias++;
        System.out.println("Competencia " + nombre + " registrada.");
    }
}