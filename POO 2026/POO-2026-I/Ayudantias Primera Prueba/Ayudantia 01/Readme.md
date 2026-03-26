<h1>Primera Ayudantía</h1>

***Objetivo***

<img align="right" width=80px alt="Unicorn" src="https://media.tenor.com/s2kXfVOep1IAAAAi/miku-hatsune-miku.gif" />


<ul>
<li>Comprender el proceso de compilación y ejecución en java de forma correcta, su sintaxis y uso de las variables.</li>
</ul>

<h2>Ejercicio 1</h2>
<p>Hatsune Miku es una cantante con una voz dulce y alegre. Vive en el mundo virtual de SEKAI pero un día se topa con una extraña tormenta que la traslada al mundo real, a un páramo desconocido llamado Kokin-boo, Japón.</p>
<p>Para regresar a su realidad necesita acumular 2200 UEM (unidades de energía mágica).
Actualmente su energía es 0 UEM.</p>
<p>Un día prueba una comida típica de la zona llamada <b><i>"completo"</b></i>, que le otorga una bonificación de +50 UEM cada que lo consume.</p> 
<p>Calcula cuántos días debe comer un completo para acumular al menos 2200 UEM y poder regresar a SEKAI.</p>

***Acalaración:***
* La restauración de su energía es acumulativa.
* Miku solo puede comer 1 completo al día.
* prueba

***Extra:***
<p>Modifica el código para que:</p>
<ol>
<li>El usuario ingrese la energía necesaria para regresar realizando control de errores simple.</li>
<li>Cada 5 días Miku come un completo XL que le entrega +80 UEM.
Los otros días mantiene la bonificación normal de +50 UEM.</li>
</ol>
<h2>Ejercicio 2</h2>

<p>La UCN necesita filtrar si un correo pertenece a un alumno o profesor para ingresar a plataforma. Para esta tarea acuden a ti, estudiante estrella, para poder ayudarlos.</p>

***Se necesita***
* Permite que el usuario ingrese por pantalla: Su nombre y un string con el correo a verificar.
* Si el correo es de un estudiante (termina en "@alumnos.ucn.cl") debe imprimirse por pantalla: "¡Bienvenido *nombre*! Acceso a plataforma estudiantil".
* Si el correo es de un profesor (termina en "@ucn.cl") debe imprimirse por pantalla: "¡Bienvenido *nombre*! Acceso a plataforma docente".
* En cualquier otro caso utiliza un control de errores simple e imprime: "Acceso denegado, intente nuevamente".

<h2>Ejercicio 3</h2>
<p>Se desean registrar las intensas temperaturas del verano en cuatro zonas clave de La Serena-Coquimbo en grados Celsius. Para organizar los datos, utilizarás una matriz de 2x2 (2 filas y 2 columnas) donde cada posición representa un sector geográfico.</p>

|       |  Columna 0  | Columna 1  |
|:-----:|:-----------------:|:-------------------:|
| **Fila 0** | **Serena Centro** | **Cuatro Esquinas** |
| **Fila 1** | **Puerto Coquimbo** | **Guanaqueros**  |

***Se necesita:***
<ol>
<li>Solicitar al usuario que ingrese la temperatura de cada una de las 4 zonas por teclado con datos tipo <b>double</b>.</li>
<li>Guardar los datos ingresados en una matriz.</li>
<li>Calcular y mostrar el promedio de cada fila (Fila 0: La Serena/Fila 1: Coquimbo).</li>
</ol>

***Extra:***
<p>Pregunta al usuario si desea ver el reporte <b>global</b> (de las 4 zonas) en Celsius, Fahrenheit o Kelvin. Dependiendo de su respuesta debes convertir el promedio general a esa unidad.</p>

***¡RECUERDA!***
* Fórmula Fahrenheit: <b><em>((Celsius * 1.8) + 32)</em></b>
* Fórmula Kelvin: <b><em>(Celsius + 273.1)</em></b>
* Puedes aproximar a 2 decimales
* Un control de errores siempre se aprecia!!!



