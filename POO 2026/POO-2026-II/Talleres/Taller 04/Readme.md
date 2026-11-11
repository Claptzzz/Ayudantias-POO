# Taller 04 — Reproductor de Música

**II Semestre - 2026**
**ITI - ICCI - ICI**

**Docentes:**
- Alejandro Paolini Godoy (C1)
- Cristhian Rabi Reyes (C2)

**Ayudantes:**
- Nicolás Rojas Bustos (C1)
- Martín Droguett Robledo (C2)

## Contexto: SPOOtify

A Nacho se le acabó el plan premium de **SPOOtify** y ahora lo interrumpe un anuncio cada dos canciones. Cansado de esto, te escribe a ti para que lo ayuden a hacer algo, por lo que deciden construir **su propio reproductor de música local** en Java.

La idea es simple: un reproductor con interfaz gráfica que lea toda su biblioteca desde un archivo de texto, les permita **armar sus propias playlists**, **reproducir canciones**, y como buenos fanáticos del *Wrapped* de fin de año, quieren una sección de **estadísticas** que les diga cuánto tiempo perdieron escuchando música en vez de estudiar.

Además, Nacho es adicto a los **podcasts**, así que el reproductor también debe poder reproducirlos, aunque con reglas distintas a las de las canciones.

Por último, Nacho jura que tiene oído de productor musical, así que quiere poder **ecualizar** lo que escucha y ver cómo se **mueve el sonido** en pantalla mientras suena.

Tu misión es construir ese reproductor.

OBLIGATORIO: **Los audios subidos al repositorio deben ser de Dominio Público, es decir, no poseer Copyright (Derechos de autor). Por lo que pueden ser audios propios, covers sin Copyright, parodias, etc.**

## Archivos

### `biblioteca.txt`

Contiene toda la biblioteca (canciones y episodios de podcast). Cada línea representa un audio y termina con la **ruta de su archivo de sonido** y la **ruta de su portada**. El formato depende del **tipo**:

```
tipo;...atributos...;rutaSonido;rutaPortada
```

| tipo | atributos propios |
|------|-------------------|
| `cancion` | `titulo;artista;genero` |
| `podcast` | `tituloEpisodio;nombrePodcast;numeroEpisodio` |

Ejemplo:

```texto
cancion;Blinding Lights;The Weeknd;Pop;sonidos/blinding_lights.wav;portadas/blinding_lights.png
cancion;Bohemian Rhapsody;Queen;Rock;sonidos/bohemian.wav;portadas/bohemian.png
cancion;Algo me gusta de ti;Wisin y Yandel;Reggaeton;sonidos/algo_me_gusta_de_ti.wav;portadas/algo_me_gusta_de_ti.png
podcast;Cap 1 - Herencia;Vidas POO;1;sonidos/poo_e1.wav;portadas/vidaspoo.png
podcast;Cap 2 - Interfaces;Vidas POO;2;sonidos/poo_e2.wav;portadas/vidaspoo.png
podcast;Cap 3 - Patrones;Vidas POO;3;sonidos/poo_e3.wav;portadas/vidaspoo.png
```

> **Importante:** los archivos de sonido (`sonidos/`) y las portadas (`portadas/`), junto con sus rutas en el `.txt`, se agregan y modifican **manualmente sobre las carpetas del proyecto**. Por lo tanto **NO es necesario** modificar los archivos de texto.

## Requerimientos

Se debe construir una **GUI totalmente interactiva** compuesta por varios paneles/pestañas. Como mínimo:

### 1. Biblioteca

* Lista todas las canciones y podcasts cargados desde `biblioteca.txt`.
* Debe permitir **buscar/filtrar** por título, artista o género.
* Desde aquí se puede reproducir cualquier audio (canción o episodio) y agregar canciones a una playlist.

### 2. Creador de Playlists

* Permite **crear una playlist** seleccionando canciones desde el listado de la biblioteca.
* Se pueden manejar **varias playlists** (crear, nombrar, ver su contenido y reproducirla).
* **Los podcasts NO se pueden agregar a una playlist** (solo canciones).

### 3. Reproductor

