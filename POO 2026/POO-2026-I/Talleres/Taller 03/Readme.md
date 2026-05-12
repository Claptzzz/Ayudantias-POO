# Taller 3

**I Semestre - 2026**
**ITI - ICCI - ICI**

**Docentes:**
- Alejandro Paolini Godoy
- Cristhian Rabi Reyes
- Juan Nilo

## Contexto: 

Los estudiantes de Proyecto Integrador de Programacion Avanzada estan realizando un juego donde la magia es la que domina sobre todas las capacidades. En este mundo, cada persona considerada un "mago" tiene un repertorio de uno a muchos hechizos, estos hechizos contienen diferentes propiedades dependiendo del elemento al que pertenecen.

Existen elementos tales como Fuego, Roca, Planta, y Agua.

## Archivos

### `Magos.txt`

En el siguiente archivo se encuentran los diferentes magos con los respectivos hechizos que dominan.

```texto
Pruno;Sofoco|Disparo Lodo|Pirotecnia|Vórtice Ígneo
Ferran;Salmuera|Envite Igneo|Disparo Lodo|Poder Pasado|Rueda Fuego|Hidroariete|Burbuja
Sasa;Infierno|Martillazo|Hidroariete|Envite Igneo
Mul;Gigadrenado|Rayo Burbuja|Danza Lluvia|Pistola Agua
Branco;Arraigo|Silvato|Danza Lluvia
MartinNegro;Acua Aro|Tumba Rocas|Polen Somnífero|Escaldar|Disparo Lodo|Cascada|Pirotecnia
EmaArdillaRabiosa;Origen Pulso|Fuego Sagrado|Cascada|Llamarada Azul
Danini;Fuego Sagrado|Pedrada|Envite Igneo|Hierba Lazo|Surf
Maxi;Explosión Ígnea|Envite Igneo|Agua Lodosa
MartinAyudanteHermoso;Disparo Lodo|Salmuera|Colmillo Igneo|Excavar|Calcinación
Estefania;Hoja Afilada|Burbuja|Acua Jet|Energibola|Fuego Sagrado|Agua Lodosa|Llamarada Azul
Churrasquita;Origen Pulso|Infierno|Silvato|Hoja Mágica|Colmillo Igneo
Clapt;Pulso de Agua|Giro Fuego|Pedrada
Rabi;Latigazo|Absorber|Vórtice Ígneo|Avalancha|Rueda Fuego|Tormenta de Arena
Nilo;Patada Ígnea|Acua Jet|Huesomerang|Clorofila|Fogonazo|Polen Somnífero|Torbellino
Papulini;Fuego Sagrado|Absorber|Infierno
```

`NombreMago;Hechizo 1|Hechizo 2|Hechizo N...`

### `Hechizos`

En el siguiente archivo se encuentran los diferentes hechizos con sus respectivas propiedades.

```texto
Escaldar;Agua;110;45,360
Tumba Rocas;Tierra;18;40
Polen Somnífero;Planta;81;3,10
Ascuas;Fuego;77;5
```

`NombreHechizo;Tipo;Daño;...`

* Para Fuego --> `NombreHechizo;Tipo;Daño;DuracionQuemadura`
* Para Roca --> `NombreHechizo;Tipo;Daño;MejoraDefensa`
* Para Planta --> `NombreHechizo;Tipo;Daño;DuracionStun,CantPlantas`
* Para Agua --> `NombreHechizo;Tipo;Daño;CantidadHeal,PresionDelAgua`

## Requerimientos

Debe realizar dos paneles, Administrador y Analista.

### Administrador

Debe permitir las siguientes opciones:

```text
1. Agregar Mago
2. Modificar Mago
3. Eliminar Mago
4. Agregar Hechizo
5. Modificar Hechizo
6. Eliminar Hechizo
```

### Analista

```text
1. Top 10 Mejores Hechizos
2. Top 3 Mejores Magos
3. Mostrar todos los Hechizos
4. Mostrar todos los magos
5. Mostrar todos los Hechizos junto a su puntuacion
6. Mostrar todos los magos junto a su puntuacion
```

## Aclaraciones

### Calcular Puntuacion de Hechizo

Para cada tipo de hechizo existe un metodo diferente para calcular su puntuacion.

* Para Fuego --> Puntaje = Daño*DuracionQuemadura
* Para Roca --> Puntaje = (Daño*MejoraDefensa)/2
* Para Planta --> Puntaje = Daño + (DuracionStun * CantPlanta)
* Para Agua --> Puntaje = (Daño+CantidadHeal+PresionDeAgua)*2

### Calcular mejor mago

La puntuacion de cada mago se calcula sumando las puntuaciones de cada hechizo que domina.

### Menu de Administrador

