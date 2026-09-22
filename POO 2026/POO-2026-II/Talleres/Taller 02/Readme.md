# Taller 02 — "La fonda del Papu"

**II Semestre - 2026**
**ITI - ICCI - ICI**

| | |
|---|---|
| **Docentes** | Alejandro Paolini (C1) — Cristhian Rabi (C2) |
| **Ayudantes** | Nicolás Rojas (C1) — Martín Droguett (C2) |
| **Inicio** | 21-Sep-2026 |
| **Fecha límite** | 16-Oct-2026 |
| **Puntaje máximo** | 110 puntos |

---

## 1. Contexto

Renato Salinas (alias *Koshao*) es un regalón del choripán y del terremoto. Junto a sus amigos, durante las fiestas se comieron y tomaron tantos que perdieron la cuenta de cuántas kcal consumieron. Por lo mismo, le pide a los prometedores POOsianos un programa que le ayude a calcular distintas métricas en base a sus registros.

Asimismo, los regalones desean seguir comiendo y tomando, así que debe ser posible **agregar, editar y eliminar** los registros ya existentes, con **persistencia** de los datos y de los cambios realizados.

---

## 2. Archivos de entrada



### 2.1 `Participantes.txt`

Una persona por línea.

**Formato:** `Nombre`

```txt
Koshao
Lemus
MrNacho
```

### 2.2 `Consumido.txt`

Un registro por línea. Existen **dos** formatos posibles, diferenciados por el primer campo:

| Tipo | Formato |
|---|---|
| Choripán | `Choripan;Consumidor;Largo;Ancho;Fecha` |
| Terremoto | `Terremoto;Consumidor;Litros;Fecha` |

```txt
Choripan;Koshao;10;3;2026-09-16
Terremoto;Lemus;0.5;2026-09-16
Choripan;MrNacho;9;3;2026-09-16
```

> La fecha usa el formato `YYYY-MM-DD`.

---

## 3. Requerimientos

Se debe implementar un **menú interactivo** con la siguiente estructura:

* **Ver registros**
  * Choripanes
  * Terremotos
  * Volver al menú principal
* **Actualizar registros**
  * Agregar
  * Editar
  * Eliminar
  * Volver al menú principal
* **Calcular métricas**
  * Cantidad de choripanes comidos en total
  * Cantidad de terremotos tomados en total
  * Cantidad de choripanes comidos por usuario
  * Cantidad de terremotos tomados por usuario
  * KCal consumidas por usuario
  * Días ebrio por usuario
  * Volver al menú principal
* **Salir**

### 3.1 Reglas de cálculo

| Métrica | Fórmula |
|---|---|
| KCal de un choripán | `(Largo * Ancho) / 3` |
| KCal de un terremoto | `(Litros * 10) / 3` |

* Un **día ebrio** se cuenta cuando un usuario consumió **2 litros de terremoto o más en un mismo día** (sumando todos sus terremotos de ese día).
* Al **ver registros** se debe mostrar **toda** la información de los consumidos, con un formato ordenado y fácil de leer.
* Al **actualizar registros**, los cambios deben quedar reflejados en `Consumido.txt`.

---

## 4. Ejemplo de ejecución

> **Nota:** los ejemplos de ejecución son solamente **EJEMPLOS**. El formato visual es libre, lo que importa es que la información esté completa y sea legible. Los valores mostrados corresponden al set de datos de más abajo.

<details>
<summary><b>Set de datos usado en los ejemplos</b></summary>

`Participantes.txt`

```txt
Koshao
Lemus
MrNacho
```

`Consumido.txt`

```txt
Choripan;Koshao;10;3;2026-09-16
Terremoto;Lemus;0.5;2026-09-16
Choripan;MrNacho;9;3;2026-09-16
Choripan;Koshao;8;3;2026-09-18
Terremoto;Koshao;1.5;2026-09-18
Terremoto;Koshao;0.75;2026-09-18
Choripan;Lemus;12;4;2026-09-18
Terremoto;MrNacho;2;2026-09-19
```

</details>

### 4.1 Menú principal

```text
============================================
           LA FONDA DEL PAPU
============================================
  Registros cargados: 8
--------------------------------------------
  [1] Ver registros
  [2] Actualizar registros
  [3] Calcular metricas
  [4] Salir
============================================
Seleccione una opcion: 1
```

### 4.2 Ver registros

