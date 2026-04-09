# Taller 2

**I Semestre - 2026**
**ITI - ICCI - ICI**

**Docentes:**
- Alejandro Paolini Godoy
- Cristhian Rabi Reyes
- Juan Nilo

## Contexto: El camino para ser el mejor

¡Desde pequeño eres un gran fan de Pokémon, por lo cual finalmente decides crear tu primer juego de simulación!

Quieres que el juego pueda simular capturas de Pokémon, batallas, entre otras características que un juego de la franquicia posee.

## Archivos

### Registros.txt

```text
nombreCuenta;medallas
pokemon1;Vivo
pokemon2;Debilitado
pokemon3;Vivo
...
pokemonN;Estado
```
***Aquí tenemos el archivo donde se guardará la partida del jugador. En la primera línea tenemos su nombre y cuántas medallas ha conseguido, luego tenemos N (yendo desde 0 a infinito) líneas que nos indican los Pokémon que posee el jugador y su estado de batalla (puede ser 'Vivo' o 'Debilitado').***

### Habitats.txt

```text
Lago
Cueva
Montaña
Bosque
Prado
Mar
```
***Este archivo nos da las zonas donde podremos encontrar Pokémon y a las que el jugador podrá ir a explorar.***

### Pokedex.txt
```text
Mawile;Cueva;0.2;50;85;85;55;55;50;Acero
Gliscor;Cueva;0.2;75;95;125;45;75;95;Tierra
MegaMawile;none;0;50;105;125;55;95;50;Acero
MegaBlaziken;none;0;80;160;80;130;80;100;Fuego
```
***El archivo tiene el siguiente formato:***

* ***pokemon;habitat;porcentajeAparicion;vida;ataque;defensa;ataqueEspecial;defensaEspecial;velocidad;Tipo***

Donde se nos darán todos los Pokémon que se usarán para el juego.

### Gimnasios.txt

```text
1;EmmaLaArdillaRabiosa;Sin derrotar;3;Minun;Plusle;Emolga
2;MartinNegro;Sin derrotar;3;MegaBlaziken;Centiskorch;Slugma
3;Ferran;Sin derrotar;4;Gengar;Reuniclus;Mewtwo;Reshiram
4;Branco;Sin derrotar;4;Minior;Dracovish;Porygon-Z;Hydrapple
5;Remi;Sin derrotar;5;Eevee;Scizor;Trevenant;Umbreon;Togekiss
6;Pruno;Sin derrotar;5;Infernape;Aggron;Tyranitar;Lucario;Aerodactyl
7;Dani;Sin derrotar;6;Mew;Swanna;Milotic;Dragapult;Lapras;Gigalith
8;Maxi;Sin derrotar;6;Chandelure;Decidueye;Froslass;Dragapult;Spiritomb;Sableye
```

***Tenemos la siguiente estructura:***

***N°Gimnasio;Lider;Estado;cantPokemons;Pokemons....***

Donde el número de Pokémon depende de la cantidad que indique la línea.

### Alto Mando.txt

```text
1;MartinGalactico;Magikarp;Noivern;Excadrill;Steelix;Lucario;Scizor
2;Estefania;Victini;Azumarill;Floatzel;Magcargo;Ludicolo;Seismitoad
3;Catalina;Snorlax;Milotic;Froslass;Shiftry;Mewtwo;Kingler
4;Clapt;MegaMawile;Spiritomb;Noivern;Scizor;Dragapult;Gliscor
5;Juan;Charizard;Sceptile;Umbreon;Psyduck;Staraptor;Mamoswine
6;Rabi;Meganium;Samurott;Groudon;Sableye;Garganacl;Reshiram
7;Papulini;Ekans;Snorlax;Wobbuffet;Zubat;Poliwrath;Victreebel
```
***Tenemos la siguiente estructura:***

***N°AltoMando;Nombre;Pokemons....***

Todos los miembros del Alto Mando poseen 6 Pokémon.

### Tabla de tipos (Extra)

```java
public class TablaTipos {
    
    // Matriz de efectividad
    private static final double[][] EFECTIVIDAD = {
        // NOR  FUE  AGU  PLA  ELE  HIE  LUC  VEN  TIE  VOL  PSI  BIC  ROC  FAN  DRA  ACE  SIN  HAD
        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0, 0.5, 1.0, 1.0 }, // NORMAL
        {  1.0, 0.5, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0 }, // FUEGO
        {  1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0 }, // AGUA
        {  1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 0.5, 0.5, 1.0, 1.0 }, // PLANTA
        {  1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0 }, // ELECTRICO
        {  1.0, 0.5, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0 }, // HIELO
        {  2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 0.5, 2.0, 0.0, 1.0, 2.0, 2.0, 0.5 }, // LUCHA
        {  1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 0.0, 1.0, 2.0 }, // VENENO
        {  1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 0.5, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0 }, // TIERRA
        {  1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 0.5, 1.0, 1.0 }, // VOLADOR
        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0 }, // PSIQUICO
        {  1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 0.5, 2.0, 0.5 }, // BICHO
        {  1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0 }, // ROCA
        {  0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0 }, // FANTASMA
        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.0 }, // DRAGON
        {  1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0 }, // ACERO
        {  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5 }, // SINIESTRO
        {  1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0, 1.0 }  // HADA
    };
}
```

