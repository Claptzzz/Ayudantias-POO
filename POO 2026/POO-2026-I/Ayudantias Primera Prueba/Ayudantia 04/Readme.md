# Ayudantía 04

## Inventario de minecraft!!

<img align="right" width=100px alt="Unicorn" src="https://media1.tenor.com/m/ZYdYQP14TcgAAAAd/cat-minecraft.gif">

<p>Año 2009... Acaba de lanzarse una de las primeras versiones del modo supervivencia de Minecraft.</p>
<p>En esta versión temprana (v0.3.0) los jugadores recién están aprendiendo a sobrevivir recolectando recursos, almacenándolos en su inventario y utilizando una pequeña cuadrícula de 2x2 para fabricar nuevos objetos mediante crafteo.</p>

<p>Sin embargo, muchos de tus amigos aún no entienden bien cómo funciona el sistema de inventario ni cómo se combinan los bloques para crear nuevos objetos. Debido a esto, decides programar un simulador simple del inventario y sistema de crafteo utilizando Programación Orientada a Objetos.
</p>
<p>El programa debe permitir que varios jugadores interactúen con un inventario, administren sus recursos y utilicen una pequeña mesa de crafteo para fabricar nuevos items.

Para comenzar, el sistema debe leer un archivo llamado "bloques.txt", que contiene la información de los items disponibles en el juego. </p>
```
nombre;tipo;cantidad
Madera;bloque;4
Piedra;bloque;5
Carbón;recurso;20
Hierro;recurso;30
Oro;recurso;1
```

## Se pide: 
<p>El programa debe presentar un menú interactivo que permita realizar las siguientes acciones:</p>
<ol>
<li>Registrarse: Permitir que un jugador se registre en el sistema ingresando nombre de usuario y contraseña.
<b>El sistema debe permitir múltiples jugadores registrados</b></li>
<li>Iniciar sesión: Un jugador debe poder ingresar al sistema utilizando su nombre de usuario y contraseña.</li>
<li>Ver disponibles: El jugador podrá visualizar los objetos disponibles a nivel global y añadirlos a su inventario. </li>
<li>Administrar inventario: agregar un item a su inventario, aumentar la cantidad de un objeto existente, eliminar objeto, disminuir cantidades.
<b>Si la cantidad de un objeto llega a 0, este debe eliminarse del inventario.</b></li>
<li>Mostrar inventario</li>
<li>Mostrar recetas: ver las recetas disponibles en el sistema (como una matriz)</li>
<li> Crafteo: simular una pequeña mesa de crafteo de 2x2, donde el jugador puede colocar objetos del inventario en cada posición de la cuadrícula.

Cuando se realiza un crafteo exitoso:
* Los materiales se consumen del inventario.
* El nuevo objeto se agrega al inventario del jugador.
De otra forma, se muestra "Receta inválida" y no ocurren modificaciones. 

<b> Las recetas se encuentran en el archivo "recetas.txt"</b>
```
ingrediente1;ingrediente2;ingrediente3;ingrediente4;resultado
Madera;Madera;Madera;Madera;Mesa de crafteo
Tablones;Tablones; ; ;Palo
Palo;Carbón; ; ;Antorcha
Piedra;Piedra;Piedra;Palo;Pico de piedra
```

</li>
<li> Salir de la sesión y guardar todos los cambios realizados por el usuario.</li>

</ol>
<p><b>Realizar diagrama de clases en UML</b></p>

## Aclaraciones:
<li> Pueden existir múltiples usuarios dentro del sistema</li>
<li> Cada jugador posee su propio inventario.</li>
<li>El inventario puede tener un máximo de 36 espacios de objetos distintos, trátalo como un vector.</li>
<li>Cada item puede alcanzar hasta 64 unidades pero las armas solo pueden tener 1 unidad!</li>