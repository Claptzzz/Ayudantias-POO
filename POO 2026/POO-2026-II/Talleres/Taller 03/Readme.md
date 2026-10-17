# Taller 03 — "Spooky Season"

**II Semestre - 2026**
**ITI - ICCI - ICI**

| | |
|---|---|
| **Docentes** | Alejandro Paolini (C1) — Cristhian Rabi (C2) |
| **Ayudantes** | Nicolás Rojas (C1) — Martín Droguett (C2) |
| **Inicio** | 14-Oct-2026 |
| **Fecha límite** | 20-Nov-2026 |
| **Puntaje máximo** | 100 puntos (+20 de bonificación) |

---

## 1. Contexto

Con la llegada de Halloween, los ayudantes estuvieron probando diversos dulces de dudosa procedencia. Estos dulces provocaron efectos extraños en sus cuerpos, haciendo que tomaran la forma de distintos monstruos: zombis, vampiros, momias y hombres lobo.

Lejos de preocuparse, decidieron poner a prueba sus nuevas habilidades en una serie de minijuegos y anotaron cuidadosamente las estadísticas de cada transformación. Ahora necesitan que los estudiantes de POO construyan una **simulación** de estos minijuegos, donde cada jugador pueda transformarse en un monstruo distinto para cada desafío y competir por el mejor puntaje.

---

## 2. Archivos de entrada

### 2.1 `Monstruos.txt`

Contiene el catálogo de monstruos en los que se puede transformar un jugador. Todas las líneas comparten un formato base, y cada tipo de monstruo agrega sus propios atributos al final.

**Formato base:** `Tipo;Vida;Velocidad;Fuerza;Resistencia;...`

```txt
Zombi;100;20;70;60;90
Vampiro;90;80;55;30;70;20
Momia;120;30;45;85;180
HombreLobo;110;60;90;50;75;4
```

| Tipo | Formato completo |
|---|---|
| **Zombi** | `Tipo;Vida;Velocidad;Fuerza;Resistencia;FuerzaDeMordida` |
| **Vampiro** | `Tipo;Vida;Velocidad;Fuerza;Resistencia;VelocidadDeVuelo;ResistenciaAlSol` |
| **Momia** | `Tipo;Vida;Velocidad;Fuerza;Resistencia;LongitudVendajes` |
| **HombreLobo** | `Tipo;Vida;Velocidad;Fuerza;Resistencia;Ferocidad;FaseLunar` |

**Rangos válidos de cada atributo (todos son enteros):**

| Atributo | Rango | Observación |
|---|---|---|
| `Vida` | 1 – 200 | |
| `Velocidad`, `Fuerza`, `Resistencia` | 1 – 100 | |
| `FuerzaDeMordida` | 1 – 100 | |
| `VelocidadDeVuelo` | 1 – 100 | |
| `ResistenciaAlSol` | 1 – 100 | Mientras más alto, mejor tolera el sol. |
| `LongitudVendajes` | 1 – 300 | En metros. |
| `Ferocidad` | 1 – 100 | |
| `FaseLunar` | 1 – 4 | 1 = luna nueva, 4 = luna llena. |

> **Importante:** el archivo de prueba puede traer **más líneas** que el ejemplo, incluyendo varios monstruos del mismo tipo con distintas estadísticas (por ejemplo, dos zombis). **Cada línea válida corresponde a un monstruo distinto**, aunque comparta tipo con otra.
>
> Toda línea con un tipo desconocido, una cantidad incorrecta de campos, valores no numéricos o fuera de rango debe **ignorarse**, informando por pantalla qué línea se descartó, sin que el programa se caiga.

### 2.2 `Registros.txt`

Contiene el récord histórico (puntaje máximo de una sesión) de cada jugador.

**Formato:** `Jugador;PuntajeMaximo`

```txt
Koshao;7823
Clapt;7600
Churrasquita;6767
```