```text
============ VER REGISTROS =================
  [1] Choripanes
  [2] Terremotos
  [3] Volver al menu principal
============================================
Seleccione una opcion: 1

=============== CHORIPANES =================
  #   Consumidor    Largo   Ancho   Fecha         KCal
  1   Koshao        10 cm    3 cm   2026-09-16   10.00
  2   MrNacho        9 cm    3 cm   2026-09-16    9.00
  3   Koshao         8 cm    3 cm   2026-09-18    8.00
  4   Lemus         12 cm    4 cm   2026-09-18   16.00
--------------------------------------------------
  Total: 4 choripanes registrados
==================================================

Presione ENTER para continuar...
```

```text
=============== TERREMOTOS =================
  #   Consumidor    Litros   Fecha         KCal
  1   Lemus         0.50 L   2026-09-16    1.67
  2   Koshao        1.50 L   2026-09-18    5.00
  3   Koshao        0.75 L   2026-09-18    2.50
  4   MrNacho       2.00 L   2026-09-19    6.67
--------------------------------------------------
  Total: 4 terremotos registrados (4.75 L)
==================================================
```

### 4.3 Actualizar registros

**Agregar**

```text
========== ACTUALIZAR REGISTROS ============
  [1] Agregar
  [2] Editar
  [3] Eliminar
  [4] Volver al menu principal
============================================
Seleccione una opcion: 1

Tipo de registro:
  [1] Choripan
  [2] Terremoto
  [3] Cancelar
Seleccione una opcion: 1

Consumidores disponibles:
  [1] Koshao
  [2] Lemus
  [3] MrNacho
Seleccione el consumidor: 3

Largo del choripan (cm): 15
Ancho del choripan (cm): 4
Fecha (YYYY-MM-DD): 2026-09-19

>> Registro agregado correctamente y guardado en Consumido.txt
   Choripan | MrNacho | 15 cm x 4 cm | 2026-09-19 | 20.00 kcal
```

**Editar**

```text
Seleccione una opcion: 2

Tipo de registro a editar:
  [1] Choripan
  [2] Terremoto
  [3] Cancelar
Seleccione una opcion: 2

  #   Consumidor    Litros   Fecha
  1   Lemus         0.50 L   2026-09-16
  2   Koshao        1.50 L   2026-09-18
  3   Koshao        0.75 L   2026-09-18
  4   MrNacho       2.00 L   2026-09-19

Seleccione el registro a editar (0 para cancelar): 3

Registro actual -> Terremoto | Koshao | 0.75 L | 2026-09-18
Deje el campo vacio para mantener el valor actual.

Consumidor [Koshao]: 
Litros [0.75]: 1.25
Fecha [2026-09-18]: 

>> Registro actualizado correctamente y guardado en Consumido.txt
   Terremoto | Koshao | 1.25 L | 2026-09-18 | 4.17 kcal
```

**Eliminar**

```text
Seleccione una opcion: 3

Tipo de registro a eliminar:
  [1] Choripan
  [2] Terremoto
  [3] Cancelar
Seleccione una opcion: 1

  #   Consumidor    Largo   Ancho   Fecha
  1   Koshao        10 cm    3 cm   2026-09-16
  2   MrNacho        9 cm    3 cm   2026-09-16
  3   Koshao         8 cm    3 cm   2026-09-18
  4   Lemus         12 cm    4 cm   2026-09-18

Seleccione el registro a eliminar (0 para cancelar): 2
Confirma la eliminacion de "Choripan | MrNacho | 9 cm x 3 cm | 2026-09-16"? (s/n): s

>> Registro eliminado correctamente. Cambios guardados en Consumido.txt
```

### 4.4 Calcular métricas

```text
============ CALCULAR METRICAS =============
  [1] Choripanes comidos en total
  [2] Terremotos tomados en total
  [3] Choripanes comidos por usuario
  [4] Terremotos tomados por usuario
  [5] KCal consumidas por usuario
  [6] Dias ebrio por usuario
  [7] Volver al menu principal
============================================
Seleccione una opcion: 1

>> Total de choripanes comidos: 4
```

```text
Seleccione una opcion: 2

>> Total de terremotos tomados: 4  (4.75 litros en total)
```

```text
Seleccione una opcion: 3

======= CHORIPANES POR USUARIO =============
  Usuario       Cantidad
  Koshao               2
  Lemus                1
  MrNacho              1
============================================
```