Mientras un audio se reproduce, debe:

* Mostrar la **portada** del audio actual como imagen.
* Mostrar, junto a la portada, un **visualizador de audio**: un gráfico 2D animado de los **decibeles (dB)** del audio con respecto al **tiempo**, al estilo de una onda en movimiento (ver la sección *Manejo del visualizador*).
  * El gráfico debe avanzar junto con la reproducción, quedar detenido al pausar y reiniciarse al cambiar de audio.
* Mostrar una **barra de progreso** que avance según el tiempo transcurrido con respecto a la **duración total** del audio.
* Ofrecer los controles: **Pausar/Reanudar**, **Siguiente (⏭)** y **Anterior (⏮)**.
* Permitir elegir el **modo de reproducción** de la playlist actual:
  * **Normal:** reproduce las canciones en el orden de la playlist.
  * **Aleatorio:** reproduce las canciones en un orden al azar.
  * **Según duración:** reproduce las canciones ordenadas por su duración (de la más corta a la más larga).
  * Estos cambios solamente se deben aplicar sobre las canciones de la playlist que **aún no se reproducen**.
* Mostrar información del audio actual (título, artista/podcast).

### 4. Ecualizador

Una pestaña o panel para ecualizar lo que se está escuchando. El ecualizador trabaja con **3 bandas**: **graves**, **medios** y **agudos**. Debe permitir elegir entre los siguientes **presets**, donde cada uno indica por cuánto se **multiplica** cada banda (`1.0` = sin cambios, `2.0` = el doble, `0.5` = la mitad):

| Preset | Graves | Medios | Agudos |
|--------|:------:|:------:|:------:|
| Flat | 1.0 | 1.0 | 1.0 |
| Bass Boost | 2.0 | 1.0 | 1.0 |
| High Boost | 1.0 | 1.0 | 2.0 |
| Vocal | 0.6 | 1.6 | 0.8 |
| Clásica | 1.2 | 1.0 | 1.5 |
| Jazz | 1.4 | 0.8 | 1.2 |
| Pop | 0.8 | 1.4 | 1.2 |
| Rock | 1.8 | 0.7 | 1.6 |

* Al abrir el programa, el preset por defecto es **Flat** (el audio suena sin cambios).
* Cada preset es una **forma distinta de procesar el audio**, y el reproductor debe poder **intercambiarlos en cualquier momento**, sin importar cuál esté activo.
* Se debe mostrar de forma visual el valor de cada banda del preset seleccionado (por ejemplo, con 3 `JSlider` verticales o barras dibujadas).
* Al cambiar de preset, el cambio se debe **escuchar sobre el audio actual sin reiniciarlo** desde el principio.
* El preset elegido se mantiene para los siguientes audios (canciones y podcasts) hasta que se cambie.

Ojo: Nacho ya está pensando en agregar más presets en el futuro, incluso algunos que no funcionan solo multiplicando bandas (por ejemplo, un modo *Karaoke* que quite la voz de la canción, o un modo *Lo-Fi*). Por lo tanto, agregar un preset nuevo **no debería obligar a modificar** la lógica del reproductor. *(No es necesario implementar estos modos extra.)*

### 5. Wrapped (Estadísticas)

Una pestaña estilo *"Spotify Wrapped"* que muestre, **como mínimo**:

1. **Minutos reproducidos** en total.
2. **Canción más escuchada.**
3. **Canción más saltada.**

Y además **dos estadísticas a elección** de esta lista:

* Artista más escuchado.
* Género favorito (el más reproducido).
* Cantidad de canciones distintas reproducidas.
* Playlist más reproducida.
* Podcast más escuchado.
* Tu "Top 3" de canciones.
* Tiempo total en podcasts vs. en canciones.

Si hay un empate entre diferentes audios, se debe escoger la primera en aparecer en los cálculos.

### Podcasts

Los podcasts tienen un comportamiento especial:

