# Ayudantía 3

<img align="right" width="280" alt="Giganotosaurus bailando" src="https://media.tenor.com/XoR_EO3uOeYAAAAi/dinosaurio-bailando-giganotosaurus.gif" />

## Ejercicio 1 — Dino Dream

Jossender es un gran fan de los dinosaurios: cada día sueña con ellos y, al despertar, anota en su bitácora toda la información que logra recopilar observándolos.

Últimamente se ha dado cuenta de que los dinosaurios no usan el hábitat que les corresponde, por lo cual comienza a anotar en otra bitácora los avistamientos raros que ha encontrado.

Además, notó que algunos dinosaurios tienen afinidad con otros, por lo cual ha catalogado a ciertas especies como "hijas" de otras.

Para poder recuperar su cordura, te pide que lo ayudes con un programa que permita ver la información de los dinosaurios y cuáles han estado fuera de su lugar correspondiente.

### Archivos de entrada

Jossender te entrega dos archivos, `Bitacora.txt` e `Inusuales.txt`, que poseen la siguiente estructura:

#### `Bitacora.txt`

Cada línea usa uno de estos dos formatos:

- `Nombre;Dieta;EdadEstimada;Habitat`
- `Nombre;Dieta;EdadEstimada;Habitat;Hijo`

El campo `Hijo` es opcional: solo algunas líneas lo incluyen.

```txt
Tyrannosaurus;Carnivoro;28;Bosque
Velociraptor;Carnivoro;15;Desierto;Microraptor
Triceratops;Herbivoro;30;Llanura
Stegosaurus;Herbivoro;26;Bosque
```

#### `Inusuales.txt`

Formato: `Nombre-HabitatInusual`

```txt
Velociraptor-Bosque
Triceratops-Desierto
Stegosaurus-Llanura
```

### Requerimientos

- Leer ambos archivos y guardar los datos en vectores.
- Crear el objeto correspondiente junto a sus atributos.
- Crear un menú con las opciones:
    1. Revisar bitácora
    2. Comparar hábitat
    3. Calcular el más fuerte
    4. Ver hijos
    5. Salir

### Aclaraciones

- No habrá más de 50 dinosaurios.
- Al comparar hábitat, se compara el hábitat original del dinosaurio con el inusual.
- Al ver hijos se deben mostrar todas las especies que tienen un hijo y cuál es.
- Para calcular el más fuerte se usa la siguiente fórmula, según el hábitat original:

    | Hábitat  | Fórmula                     |
    | -------- | --------------------------- |
    | Bosque   | `EdadEstimada * 2`          |
    | Llanura  | `(EdadEstimada + 50) * 2/3` |
    | Pantano  | `(EdadEstimada - 10) * 2`   |
    | Desierto | `(EdadEstimada + 150) / 2`  |

### Ejemplo de ejecución

> Los puntajes del ejemplo son referenciales y no corresponden al cálculo real.

```text
--- Bienvenido Jossender!! ---

1) Revisar bitacora
2) Comparar habitat
3) Calcular el mas fuerte
4) Ver hijos
5) Salir

Ingrese opcion: 1

---- Tenemos 2 Dinosaurios en la bitacora!! ----

Un Gallimimus que es Omnivoro y vive aproximadamente 16 anios en el habitat: Desierto

Un Oviraptor que es Omnivoro y vive aproximadamente 14 anios en el habitat: Desierto

--- Bienvenido Jossender!! ---

1) Revisar bitacora
2) Comparar habitat
3) Calcular el mas fuerte
4) Ver hijos
5) Salir

Ingrese opcion: 2

---- Tenemos 1 Dinosaurio inusual ----

El Gallimimus fue visto en el Pantano, siendo que su habitat usual es Desierto

--- Bienvenido Jossender!! ---

1) Revisar bitacora
2) Comparar habitat
3) Calcular el mas fuerte
4) Ver hijos
5) Salir

Ingrese opcion: 3

---- GANADOR ----

El Oviraptor es el mas fuerte con 676767 puntos!!

--- Bienvenido Jossender!! ---

1) Revisar bitacora
2) Comparar habitat
3) Calcular el mas fuerte
4) Ver hijos
5) Salir

Ingrese opcion: 4

--- Hijos ---

Velociraptor es padre de Microraptor!!

--- Bienvenido Jossender!! ---

1) Revisar bitacora
2) Comparar habitat
3) Calcular el mas fuerte
4) Ver hijos
5) Salir

Ingrese opcion: 5

Hasta luego!!
```