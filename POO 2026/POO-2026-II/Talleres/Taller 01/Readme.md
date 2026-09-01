# Taller 01

**II Semestre - 2026**
**ITI - ICCI - ICI**

**Docentes:**
- _Alejandro Paolini (C1) - Cristhian Rabi (C2)_

**Ayudantes:**
- _Nicolás Rojas (C1) - Martín Droguett (C2)_

---

## Contexto: "El Grupo de POO"

Durante el primer semestre de 2026 existió un grupo de WhatsApp de POO que servía para compartir avisos importantes, material de estudio y consultas. El problema es que **nunca hubo control sobre quién entraba**: el link circuló por todos lados y terminaron ingresando personas de otros cursos que descontrolaban el grupo hasta que se convirtió en inservible.

Para que esto no ocurra durante este semestre, los ayudantes decidieron **crear el grupo con control de acceso**. La idea es simple: solo pueden entrar quienes estén **oficialmente inscritos en un paralelo del curso (C1 o C2)**.

Para lograrlo cuentan con dos archivos:

1. Un archivo llamado **Alumnos.txt**, con la **lista oficial de alumnos del curso**, con su nombre, apellido, RUT y paralelo. Este es el **filtro**: si alguien no está aquí, no es alumno del curso.

2. Un archivo llamado **Solicitudes.txt**, con las **solicitudes de ingreso**: la lista de personas que hicieron clic en el link e intentaron entrar al grupo (solo se registró su nombre y apellido).

Tu misión es construir el software que los ayudantes usarán para **filtrar automáticamente** quién puede entrar, **inscribir manualmente** a rezagados, **administrar el curso** durante el período de inscripciones y **generar reportes y estadísticas** de todo el proceso.

> Una persona **solo puede ingresar al grupo si aparece en la lista**

---

## Archivos de Entrada

### `Alumnos.txt` (la lista del curso)

Contiene a los alumnos oficialmente inscritos en el curso. No siguen ningún orden (mezclados C1 y C2).

```text
Martin;Droguett;20345678-9;C1
Luis;Pineda;19876543-2;C2
Miguel;Perez;20111222-3;C1
Nicolas;Rojas;20654321-K;C2
Alejandro;Rabi;19555444-1;C1
```

Formato de cada línea:
- ***nombre;apellido;rut;paralelo***

Donde `paralelo` solo puede ser `C1` o `C2`.

### `Solicitudes.txt` (quienes intentan entrar al grupo)

Contiene el nombre y apellido de todas las personas que hicieron clic en el link e intentaron ingresar. 

```text
Martin-Droguett
Miguel-Perez
Cristhian-Paolini
Sebastian-Fantasma
Nicolas-Rojas
```

Formato de cada línea:
- ***nombre-apellido***

---

## Requerimientos

Se debe construir un **menú interactivo por consola**:

```text
===== Sistema de Control del Grupo POO =====
1) Cargar archivos (Alumnos y Solicitudes)
2) Procesar solicitudes (Filtrado automatico)
3) Inscripcion manual al grupo
4) Administracion del curso
5) Generar reportes
6) Analisis estadistico
7) Salir
```
> El diseño exacto del menú es libre, **mientras cumpla con todos los requerimientos.**

### 1) Cargar archivos

Lee `Alumnos.txt` y `Solicitudes.txt` y carga su información en **vectores estáticos paralelos**.

Debe manejar el caso de que un archivo **no exista** sin caerse.

### 2) Procesar solicitudes (Filtrado automático)

Recorre todas las solicitudes cargadas y, para cada una, verifica si **existe en la lista** (comparando por **nombre + apellido**):

- **Si pertenece a un paralelo** → se agrega a la lista de **miembros admitidos** (recuperando su RUT y paralelo desde la lista).
- **Si NO pertenece** → se agrega a la lista de **rechazados**.

### 3) Inscripción manual al grupo

Simula que un ayudante ingresa manualmente a una persona rezagada. Debe poder inscribirse de **dos formas**:

- **Por nombre completo** (nombre y apellido).
- **Por RUT.**

En ambos casos se verifica contra la lista:

- **Si está inscrito en un paralelo** → entra al grupo y se guarda **normalmente con su nombre y RUT**.
- **Si NO está inscrito** → no puede entrar y se anota en el registro de rechazados.
  - Si se intentó por **nombre** y no está → se registra su nombre.
  - Si se intentó por **RUT** y no está → como no tenemos su nombre, se registra el **mensaje especial** indicando que solo se dispone del RUT.