* Se pueden **reproducir** desde la biblioteca, pero **no** se pueden agregar a una playlist.
* Al **terminar un episodio**, el reproductor debe pasar **automáticamente al siguiente episodio** de ese mismo podcast.
* Al terminar el **último** episodio, debe **reiniciar desde el primero**.
* Los episodios deben modelarse mediante **herencia** (un episodio es también algo reproducible). La forma en que todos los episodios pertenecen a un mismo podcast **queda a tu elección** (por ejemplo, una clase `Podcast` que agrupe sus episodios, o un atributo que los relacione). Lo importante es que la **lógica y la arquitectura sean coherentes**.

## Aclaraciones

* **Tipo de archivo de sonido recomendado: `.wav` (PCM).** Java reproduce WAV/AIFF/AU de forma **nativa** con la librería estándar. Los `.mp3` **no** son soportados sin librerías externas, así que se pide trabajar con **`.wav`**.
* Para el **ecualizador** y el **visualizador** se asume audio `.wav` **PCM de 16 bits** (mono o estéreo, idealmente a 44.1 kHz). Si se carga un audio con otro formato, puede reproducirse sin ecualizar ni graficar, pero **el programa no se puede caer**.
* Las **portadas** deben ser imágenes `.png` o `.jpg`. Si un audio no tiene portada disponible, debe mostrarse una **imagen por defecto** (a elección) sin que se rompa la interfaz.
* Los archivos de sonido y las portadas del `.txt` deben ser **buscados y agregados manualmente** por los estudiantes en sus carpetas.
* La **duración** de cada audio puede obtenerse directamente del archivo de sonido al cargarlo (no es necesario que venga en el `.txt`).
* Debe usar **POO**, **Arquitectura** (separar el `main`/GUI de la lógica del sistema), **Herencia**, **Interfaces** y **GUI**.
* Los archivos de sonido no deben ser obligatoriamente canciones o podcast reales, puede ser cualquier sonido y portada que decidan. **No se aceptarán sonidos ni imágenes inapropiadas (pueden ser memes, pero manteniendo el respeto hacia compañeros, profesores y ayudantes).** En caso de incumplirse esta regla, se evaluará con la **nota mínima (1.0)**.

## Librerías recomendadas

se **permite y recomienda el uso de las siguientes librerías** para este taller:

* **`javax.sound.sampled`** → reproducción de audio. Las clases clave son `AudioSystem`, `AudioInputStream` y `Clip`. Un `Clip` permite `start()`, `stop()`, `setFramePosition(0)` y, muy útil para la barra de progreso, `getMicrosecondLength()` (duración total) y `getMicrosecondPosition()` (posición actual).
* **`javax.sound.sampled.AudioFormat`** → para conocer el formato de cada audio (`getSampleRate()`, `getChannels()`, `getSampleSizeInBits()`, `getFrameSize()`, `isBigEndian()`). Se necesita para el ecualizador y el visualizador.
* **`javax.swing.Timer`** → un temporizador de Swing para **actualizar la barra de progreso y el visualizador** cada cierto tiempo (por ejemplo, cada 30-100 ms) sin congelar la interfaz. *(Ojo: es distinto de `java.util.Timer`.)*
* **`javax.swing.JProgressBar`** → la barra de progreso.
* **`javax.imageio.ImageIO`** + **`java.awt.image.BufferedImage`** → para **cargar las portadas** (ver la sección *Manejo de imágenes*).
* **`java.awt.Graphics2D`** → para **dibujar el visualizador** (`drawLine`, `drawPolyline`, `setStroke`, `setColor`, etc.).
* **`javax.swing.*`** en general (`JFrame`, `JPanel`, `JButton`, `JList`, `JTabbedPane`, etc.) para el resto de la GUI.

> Cualquier **otra** librería externa debe consultarse y ser autorizada por el ayudante antes de usarse.

## Manejo de imágenes (portadas)

Se recomienda trabajar con un **panel de imagen propio**: una clase que **extienda `JPanel`**, lea la imagen con `ImageIO.read(new File(ruta))` hacia un `BufferedImage` y la **dibuje** sobrescribiendo `paintComponent(Graphics g)` con `g.drawImage(...)` ajustada al tamaño del panel.

Deben tratar las excepciones correspondientes.

## Manejo del ecualizador

