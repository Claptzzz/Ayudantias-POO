# Ayudantía 2

## Ejercicio 1 - Sopa de Letras

Renatito es fanático de las **sopas de letras**, tanto que está todo el día creando nuevos tableros y anotando las palabras que esconde en una agenda, esperando el momento en el que se olvide de el orden de sus sopas y poder jugarlas como si el no las hubiese creado.

Un día cualquiera, se da cuenta de que ya puede jugar sus sopas así que se dirige emocionado a revisar sus apuntes, pero hay un problema:

Todas sus sopas de letras y las listas de palabras asociadas a cada una están completamente mezcladas, incluso con palabras que no puso en ninguno de sus juegos.

Ahí es donde se da cuenta de que te tiene a ti, estudiante de POO, por lo que te pide ayuda para que desarrolles un programa en Java capaz de:

<li>Obtener las sopas de letras de un archivo llamado *sopas.txt*</li>
<li>Obtener las listas de palabras de un archivo llamado *agenda.txt*</li>
<li>Por cada palabra, revisar e imprimir por pantalla a que sopa de letras pertenece o si, de lo contrario, no pertenece a ninguna</li>

### Formato de Archivos
#### sopas.txt
```
X //Cantidad de sopas de letras
NxM //Tamaño de la sopa de letras, donde N = filas y M = columnas
a,b,c,... 
a,b,c,...
... //Un total de N filas, con M columnas cada una, representando a la sopa de letras.
N2xM2 //Siguiente sopa de letras...
```

#### agenda.txt
```
p1 //Varias palabras que pueden, o no, estar en una sopa de letras cualquiera
p2
...
```

### Consideraciones
- Solo se considerará una palabra si está hacía abajo (↓) o hacía la derecha (→)
- No habrán más de 10 sopas de letras
- N <= 20 ; M <= 20
- No habrán más de 100 palabras en total
- No se puede utilizar POO. 
- Debes utilizar vectores con tamaño definido, no listas ni ninguna librería de colecciones.
- Pista: Empieza preguntandote: ¿Cómo almacenarás las sopas de letras? ¿Debes crear 10 matrices diferentes? (No).

### Más????
Renatito, luego de ver tus habilidades, te pidió si puedes hacer un menú interactivo que permita:
- Ver las sopas de letras, junto a las palabras que le corresponden.
- Anotar que palabras ha ido encontrando por cada una de las sopas de letas.
- Ver el porcentaje de avance en una sopa de letras específica. 

#### Consideracioenes 2.0
- El menú debe funcionar hasta que se seleccione una opción de salir.
- Debe haber un control de error tanto en las opciones, como si en no existe una palabra específica dentro de la sopa de letras.