Este archivo **se lee al iniciar** el programa y **se reescribe** cada vez que un jugador termina su sesión (ver R8).

---

## 3. Requerimientos

### R1. Carga de datos

Al iniciar, el programa debe leer ambos archivos:

- Cada línea válida de `Monstruos.txt` se convierte en un objeto de la subclase correspondiente (`Zombi`, `Vampiro`, `Momia` o `HombreLobo`) y se almacena en un **`ArrayList<Monstruo>`**.
- Cada línea válida de `Registros.txt` se convierte en un objeto `Jugador` y se almacena en un **`ArrayList<Jugador>`**.
- Si `Registros.txt` no existe, se parte con una lista vacía y se creará al guardar.
- Si `Monstruos.txt` no existe o no tiene ningún monstruo válido, el programa debe informarlo y terminar de forma controlada.

### R2. Inicio de sesión

El programa solicita el **nombre de usuario**:

- No puede estar vacío ni contener el carácter `;`.
- Si el jugador ya existe en los registros, se le da la bienvenida y se muestra su récord actual.
- Si no existe, se le da la bienvenida como jugador nuevo.

Al iniciar sesión comienza una **sesión de juego nueva**: todos los minijuegos quedan pendientes, todos los monstruos quedan disponibles y el puntaje acumulado parte en 0.

### R3. Menú principal

```txt
1) Jugar un minijuego
2) Ver catálogo de monstruos
3) Ver historial de la sesión
4) Ver ranking de jugadores
5) Terminar sesión
6) Salir
```

### R4. Jugar un minijuego

Existen **4 minijuegos**:

| # | Minijuego | Descripción | Habilidad premiada |
|---|---|---|---|
| 1 | **Carrera del Cementerio** | Recorre el cementerio de punta a punta antes de que el sepulturero te vea. | `Volador` |
| 2 | **Caza de Calabazas** | Muerde la mayor cantidad de calabazas del huerto en 60 segundos. | `Mordedor` |
| 3 | **Lanzamiento de Lápidas** | Lanza una lápida lo más lejos posible. | `Furioso` |
| 4 | **Sobrevivir al Amanecer** | Aguanta en pie cuando salgan los primeros rayos de sol. | `Regenerable` |

El flujo para jugar es el siguiente:

1. Se listan los minijuegos indicando si están **pendientes** o **jugados** (con su puntaje). Un minijuego ya jugado **no puede repetirse** en la misma sesión.
2. El jugador elige un minijuego y se listan los **monstruos disponibles**, mostrando su tipo y **todos sus atributos** (base y propios), para que el jugador pueda distinguirlos y decidir cuál le conviene. Si no quedan monstruos disponibles, se informa y se vuelve al menú.
3. El jugador elige un monstruo, se muestra un mensaje de transformación y el **potencial** del monstruo para ese minijuego (con 2 decimales), calculado según la sección 3.1.
4. Se listan las **habilidades** del monstruo más la opción de no usar ninguna. El jugador puede usar **como máximo una habilidad** por minijuego. El funcionamiento de las habilidades se detalla en la sección 3.2.

**Regla de monstruos:** cada monstruo puede usarse **una sola vez por sesión** (te transformas en un monstruo diferente para cada minijuego). Como cada línea del archivo es un monstruo distinto, si existen dos monstruos del mismo tipo (por ejemplo, dos zombis), **ambos pueden usarse en la misma sesión**, cada uno una sola vez y en minijuegos distintos.

5. Se calcula el puntaje del minijuego:

   ```text
   puntaje = Math.round(potencial × 10 × multiplicador)
   ```

   donde `multiplicador` es `1.5` si la habilidad fue efectiva y `1.0` en cualquier otro caso.

6. El resultado (minijuego, monstruo, habilidad usada y puntaje) se agrega al **historial de la sesión**, almacenado en una **`LinkedList`**, y se suma al puntaje acumulado.