Java **no** trae un ecualizador listo para usar (el `Clip` solo permite controlar cosas como el volumen o el balance mediante `FloatControl`), por lo que el ecualizador se debe hacer **modificando directamente las muestras del audio**. Se recomienda seguir estos pasos:

1. Leer todos los bytes del `.wav` con `readAllBytes()` del `AudioInputStream` y guardar su `AudioFormat`.
2. Convertir los bytes a muestras. En un `.wav` PCM de 16 bits cada muestra ocupa 2 bytes en *little endian*, y si es estéreo los canales vienen intercalados (izquierdo, derecho, izquierdo, derecho, ...):
   ```java
   short muestra = (short) ((datos[i + 1] << 8) | (datos[i] & 0xFF));
   ```
3. Separar cada muestra en **graves**, **medios** y **agudos**, multiplicar cada parte por el valor del preset y volver a sumarlas (ver más abajo). Si el audio es estéreo, cada canal se procesa por separado.
4. Limitar cada resultado al rango de un `short` (`-32768` a `32767`) para que no se desborde, y volver a convertirlo a bytes.
5. Cargar el audio procesado en el `Clip` con `clip.open(formato, datos, 0, datos.length)`.

Para separar las bandas, la idea es **suavizar** el audio. Un valor que se va acercando de a poco a cada muestra (`suave += k * (x - suave)`) no alcanza a seguir los cambios rápidos del sonido, por lo que con un suavizado **fuerte** solo quedan los **graves**. Con un suavizado **leve** se sigue casi todo el audio menos los cambios más rápidos, y justamente lo que **no** se alcanza a seguir son los **agudos**. Lo que queda entre ambos son los **medios**:

```java
// Se calculan una sola vez (fs = sample rate del audio)
double kFuerte = 1 - Math.exp(-2 * Math.PI * 250 / fs);  // graves: bajo los 250 Hz aprox.
double kLeve = 1 - Math.exp(-2 * Math.PI * 4000 / fs);   // agudos: sobre los 4000 Hz aprox.

// Para cada muestra x (suaveFuerte y suaveLeve parten en 0 y se guardan uno por canal)
suaveFuerte += kFuerte * (x - suaveFuerte);
suaveLeve += kLeve * (x - suaveLeve);

double graves = suaveFuerte;
double agudos = x - suaveLeve;
double medios = x - graves - agudos;

double y = graves * multGraves + medios * multMedios + agudos * multAgudos;
```

Con **Flat** (todo en `1.0`) el audio debe quedar exactamente igual al original, lo que sirve para comprobar que la separación está bien hecha.

Para cambiar de preset mientras suena un audio, se guarda la posición actual con `getMicrosecondPosition()`, se procesa nuevamente el audio **original** con el nuevo preset, se cierra el `Clip` y se vuelve a abrir con los datos nuevos, retomando desde la misma posición con `setMicrosecondPosition(...)`. Ojo si usan un `LineListener` para detectar cuándo termina un audio: al detener el `Clip` para cambiar el preset también se generan eventos, y eso **no** debe hacer que salte al siguiente audio.

## Manejo del visualizador

Al igual que con las portadas, se recomienda una clase propia que **extienda `JPanel`** y dibuje el gráfico sobrescribiendo `paintComponent(Graphics g)`. Para animarlo, se usa un `javax.swing.Timer` que cada cierto tiempo calcule un nuevo valor y llame a `repaint()`.

Para obtener los decibeles del instante que está sonando:

1. Con `clip.getFramePosition()` se obtiene el *frame* actual. Su posición en el arreglo de bytes es `frame * formato.getFrameSize()`.
2. Desde esa posición se toma una ventana pequeña de muestras (por ejemplo, unos 30 ms de audio) y se calcula su valor **RMS** (raíz cuadrada del promedio de las muestras al cuadrado).
3. Se convierte a decibeles con `20 * Math.log10(rms / 32768.0)`. El resultado es **0 dB** en el volumen máximo y se vuelve negativo hacia el silencio, por lo que se recomienda limitarlo a un mínimo (por ejemplo, **-60 dB**).