```text
Seleccione una opcion: 4

======= TERREMOTOS POR USUARIO =============
  Usuario       Cantidad    Litros
  Koshao               2     2.25 L
  Lemus                1     0.50 L
  MrNacho              1     2.00 L
============================================
```

```text
Seleccione una opcion: 5

============ KCAL POR USUARIO ==============
  Usuario       Choripan    Terremoto    Total
  Koshao           18.00         7.50    25.50
  Lemus            16.00         1.67    17.67
  MrNacho           9.00         6.67    15.67
--------------------------------------------
  Consumo total de la fonda: 58.84 kcal
============================================
```

```text
Seleccione una opcion: 6

========= DIAS EBRIO POR USUARIO ===========
  (se cuenta un dia ebrio con 2 L o mas en la misma fecha)

  Usuario       Dias ebrio   Detalle
  Koshao                 1   2026-09-18 (2.25 L)
  Lemus                  0   -
  MrNacho                1   2026-09-19 (2.00 L)
============================================
```

### 4.5 Salir

```text
Seleccione una opcion: 4

>> Hasta luego...
```

### 4.6 Manejo de errores (muestra)

```text
Seleccione una opcion: hola
>> Error: la opcion debe ser un numero entre 1 y 4. Intente nuevamente.

Seleccione una opcion: 9
>> Error: opcion fuera de rango. Intente nuevamente.

Seleccione una opcion: 
>> Error: no ingreso ninguna opcion. Intente nuevamente.
```

```text
>> ADVERTENCIA: no se encontro el archivo "Consumido.txt".
   Se iniciara el programa sin registros previos.
```

```text
Seleccione el registro a editar (0 para cancelar): 15
>> Error: no existe un registro con ese numero. Intente nuevamente.
```

```text
Litros del terremoto: -2
>> Error: los litros deben ser un numero mayor a 0. Intente nuevamente.
```

```text
>> Error: se alcanzo la capacidad maxima de registros (200).
   No es posible agregar mas consumos.
```

---

## 5. Control de errores (OBLIGATORIO)

El programa **NO se puede caer bajo ninguna circunstancia.** Se probará explícitamente que resista, entre otros:

- Opciones de menú inválidas (letras, números fuera de rango, entrada vacía).
- Archivos inexistentes o con líneas mal formadas.
- Selección de índices inválidos (`IndexOutOfBounds`).
- Superar la capacidad máxima de los vectores.
- Bucles de menú que dejen atrapado al usuario (todas las opciones "Volver" / "Salir" deben funcionar).

---

## 6. Aclaraciones técnicas

1. Se **debe** usar **POO**.

2. **NO** se pueden utilizar colecciones dinámicas (`ArrayList`, `LinkedList`, `HashMap`, etc.). **Solo vectores estáticos** (`String[]`, `int[]`, ...).

3. Se permiten únicamente las siguientes librerías:

   ```text
   Scanner
   File
   FileWriter
   BufferedWriter
   IOException
   ```

   Cualquier otra librería debe ser **consultada y autorizada** por el ayudante con anticipación.

4. Debe existir **persistencia**: los cambios en la lista deben quedar guardados en `Consumido.txt`.

5. Se puede asumir que no habrá más de **200** líneas en cada archivo.

---

## 7. Consideraciones

0. Se engloban todas las consideraciones redactadas en el README de talleres <a href="../Readme.md">(click aquí para ver)</a>.

1. Los datos del/los integrante(s) (nombre completo, RUT y carrera) deben ir en las **primeras 5 líneas del archivo que contiene el método `main`**.

   ```java
   //Nombre1 Apellido1 - 21.000.000-K - ICCI
   //Nombre2 Apellido2 - 22.000.000-0 - ITI

   package taller02;

   import ...;

   public class Main {
       public static void main(String[] args) {
           ...
   ```

2. El código debe estar **limpio, ordenado y documentado**, con nombres de variables descriptivos.
3. Se debe manejar **control de errores** en los inputs (¡se probará que no se caiga el taller!).
4. El taller se desarrolla en un **repositorio de GitHub** con commits frecuentes y descriptivos.
5. El código **DEBE** compilar sin problemas.
6. El `README.md` del taller debe estar correctamente documentado, con las instrucciones de ejecución (clonación del repositorio y testeo).
7. **Se espera originalidad de cada equipo**, es decir, no copiar explícitamente de los ejemplos ni de otro equipo.

---

## 8. Pauta de evaluación
 