***Se hace entrega de la tabla de tipos para que puedan implementarla mediante una matriz en su código.***

***Filas->Pokemon del jugador; Columna->PokemonRival***

## Requerimientos

Se debe generar un juego interactivo por consola.

### Menú inicial

Debe tener un menú donde se dé la bienvenida al juego y el usuario tenga 3 opciones:
```text
1) Continuar.
2) Nueva Partida.
3) Salir.
```
### Menú de continuar

En caso de continuar, se deben cargar los datos guardados en `Registros.txt`, dar la bienvenida al usuario guardado y mostrar las siguientes opciones:
```text
1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

### Menú de nueva partida

En caso de comenzar una nueva partida, se debe consultar por el nombre de usuario a jugar y sobrescribir toda la información que haya en `Registros.txt` por la nueva. 
```text
Ingrese su apodo de jugador:
```

Luego, dar acceso al mismo menú principal:
```text
1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

### Mecánicas de Combate
* **Condición de victoria:** Los combates se deciden por la suma de las estadísticas (stats) de cada Pokémon. Se sumarán las estadísticas del Pokémon en uso del jugador y las del enemigo. El que tenga la suma mayor derrota al otro.
* **Efectividad de tipos:** La tabla de tipos influye directamente en el combate. Se deben comparar los tipos de ambos Pokémon; si el pokemon es efectivo, la suma de las estadísticas del atacante se multiplica por 2 (x2). Si es poco eficaz, se reduce a la mitad.
* **Opciones en batalla:** Durante el combate, el jugador tendrá la opción de atacar o cambiar de Pokémon (eligiendo otro de los 6 disponibles en su equipo). 

## Aclaraciones

Explicación de cada opción en el menú:

```text
1) Revisar equipo -> Debe imprimir la información (nombre, tipo y suma de todas las estadísticas) de cada Pokémon que el jugador tenga en su equipo.

2) Salir a capturar -> Debe mostrarle al usuario todas las zonas existentes para salir a capturar un Pokémon. Al seleccionar una zona, debe generarse un Pokémon aleatorio (que exista en esa zona) y el usuario tendrá dos opciones: 1) Capturar. 2) Huir. En caso de capturarlo, se debe añadir a su lista de Pokémon.

3) Acceso al PC -> Aquí se deben mostrar de manera numerada todos los Pokémon que el usuario haya capturado. Luego, el usuario tendrá dos opciones: 1) Cambiar Pokémon. 2) Salir. En caso de elegir cambiar un Pokémon, el usuario deberá elegir dos números para intercambiar sus lugares en la lista y así, por ejemplo, modificar su equipo.

4) Retar un gimnasio -> Aquí se deberán imprimir todos los gimnasios existentes y el estado de cada uno. El usuario podrá elegir ir a retar a uno (no puede retar a un gimnasio sin antes haber derrotado al anterior).

5) Desafío al Alto Mando -> El usuario podrá retar al Alto Mando para coronarse como campeón, pero en esta parte hay ciertas restricciones. 

Una vez ingresado a las batallas, se retará a cada oponente de manera consecutiva, sin poder regresar al menú para cambiar de equipo. Las únicas maneras de regresar al menú son siendo derrotado o rindiéndose. En cualquiera de los casos, el usuario regresará y, si desea retarlos de nuevo, deberá luchar contra todos otra vez (o sea, no se guarda el progreso en caso de haber derrotado a alguno previamente).

6) Curar Pokémon -> Se curarán todos los Pokémon debilitados, pasando su estado a 'Vivo'.

7) Guardar -> Se sobrescriben los datos en Registros.txt.

8) Guardar y Salir -> Se guardan los datos y finaliza el programa.
```

### Aclaraciones Extra

* Los primeros 6 Pokémon que estén en la lista del jugador serán los que pertenecen a su equipo, con el cual podrá desafiar a los gimnasios y altos mandos.
* Cada Pokémon tiene un % de aparición. La suma de probabilidades de los Pokémon en una zona siempre es el 100%.
* Para mayor simplicidad, cada Pokémon tendrá un solo tipo.
* Los Pokémon en estado 'Debilitado' no se pueden usar en combate.
* Al desafiar a un Líder de Gimnasio o a un miembro del Alto Mando, el jugador tendrá tres opciones: `1) Atacar 2) Cambiar de Pokémon 3) Rendirse`
    * Al atacar, se simula la batalla de ambos Pokémon.
    * Al elegir cambiar, se podrá elegir uno de los primeros 6 Pokémon para enviarlo al combate.
    * Al rendirse, volverá al menú dejando el estado del gimnasio en 'Sin derrotar'.
