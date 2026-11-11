# Ayudantía 06 — Herencia, Interfaces, Arquitectura y Patrones: Plants vs Zombies

<img align="right" width=220px alt="Plants vs Zombies" src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExbzVwYzJ5OHV1dHVnZGVjNW85cHRqaG1wMHY1YnV5bXVxeHNkeHBoYyZlcD12MV9naWZzX3NlYXJjaCZjdD1n/KvmczTEzQjXHemSDBM/giphy.gif">

Un día, estando aburrido, se te ocurre recrear un juego de cuando eras pequeño, específicamente Plantas vs Zombies.

Como no sabes por donde empezar, se te ocurre hacer el **almanaque**: ese catálogo donde estaban registradas todas las plantas con su costo en soles, su tiempo de recarga y sus habilidades y descripción.

Para organizarte mejor, decides hacer un sistema en Java, el cual debe ser capaz de:

- Cargar el catálogo de plantas desde un archivo.
- Gestionar distintos tipos de plantas, cada una con su comportamiento.
- Mostrar la ficha de cada planta (que depende de qué tipo de planta sea).
- Simular un turno de partida.
- Dejar que el jugador plante en su jardín gastando soles.
- Obtener estadísticas globales del jardín.

## Los tipos de plantas

Todas las plantas comparten cosas en común: tienen un **nombre**, un **costo** en soles y un **tiempo de recarga**. Pero según su función, se dividen en **cuatro tipos**:

<ul>
<li><b>Productoras de soles</b>: no pelean, su trabajo es producir soles cada cierto tiempo para que puedas comprar más plantas.</li>
<li><b>De ataque</b>: disparan a los zombies. Cada una hace un daño específico y tiene una habilidad especial.</li>
<li><b>De defensa</b>: no producen soles ni atacan, solo tienen muchísima vida para bloquear el avance de los zombies.</li>
<li><b>De un solo uso</b>: se activan una única vez, hacen un gran daño con su habilidad especial y desaparecen.</li>
</ul>

## Las interfaces

Debes crear **dos contratos** (interfaces) que solo firman las plantas que corresponda:

- **`Productor`**: obliga a la planta a **producir soles cada cierto tiempo**. Solo las productoras la implementan. Debe permitir saber *cuántos* soles produce y *cada cuánto* (intervalo).
- **`Atacante`**: es el contrato de las plantas que **atacan**. Debe especificar su **ataque** (el daño que hace) y su **habilidad especial**. La implementan las plantas de ataque y las de un solo uso.

## plantas.txt

El catálogo se encuentra en el archivo **`plantas.txt`**, con el siguiente formato:

```
tipo;nombre;costo;recarga;parametro;extra
```

Donde:
- **tipo**: `productora`, `ataque`, `defensa` o `unuso`.
- **nombre**: nombre de la planta (Girasol, Lanzaguisantes, Nuez, ...).
- **costo**: soles que cuesta plantarla.
- **recarga**: tiempo de recarga en segundos.
- **parametro** y **extra**: dependen del tipo de planta

| tipo | parametro | extra |
|------|-----------|-------|
| `productora` | soles que produce por ciclo | intervalo de producción (seg) |
| `ataque` | daño por disparo | habilidad especial |
| `defensa` | vida total | defensa extra |
| `unuso` | daño del efecto al activarse | casillas de ataque |

Ejemplo:
```
productora;Girasol;50;7;25;24
ataque;Lanzaguisantes;100;7;20;disparo simple
defensa;Nuez cascarrabias;125;50;600;no se puede saltar por encima
unuso;Petacereza;150;50;90;3x3 casillas
```

## El sistema 

El programa debe ofrecer un menú con al menos las siguientes opciones:

1. **Ver almanaque completo** — muestra una lista con cada planta del catálogo.
2. **Consultar una planta por nombre** — el usuario escribe un nombre y se muestra su ficha detallada.
3. **Plantar en el jardín** — el usuario elige plantas (por nombre) para agregarlas a su jardín. Se debe descontar el costo de un banco de soles. Si no alcanzan los soles, no se puede plantar.
4. **Simular un turno** — recorre el jardín:
   - Las plantas que son `Productor` **producen soles** (que se suman al banco).
   - Las plantas que son `Atacante` ejecutan su **ataque** y muestran su **habilidad especial**.
5. **Ver estadísticas del jardín** — muestra estadísticas globales (ver consideraciones).
0. **Salir.**

## Consideraciones

### Arquitectura
Se debe utilizar una arquitectura de software adecuada:
- Un orden en paquetes de **Dominio**, **Lógica** y **Visitor**.
- En **Lógica**: una interfaz **`Sistema`**, su implementación **`SistemaImpl`** y una clase **`App`**.
- La **App** solo se comunica con el `Sistema` (nunca crea plantas ni recorre listas), solamente pide datos y muestra por consola.

### Estadísticas
1. **Costo total** en soles de las plantas plantadas.
2. **Producción total de soles por ciclo**.
3. **Daño total** disponible en el jardín (solo suman las de ataque y las de un solo uso).
4. **Defensa total** del jardín.

### Otros
- Empiezas con 100 soles.
- Las plantas de un solo uso desaparecen del jardín una vez simulado el turno.
- No es necesario simular una grilla con las posiciones de cada planta, una única colección funciona.
- **DEBES** aplicar Programación Orientada a Objetos, una Arquitectura correspondiente, Herencia e Interfaces, y los patrones de diseño Singleton, Factory y Visitor.
