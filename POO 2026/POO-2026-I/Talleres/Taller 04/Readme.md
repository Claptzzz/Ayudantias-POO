# Taller 4

**I Semestre - 2026**
**ITI - ICCI - ICI**

**Docentes:**
- Alejandro Paolini Godoy
- Cristhian Rabi Reyes
- Juan Nilo Iturra

## Contexto:

Sutrostian y POOsandon son dos muy buenos amigos que disfrutan mucho realizar todo tipo de actividades juntos. Últimamente su buen amigo Mateo les ha recomendado sumergirse en el mundo de Pokémon TCG. Emocionados por esta nueva experiencia, han decidido comprarse varios paquetes con sobres y mazos prearmados para poder jugar.

Luego de un tiempo experimentando juntos, se han dado cuenta de que se ha hecho muy difícil mantener su colección organizada. Por lo cual, gracias a su vasta experiencia en Programación Orientada a Objetos, han decidido crear un software con GUI en Java que les permita modificar sus cartas de colección, listarlas y calcular sus respectivas puntuaciones.

Debido al meta actual, solo han comprado sobres de una expansión especial que permite un juego más amigable.

## Archivos

### `Sobres.txt`

El siguiente archivo contiene los datos de las cartas sacadas, usando el formato:

`NombreCarta;Rareza;Tipo;...`

Dependiendo del Tipo de carta existen diferentes atributos:

* Tipo: ***Pokemon*** -> `Daño;CantEnergias`
* Tipo: ***Item*** -> `Bonificacion`
* Tipo: ***Supporter*** -> `EfectosPorTurno`
* Tipo: ***Energy*** -> `Elemento`

Ejemplo:

```texto
Mega Mawile-Ex;5;Pokemon;260;3
Premium Power Pro;2;Item;30
Lillie's Determination;2;Supporter;3
Basic Energy;1;Energy;Fight
```

## Requerimientos

Se debe crear una GUI totalmente interactiva que tenga las siguientes funcionalidades:

## Administración (Pestaña 1)

* Agregar Carta
* Eliminar Carta
* Modificar Carta

## Ver Colección (Pestaña 2)

* Ordenar por

## Aclaraciones

* Al agregar una carta, la ruta de su imagen será su {`nombreCarta`}.png/jpg/etc.
* En caso de que no exista una imagen, se deberá tener una por defecto (a elección del estudiante).
* Las imágenes de las cartas del .txt deben ser buscadas y agregadas por los estudiantes manualmente.
* Al eliminar una carta no es necesario eliminar su imagen del proyecto, solo el objeto con sus datos.
* Al modificar una carta se pueden modificar solamente sus atributos adicionales (relacionados al tipo de carta).
* Al ordenar las cartas y mostrarlas debe haber tres opciones de sort:
    1) Ordenar por Rareza.
    2) Ordenar por Nombre.
    3) Ordenar por Poder.
* Mientras mayor sea la rareza de una carta, mejor es.
* Pueden existir cartas repetidas.
* Al hacerle "clic" a una carta en colección, debe abrir una visualización ampliada de esta, mostrando sus atributos y su poder calculado (junto con su respectiva imagen).
* Debe usar los patrones `Singleton` `Factory` `Visitor` `Strategy`.
* Debe documentar con `javadoc`.
* Para calcular el `poder` de cada carta debe usar:
    * ***Pokemon*** -> `(daño/cantEnergias)*100`.
    * ***Item*** -> `bonificacion*20`.
    * ***Supporter*** -> `EfectosPorTurno*50`.
    * ***Energy*** -> `1` -> Por defecto.

## Consideraciones

1) Se engloban todas las consideraciones redactadas en el Readme de los talleres <a href="../Readme.md"> (Clic aquí para ver)</a>.
2) Se podrán utilizar todas las librerías vistas en clase.

***En caso de necesitar alguna librería adicional, consultar con tiempo.***

3) Se deben entregar el Modelo de Dominio y el Diagrama de Clases en la raíz del repositorio ***EN FORMATO PDF***.
4) Se debe utilizar POO, Arquitectura (separar el main y el sistema), Herencia, Interfaces y GUI.

## Fechas
Inicio -> 09/06/2026

Fecha límite -> 03/07/2026