### 4) Administración del curso

Como aún estamos en **período de inscripciones**, la lista puede cambiar. Debe permitir:

- **Cambiar el paralelo** de un alumno (C1 ⇄ C2).
- **Eliminar** un alumno del curso.
- **Inscribir un alumno nuevo** al curso (nombre, apellido, RUT y paralelo).

Todo cambio debe:
1. Reflejarse en los datos en memoria (los vectores).
2. **Persistir en el archivo `Alumnos.txt`** (reescribiéndolo con `BufferedWriter`, manteniendo el formato original).
3. Reflejarse en los reportes la **próxima vez** que se generen.

> **Reglas de coherencia:**
> - Al **cambiar el paralelo** de un alumno, si ya era miembro del grupo, debe quedar reclasificado en el paralelo nuevo.
> - Al **eliminar** a un alumno de la lista, deja de ser alumno; si era miembro del grupo, pierde el acceso.
> - **Inscribir un alumno nuevo** a la lista NO lo mete automáticamente al grupo: aún debe "hacer clic en el link" (procesarse o inscribirse manualmente).

### 5) Generar reportes

Abre un menú que permite escribir los archivos `ReporteC1-VX.txt`, `ReporteC2-VX.txt` y `Rechazados-VX.txt` según los formatos de la sección **Archivos de Salida**, reflejando el estado actual.

Para mantener un control de versiones, el sistema no debe borrar el reporte anterior, sino crear uno nuevo siguiendo siempre el mismo formato: `ReporteC1-VX.txt`, `ReporteC2-VX.txt`, `Rechazados-VX.txt` según corresponda, con X = Versión de cada reporte.

#### Ejemplo de estructura
```
Reportes/
├── ReporteC1-V1.txt
├── ReporteC1-V2.txt
├── ReporteC2-V1.txt
├── Rechazados-V1.txt
├── Rechazados-V2.txt
└── Rechazados-V3.txt
```
- Esta estructura se obtendría solicitando dos veces el reporte del paralelo C1, una vez el del paralelo C2, y tres veces el reporte de rechazados.

---

#### Archivos de Salida (Reportes)

Los reportes se **generan por código** (con `BufferedWriter`) desde la opción correspondiente del menú y deben reflejar **el estado actual** de los datos.

##### `ReporteC1-VX.txt` y `ReporteC2-VX.txt` (miembros admitidos por paralelo)

```text
=== Miembros del grupo - Paralelo C1 ===
Martin Droguett - 20345678-9
Miguel Perez - 20111222-3
```

##### `Rechazados-VX.txt` (quienes intentaron entrar y no pudieron)

```text
=== Solicitudes rechazadas ===
Cristhian Paolini - No pertenece a ningun paralelo del curso
Sebastian Fantasma - No pertenece a ningun paralelo del curso
Sin nombre registrado, RUT: 21999888-7
```

> La última línea corresponde a un caso especial: alguien intentó inscribirse **manualmente ingresando solo su RUT**, ese RUT no está en la lista, y como no tenemos su nombre, se deja constancia únicamente del RUT.

### 6) Análisis estadístico

Debe mostrar, como mínimo:

- **Porcentaje de solicitudes rechazadas** respecto del total de intentos de ingreso.

Y **al menos 2 métricas adicionales** a elección. Algunas ideas:

- Cantidad y porcentaje de alumnos por paralelo (C1 vs C2).
- Tasa de admisión (admitidos / total de intentos).
- Paralelo con más alumnos.
- Cantidad de rechazados de los que solo se tiene el RUT (ingresos "anónimos").
- Cantidad de inscripciones hechas manualmente vs por archivo.
- Cantidad de solicitudes duplicadas (personas que intentaron entrar más de una vez).
- Apellido más repetido en la lista.

---

## Ejemplo de Ejecución