Cada valor calculado se guarda en un historial (por ejemplo, los últimos 5 segundos) y el panel dibuja ese historial uniendo los puntos, con el **tiempo** en el eje X y los **dB** en el eje Y, de forma que la onda se vaya desplazando a medida que avanza el audio.

Como el audio ya ecualizado queda guardado en memoria, conviene calcular los decibeles sobre esos mismos datos. Así el gráfico también refleja el preset que está sonando.

## Patrones de diseño

Se deben aplicar **obligatoriamente los 4** patrones siguientes, de forma **justificada**:

* **Singleton** 
* **Factory** 
* **Visitor** 
* **Strategy**

## Consideraciones

1. Se engloban todas las consideraciones generales de los talleres <a href="../README.md"> (Click aqui para ver)</a>.
2. Se pueden utilizar todas las librerías vistas en clase, más las indicadas en la sección **Librerías recomendadas**.
3. Se debe documentar todas las clases y métodos, utilizando Javadoc.
4. Se debe entregar el **Diagrama de Clases** en la raíz del repositorio ***EN FORMATO PDF***.
5. Se debe manejar **control de errores** en los inputs y en la carga de archivos/recursos (rutas inexistentes, formatos inválidos, etc.); se probará que el programa **no se caiga** en ninguna circunstancia.
6. El proyecto es en **pareja o individual** (máximo 2 personas).

## Control de Errores (Obligatorio)

El programa **NO se puede caer bajo ninguna circunstancia.** Se probará explícitamente que resista, entre otros:

- Opciones inválidas (Nombres no existentes).
- Archivo (sonidos o imágenes) no inexistentes.
- Bucles de menú que dejen atrapado al usuario (todas las opciones "Volver"/"Salir" deben funcionar).
- Etc...

Si el programa se cae por cualquier razón, se descontarán **20 décimas** de la nota final (Ej: Si tienes un 7, se convierte en 5).

## Importante

1. OBLIGATORIO: **Los audios subidos al repositorio deben ser de Dominio Público, es decir, no poseer Copyright (Derechos de autor). Por lo que pueden ser audios propios, covers sin Copyright, parodias, etc.**
2. La GUI debe ser atractiva visualmente e intuitiva para un usuario cualquiera.
3. Se espera originalidad, donde cada grupo pueda agregar algo representativo que los identifique.
4. No se puede utilizar IA para copiar y pegar, se espera que (si la utilizan) sea como apoyo para entender las librerías a utilizar o similar. Se recomienda fuertemente **no** utilizarla para desarrollar ningún tipo de lógica. Si se detecta uso explícito de IA se evaluará con la nota mínima (1.0).
5. Se probarán con archivos de audio e imágenes propias, y con los archivos subidos por el grupo en el repositorio.

## Fechas

Inicio -> 10/11/2026

Fecha límite -> 11/12/2026

## Contactos
* martin.droguett@alumnos.ucn.cl
* nicolas.rojas11@alumnos.ucn.cl
* Grupo de WhatsApp **(preferido)**

## Pauta de Evaluación

**Puntaje Total Máximo:** 215 puntos

---

### 1. Lectura de Archivos y Recursos (12 puntos)
* **[6 pts] Lectura de `biblioteca.txt`:** Carga correctamente cada línea, separando por `;` e interpretando los atributos según el tipo (`cancion` / `podcast`) sin errores de parseo.
* **[3 pts] Rutas de sonido:** Asocia correctamente cada audio con su archivo `.wav`.
* **[3 pts] Portadas:** Carga correctamente la imagen de portada de cada audio y usa una **imagen por defecto** cuando la ruta no existe.

### 2. Diseño de Software y POO (13 puntos)
* **[5 pts] Herencia:** Existe una clase base/abstracta con subclases. La agrupación de episodios en un podcast está bien modelada.
* **[4 pts] Arquitectura:** Separa claramente **Dominio**, **Lógica**, **GUI**, además de los paquetes asociados a los patrones según corresponda.
* **[4 pts] Encapsulamiento y colecciones:** Atributos privados con métodos de acceso. Uso correcto de colecciones dinámicas (`ArrayList`).

