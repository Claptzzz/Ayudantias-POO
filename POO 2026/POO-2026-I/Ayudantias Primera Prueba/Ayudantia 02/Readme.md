<h1> Ayudantía 02 </h1>


<h2>Ejercicio 01</h2>

<img align="right" width=100px alt="Unicorn" src="https://media1.tenor.com/m/1y8zDc-ll-EAAAAd/3d-saul-saul-goodman.gif" />

<p>Saul Goodman es un abogado muy profesional y ha dedicado (casi) toda su vida a estudiar, además es fanático de la moda y de vestirse bien, pero tiene un serio problema: Es muy desordenado.</p>

<p>El tenía toda su ropa mezclada una con otra, así que un día que tuvo libre se dedicó a ordenarla en tres muebles, de forma que quedó seccionada de la siguiente manera: </p>

<ul>
<li>En el closet guardó todos sus trajes colgados uno al lado del otro, donde entran 10 trajes en total</li>
<li>Sus camisas las guardó en una cómoda de 9 cajones (3x3), donde además puede guardar 2 camisas en cada cajón <b>(una atrás de la otra)</b></li>
<li>Su calzado lo guardó en un portazapatos que consta de 4 filas, de tal manera que puede guardar 2 pares de zapatos en cada fila</li>
</ul>

<p>Mientras ordenaba se dió cuenta que tenía mucha ropa parecida entre sí, por lo que decidió quedarse con solamente un color de cada prenda y anotar en un archivo llamado <b>ropa.txt</b> todas las posiciones de su ropa junto a su color.</p>
<p>El archivo tiene la siguiente estructura: <b>prenda, x, y (si corresponde), z (si corresponde), color</b> </p>

**Ejemplo**
```
traje,0,Gris Espacial
traje,4,Azul Eléctrico
traje,9,Rojo Salmon
camisa,0,0,0,Blanca
camisa,0,1,1,Celeste
camisa,1,2,0,Rosada
camisa,2,2,1,Rayas Amarillas
zapato,0,0,Café Cuero
zapato,1,1,Negro Charol
zapato,3,0,Gris Oxford
```


<p>Finalmente, para mantener el orden, te pidió a ti que lo ayudes con un programa que muestre un menú con 5 opciones: </p>

<ol>
<li>Cargar el archivo</li>
<li>Consultar por el color de una prenda, pidiendo el tipo de prenda y las posición por teclado</li>
<li>Agregar una nueva prenda (No se puede agregar en una posición ocupada ni con un color repetido)</li>
<li>Mostrar la posición de los espacios vacíos</li>
<li>Salir</li>
</ol>

<h3>CONSIDERACIONES</h3>
<ul>
<li>No se deben poder consultar sobre las prendas si no hay ningún archivo cargado</li>
<li>Utiliza ciclos y try/catch para el control de error, ¡el programa no debería caerse!</li>
<li>Utiliza funciones para hacer las opciones del menú</li>
</ul>

<details>
  <summary>Haz clic para ver una pista</summary>
  <ul>
  <li>El closet es una lista!</li>
  <li>La cómoda es un cubo!</li>
  <li>El portazapatos es una matriz!</li>
  </ul>
</details>

<h2>Ejercicio 02</h2>