```text
===== Sistema de Control del Grupo POO =====
1) Cargar archivos (Alumnos y Solicitudes)
2) Procesar solicitudes (Filtrado automatico)
3) Inscripcion manual al grupo
4) Administracion del curso
5) Generar reportes
6) Analisis estadistico
7) Salir
```
```text
Ingrese opcion: 1
```
```text
Archivos cargados con exito!
- 5 alumnos en la lista.
- 5 solicitudes de ingreso.
```
```text
Ingrese opcion: 2
```
```text
Procesando solicitudes...

[OK]       Martin Droguett -> admitido en C1
[OK]       Miguel Perez -> admitido en C1
[OK]       Nicolas Rojas -> admitido en C2
[RECHAZO]  Cristhian Paolini -> no pertenece a ningun paralelo
[RECHAZO]  Sebastian Fantasma -> no pertenece a ningun paralelo

Resumen: 3 admitidos / 2 rechazados.
```
```text
Ingrese opcion: 3
```
```text
Como desea inscribir a la persona?
1) Por nombre completo
2) Por RUT
Ingrese opcion: 2
```
```text
Ingrese RUT: 21999888-7
```
```text
El RUT 21999888-7 no pertenece a ningun paralelo del curso.
No tenemos su nombre, por lo que se registrara solo el RUT en los rechazados.
```
```text
Ingrese opcion: 4
```
```text
--- Administracion del curso ---
1) Cambiar paralelo de un alumno
2) Eliminar alumno del curso
3) Inscribir alumno nuevo
4) Volver
Ingrese opcion: 1
```
```text
Ingrese RUT del alumno: 20345678-9
Alumno: Martin Droguett (actualmente en C1)
Nuevo paralelo (C1/C2): C2
```
```text
Paralelo actualizado! Cambios guardados en Alumnos.txt
```
```text
Ingrese opcion: 6
```
```text
--- Analisis estadistico ---
Total de intentos de ingreso: 6
Rechazados: 3 (50.0%)
Admitidos por paralelo -> C1: 1 | C2: 2
Tasa de admision: 50.0%
```

> ****Nota: los ejemplos de ejecución son solamente EJEMPLOS, no necesariamente muestran el valor real.****

---

## Control de Errores (OBLIGATORIO)

El programa **NO se puede caer bajo ninguna circunstancia.** Se probará explícitamente que resista, entre otros:

- Opciones de menú inválidas (letras, números fuera de rango, vacío).
- Intentar procesar/reportar **antes** de cargar los archivos.
- Archivos inexistentes.
- Selección de índices inválidos (`IndexOutOfBounds`).
- Superar la capacidad máxima de los vectores.
- RUT o paralelo inválidos.
- Bucles de menú que dejen atrapado al usuario (todas las opciones "Volver"/"Salir" deben funcionar).

---

## Aclaraciones
**Se espera originalidad para cada equipo, es decir, no copiar explícitamente de los ejemplos o de otro equipo.**

1. Se engloban todas las consideraciones redactadas en el README de talleres <a href="../README.md"> (Click aqui para ver)</a>.
2. **Clave de comparación:** para cruzar solicitudes contra la lista se usa **nombre + apellido**. Para la inscripción manual por RUT, la clave es el **RUT** (que es único). Se recomienda comparar textos de forma robusta (ignorando mayúsculas/minúsculas).
3. **Capacidad de los vectores:** Existirán como máximo 100 personas en cada archivo. El programa **no debe caerse** si se alcanza el límite: debe avisar que no hay espacio.
4. **Eliminación en vectores:** al eliminar un alumno, deben tener en cuenta que el espacio en el vector quedará vacío, esto no debe afectar a los recorridos con aquellos que están más adelante del vector.
5. **Duplicados:** una persona no puede ser admitida dos veces al grupo, ni inscribirse dos veces en la lista (validar por RUT).
6. **Validaciones mínimas:** el paralelo solo puede ser `C1` o `C2`, el RUT no puede estar vacío, los campos no pueden quedar en blanco.
7. **Verificación:** Se probarán con distintos archivos y casos de prueba, por lo que no deben hacer todo su código pensando en el archivo entregado, sino que en todas las posibilidades donde este podría fallar.

---

## Aclaraciones Técnicas

1. ***NO*** se puede utilizar Programación Orientada a Objetos (POO) en este taller.

2. ***NO*** se pueden utilizar colecciones dinámicas (`ArrayList`, `LinkedList`, `HashMap`, etc.). **Solo vectores estáticos** (`String[]`, `int[]`, ...).

3. Se permite el uso de las siguientes librerías:
```text
Scanner        -> Lectura por consola y de archivos.
File           -> Referenciar archivos.
FileWriter     -> Apertura de archivos para escritura.
BufferedWriter -> Escritura/sobrescritura de archivos.
IOException    -> Manejo de errores de entrada/salida.
```
Cualquier otra librería debe ser **consultada y autorizada** por el ayudante con anticipación.

4. Debe existir **persistencia**: los cambios en la lista deben quedar guardados en `Alumnos.txt`.