En cualquier paso debe existir la opción **"0) Volver"**.

### 3.1 Fórmulas de potencial

Cada monstruo calcula su potencial de forma **distinta** en cada minijuego, aprovechando sus atributos propios. Todos los cálculos deben hacerse en `double`.

#### Carrera del Cementerio

| Monstruo | Fórmula |
|---|---|
| Zombi | `Velocidad × Resistencia / 100` |
| Vampiro | `(Velocidad + 2 × VelocidadDeVuelo) / 2` |
| Momia | `Velocidad × 100 / (100 + LongitudVendajes)` |
| HombreLobo | `(Velocidad + Ferocidad / 5) × FaseLunar / 4` |

#### Caza de Calabazas

| Monstruo | Fórmula | 
|---|---|
| Zombi | `FuerzaDeMordida × Vida / 100 + Resistencia / 2` | 
| Vampiro | `(Fuerza + Velocidad) / 3` | 
| Momia | `LongitudVendajes × Fuerza / 200` | 
| HombreLobo | `Ferocidad × FaseLunar / 4 + Velocidad / 4` |

#### Lanzamiento de Lápidas

| Monstruo | Fórmula |
|---|---|
| Zombi | `Fuerza × Resistencia / 100` |
| Vampiro | `Fuerza + VelocidadDeVuelo / 4` |
| Momia | `Fuerza + LongitudVendajes / 10` |
| HombreLobo | `Fuerza + Ferocidad × FaseLunar / 8` |

#### Sobrevivir al Amanecer

| Monstruo | Fórmula |
|---|---|
| Zombi | `Resistencia × Vida / 100` | 
| Vampiro | `Resistencia × ResistenciaAlSol / 100` |
| Momia | `(Resistencia + Vida) / 2 × (1 + LongitudVendajes / 300)` |
| HombreLobo | `(Resistencia + Vida) / 2 × (5 − FaseLunar) / 4` |


> **No se aceptará** resolver las fórmulas con cadenas de `if`/`switch` que pregunten por el tipo del monstruo (por ejemplo `if (m.getTipo().equals("Zombi"))`). El cálculo debe resolverse con **polimorfismo** (por ejemplo, un método abstracto por minijuego en `Monstruo`) o, de forma opcional, con el **patrón Visitor** (ver sección 3.3).

### 3.2 Habilidades (interfaces)

Las habilidades son acciones especiales que un monstruo puede usar durante un minijuego para intentar mejorar su puntaje. Se modelan como **interfaces**: existe una interfaz por habilidad, y cada monstruo implementa las interfaces de las habilidades que posee.

| Interfaz | Método | Nombre en el menú | Implementada por |
|---|---|---|---|
| `Mordedor` | `String morder()` | Morder | Zombi, Vampiro, HombreLobo |
| `Volador` | `String volar()` | Volar | Vampiro |
| `Regenerable` | `String regenerarse()` | Regenerarse | Zombi, Momia |
| `Furioso` | `String enfurecerse()` | Enfurecerse | Momia, HombreLobo |

Visto desde cada monstruo, todos tienen exactamente dos habilidades:

| Monstruo | Habilidades |
|---|---|
| Zombi | Morder, Regenerarse |
| Vampiro | Morder, Volar |
| Momia | Regenerarse, Enfurecerse |
| HombreLobo | Morder, Enfurecerse |

#### 3.2.1 Cómo se usan durante un minijuego?

Después de elegir el monstruo y ver su potencial (R4, paso 3), el uso de una habilidad sigue tres pasos:

1. **Detección:** el programa revisa con `instanceof` qué interfaces implementa el monstruo y arma el menú solo con esas habilidades, más la opción "No usar habilidad". Por ejemplo, para un Zombi el menú muestra *Morder* y *Regenerarse*.
2. **Ejecución:** si el jugador elige una habilidad, se hace un *cast* del monstruo a la interfaz correspondiente y se llama su método para mostrar el mensaje. Por ejemplo: `((Mordedor) monstruo).morder()`.
3. **Efecto:** el programa compara la habilidad usada con la **habilidad premiada** del minijuego (tabla de R4):
   - Si coinciden, se informa que la habilidad fue efectiva y el multiplicador es **1.5**.
   - Si no coinciden, el mensaje de la habilidad se muestra igual, pero se informa que no tuvo efecto y el multiplicador es **1.0**.
   - Si el jugador no usa habilidad, el multiplicador es **1.0**.

**Ejemplo:** un Zombi con potencial 120.00 en Caza de Calabazas (habilidad premiada: *Morder*):

| Habilidad usada | Multiplicador | Puntaje |
|---|---|---|
| Morder | 1.5 | `Math.round(120.00 × 10 × 1.5)` = **1800** |
| Regenerarse | 1.0 | `Math.round(120.00 × 10 × 1.0)` = **1200** |
| No usar habilidad | 1.0 | `Math.round(120.00 × 10 × 1.0)` = **1200** |

#### 3.2.2 Reglas y responsabilidades

- Se puede usar **como máximo una habilidad** por minijuego.
- Las habilidades **no modifican el potencial** del monstruo, solo el multiplicador del puntaje.
- La habilidad usada (o "Ninguna") debe quedar registrada en el historial de la sesión.
- **La interfaz de habilidad solo sabe qué decir** al usarse. **Si la habilidad sirve o no lo decide el minijuego**, a través de su habilidad premiada. Por eso las interfaces de habilidad no deben conocer los minijuegos, ni contener el multiplicador.

Para detectar las habilidades se permite el uso de `instanceof` y *casts* sobre estas cuatro interfaces (y solo para esto, no para calcular el potencial).

#### 3.2.3 Interfaz `Minijuego`

Cada minijuego es una clase que implementa la interfaz **`Minijuego`**, la cual debe definir, como mínimo, su nombre, su descripción, su **habilidad premiada** y el cálculo del potencial de un monstruo.

### 3.3 Bonificación: patrón Visitor (OPCIONAL, +10 puntos)

El potencial depende de **dos cosas a la vez**: el tipo de monstruo y el minijuego. Este es exactamente el escenario que resuelve el **patrón Visitor**.

Para obtener la bonificación:

- Cada minijuego debe actuar como un **visitor** que contiene las 4 fórmulas de ese minijuego, una por tipo de monstruo:

  ```java
  public interface VisitorMinijuego {
      double visitar(Zombi zombi);
      double visitar(Vampiro vampiro);
      double visitar(Momia momia);
      double visitar(HombreLobo hombreLobo);
  }
  ```

- `Monstruo` debe declarar un método abstracto `aceptar(VisitorMinijuego visitor)` que cada subclase implementa.
- Las fórmulas deben vivir **exclusivamente** en los visitors (las subclases de `Monstruo` no contienen fórmulas).
- No se puede usar `instanceof` ni preguntar por el tipo para calcular el potencial.

El esqueleto anterior es solo una guía: el diseño final (nombres, si `Minijuego` extiende o no a `VisitorMinijuego`, etc.) queda a criterio de cada equipo, siempre que se respete el patrón.
### 3.4 Bonificación: arquitectura Main / Sistema (OPCIONAL, +10 puntos)
 
