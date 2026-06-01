# Ayudantía 10 - Patrones 2

# Netflix!!!
<img align="right" width=200px alt="Unicorn" src="https://media.tenor.com/ehm8MIrmguoAAAAi/drama-popcorn.gif">

Netflix está atravesando una fuerte competencia contra otras plataformas de streaming y necesita mejorar su sistema de recomendaciones, para generar una mayor adicción y que los consumidores pasen horas y horas procrastinando en su app, en vez de hacer cosas productivas (como sus talleres de POO).

Es por ello, que te han contratado a ti para esta difícil misión.

Durante años, las películas y series se han agregado manualmente al catálogo, pero ahora el sistema debe ser capaz de:
<ul>
<li>Cargar contenido desde un archivo.</li>
<li>Gestionar distintos tipos de contenido audiovisual.</li>
<li>Obtener estadísticas globales del catálogo.</li>
<li>Garantizar que exista una única plataforma Netflix funcionando en el sistema.</li>
</ul>

Para ello, se tiene el archivo **catalogo.txt** con el siguiente formato:
```
tipo;título;género;duración;rating
```
#### Donde:
* tipo: puede ser pelicula o serie.
* título: nombre del contenido.
* género: acción, drama, ciencia ficción, comedia, etc.
* duración: <br>
        películas: minutos. <br>
        series: cantidad de episodios.
* rating: puntuación promedio entre 1 y 5.

Desarrolla una app que permita:
1. Mostrar catálogo completo (series y películas).
2. Obtener recomendaciones: El usuario podrá elegir un algoritmo de recomendación para visualizar contenido sugerido.
3. Mostrar estadísticas generales.

## Consideraciones:
* Ten en cuenta una clase padre para película y serie.  
* Siempre es necesario una correcta separación de App/Sistema.
* Es necesario que utilices *todos* los patrones vistos en clase (Factory, Singleton, Visitor, Strategy). Para ello guíate por el enunciado y las siguientes pistas:
1. La creación de los objetos siempre debe delegarse! Nunca puede estar directamente en el sistema; identifica los objetos que trabajaremos en el enunciado y utiliza unos de los patrones para su creación.
2. Debe existir una única plataforma, puedes delegarla a una clase en concreto ("Netflix") o utilizar *SistemaImpl* como dicha plataforma, ambos enfoques se considerarán correctos.
3. Cuando hablamos de "diferentes algoritmos" para un mismo fin, siempre se trata del mismo patrón.
4. Las estadísticas dependen del objeto!

* Para las recomendaciones de películas/series ten en cuenta las siguientes:
1. Por rating: Muestra los contenidos mejor evaluados.
2. Por género: Solicita un género y recomienda contenidos de ese tipo.
3. Aleatoria: Sugiere contenidos al azar.

* Estadísticas mínimas (recuerda diferenciar por película/serie):
1. Rating promedio de películas.
2. Rating promedio de series.
3. Minutos promedio de las películas.
4. Cantidad de capítulos en promedio para las series.
5. Género más frecuente para cada uno.