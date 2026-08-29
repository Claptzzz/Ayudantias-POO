# Ayudantía 1

<img align="right" width=180px alt="Aura farming" src="https://media1.tenor.com/m/VpTL_LfJpcYAAAAC/67.gif" />

## Ejercicio 1 — Batallas de Aura

El CEAL de ICCI quiere aumentar la participación de los alumnos de la carrera en actividades extracurriculares. Por lo mismo, pensaron que sería una gran (pésima) idea realizar batallas de aura en el horario "Encuéntrate UCN". Ahora necesitan un programa que les permita registrar a los participantes, así que deciden pedirles ayuda a los prometedores alumnos de POO.

### Requerimientos

- Mostrar un menú con las opciones **Ingresar competidor** y **Salir**.
- Al ingresar un competidor, solicitar su nombre y guardarlo.
- Volver al menú después de cada operación, hasta que se elija **Salir**.

### Ejemplo

```text
1. Ingresar competidor
2. Salir

Ingresa opción: 1

Ingresa el nombre del farmeador de aura: Martín

Martín registrado!

1. Ingresar competidor
2. Salir

Ingresa opción:
```

## Ejercicio 2 — Aura Puntos

<img align="right" width=180px alt="Aura points" src="https://media.tenor.com/x3ue1dJZ-kUAAAA1/67-pig-sigma-pig.webp">

Ahora quieren poder ingresar los puntos de cada participante, sumando el puntaje al que ya tenía guardado previamente. Se espera que no haya más de 100 participantes en el torneo.

### Requerimientos

- Agregar una nueva opción al menú: **Ingresar puntaje**.
- Al seleccionarla, mostrar la lista de todos los participantes registrados.
- Permitir elegir uno de ellos e ingresar un puntaje, que se **suma** al acumulado personal.
- Ingresar `-1` debe volver al menú principal sin registrar puntaje.

### Ejemplo

```text
1. Ingresar competidor
2. Ingresar puntaje
3. Salir

Ingresa opción: 1

Ingresa el nombre del farmeador de aura: Martín

Martín registrado!

1. Ingresar competidor
2. Ingresar puntaje
3. Salir

Ingresa opción: 2

Participantes:
1. Martín

Ingresa participante (-1 para salir): 1

Ingresa puntos de Martín = 160

Puntaje registrado!

1. Ingresar competidor
2. Ingresar puntaje
3. Salir

Ingresa opción:
```

## Ejercicio 3 — Aura Viewer

<img align="right" width=180px alt="Angry bird" src="https://media.tenor.com/U94DkrDstecAAAAM/67-angry-bird.gif">

Por último, el CEAL se dio cuenta de que, luego de registrar todos los puntos, no tiene manera alguna de ver el puntaje total acumulado. Así que recurren nuevamente a ti y te piden una última opción que permita ver los puntajes de todos los competidores registrados, para así determinar un ganador.

### Requerimientos

- Agregar la opción **Mostrar puntajes** al menú.
- Listar a todos los competidores registrados junto con su puntaje acumulado.

> **BONUS** → Haz una función que muestre quién fue el competidor con mayor puntaje (el ganador con más aura).

### Ejemplo

```text
1. Ingresar competidor
2. Ingresar puntaje
3. Mostrar puntajes
4. Salir

Ingresa opción: 1

Ingresa el nombre del farmeador de aura: Martín

Martín registrado!

1. Ingresar competidor
2. Ingresar puntaje
3. Mostrar puntajes
4. Salir

Ingresa opción: 2

Participantes:
1. Martín

Ingresa participante (-1 para salir): 1

Ingresa puntos de Martín = 160

Puntaje registrado!

1. Ingresar competidor
2. Ingresar puntaje
3. Mostrar puntajes
4. Salir

Ingresa opción: 3

Participantes:
1. Martín -> 160 pts.

1. Ingresar competidor
2. Ingresar puntaje
3. Mostrar puntajes
4. Salir

Ingresa opción:
```