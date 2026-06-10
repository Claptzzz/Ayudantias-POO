# Ayudantía 11 — Patrones de Diseño: Spotify

Spotify se encuentra en una crisis, un ingeniero novato subió su código a la plataforma sin darse cuenta que sobreescribió todo lo que había en ella. Luego de despedirlo, te contrataron a ti, la única persona capaz de solucionar el problema.

El código que subió el novato es completamente funcional, pero es un desastre arquitectónicamente. Tiene todo mezclado en unas pocas clases, está lleno de if/else y variables auxiliares, y si modificas una pequeña parte, todo puede explotar...

Tu misión es reconstruir el sistema ya existente, pero aplicando todos tus conocimientos de arquitectura de software: Los 8 patrones de diseño y la organización por paquetes, interfaces y herencia.

Además, el sistema debe ser capaz de:

- Cargar el catálogo de contenido desde un archivo.
- Importar contenido desde Apple Music (que usa un formato distinto).
- Gestionar canciones y podcasts.
- Reproducir contenido y notificar a varios subsistemas.
- Obtener recomendaciones con distintos algoritmos.
- Crear playlists y aplicarles modos (shuffle, filtros, repeat...).
- Generar estadísticas globales del catálogo.
- Garantizar que exista una única plataforma Spotify en el sistema.

El catálogo se encuentra en el archivo "catalogo.txt", el cual tiene el siguiente formato:
```
tipo;titulo;artista;genero;duracion;rating;explicito
```
Donde:
- **tipo**: cancion o podcast.
- **titulo**: nombre del contenido.
- **artista**: para canciones, el cantante o banda. Para podcasts, el host.
- **genero**: rock, pop, hip-hop, historia, comedia, etc.
- **duracion**:
  - canciones: segundos.
  - podcasts: cantidad de episodios.
- **rating**: puntuación entre 1 y 5.
- **explicito**: `true` o `false`.

Ejemplo:
```
cancion;Bohemian Rhapsody;Queen;Rock;360;5;false
podcast;Tomás va a morir;Estudios Neverland;Comedia;420;4;true
cancion;Money Trees;Kendrick Lamar;Hip-Hop;360;5;true
```

Por otro lado, está el contenido de Apple Music en el archivo "apple_music.txt", que tiene el siguiente formato:
```
[SONG]|title|artist|category|minutes|stars|explicit
[EPISODE]|title|host|category|episodes|stars|explicit
```

Ojo: este archivo viene de un sistema externo (Apple Music), por lo que:
- Usa otro separador.
- Se identifican los tipos de forma diferente.
- explicito está en el formato 0 o 1 (no true o false).
- La duración de las canciones viene en minutos (pueden ser decimales).
- Para leer correctamente el "|" se debe hacer de la forma: .split("\\\\|").

Ejemplo:
```
[SONG]|Hotel California|Eagles|Classic Rock|6.5|4.8|0
[EPISODE]|The Daily|The New York Times|News|2100|4.3|0
[SONG]|Lose Yourself|Eminem|Rap|5.2|4.9|1
```
El programa además debe ofrecer un menú con las siguientes opciones:

1. **Mostrar catálogo completo** (canciones y podcasts).
2. **Importar catálogo desde Apple Music** y agregarlo al catálogo principal.
3. **Reproducir contenido** (por título). Esto debe **notificar** a varios subsistemas internos.
4. **Obtener recomendaciones** - el usuario elige el algoritmo **(Ver consideraciones)**.
5. **Mostrar estadísticas generales** del catálogo **(Ver consideraciones)**.
6. **Crear playlist** a partir de contenidos del catálogo.
7. **Aplicar modos a una playlist y reproducirla** (shuffle, solo favoritas, filtro explicit, repeat) **(Ver consideraciones)**.
8. **Ver trending** (canciones más reproducidas durante la sesión).
9. **Ver historial** de reproducciones.
0. **Salir.**

## Consideraciones
El sistema debe cumplir con:

Recomendaciones:
1. **Por rating**: muestra los top X contenidos mejor evaluados.
2. **Por género**: solicita un género y recomienda contenido de ese tipo.
3. **Aleatoria**: X cantidad de contenido al azar.

Estadísticas mínimas (diferenciar por canción / podcast)
1. Rating promedio de canciones.
2. Rating promedio de podcasts.
3. Duración promedio en segundos de las canciones.
4. Episodios promedio de los podcasts.
5. Género más frecuente para cada tipo.

Modos de playlist
1. **AlAzar**: Ordena toda la playlist de manera Random.
2. **SoloFavoritas**: filtra y deja solo el contenido con rating >= 4.
3. **FiltroExplicito**: quita el contenido marcado como explícito.
4. **ConRepeat**: se repite la playlist X veces seguidas.

Debe poder aplicarse más de un modo: Una playlist que tenga solo mis canciones favoritas, que no sean explicitas, 3 veces.

Notificar al reproducir un contenido:
1. **HistorialReproduccion**: guarda el contenido reproducido con su orden.
2. **MasReproducidos**: lleva cuenta de cuántas veces se ha reproducido un contenido específico.
3. **ContadorArtista**: lleva cuenta de cuántas veces se han reproducido contenido de cada artista.

Arquitectura:
* Se debe utilizar una arquitectura de software adecuada:
    * Paquetes separados de **Dominio** y **Lógica**.
    * Una interfaz **Sistema**, un **SistemaImpl** y una clase **App**.
    * Paquetes adicionales para los patrones Strategy, Visitor, Decorator, Adapter y Observer. Otro patrones (como el Factory) pueden ubicarse en alguno de los paquetes ya mencionados.
* Se deben utilizar los 8 patrones vistos en clase.

Pistas: 
1. **Singleton** — Debe existir una única plataforma Spotify.
2. **Factory Method** — La creación de los objetos siempre debe delegarse. No pueden estar en el Sistema ni en la App.
3. **Strategy** — Se aplican diferentes algoritmos para un mismo objetivo.
4. **Visitor** — Las estadísticas dependen del objeto: las canciones tienen duracion en segundos y los podcast cantidad de episodios.
5. **Adapter** — Apple Music usa otro formato. Tu sistema no puede entender directamente esos datos, se deben traducir.
6. **Observer** — Cuando se reproduce un contenido, se debe informar a otros subsistemas, sin que la app se entere.
7. **Decorator** — Los modos de la playlist se pueden aplicar uno encima de otro.
8. **Facade** — El Sistema debe ocultarle el trabajo y la lógica a la App.