* No existen turnos, por lo cual el jugador puede cambiar cuantas veces quiera de Pokémon en combate.
* En caso de elegir la opción `Atacar` se debera imprimir los stats resultantes de cada Pokémon (del jugador y el rival) y el resultado del combate.
* Para desafiar al Alto Mando, debes tener los 8 gimnasios derrotados.
* Un pokemon no se puede repetir en los pokemons del jugador, esto significa que si ya lo capturo no puede volver a capturarlo.


### Ejemplos de Ejecución.

```text
1) Continuar.
2) Nueva Partida.
3) Salir.
```

```text
Ingrese Opcion: 2
```

```text
Ingrese Apodo: Clapt
```

```text
Bienvenido Clapt!!
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 2
```

```text
Donde deseas ir a explorar?

Zonas disponibles:

1) Lago
2) Cueva
3) Montaña
4) Bosque
5) Prado
6) Mar
7) Volver al menu.
```

```text
Ingrese Zona: 2
```

```text
Oh!! Ha aparecido un increible Mawile!!

Que deseas hacer?

1) Capturar
2) Huir
```

```text
Ingrese Opcion: 1
```

```text
Mawile capturado con exito!!
```

```text
Mawile ha sido agregado a tu equipo!
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 1
```

```text
Equipo Actual:
1) Mawile|Acero|Stats totales: 380
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 4
```

```text
A cual Lider deseas retar??

1) EmmaLaArdillaRabiosa - Estado: Sin derrotar
2) MartinNegro - Estado: Sin derrotar
3) Ferran - Estado: Sin derrotar
4) Branco - Estado: Sin derrotar
5) Remi - Estado: Sin derrotar
6) Pruno - Estado: Sin derrotar
7) Dani - Estado: Sin derrotar
8) Maxi - Estado: Sin derrotar
9) Volver al menu.
```

```text
Ingrese Opcion: 7
```

```text
Calmado Entrenador!!! No puedes retar a Dani sin haber derrotado a los lideres anteriores!!
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 4
```

```text
A cual Lider deseas retar??

1) EmmaLaArdillaRabiosa - Estado: Sin derrotar
2) MartinNegro - Estado: Sin derrotar
3) Ferran - Estado: Sin derrotar
4) Branco - Estado: Sin derrotar
5) Remi - Estado: Sin derrotar
6) Pruno - Estado: Sin derrotar
7) Dani - Estado: Sin derrotar
8) Maxi - Estado: Sin derrotar
9) Volver al menu.
```

```text
Ingrese Opcion: 1
```

```text
Desafiando a EmmaLaArdillaRabiosa!!
```

```text
Emma saca a Minun!
Clapt saca a Mawile!
```

```text
Que deseas hacer?
1) Atacar
2) Cambiar de pokemon
3) Rendirse
Ingrese Opcion: 1
```

```text
Mawile -> 380 puntos
Minun -> 385 puntos
```

```text
Mawile no es efectivo contra Minun!
Nuevo puntaje:
Mawile -> 190 puntos
Minun -> 385 puntos
```

```text
Ha ganado Minun! Mawile ha sido derrotado...
```

```text
Te has quedado sin pokemons en tu equipo!
Volviendo al menu...
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 6
```

```text
Tu equipo se ha recuperado!
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 2
```

```text
Donde deseas ir a explorar?

Zonas disponibles:

1) Lago
2) Cueva
3) Montaña
4) Bosque
5) Prado
6) Mar
7) Volver al menu.
```

```text
Ingrese Zona: 3
```

```text
Oh!! Ha aparecido un increible Groudon!!

Que deseas hacer?

1) Capturar
2) Huir
```

```text
Ingrese Opcion: 1
```

```text
Groudon capturado con exito!!
```

```text
Groudon ha sido agregado a tu equipo!
```

```text
Clapt, que deseas hacer?

1) Revisar equipo.
2) Salir a capturar.
3) Acceso al PC (cambiar Pokémon del equipo).
4) Retar un gimnasio.
5) Desafío al Alto Mando.
6) Curar Pokémon.
7) Guardar.
8) Guardar y Salir.
```

```text
Ingrese Opcion: 8
```

```text
Nos vemos entrenador...
```

***Registros.txt quedaria tal que***

```text
Clapt;none
Mawile;Vivo
Groudon;Vivo
```

***En caso de haber derrotado a Emma hubiera quedado***