5. Se puede asumir que no habrá más de **100** líneas en cada archivo.

---

## Consideraciones

1. Los datos del/los integrante(s) (nombre completo, RUT y carrera) deben ir en las **primeras 5 líneas del archivo que contiene el método `main`**.
```
//Nombre1 Apellido1 - 21.000.000-K - ICCI
//Nombre2 Apellido2 - 22.000.000-0 - ITI

package taller01;

import ...;

public class Main {
    public static void main(String[] args) {
        ...
```

2. El código debe estar **limpio, ordenado y documentado**, con nombres de variables descriptivos.
3. Se debe manejar **control de errores** en los inputs (Se probará que no se caiga el taller!).
4. El taller se desarrolla en un **repositorio de GitHub** con commits frecuentes y descriptivos.
5. El código **DEBE** compilar sin problemas.
6. El README.md del taller debe estar correctamente documentado, con las instrucciones de ejecución (clonación de repositorio y testeo).

---

## Fechas

Inicio -> _01-Sep-2026_

Fecha límite -> _25-Sep-2026_

---

## Contactos

- _martin.droguett@alumnos.ucn.cl_
- _(Grupo de WhatsApp) (Preferido)_

---

## Pauta de Evaluación

**Puntaje Total Máximo:** 100 puntos

### 1. Carga y Lectura de Archivos (15 puntos)
* **[6 pts] Lectura de la lista:** Lee `Alumnos.txt` correctamente, separando por `;` y almacenando nombre, apellido, RUT y paralelo en vectores paralelos. 
* **[5 pts] Lectura de solicitudes:** Lee `Solicitudes.txt` correctamente. 
* **[4 pts] Manejo de errores:** Maneja archivos inexistentes.

### 2. Filtrado Automático de Solicitudes (15 puntos)
* **[8 pts] Cruce de datos:** Compara cada solicitud (nombre + apellido) contra la lista e identifica correctamente admitidos vs rechazados.
* **[4 pts] Recuperación de datos:** Para los admitidos, recupera correctamente su RUT y paralelo desde la lista.
* **[3 pts] Duplicados:** No admite dos veces a la misma persona ni cuenta mal las solicitudes repetidas.

### 3. Inscripción Manual (15 puntos)
* **[5 pts] Por nombre:** Permite inscribir por nombre completo y lo verifica contra la lista.
* **[5 pts] Por RUT:** Permite inscribir por RUT y lo verifica contra la lista.
* **[5 pts] Reglas de rechazo:** Envía correctamente los casos no válidos a rechazados y aplica el **mensaje especial "solo RUT"** cuando corresponde.

### 4. Administración del Curso y Persistencia (20 puntos)
* **[6 pts] Cambiar paralelo:** Cambia el paralelo de un alumno (C1 ⇄ C2) y lo refleja en memoria.
* **[6 pts] Eliminar alumno:** Elimina un alumno de la lista, y lo quita del grupo si correspondía.
* **[4 pts] Inscribir alumno nuevo:** Agrega un alumno a la lista validando datos y capacidad.
* **[4 pts] Persistencia:** Reescribe `Alumnos.txt` con `BufferedWriter` manteniendo el formato original.

### 5. Generación de Reportes (15 puntos)
* **[6 pts] Control de versiones:** Manejo coherente y ordenado de las versiones de cada archivo por separado.
* **[3 pts] `ReporteC1-VX.txt`:** Lista correctamente a los miembros del paralelo C1.
* **[3 pts] `ReporteC2-VX.txt`:** Lista correctamente a los miembros del paralelo C2.
* **[3 pts] `Rechazados-VX.txt`:** Lista a quienes no pudieron entrar, incluyendo el mensaje especial "solo RUT". Los reportes reflejan el estado actual tras los cambios.

### 6. Análisis Estadístico (10 puntos)
* **[5 pts] Porcentaje de rechazo:** Calcula correctamente el % de solicitudes rechazadas sobre el total.
* **[5 pts] Métricas adicionales:** Implementa correctamente al menos 2 métricas extra (por paralelo, tasa de admisión, etc.).

### 7. Control de Errores y Calidad de Código (10 puntos)
* **[6 pts] Robustez:** El programa NO se cae ante ningún input (menús, tipos de dato, índices, capacidad de vectores, archivos).
* **[4 pts] Estructura y estilo:** Código limpio y ordenado, funciones documentadas, nombres descriptivos y datos del integrante en el `main`.

---
