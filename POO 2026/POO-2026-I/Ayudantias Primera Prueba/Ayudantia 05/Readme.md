<h1>Ayudantía 05</h1>

***Objetivo***

<img align="right" width=80px alt="Unicorn" src="https://media.tenor.com/hmSBIfXirDsAAAAi/catjam-cat.gif" />


<ul>
<li>Comprender y aplicar arreglos dinámicos a través de ejercicios prácticos.</li>
</ul>

<h2>Ejercicio 1: La Ruleta Vallenarina</h2>
<p>El ayudante Nicolás, cansado de que le hagan preguntas sobre los talleres que están explícitas en los ReadMe, decide castigar a los estudiantes obligándolos a jugar a su juego macabro.</p>
<p>En este juego, los participantes deberán ubicarse uno al lado de otro de forma circular, es decir, el que se ubica de los últimos también estará al lado del primero en la fila. Luego, a un jugador en una posición al azar, se le entregará una bomba.</p> 
<p>La bomba puede debe ser pasada entre los participantes, donde cada uno de ellos deberá decidir si hacer el pase hacía el jugador de la izquierda o el de la derecha. Luego de K pases, la bomba explota y ese jugador queda con 15 décimas menos en la nota del taller.</p> 
<p>El juego debe continuar hasta que quede solo 1 jugador con vida.</p>
<p> La información de los jugadores y el juego se encontrará en un archivo llamado TalleresPOO.txt con el siguiente formato:</p>
<p><b>K (número de pases antes de que la bomba explote)</b></p>
<p><b>nombreJ1;apellidoJ1;notaJ1</b></p>
<p><b>nombreJ2;apellidoJ2;notaJ2</b></p>
<p><b>...</b></p>

<p>Antes de cada ronda debe elegirse de manera aleatoria al jugador inicial, por lo que deberás utilizar la librería Random para ayudarte.</p>

<p>Al finalizar la partida, el programa debe mostrar: </p>
<ul>
<li>El ganador del juego.</li>
<li>Los jugadores eliminados en orden.</li>
<li>Sus notas iniciales y sus notas finales.</li>
</ul>

***Consideraciones:***
* El número de jugadores puede ser variable, por lo que debes utilizar arreglos dinámicos.
* Debes usar Orientación a Objetos.
* Se debe aplicar una lógica circular, es decir, si el jugador en la última posición da un pase hacía la derecha, el jugador en la primera posición debe recibir la bomba, y viceversa. 
* Las notas no pueden ser inferiores a 1.
* Puedes usar la libreria Random.

<h2>Ejercicio 2</h2>

<p>Un día cualquiera todos los sistemas de playlist de música se cayeron de la nada.</p>
<p>Como tu eres fanátic@ de la música, necesitas una solución inmediata, por lo que decides construir un programa en Java que funcione como un reproductor de música con un sistema de playlist completamente funcional.</p>
<p>El programa debe ser capaz de recibir entradas de canciones, las cuales se ubicarán en orden en tu queue.</p>
<p>Luego de importar tu playlist, las canciones quedan en un archivo de texto llamado "canciones.txt" con el siguiente formato: </p>
<p><b>nombre;artista;duraciónMin:duraciónSeg;posiciónEnTop1000;diaPublicación/mesPublicación/añoPublicacion</b></p>
<p><b>...</b></p>
<p>El programa debe ser capaz de funcionar como un reproductor, por lo que se piden los siguientes requerimientos:</p>
<ol>
<li>Mostrar la canción que se está reproduciendo actualmente.</li>
<li>Avanzar a la siguiente canción.</li>
<li>Retroceder a la canción anterior.</li>
<li>Ordenar las canciones siguientes (de menor a mayor) a partir de cualquier criterio: Duración, Posición en el top 1000, Fecha de publicación</li>
<li>Agregar canciones</li>
<li>Eliminar canciones</li>
<li>Ver toda la playlist</li>
</ol>

***Consideraciones:***
* Debes usar colecciones (Arreglos dinámicos).
* Debes usar Orientación a Objetos.
* Al momento de crear canciones, debes cumplir con el formato entregado. 
* Utiliza un menú para las diferentes opciones.