### 3. Patrones de Diseño (32 puntos)

> Deben implementarse **los 4** patrones de diseño vistos en clases de forma correcta y justificada. No se otorga puntaje a patrones forzados o mal aplicados.

* **[8 pts c/u] Singleton, Factory, Visitor, Strategy**.

### 4. Reproductor de Audio (30 puntos)
* **[6 pts] Reproducción:** Reproduce correctamente el archivo de sonido del audio seleccionado.
* **[6 pts] Portada:** Muestra la imagen de portada del audio en reproducción.
* **[6 pts] Barra de progreso:** Avanza de acuerdo al tiempo transcurrido respecto de la duración total del audio.
* **[6 pts] Controles:** Pausar/Reanudar, Siguiente y Anterior funcionan correctamente.
* **[6 pts] Modos de reproducción:** Los tres modos (Normal, Aleatorio y Según duración) funcionan correctamente.

### 5. Ecualizador (20 puntos)
* **[4 pts] Presets:** Están disponibles los 8 presets con los valores indicados en la tabla.
* **[8 pts] Aplicación del preset:** El preset seleccionado modifica realmente el audio (se debe notar la diferencia al escucharlo).
* **[4 pts] Cambio en reproducción:** Al cambiar de preset el audio actual no se reinicia, y el preset se mantiene para los siguientes audios.
* **[4 pts] Bandas:** Se muestra de forma visual el valor de cada banda (graves, medios y agudos) del preset seleccionado.

### 6. Visualizador de Audio (12 puntos)
* **[6 pts] Cálculo de decibeles:** Obtiene los dB a partir de las muestras del audio, según el instante que se está reproduciendo.
* **[6 pts] Animación:** El gráfico de dB con respecto al tiempo se dibuja como una onda en movimiento, sincronizada con la reproducción (avanza al reproducir, se detiene al pausar y se reinicia al cambiar de audio).

### 7. Biblioteca y Playlists (17 puntos)
* **[4 pts] Biblioteca:** El panel lista todas las canciones y podcasts cargados.
* **[5 pts] Crear playlist:** Permite armar una playlist seleccionando canciones desde la biblioteca (**los podcasts no se pueden agregar**).
* **[4 pts] Múltiples playlists:** Se pueden crear, nombrar, ver y reproducir varias playlists.
* **[4 pts] Búsqueda/Filtro:** Permite filtrar la biblioteca por título, artista o género.

### 8. Podcasts (12 puntos)
* **[4 pts] Reglas de podcast:** Los episodios se pueden reproducir pero **no** agregar a playlists.
* **[5 pts] Avance automático:** Al terminar un episodio pasa al siguiente y, tras el último, reinicia desde el primero.
* **[3 pts] Agrupación:** Los episodios pertenecen coherentemente a un mismo podcast (herencia + relación bien resueltas).

### 9. Wrapped / Estadísticas (12 puntos)
* **[3 pts] Minutos reproducidos** calculados correctamente.
* **[3 pts] Canción más escuchada y canción más saltada.**
* **[6 pts] Dos estadísticas adicionales** a elección, correctamente calculadas.

### 10. Diseño de GUI (15 puntos)
* **[10 pts] Diseño:** La GUI debe ser atractiva visualmente, con colores armónicos y paneles correctamente ubicados, sin sobreponerse unos con otros, quedar con tamaños no adecuados o recortarse, palabras fuera de límites, etc.
* **[5 pts] Intuitividad:** Los botones y paneles deben ser claros de sus funcionalidades y estado, de forma que *cualquier* usuario pueda utilizarla sin leer ningún manual de uso.

### 11. Documentación y Diagramas (30 puntos)
* **[15 pts] Diagrama de Clases:** PDF en la raíz con notación UML y relaciones claras.
* **[15 pts] javadoc:** Clases y métodos principales documentados.

### 12. Uso de GitHub (10 puntos)
* **[10 pts] Gestión de versiones:** Repositorio bien estructurado, commits equitativos y descriptivos, y README completo (descripción, integrantes, estructura e instrucciones de ejecución).
