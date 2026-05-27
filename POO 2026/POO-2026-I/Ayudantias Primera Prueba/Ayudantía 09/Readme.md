# Ayudantía 09

# Ejercicio 01

<img align="right" width=200px alt="Unicorn" src="https://media1.tenor.com/m/e2Abg24uiv4AAAAC/make-it-rain-money-money-make-it-rain.gif">


#### Un youtuber del momento decidió hacer un sorteo. Las primeras cinco personas que comenten se van a llevar un premio de 20 lucas. Sin embargo, hay un premio extra: Una de las 5 personas se va a ganar un premio de 100 lucas en vez de las 20. Esta persona en específico debe seguir a la cuenta, debe haber comentado la palabra “yo” y debe haber colocado el emoji del trébol de 4 hojas en su comentario. 
#### Se le pide que haga un código donde el youtuber que hizo el sorteo pueda ingresar los datos de la persona para poder contactarla, el nombre de usuario y su comentario. Además, el código debe elegir a un solo ganador, debe revisar que esa persona esté siguiendo la cuenta, guardarlo aparte y revisar si su comentario cumple con los requisitos. Para esto, use el código String.contains(“texto a contener”) si es que no lo conoce.

### Ejemplo de comentarios válidos para ganar:
```
Yoooo porfi lo necesito para mis medicamentos :trébolcuatrohojas:
YO PLZ :trébolcuatrohojas:
:trébolcuatrohojas: :trébolcuatrohojas: yo
```

### Ejemplo de comentario inválido: 
```
Ioooo plzz :caritafeliz:
:fuego:
```
#### Recomendaciones:
<li> El youtuber le pide que se asegure que solo pueda existir un solo ganador, que el código no permita que, por error, se cree otro. Para esto, use el patrón Singleton. </li>
<li> Para la creación de los usuarios, use el patrón Factory. </li>
<li> Todos los datos deben ser ingresados por el usuario. </li>
<li> El youtuber le indica que en el caso de que un comentario no cumpla, que siga buscando por todos los ganadores. Si ninguno de los 5 comentarios cumple con los requerimientos, entonces nadie se lleva las 100 lucas y los 5 solo se ganan 20. </li>
<li> Para la elección del ganador, importe java.util.Random </li>

####
####

# Ejercicio 02

<img align="right" width=200px alt="Unicorn" src="https://media1.tenor.com/m/R4ESxPqwu-8AAAAC/android-iphone.gif">

#### Dentro de una fábrica de celulares, se encuentran dos marcas luchando por el título de “celular más comprado del año”. Los contrincantes son: Samsung P67 con la última tecnología de creación de hologramas y el iPhone 103, con una IA integrada para hablar en tiempo real como si fuera una persona. 
#### Todos asumen que ambos celulares se venden con la misma velocidad, pero nadie está contando los números de forma lógica, además que el precio puede variar según el país y el color del celular. Por eso se le pide a usted que analice los datos recaudados de múltiples tiendas por el mundo en el archivo ventas.txt

```
Modelo,color,país,ventas,rating de satisfacción en estrellas (1-5)
```

#### Se le da las siguientes especificaciones:

#### El Samsung P67 tiene dos colores: blanco y gris. El precio base de este modelo es de 1500 dólares. Si el modelo es blanco, el precio es el mismo. Si es gris, el precio se multiplica x1.1. Todos los países aceptaron el precio, excepto por Estados Unidos (x1.2), Taiwan (x1.11) y España (x1.25). Calcule primero sacando el valor del modelo según su color y luego según su país.
#### El iPhone 103 tiene tres colores: Blanco, azul y rosado. El precio base de este modelo es de 1700 dólares. Si el modelo es blanco, el precio es el mismo. Si es azul o rosado, el precio se multiplica por x1.23. Todos los países aceptaron el precio, excepto China (x1.20), Venezuela (x1.57) e India (x0.99).
#### A usted se le pide la cantidad de ventas totales y el dinero total recaudado por cada uno de estos modelos, incluyendo un detalle de qué color se vendió más, qué país fue más popular para cada modelo y cuál de los dos modelos vendió más celulares en todo el mundo. Además, se le pide el modelo con el mejor rating de satisfacción entre todas las tiendas.

#### Recomendaciones:
<li> Use un visitor diferente para el cálculo de las ventas totales, para el dinero recaudado y para el cálculo de los ratings totales, esto para ordenar el código de mejor forma. Coloque las estadísticas extras (color y país) en uno de estos visitors, el que cree que sea mejor. </li>
<li> El precio de cada país ya está hecho en dólares, por lo que no es necesaria hacer ninguna conversión. Es recomendado que el celular ya haya calculado su propio precio antes de ser visitado para hacer el trabajo de visitor más fácil. </li>
<li> Puede hacer una clase padre para ambos celulares (ya que ambos son celulares), pero lo importante es que el celular en si no contenga ningún dato fuera de sí. Por ejemplo, no tiene por qué saber cuántos teléfonos se han vendido en total. </li>
<li> Si quiere, implemente un factory para la creación de celulares.  </li>