**Puntaje total máximo: 110 puntos**

### A. Diseño y aplicación de POO — **25 pts**
 
| Criterio | Pts |
|---|---:|
| A.1 Identificación y modelado de las clases del dominio (no se resuelve todo dentro de `Main`) | 6 |
| A.2 Encapsulamiento: atributos privados y acceso mediante métodos | 5 |
| A.3 Abstracción aplicada correctamente entre los tipos de consumo | 7 |
| A.4 Polimorfismo: los consumos se tratan de forma uniforme (cálculo de kcal, despliegue, etc.) | 4 |
| A.5 Distribución de responsabilidades: cada clase hace lo suyo, `main` liviano | 3 |
 
### B. Lectura de archivos y carga de datos — **10 pts**
 
| Criterio | Pts |
|---|---:|
| B.1 Lectura correcta de `Participantes.txt` | 3 |
| B.2 Lectura de `Consumido.txt` distinguiendo ambos formatos (Choripán / Terremoto) | 5 |
| B.3 Parseo tolerante: líneas vacías o mal formadas se descartan sin detener el programa | 2 |
 
### C. Menú interactivo — **10 pts**
 
| Criterio | Pts |
|---|---:|
| C.1 Menú principal y submenús implementados según el enunciado | 4 |
| C.2 Navegación funcional: "Volver" y "Salir" operan desde cualquier nivel | 4 |
| C.3 Flujo claro, sin opciones muertas ni estados confusos | 2 |
 
### D. Ver registros — **10 pts**
 
| Criterio | Pts |
|---|---:|
| D.1 Listado de choripanes con toda su información | 4 |
| D.2 Listado de terremotos con toda su información | 4 |
| D.3 Formato ordenado, alineado y fácil de leer | 2 |
 
### E. Actualizar registros — **15 pts**
 
| Criterio | Pts |
|---|---:|
| E.1 **Agregar** un registro de cualquiera de los dos tipos, con validación de los datos ingresados | 5 |
| E.2 **Editar** un registro existente (selección + modificación de campos) | 5 |
| E.3 **Eliminar** un registro existente (selección + confirmación) | 5 |
 
### F. Persistencia — **10 pts**
 
| Criterio | Pts |
|---|---:|
| F.1 Los cambios se escriben en `Consumido.txt` respetando el formato original | 6 |
| F.2 Al cerrar y volver a ejecutar el programa, los cambios siguen presentes | 4 |
 
### G. Métricas — **10 pts**
 
| Criterio | Pts |
|---|---:|
| G.1 Total de choripanes y total de terremotos | 2 |
| G.2 Choripanes y terremotos por usuario | 2 |
| G.3 KCal por usuario aplicando correctamente ambas fórmulas | 3 |
| G.4 Días ebrio por usuario (agrupación por fecha y umbral de 2 L) | 3 |
 
### H. Control de errores — **10 pts**
 
| Criterio | Pts |
|---|---:|
| H.1 Entradas inválidas en los menús (letras, vacío, fuera de rango) | 3 |
| H.2 Índices inválidos al editar o eliminar (`IndexOutOfBounds`) | 3 |
| H.3 Archivos inexistentes o no legibles | 2 |
| H.4 Capacidad máxima de los vectores (200 registros) | 2 |
 
### I. Código y repositorio — **10 pts**
 
| Criterio | Pts |
|---|---:|
| I.1 Código limpio y ordenado, con nombres de variables descriptivos | 3 |
| I.2 Código documentado (comentarios útiles, no ruido) | 2 |
| I.3 Commits frecuentes y descriptivos durante todo el desarrollo | 3 |
| I.4 `README.md` del grupo con instrucciones de clonación y ejecución | 2 |
 
### Resumen
 
| Sección | Puntaje |
|---|---:|
| A. Diseño y aplicación de POO | 25 |
| B. Lectura de archivos y carga de datos | 10 |
| C. Menú interactivo | 10 |
| D. Ver registros | 10 |
| E. Actualizar registros | 15 |
| F. Persistencia | 10 |
| G. Métricas | 10 |
| H. Control de errores | 10 |
| I. Código y repositorio | 10 |
| **Total** | **110** |
 

> **Descuentos:** el código que no compile se evalúa con puntaje 0.

---

## 9. Contactos

- martin.droguett@alumnos.ucn.cl
- nicolas.rojas11@alumnos.ucn.cl
- **Grupo de WhatsApp (preferido)**