# Ayudantia 07- Resolución prueba

# Sistema del Coleccionista y Exposiciones

Un coleccionista administra una serie de piezas de colección, particularmente cartas y cómics. Además, organiza distintas exposiciones temporales donde muestra algunas de sus piezas.

Para organizar todo hará un sistema en Java utilizando lo aprendido hasta ahora en el curso de Programación orientada a objetos. El sistema debe permitir manejar:
* El inventario general del coleccionista
* Un conjunto de exposiciones

---

## Descripción general

### Piezas
Cada pieza tiene información básica:
* Código único
* Nombre
* Año
* Valor estimado en dólares

Existen dos tipos de piezas:
* **Cartas**, que además tienen juego y nivel de rareza.
* **Cómics**, que además tienen editorial y número de edición.

---

## Inventario

El coleccionista mantiene un inventario con todas sus piezas.
* Todas las piezas se cargan inicialmente desde un archivo.
* Cada pieza tiene un código único.
* El inventario no permite duplicados.
* Si existen piezas con el mismo código en el archivo, se conserva la que se registró primero en la carga de datos y se descarta la otra. Fueron errores de tipeo del coleccionista.
* El inventario tiene un máximo de 100 ítems.

---

## Exposiciones

El coleccionista puede crear múltiples exposiciones. Cada exposición:
* Tiene un nombre.
* Tiene una capacidad máxima de piezas dispuestas una al lado de la otra.
* Tiene un valor máximo total permitido para las piezas exhibidas.
* Contiene a lo más 5 piezas que provienen del inventario.

Una misma pieza puede estar en más de una exposición.

Las piezas de cada exposición no se agregan manualmente una a una. Al crear una exposición, el sistema debe recorrer el inventario desde el inicio e ir incorporando automáticamente las piezas que cumplan las reglas de la exposición, mientras exista espacio y no se supere el valor máximo total permitido.

---

### Tipos de exposiciones

#### 1. Exposición temática
Se define por:
* Una palabra clave para el juego de las cartas.
* Una editorial específica para los cómics.

**Reglas:**
* Una carta puede entrar si el nombre de su juego contiene la palabra clave indicada.
* Un cómic puede entrar si pertenece exactamente a la editorial indicada.

#### 2. Exposición de rareza
Se define por:
* Una rareza mínima para las cartas.
* Un número de edición mínimo para los cómics.

**Reglas:**
* Una carta puede entrar si su rareza es mayor o igual al mínimo indicado.
* Un cómic puede entrar si su número de edición es mayor o igual al mínimo indicado.

---

## Restricciones generales

Al incorporar una pieza a una exposición se deben cumplir todas las siguientes condiciones:
* La pieza debe existir en el inventario.
* No puede repetirse el mismo código dentro de una misma exposición.
* La exposición no puede superar su capacidad máxima.
* El valor total acumulado de las piezas de la exposición no puede superar el valor máximo permitido.
* Las piezas se deben considerar en el orden en que aparecen en el inventario.
* Si se alcanza la capacidad máxima, no se pueden agregar más piezas.
* Puede ocurrir que una pieza no pueda ser agregada por su valor, pero las siguientes sí puedan ser agregadas.

---

## Archivo de entrada

Archivo de piezas (`piezas.txt`):

```text
CARTA;C001;Pikachu;2018;15000;Pokemon;5
COMIC;CM001;Batman Año 1;1990;30000;DC;1
CARTA;C002;Carta Débil;2020;500;Magic;1
COMIC;CM002;Comic Nuevo;2018;10000;Marvel;12
CARTA;C003;Dragón Rojo;2015;25000;YuGiOh;4
COMIC;CM003;Spider-Man Clásico;2005;18000;Marvel;45
```
Interpretación:
* CARTA;codigo;nombre;anio;valor;juego;rareza
* COMIC;codigo;nombre;anio;valor;editorial;numeroEdicion

## Requerimientos
El sistema debe permitir mediante un menú :
1. Mostrar todas las piezas del inventario
2. Crear una exposición temática
3. Crear una exposición de rareza
4. Mostrar todas las exposiciones y sus piezas
5. Buscar una pieza por código en el inventario y mostrar las exposiciones a las que pertenece
6. Salir
Diagrama modelo del dominio

## Consideraciones
* El sistema debe trabajar con arreglos de tamaño fijo, no ArrayList ni LinkedList
* El modelo del dominio vale un 10 % y el código 90 % del total del problema
* Tip: Cada tipo de pieza “sabe” si puede entrar a una exposición o no.

## Distribución del puntaje del código
* Modelado POO (código de las clases) - 55 %
* Lectura archivo - 15 %
* Funcionalidades menú - 30 %