Se deben ver reflejados los cambios efectuados, en sus respectivos txt.

## Consideraciones

1) Se engloban todas las consideraciones redactadas en el Readme de los talleres <a href="../Readme.md"> (Click aquí para ver)</a>.
2) Se podrán utilizar las siguientes librerías:
```text
Scanner -> Lectura de archivo.
BufferedWriter -> Sobrescritura de los archivos.
ArrayList y LinkedList -> Uso de Colecciones.
```
***En caso de necesitar alguna adicional, consultar con tiempo.***

3) Se deben entregar el Modelo de Dominio y el Diagrama de Clases en la raíz del repositorio ***EN FORMATO PDF***.
4) Se debe utilizar POO, Arquitectura (separar el main y el sistema), Herencia e Interfaces.

## Fechas
Inicio -> 11/05/2026

Fecha límite -> 05/06/2026
## Contactos
* nicolas.rojas11@alumnos.ucn.cl
* [Grupo de WhatsApp](https://chat.whatsapp.com/GGkRnviIyRfDj24kXZeGpu?mode=gi_t)

## Pauta de evaluacion

**Puntaje Total Máximo:** 120 puntos

---

### 1. Persistencia de Datos y Archivos (20 puntos)
* **[8 pts] Lectura inicial:** Carga correctamente los datos de `Magos.txt` y `Hechizos.txt` al iniciar el programa. Procesa adecuadamente las líneas con múltiples hechizos y los diferentes parámetros según el tipo de elemento (Fuego, Roca, Planta, Agua) sin errores de parseo.
* **[6 pts] Actualización de Archivos:** Las operaciones de agregar, modificar o eliminar (CRUD) se reflejan correctamente en los archivos `.txt` correspondientes. Los cambios persisten tras cerrar la aplicación.
* **[6 pts] Formato de Salida:** Al sobrescribir los archivos, se mantiene estrictamente el formato original (`Nombre;Dato1|Dato2` o `Nombre;Tipo;...`), asegurando la integridad de los datos para futuras ejecuciones.

### 2. Diseño de Software y POO (30 puntos)
* **[10 pts] Herencia e Interfaces:** Implementa una estructura de herencia lógica con una clase base (o abstracta) para `Hechizo` y subclases específicas. Utiliza interfaces para definir comportamientos requeridos.
* **[10 pts] Modelado de Clases:** Demuestra un uso correcto de la abstracción y el encapsulamiento (atributos privados y métodos de acceso). Las clases son cohesivas y representan fielmente las entidades del problema.
* **[10 pts] Arquitectura y Colecciones:** El código separa la lógica del sistema del punto de entrada (`Main`). Utiliza colecciones dinámicas (`ArrayList` o `LinkedList`) para gestionar los hechizos de cada mago y el catálogo global.

### 3. Lógica de Negocio y Requerimientos (40 puntos)
* **[15 pts] Panel Administrador (CRUD):** Implementa funcionalmente las 6 opciones (Agregar, Modificar, Eliminar tanto para Magos como Hechizos). Las modificaciones en un hechizo se ven reflejadas correctamente en los magos que lo poseen.
* **[10 pts] Cálculo de Puntuaciones:** Implementa con exactitud las fórmulas de puntuación para cada tipo de elemento:
    * **Fuego:** Daño * DuracionQuemadura
    * **Roca:** (Daño * MejoraDefensa) / 2
    * **Planta:** Daño + (DuracionStun * CantPlanta)
    * **Agua:** (Daño + CantidadHeal + PresionDeAgua) * 2
* **[15 pts] Panel Analista (Reportes):** Genera correctamente los listados y rankings (Top 10 Hechizos, Top 3 Magos) basados en las puntuaciones calculadas. Los datos se muestran de forma clara y ordenada.

### 4. Control de Errores y Robustez (10 puntos)
* **[5 pts] Validación de Entradas:** El programa utiliza validaciones (ej. `Scanner` o `try-catch`) para evitar caídas por ingresos de tipos de datos incorrectos en los menús.
* **[5 pts] Calidad de Código:** Respeta las convenciones de Java (CamelCase), mantiene una indentación correcta y utiliza nombres de variables descriptivos.

### 5. Diagramas y Entregables (10 puntos)
* **[5 pts] Diagrama de Clases:** Entrega un PDF en la raíz que representa la arquitectura del código, incluyendo relaciones, atributos y métodos.
* **[5 pts] Modelo de Dominio:** Entrega un PDF con la abstracción conceptual del problema, diferenciándose claramente del diagrama técnico de clases.

### 6. Uso de GitHub y Repositorio (10 puntos)
* **[10 pts] Gestión de Versiones:** El repositorio está bien estructurado, cuenta con commits frecuentes y significativos, y sigue las consideraciones generales de entrega.

---