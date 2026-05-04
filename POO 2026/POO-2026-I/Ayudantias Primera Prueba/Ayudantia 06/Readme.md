# Ayudantía 06

## Ejercicio 01

<img align="right" width=200px alt="Unicorn" src="https://media1.tenor.com/m/1LjbH9PW5FoAAAAC/cat-kitty.gif">

#### Para un evento de navidad, se hizo un llamado a que todas las familias donaran los juguetes que sus niños ya no usaran para regalar a niños de menores recursos. El llamado trajo muchas familias dispuestas a donar, sin embargo, como eran juguetes usados, algunos de ellos no están en un estado lo suficientemente limpio o de buena calidad como para regalar. Es por eso que se le pide que haga un programa que filtre los juguetes y luego los regale en tandas de tres. Se le entrega un txt llamado “juguetes.txt” que tiene los datos de todos los juguetes mezclados en el siguiente formato:

```
id, tamaño, tipo de juguete, datos
1, pequeño, muñeca, 85%, rosado
2, mediano, peluche, oso, 20%
3, grande, auto, rojo, 4, si
4, pequeño, pelota, azul, no
```

#### También se les entrega todas las categorías de juguetes que se lograron recaudar:

<li>Muñecas tienen un porcentaje de calidad y color de ropa.</li>
<li>Peluches tienen un tipo (por ejemplo, si es un oso, una muñeca de peluche, un personaje animado, puede ser cualquier cosa) y un porcentaje de relleno perdido.</li>
<li>Autos de juguete tienen un color, cantidad de ruedas que tiene y si funciona con un control remoto o no.</li>
<li>Pelotas tienen el color y si está desinflada o no. </li>

#### Todos los juguetes tienen un id, un tamaño y un estado general (Si se puede regalar o no). Los juguetes están aptos para regalo si cumplen con lo siguiente:

<li>Las muñecas tienen más o igual de un 70% porcentaje de calidad</li>
<li>Los peluches tienen un 15% o menos de relleno perdido.</li>
<li>Los autos deben tener las 4 ruedas.</li>
<li>Las pelotas no deben estar desinfladas.</li>

#### Luego de sacar todos los datos, se les informa que hay otro archivo llamado “deseos.txt” que es una lista de los deseos que pidió cada niño en la lista. Entonces, es necesario que usted encuentre un juguete que cumpla con esos requerimientos primero y luego elija 2 juguetes más al azar para darle al niño. Este archivo tiene el siguiente formato:

```
Nombre niño, edad niño, tipo de juguete, requerimiento
Sofía, 12, muñeca, rosado
Juan, 8, auto, rojo, si
Martina, 6, peluche, oso
```

#### Su código deber ser capaz de:
<li>Filtrar todos los juguetes hasta obtener solamente los aptos para regalo. </li>
<li>Encontrar el juguete que cumpla con las especificaciones del deseo del niño.</li>
<li>Repartir el resto de los juguetes hasta que no queden. Asegurarse que todos los niños tengan como mínimo 1 regalo, luego 2 y luego tres. Si los juguetes no alcanzan, no importa. Si sobran, tampoco. Pero reparta de tal forma que pueda darles a todos los niños la posibilidad de tener 2 regalos antes de que alguien tenga 3. Un regalo no se puede dar 2 veces, así que asuma que si dos niños piden el mismo juguete, solo el primer niño lo obtendrá. Si un niño se queda sin regalo de deseos, entonces debes omitirlo y, cuando estés entregando el segundo regalo, darle dos.</li>
<li>Recomendación: Use listas dinámicas para ahorrarse problemas.</li>
<li>Recomendación: Haga una función PuedeRegalar() que pueda devolver si el juguete se puede regalar que varíe según el tipo de juguete.</li>
<li>Al final, imprima todos los niños y los juguetes que se les regalarán.</li>