# Ayudantía Intensiva POO 2026-II

## PROG-COMP

La Academia de Programación Competitiva (APC) participa todos los años en la ICPC (*International Collegiate Programming Contest*) y guarda los registros de cada competencia en archivos de texto. Sin embargo, después de tantos años compitiendo, la cantidad de información ha crecido demasiado como para manejarla a mano, por lo que se dieron cuenta de que necesitan un programa que la administre.

Por esta razón, decidieron pedírselo a los estudiantes de POO.

---

## Archivos

### `Registros.txt`

Contiene los resultados de cada competencia, una tras otra, con el siguiente formato:

```txt
NombreCompetencia
CantidadEquipos
NombreEquipo;Ejercicio1;Ejercicio2;...
NombreEquipo;Ejercicio1;Ejercicio2;...
...
NombreCompetencia
CantidadEquipos
NombreEquipo;Ejercicio1;Ejercicio2;...
...
```

Donde cada ejercicio corresponde a la letra de un problema **resuelto** por el equipo.

Ejemplo:

```txt
ICPC-2025
3
Os-Poropos;A;B;D
MartinDxNico;A;C;D;E
Empanada de Choclo;A;B;C;D;E;F;G
ICPC-2026
4
Os-Poropos;A;B;C;D;F
Empanada de Choclo;A;B;D;E;F
Los Kernel Panic
MartinDxNico;B
```

### `Equipos.txt`

Formato:

```txt
NombreEquipo;Rut1;Rut2;Rut3;Universidad
```

Ejemplo:

```txt
Os-Poropos;22.222.222-1;22.111.111-1;22.333.333-1;Universidad Catolica del Norte
MartinDxNico;22.222.222-2;22.111.111-2;22.333.333-2;Universidad Catolica del Norte
Empanada de Choclo;22.222.222-3;22.111.111-3;22.333.333-3;Universidad Catolica del Norte
Los Kernel Panic;21.444.444-4;21.555.555-5;21.666.666-6;Universidad de La Serena
```

### `Participantes.txt`

Formato:

```txt
Nombre;Apellido;Rut;Semestre
```

Ejemplo:

```txt
Camila;Araya;22.222.222-1;4
Diego;Castillo;22.111.111-1;4
Javiera;Munoz;22.333.333-1;2
Nicolas;Rojas;22.222.222-2;8
Martin;Droguett;22.111.111-2;6
Fernanda;Tapia;22.333.333-2;6
Ignacio;Vega;22.222.222-3;10
Sofia;Pizarro;22.111.111-3;8
Tomas;Carvajal;22.333.333-3;10
Valentina;Rivera;21.444.444-4;5
Benjamin;Olivares;21.555.555-5;7
```

---

## Consideraciones

* Un equipo puede no haber resuelto ningún ejercicio; en ese caso, su línea contiene solo el nombre del equipo.
* Un ejercicio no se repite dentro de la línea de un mismo equipo.
* El RUT identifica de forma única a un participante, y el nombre identifica de forma única a un equipo.
* Si en `Registros.txt` aparece un equipo que no existe en `Equipos.txt`, ese resultado se ignora y se informa por pantalla al momento de cargar.
* Si en `Equipos.txt` aparece un RUT que no existe en `Participantes.txt`, el equipo se crea igualmente, se informa por pantalla y ese integrante se considera **no registrado**.
* **Criterio de ranking:** gana el equipo con más ejercicios resueltos. En caso de empate, se ordena alfabéticamente por nombre de equipo.
* Los archivos se leen **una sola vez**, al iniciar el programa.

---

## Parte II: Modelado (15 pts)

Realice el **diagrama de clases UML** de su solución, incluyendo:

* Atributos con su tipo y visibilidad.
* Métodos principales (no es necesario incluir getters y setters).
* Relaciones entre clases con su **multiplicidad**.

---

## Parte III: Implementación (65 pts)

### Menú

Se debe crear un menú interactivo con las siguientes opciones:

```txt
===== PROG-COMP =====
1) Ver competencias
2) Ver equipos por competencia
3) Ver historial de un participante
4) Ranking de universidades
5) Estadísticas de ejercicios
6) Actualizar semestre de un participante
7) Reemplazar integrante de un equipo
8) Registrar nueva competencia
9) Guardar y salir
```

El menú debe validar que la opción ingresada sea correcta y repetirse hasta que el usuario elija salir.

#### 1) Ver competencias

Muestra todas las competencias registradas, con su cantidad de equipos y el equipo ganador.

```txt
ICPC-2025 | 3 equipos | Ganador: Empanada de Choclo (7 ejercicios)
ICPC-2026 | 4 equipos | Ganador: Empanada de Choclo (5 ejercicios)
```

#### 2) Ver equipos por competencia

Se solicita el nombre de una competencia y se muestra su ranking completo, según el criterio indicado en las consideraciones, junto con la universidad y los integrantes de cada equipo. Si la competencia no existe, se debe informar.

```txt
Competencia: ICPC-2026
1. Empanada de Choclo (UCN) - 5 ejercicios [A, B, D, E, F]
   Integrantes: Ignacio Vega, Sofia Pizarro, Tomas Carvajal
2. Os-Poropos (UCN) - 5 ejercicios [A, B, C, D, F]
   Integrantes: Camila Araya, Diego Castillo, Javiera Munoz
3. MartinDxNico (UCN) - 1 ejercicio [B]
   Integrantes: Nicolas Rojas, Martin Droguett, Fernanda Tapia
4. Los Kernel Panic (Universidad de La Serena) - 0 ejercicios []
   Integrantes: Valentina Rivera, Benjamin Olivares, (no registrado)
```

#### 3) Ver historial de un participante

Se solicita un RUT y se muestran los datos del participante, su equipo y su desempeño en cada competencia en la que participó (ejercicios resueltos y posición obtenida), además del total de ejercicios resueltos. Si el RUT no existe, se debe informar.

```txt
Martin Droguett (22.111.111-2) - Semestre 6
Equipo: MartinDxNico - Universidad Catolica del Norte
ICPC-2025: 4 ejercicios - Posicion 2 de 3
ICPC-2026: 1 ejercicio  - Posicion 3 de 4
Total de ejercicios resueltos: 5
```

#### 4) Ranking de universidades

Muestra las universidades ordenadas de mayor a menor según el total de ejercicios resueltos por todos sus equipos, sumando todas las competencias.

```txt
1. Universidad Catolica del Norte - 25 ejercicios
2. Universidad de La Serena - 0 ejercicios
```

#### 5) Estadísticas de ejercicios

Se solicita el nombre de una competencia y se muestra, para cada ejercicio resuelto al menos una vez, cuántos equipos lo resolvieron. Además, se indica el ejercicio más resuelto y el o los ejercicios menos resueltos.

```txt
ICPC-2026
A: 2 equipos | B: 3 equipos | C: 1 equipo | D: 2 equipos | E: 1 equipo | F: 2 equipos
Mas resuelto: B
Menos resueltos: C, E
```

#### 6) Actualizar semestre de un participante

Se solicita un RUT y el nuevo semestre (entero entre 1 y 12). El cambio debe verse reflejado inmediatamente en **todas** las opciones del menú, **modificando un único objeto**.

#### 7) Reemplazar integrante de un equipo

Se solicita el nombre de un equipo, el RUT del integrante que sale y el RUT del participante que entra. Se debe validar que:

* El equipo exista.
* El integrante que sale pertenezca al equipo.
* El participante que entra esté registrado y no pertenezca ya a otro equipo.

#### 8) Registrar nueva competencia

Se solicita el nombre de la competencia (no debe existir previamente), la cantidad de equipos y, por cada equipo, su nombre y los ejercicios que resolvió. Se debe validar que cada equipo exista y que no se repita dentro de la misma competencia.

#### 9) Salir