Un error común es escribir todo el programa dentro del `main`: menús, lectura de archivos, listas y cálculos mezclados en un solo lugar. Para obtener esta bonificación, el programa debe separar sus responsabilidades en dos clases.

 
| Clase | Responsabilidad | Qué **sí** hace | Qué **no** hace |
|---|---|---|---|
| **`Main`** | Entrada y salida | Usa `Scanner` para leer el teclado y los archivos `.txt`. Separa cada línea con `split`, y envía los atributos a `Sistema`. Muestra menús, lee opciones, imprime resultados y escribe `Registros.txt` con `FileWriter`. | No crea objetos del modelo (`Zombi`, `Jugador`, etc.) ni guarda listas. No calcula potenciales ni puntajes. |
| **`Sistema`** | Lógica y datos | Recibe atributos y crea los objetos, validando las **reglas** del programa (rangos de los atributos). Contiene las colecciones, maneja la sesión (minijuegos jugados, monstruos disponibles, historial), calcula puntajes, ordena el ranking y actualiza récords. | No usa `Scanner`, no lee ni escribe archivos y no imprime nada por consola. Comunica sus resultados a `Main` mediante **valores de retorno**. |


### R5. Ver catálogo de monstruos

Muestra todos los monstruos cargados con sus atributos (base y propios) y sus habilidades, indicando cuáles ya fueron **usados** en la sesión actual.

### R6. Ver historial de la sesión

Recorre la `LinkedList` del historial y muestra, en el orden en que se jugaron, cada minijuego con el monstruo usado, la habilidad utilizada (o "Ninguna") y el puntaje obtenido. Al final muestra el **puntaje acumulado** de la sesión. Si aún no se ha jugado nada, se informa.

### R7. Ver ranking de jugadores

Muestra todos los jugadores registrados ordenados de **mayor a menor** puntaje máximo (en caso de empate, por nombre en orden alfabético). El ordenamiento debe ser **implementado por ustedes** (no se permite `Collections.sort` ni similares).

### R8. Terminar sesión

1. Se muestra el puntaje total de la sesión.
2. Si el jugador **jugó al menos un minijuego**:
   - Si es nuevo, se agrega a los registros con ese puntaje.
   - Si ya existía y **superó** su récord, se actualiza y se muestra un mensaje de felicitación.
   - Si no lo superó, se mantiene su récord anterior.
3. Se reescribe `Registros.txt` con los datos actualizados.
4. Se vuelve a la pantalla de inicio de sesión (R2) para que pueda jugar otra persona.

### R9. Salir

Termina la sesión actual (aplicando R8, incluyendo el guardado) y cierra el programa.

---

## 4. Ejemplo de ejecución

