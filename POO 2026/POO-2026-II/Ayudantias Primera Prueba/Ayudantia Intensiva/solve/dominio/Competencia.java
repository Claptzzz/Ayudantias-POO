package dominio;

public class Competencia {
    private String nombre;
    private Resultado[] resultados;
    private int cantResultados;

    // La capacidad es la cantidad de equipos que indica el archivo (o el usuario)
    public Competencia(String nombre, int capacidad) {
        this.nombre = nombre;
        this.resultados = new Resultado[capacidad];
        this.cantResultados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadEquipos() {
        return cantResultados;
    }

    public Resultado getResultado(int posicion) {
        return resultados[posicion];
    }

    public boolean agregarResultado(Resultado resultado) {
        if (cantResultados < resultados.length) {
            resultados[cantResultados] = resultado;
            cantResultados++;
            return true;
        }
        return false;
    }

    // Busca el resultado del equipo indicado (misma referencia)
    public Resultado buscarResultado(Equipo equipo) {
        for (int i = 0; i < cantResultados; i++) {
            if (resultados[i].getEquipo() == equipo) {
                return resultados[i];
            }
        }
        return null;
    }

    public Resultado[] getRanking() {
        Resultado[] ranking = new Resultado[cantResultados];
        for (int i = 0; i < cantResultados; i++) {
            ranking[i] = resultados[i];
        }

        // Ordenamiento burbuja: mas ejercicios primero, empate por nombre
        for (int i = 0; i < ranking.length - 1; i++) {
            for (int j = 0; j < ranking.length - 1 - i; j++) {
                boolean cambiar = false;

                if (ranking[j].getCantidadResueltos() < ranking[j + 1].getCantidadResueltos()) {
                    cambiar = true;
                } else if (ranking[j].getCantidadResueltos() == ranking[j + 1].getCantidadResueltos()
                        && ranking[j].getEquipo().getNombre().compareTo(ranking[j + 1].getEquipo().getNombre()) > 0) {
                    cambiar = true;
                }

                if (cambiar) {
                    Resultado aux = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = aux;
                }
            }
        }
        return ranking;
    }

    public Resultado getGanador() {
        if (cantResultados == 0) {
            return null;
        }
        return getRanking()[0];
    }

    public int getPosicion(Equipo equipo) {
        Resultado[] ranking = getRanking();
        for (int i = 0; i < ranking.length; i++) {
            if (ranking[i].getEquipo() == equipo) {
                return i + 1;
            }
        }
        return -1;
    }
}