## Contactos
* nicolas.rojas11@alumnos.ucn.cl
* [Grupo de WhatsApp](https://chat.whatsapp.com/GGkRnviIyRfDj24kXZeGpu?mode=gi_t)

## Pauta de evaluación

**Puntaje Total Máximo:** 140 puntos

---

### 1. Persistencia de Datos y Archivos (15 puntos)
* **[7 pts] Lectura inicial:** Carga correctamente los datos de `Sobres.txt` al iniciar el programa. Procesa adecuadamente cada línea y los distintos atributos según el tipo de carta (`Pokemon`, `Item`, `Supporter`, `Energy`) sin errores de parseo.
* **[4 pts] Actualización de Archivos:** Las operaciones de agregar, modificar o eliminar (CRUD) se reflejan correctamente en el archivo `.txt`. Los cambios persisten tras cerrar la aplicación.
* **[4 pts] Formato de Salida:** Al sobrescribir el archivo, se mantiene estrictamente el formato original (`NombreCarta;Rareza;Tipo;...`), respetando los atributos propios de cada tipo y asegurando la integridad de los datos para futuras ejecuciones.

### 2. Diseño de Software y POO (15 puntos)
* **[5 pts] Herencia e Interfaces:** Implementa una estructura de herencia lógica con una clase base (o abstracta) para `Carta` y subclases específicas por tipo. Utiliza interfaces para definir comportamientos requeridos.
* **[5 pts] Modelado de Clases:** Demuestra un uso correcto de la abstracción y el encapsulamiento (atributos privados y métodos de acceso). Las clases son cohesivas y representan fielmente las entidades del problema.
* **[5 pts] Arquitectura y Colecciones:** El código separa la lógica del sistema del punto de entrada (`Main`). Utiliza colecciones dinámicas (`ArrayList` o `LinkedList`) para gestionar la colección de cartas, contemplando la existencia de cartas repetidas.

### 3. Patrones de Diseño (32 puntos)

> Los cuatro patrones deben estar implementados de forma correcta, pertinente y justificada dentro de la arquitectura. No se otorga puntaje a patrones forzados o mal aplicados.

* **[8 pts] Singleton:** Implementa correctamente el patrón Singleton.
* **[8 pts] Factory:** Implementa correctamente el patrón Factory.
* **[8 pts] Visitor:** Implementa correctamente el patrón Visitor.
* **[8 pts] Strategy:** Implementa correctamente el patrón Strategy.

### 4. Lógica de Negocio y Requerimientos (25 puntos)
* **[10 pts] Administración (Pestaña 1):** Implementa funcionalmente Agregar, Eliminar y Modificar Carta. Al agregar, asocia la ruta de imagen `{nombreCarta}`. Al eliminar, remueve únicamente el objeto y sus datos (no la imagen). Al modificar, permite cambiar solo los atributos adicionales propios del tipo de carta.
* **[10 pts] Cálculo de Puntuaciones:** Implementa con exactitud las fórmulas de poder para cada tipo de carta:
    * **Pokemon:** `(daño / cantEnergias) * 100`
    * **Item:** `bonificacion * 20`
    * **Supporter:** `efectosPorTurno * 50`
    * **Energy:** `1` (por defecto)
* **[5 pts] Ordenamiento (Pestaña 2):** Implementa correctamente las tres opciones de sort sobre la colección: por Rareza, por Nombre y por Poder (considerando que mayor rareza es mejor).

### 5. Interfaz Gráfica (GUI) (25 puntos)
* **[10 pts] Interactividad y Estructura:** La GUI es totalmente interactiva, fluida y organiza las funcionalidades en las dos pestañas requeridas (Administración y Ver Colección), con una navegación clara entre ellas.
* **[8 pts] Manejo de Imágenes:** Muestra la imagen de cada carta según su ruta `{nombreCarta}` y utiliza una imagen por defecto cuando esta no existe, sin romper la interfaz.
* **[7 pts] Visualización Ampliada:** Al hacer clic sobre una carta de la colección, abre una vista ampliada con sus atributos, su poder calculado y su respectiva imagen.

### 6. Control de Errores, Calidad y Documentación (10 puntos)
* **[4 pts] Validación de Entradas:** El programa utiliza validaciones (ej. `try-catch` o validación de campos) para evitar caídas por ingresos de datos incorrectos en los formularios y menús.
* **[3 pts] Calidad de Código:** Respeta las convenciones de Java (CamelCase), mantiene una indentación correcta y utiliza nombres de variables descriptivos.
* **[3 pts] Documentación javadoc:** Documenta correctamente clases y métodos con `javadoc`.

### 7. Diagramas y Entregables (8 puntos)
* **[4 pts] Diagrama de Clases:** Entrega un PDF en la raíz que representa la arquitectura del código, incluyendo relaciones, atributos y métodos.
* **[4 pts] Modelo de Dominio:** Entrega un PDF con la abstracción conceptual del problema, diferenciándose claramente del diagrama técnico de clases.

### 8. Uso de GitHub y Repositorio (10 puntos)
* **[10 pts] Gestión de Versiones:** El repositorio está bien estructurado, cuenta con commits frecuentes y significativos, y sigue las consideraciones generales de entrega.

---