```txt
Cargando archivos...
 > 4 monstruos cargados desde Monstruos.txt
 > 3 jugadores cargados desde Registros.txt

=========================================
             SPOOKY SEASON
=========================================
Ingrese su nombre de usuario:
[!] El nombre no puede estar vacío.
Ingrese su nombre de usuario: Clapt

¡Bienvenido de vuelta, Clapt! Tu récord actual es de 7600 puntos.

------ MENÚ PRINCIPAL (Clapt) ------
1) Jugar un minijuego
2) Ver catálogo de monstruos
3) Ver historial de la sesión
4) Ver ranking de jugadores
5) Terminar sesión
6) Salir
> 1

------ MINIJUEGOS ------
1) Carrera del Cementerio   [PENDIENTE]
2) Caza de Calabazas        [PENDIENTE]
3) Lanzamiento de Lápidas   [PENDIENTE]
4) Sobrevivir al Amanecer   [PENDIENTE]
0) Volver
> 1

Carrera del Cementerio: recorre el cementerio de punta a punta antes de que el sepulturero te vea.

Elige el monstruo en el que te transformarás:
1) Zombi      | Vida 100 | Vel 20 | Fue 70 | Res 60 | Mordida 90
2) Vampiro    | Vida 90  | Vel 80 | Fue 55 | Res 30 | Vuelo 70 | Sol 20
3) Momia      | Vida 120 | Vel 30 | Fue 45 | Res 85 | Vendajes 180
4) HombreLobo | Vida 110 | Vel 60 | Fue 90 | Res 50 | Ferocidad 75 | Luna 4
0) Volver
> 7
[!] Opción fuera de rango. Intente nuevamente.
> 2

Te comes un dulce de dudosa procedencia...
Potencial para Carrera del Cementerio: 110.00

¿Quieres usar una habilidad?
1) Morder
2) Volar
0) No usar habilidad
> 2
¡La habilidad fue efectiva! Puntaje x1.5

>> Puntaje obtenido: 1650 puntos

------ MENÚ PRINCIPAL (Clapt) ------
1) Jugar un minijuego
2) Ver catálogo de monstruos
3) Ver historial de la sesión
4) Ver ranking de jugadores
5) Terminar sesión
6) Salir
> 1

------ MINIJUEGOS ------
1) Carrera del Cementerio   [JUGADO - 1650 pts]
2) Caza de Calabazas        [PENDIENTE]
3) Lanzamiento de Lápidas   [PENDIENTE]
4) Sobrevivir al Amanecer   [PENDIENTE]
0) Volver
> 1
[!] Ya jugaste Carrera del Cementerio en esta sesión.
> 3

Lanzamiento de Lápidas: lanza una lápida lo más lejos posible.

Elige el monstruo en el que te transformarás:
1) Zombi      | Vida 100 | Vel 20 | Fue 70 | Res 60 | Mordida 90
2) Momia      | Vida 120 | Vel 30 | Fue 45 | Res 85 | Vendajes 180
3) HombreLobo | Vida 110 | Vel 60 | Fue 90 | Res 50 | Ferocidad 75 | Luna 4
0) Volver
> 1

Te comes un dulce de dudosa procedencia...
Potencial para Lanzamiento de Lápidas: 42.00

¿Quieres usar una habilidad?
1) Morder
2) Regenerarse
0) No usar habilidad
> 1
La habilidad no tuvo efecto en este minijuego.

>> Puntaje obtenido: 420 puntos

------ MENÚ PRINCIPAL (Clapt) ------
...
> 3

------ HISTORIAL DE LA SESIÓN ------
1. Carrera del Cementerio | Vampiro | Habilidad: Volar  | 1650 pts
2. Lanzamiento de Lápidas | Zombi   | Habilidad: Morder |  420 pts
Puntaje acumulado: 2070 pts

------ MENÚ PRINCIPAL (Clapt) ------
...
> 4

------ RANKING ------
1. Koshao         7823
2. Clapt          7600
3. Churrasquita   6767

------ MENÚ PRINCIPAL (Clapt) ------
...
> 5

Sesión terminada. Puntaje total: 2070 puntos.
No superaste tu récord (7600). ¡Suerte para la próxima!
Registros guardados en Registros.txt.

Ingrese su nombre de usuario: Nicolas

¡Bienvenido, Nicolas! Es tu primera vez jugando.

------ MENÚ PRINCIPAL (Nicolas) ------
...
> abc
[!] Debe ingresar un número. Intente nuevamente.
> 6

No jugaste ningún minijuego, no se guardó registro.
```

> El ejemplo es referencial: el formato visual de los menús queda a criterio de cada equipo, pero el flujo y la información mostrada deben respetarse.

---

## 5. Control de errores (OBLIGATORIO)

El programa **NO se puede caer bajo ninguna circunstancia.** Se probará explícitamente que resista, entre otros:

- Opciones de menú inválidas (letras, números fuera de rango, entrada vacía).
- Nombres de usuario vacíos o que contengan `;`.
- Archivos inexistentes o con líneas mal formadas (tipo desconocido, campos faltantes o sobrantes, valores no numéricos o fuera de rango).
- Selección de índices inválidos (`IndexOutOfBoundsException`).
- Intentar repetir un minijuego o reutilizar un monstruo en la misma sesión.
- Archivos con varios monstruos del mismo tipo (cada uno debe poder elegirse y usarse por separado).
- Quedarse sin monstruos disponibles antes de completar todos los minijuegos.
- Bucles de menú que dejen atrapado al usuario (todas las opciones "Volver" / "Salir" deben funcionar).