```text
Clapt;EmmaLaArdillaRabiosa
Mawile;Vivo
Groudon;Vivo
```

## Consideraciones

1) Se engloban todas las consideraciones redactadas en el Readme de los talleres <a href="../Readme.md"> (Click aquí para ver)</a>.
2) Se podrán utilizar las siguientes librerías:
```text
Scanner -> Lectura de archivo.
BufferedWriter -> Sobrescritura de los archivos.
Random -> Elegir un Pokémon aleatorio en sus hábitats.
ArrayList y LinkedList -> Uso de Colecciones.
```
***En caso de necesitar alguna adicional, consultar con tiempo.***

3) Se deben entregar el Modelo de Dominio y el Diagrama de Clases en la raíz del repositorio ***EN FORMATO PDF***.
4) Se debe utilizar POO. 

## Fechas
Inicio -> 06/04/2026

Fecha límite -> 08/05/2026
## Contactos
* nicolas.rojas11@alumnos.ucn.cl
* [Grupo de WhatsApp](https://chat.whatsapp.com/GGkRnviIyRfDj24kXZeGpu?mode=gi_t)


## Pauta de Evaluación

**Puntaje Total Máximo:** 120 puntos

### 1. Persistencia de Datos y Archivos (20 puntos)
* **[8 pts] Lectura inicial:** Carga correctamente los datos de `Habitats.txt`, `Pokedex.txt`, `Gimnasios.txt` y `AltoMando.txt` al iniciar el programa sin errores de parseo ni caídas.
* **[6 pts] Carga de partida:** La opción "Continuar" lee correctamente `Registros.txt`, identificando el apodo del jugador, sus medallas y el estado ('Vivo' o 'Debilitado') de cada Pokémon que posee.
* **[6 pts] Guardado de partida:** Las opciones "Guardar" y "Guardar y Salir" sobrescriben `Registros.txt` manteniendo el formato exacto original para futuras lecturas exitosas.

### 2. Lógica de Colecciones y POO (20 puntos)
* **[8 pts] Modelado de Clases:** Crea clases cohesivas (Ej: `Pokemon`, `Gimnasio`, etc.) con sus respectivos atributos privados y métodos, demostrando un uso correcto de la abstracción y el encapsulamiento.
* **[6 pts] Uso de Colecciones:** Utiliza `ArrayList` o `LinkedList` para manejar el equipo del jugador, el inventario del PC y las listas de Pokémon por zona de forma dinámica y eficiente.
* **[6 pts] Tabla de Efectividad:** Implementa correctamente la matriz bidimensional (`double[][]`) para la tabla de tipos, y la consulta correctamente sin usar múltiples `if-else` anidados.

### 3. Mecánicas de Juego (30 puntos)
* **[8 pts] Captura Aleatoria:** Al explorar una zona, el sistema genera un Pokémon aleatorio respetando estrictamente sus porcentajes (%) de aparición.
* **[8 pts] Combate (Stats y Tipos):** El sistema calcula al ganador sumando las estadísticas y aplicando correctamente el multiplicador de la Tabla de Tipos (x2 o x0.5) según corresponda.
* **[7 pts] Gestión de Equipo y PC:** Permite visualizar e intercambiar de forma fluida los Pokémon entre el equipo principal (primeros 6) y el resto almacenado en el PC, sin generar duplicados.
* **[7 pts] Restricciones de Batalla:** Respeta reglas clave: Pokémon 'Debilitados' no pueden pelear, avance progresivo en los Gimnasios (no saltar líderes), y combate consecutivo (sin acceso al PC) en el Alto Mando.

### 4. Control de Errores y Robustez (15 puntos)
* **[5 pts] Estructura de código:** Mantiene un código limpio y ordenado, respetando convenciones de Java (CamelCase) y utilizando nombres de variables descriptivos y no genéricos.
* **[5 pts] Validación de Entradas:** El programa utiliza bloques `try-catch` o validaciones con `Scanner` para evitar errores de `InputMismatchException` (ej. ingresar una letra en vez de un número en los menús).
* **[5 pts] Navegación de Menús:** Los menús fluyen correctamente, permitiendo usar las opciones de rendirse o volver atrás sin atrapar al usuario en bucles infinitos.

### 5. Diagramas y Entregables (15 puntos)
* **[8 pts] Diagrama de Clases:** Entrega un diagrama en formato PDF en la raíz del repositorio que representa fielmente el código construido (atributos, métodos y relaciones entre clases).
* **[7 pts] Modelo de Dominio:** Entrega un modelo conceptual claro en formato PDF que abstrae el problema planteado, diferenciándose del diagrama de clases (sin tipos de datos ni firmas de métodos).

### 6. Uso de GitHub (20 puntos)
* **[20 pts] Uso correcto:** Estructura correcta del repositorio, commits frecuentes, buena documentacion.

---