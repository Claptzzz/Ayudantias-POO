# Taller 01

**I Semestre - 2026**
**ITI - ICCI**

**Docentes:**
- Alejandro Paolini Godoy
- Cristhian Rabi Reyes
- Juan Nilo

## Contexto: Procastinacion

Martin Galactico, Catalina y Estefania utilizan su tiempo de ocio para diversas actividades, mientras algunas disfrutan de ver series, otros son consumidos por los reels, de esta manera se han propuesto llevar la cuenta del tiempo consumido gracias a una aplicacion integrada de sus dispositivos.

Lamentablemente esta aplicacion ha dejado de llevar la cuenta por un fallo interno, por lo cual le piden a sus alumnos superdotados de POO que hagan un software que les permita leer los registros que quedaron, añadir nuevos tiempos a los registros, y analizarlos.

## Archivos

### `Usuarios.txt`
```
Martin;papurri
Catalina;furryfacto
Estefania;cutiemarks
```
Contiene la informacion de los usuarios
- ***ID;Contraseña***

### `Registros`

```
Catalina;14/10/2025;6;viendo jojos
Martin;15/10/2025;4;viendo reels
Estefania;15/10/2025;3;viendo mlp
```
Contiene los registros rescatados del software anterior
- ***ID;Fecha;Horas;Actividad***

## Requerimientos

Se pide hacer dos menus, uno donde los usuarios puedan ingresar verificando sus credenciales y añadir algun tipo de actividad que hayan realizado, y el otro donde se pueda entrar sin credenciales para revisar las estadisticas.

### Menu Usuarios

Se debe realizar un menu interactivo por consola, donde se pida ingresar el nombre y contraseña para verificar la identidad. Luego deben haber opciones tales como:

1) Registrar actividad.
2) Modificar actividad.
3) Eliminar actividad.
4) Cambiar contraseña.
5) Salir.

Ejemplo de ejecucion:

```
1) Menu de Usuarios
2) Menu de Analisis
3) Salir
```
```
1
```
```
Usuario: Martin
Contraseña: papurri
```

```
Acceso correcto!
```

```
Bienvenido Martin!

Que deseas realizar?

1) Registrar actividad.
2) Modificar actividad.
3) Eliminar actividad.
4) Cambiar contraseña.
5) Salir.
```
```
2
```
```
Cual actividad deseas modificar?
```
```
0) Regresar.
1) Martin;15/10/2025;4;viendo reels
2) Martin;16/10/2025;4;viendo reels
3) Martin;17/10/2025;4;viendo reels
4) Martin;18/10/2025;4;viendo reels
5) Martin;19/10/2025;4;viendo reels
6) Martin;20/10/2025;4;viendo reels
7) Martin;21/10/2025;4;viendo reels
8) Martin;22/10/2025;4;viendo reels
```
```
2
```
```
Que deseas modificar?

0) Regresar.
1) Fecha
2) Duracion
3) Tipo de actividad
```
```
3
```
```
0) Regresar.
Ingrese nuevo tipo de actividad: Leer literatura feminista
```
```
Actividad modificada con exito!
```
```
Bienvenido Martin!

Que deseas realizar?

1) Registrar actividad.
2) Modificar actividad.
3) Eliminar actividad.
4) Cambiar contraseña.
5) Salir.
```

Es solo una salida de ejemplo y la opcion de modificarla al gusto del estudiante es totalmente libre, ***Mientras cumpla con los requerimientos.***
### Menu de Analisis

Se debe realizar un menu interactivo por consola donde le permita a cualquier usuario revisar metricas para comparar su nivel de procastinacion, ya sea individual o en comparacion a los demas.

El menu debe contener:

1) Actividad más realizada
2) Actividad más realizada por cada usuario
3) Usuario con mayor procastinacion
4) Ver todas las actividades
5) Salir

Ejemplo de ejecucion:

```
1) Menu de Usuarios
2) Menu de Analisis
3) Salir
```
```
2
```
```
Bienvenido al menu de analisis!

Que deseas realizar?

1) Actividad más realizada
2) Actividad más realizada por cada usuario
3) Usuario con mayor procastinacion
4) Ver todas las actividades
5) Salir
```
```
2
```
```
Actividades mas realizadas por cada usuario:

* Martin -> Ver reels -> con 82 horas registradas
* Catalina -> Ver jujutsu -> con  8 horas registradas
* Estefania -> Ser Batman -> 189 horas registradas
```
```
Bienvenido al menu de analisis!

Que deseas realizar?

1) Actividad más realizada
2) Actividad más realizada por cada usuario
3) Usuario con mayor procastinacion
4) Ver todas las actividades
5) Salir
```

****Nota: Los ejemplos de ejecucion son solamente EJEMPLOS, no necesariamente mostrara el valor real****
## Aclaraciones

1) ***NO*** se puede utilizar programacion orientada a objetos (POO) en este taller.
2) ***NO*** se pueden utilizar colecciones en este taller, solo vectores (int[] vectorDeNumeros).
3) Se permite el uso de librerias basicas (Scanner, BufferedWrite, etc...) pero nada de maps() o librerias no vistas en clase. Al menos que el ayudante de talleres les de el visto bueno en caso de consulta.
4) Al agregar actividades o modificar usuarios debe existir persistencia en los datos modificados, osea modificar los archivos mediante el codigo.
5) Se debe considerar que la cantidad de actividades no seran más de 300 actividades.

## Consideraciones

1) Se engloban todas las consideraciones redactadas en el Readme de los talleres <a href="../Readme.md"> (Click aqui para ver)</a>.
2) Se debe manejar control de errores en los inputs! ya que se probara que no se caiga el taller!

## Fechas
Inicio -> 17/03/2026

Fecha limite -> 03/04/2026

## Contactos
* nicolas.rojas11@alumnos.ucn.cl
* [Grupo de WhatsApp](https://chat.whatsapp.com/GGkRnviIyRfDj24kXZeGpu?mode=gi_t)