---

## 6. Aclaraciones técnicas

1. Se **debe** usar **POO, Herencia, Interfaces, y Colecciones.**

2. Se permiten únicamente las siguientes librerías:

   ```text
   Scanner
   File
   FileWriter
   BufferedWriter
   IOException
   FileNotFoundException
   ArrayList
   LinkedList
   ```

   Cualquier otra librería debe ser **consultada y autorizada** por el ayudante con anticipación.

3. Debe existir **persistencia**, los puntajes deben quedar guardados en `Registros.txt` al terminar cada sesión.

4. Los potenciales se calculan en `double` y se muestran con 2 decimales. El puntaje de cada minijuego es un entero calculado con `Math.round`.

5. Se puede asumir que no habrá más de **200** líneas en cada archivo.

---

## 7. Consideraciones

0. Se engloban todas las consideraciones redactadas en el README de talleres <a href="../Readme.md">(click aquí para ver)</a>.

1. Los datos del/los integrante(s) (nombre completo, RUT y carrera) deben ir en las **primeras 5 líneas del archivo que contiene el método `main`**.

   ```java
   //Nombre1 Apellido1 - 21.000.000-K - ICCI
   //Nombre2 Apellido2 - 22.000.000-0 - ITI

   package taller03;

   import ...;

   public class Main {
       public static void main(String[] args) {
           ...
   ```

2. El código debe estar **limpio, ordenado y documentado**, con nombres de variables descriptivos.
3. Se debe manejar **control de errores** en los inputs (se probará que no se caiga el taller).
4. El taller se desarrolla en un **repositorio de GitHub** con commits frecuentes y descriptivos.
5. El código **DEBE** compilar sin problemas.
6. El `README.md` del taller debe estar correctamente documentado, con las instrucciones de ejecución (clonación del repositorio y testeo).
7. El repositorio debe incluir el **diagrama de clases UML** del proyecto (imagen o PDF), reflejando herencia, interfaces y relaciones.
8. **Se espera originalidad de cada equipo**, es decir, no copiar explícitamente de los ejemplos ni de otro equipo.

---

## 8. Pauta de evaluación

| Ítem | Descripción | Puntaje |
|---|---|---|
| **Lectura de archivos y herencia** | Clases y subclases correctamente modeladas; lectura de ambos archivos descartando líneas inválidas. | 15 |
| **Interfaces** |Interfaces implementadas correctamente en cada clase. | 10 |
| **Colecciones** | Uso correcto de colecciones. | 10 |
| **Inicio de sesión y menú** | R2 y R3: validación del nombre, bienvenida según corresponda y navegación del menú. | 5 |
| **Jugar minijuego** | R4: restricción de minijuego y monstruo únicos por sesión, uso de habilidades y multiplicador. | 15 |
| **Fórmulas y puntaje** | Fórmulas de la sección 3.1 resueltas con polimorfismo y cálculo correcto del puntaje. | 15 |
| **Catálogo, historial y ranking** | R5, R6 y R7, incluyendo el ordenamiento implementado por el equipo. | 10 |
| **Persistencia** | R8 y R9: actualización de récords y escritura correcta de `Registros.txt`. | 5 |
| **Control de errores** | El programa resiste todos los casos de la sección 5 sin caerse. | 10 |
| **Repositorio y documentación** | README, commits frecuentes y descriptivos, código limpio y documentado, diagrama UML. | 5 |
| **Total** | | **100** |
| **Bonificación: patrón Visitor** | Implementación correcta según la sección 3.3. | **+10** |
| **Bonificación: arquitectura Main / Sistema** | Separación correcta de responsabilidades según la sección 3.4. | **+10** |

---

## 9. Contactos

- martin.droguett@alumnos.ucn.cl
- nicolas.rojas11@alumnos.ucn.cl
- **Grupo de WhatsApp (preferido)**