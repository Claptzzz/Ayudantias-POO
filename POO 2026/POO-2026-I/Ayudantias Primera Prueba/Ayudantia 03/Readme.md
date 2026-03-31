# Ayudantía 03

## Ejercicio 01

<img align="right" width=200px alt="Unicorn" src="https://media1.tenor.com/m/mIxfmixcENIAAAAd/palomitas-eating-popcorn.gif">

#### Tú y tu persona especial deciden tener una maratón de películas que nunca han visto. Ambos anotan 50 películas y luego las juntan en un archivo llamado "peliculas.txt" con el siguiente formato:

```
Nombre,Duración (min),Género,IMDb,Rotten Tomatoes (%)
The Shawshank Redemption,142,Drama,9.3,91
The Godfather,175,Crimen,9.2,98
The Dark Knight,152,Acción,9.0,94
Pulp Fiction,154,Crimen,8.9,92
```

#### El tema es que nica van a lograr terminar 100 películas en una sola noche. Ambos llegan a la conclusión de que la maratón se va a tener que contener en solo 4 películas para poder verlas todas. Pero, al fin y al cabo, pueden hacer infinitas piyamadas hasta terminar todas las películas. Se proponen mantener un orden haciendo un código que guarde las películas que ya han visto, junto a sus ratings dentro de IMDb y Rotten Tomatoes. Por lo tanto, el código resultante debe ser capaz de:

<li>Tener un menú que indique en qué parte de la noche están (Inicio o final) y poder salir si ya se vieron todas las películas. </li>
<li>Si están al inicio, debe buscar las 4 películas con los mejores ratings combinados entre IMDb y Rotten Tomatoes (O sea, dar un rating en estrellas O en porcentaje que sea el promedio entre ambos) y elegirlos para la noche.</li>
<li>Un submenú donde pueden consultar todos los ratings, incluyendo: El de IMDb, el de Rotten Tomatoes, el combinado de ambos y el que le dieron ustedes a películas que ya vieron.</li>
<li>Si están al final, debe marcar que las películas elegidas fueron vistas. </li>

#### Desafíos extra:
<ol>
<li>Añadir una variable donde tú y tu persona especial guarden el rating en 10 estrellas que le dan a la película cada uno.</li>
<li>Hacer un juego en el menú donde se elijan 5 películas de forma aleatoria y ambos adivinen qué rating tienen combinado entre IMDb y Rotten Tomatoes. Quien se acerque más gana. Use el siguiente código:  </li>

```
import java.util.Random;

Random rand = new Random();
int num = rand.nextInt(100);
```
<li>Encontrar la forma de añadir al txt las películas que ya han sido vistas para poder parar el código tras cada piyamada completada. Use el siguiente código: </li>
</ol>

```
try (FileWriter writer = new FileWriter("peliculas.txt", false)) {
    writer.write(peliculas a agregar);
    System.out.println("Peliculas añadidas.");
} catch (IOException e) {
    System.out.println("Hubo un error leyendo el archivo.");
}
```
#### Recomendaciones: 
<li>Puedes ordenar la lista de películas para evitar tener que estar constantemente buscando las películas con mejores ratings. </li>
<li>Manten una verificación de errores donde puedas. El código no debería caerse o terminar previo a elegir la opción "salir"</li>
<li>Usa a tu favor los tamaños entregados de películas</li>