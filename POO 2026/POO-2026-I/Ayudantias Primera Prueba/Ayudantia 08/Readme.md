# Ayudantía 08 - Interfaces y Arquitectura

Los ayudantes de POO, pensando en el bien común, decidieron hacer un grupo unificado de todos los paralelos del curso para entregar información relevante de las ayudantías y talleres, además de tener un contacto directo con los estudiantes. 

Al principio todo funcionó bien, hasta que un día los alumnos comenzaron a enviar mensajes constantemente que no se relacionaban con POO, agregar a otros amigos que no forman parte del curso, y a enviar stickers indebidos.

Para mantener un orden en el grupo no bastaba solo con bloquear los mensajes para los alumnos, ya que debían ser capaces de hacer preguntas reales y serias, por lo que los ayudantes tomaron la decisión de construir un sistema que filtre automáticamente los mensajes enviados, evitando así el spam y otros problemas.

Para el filtro se determinó que:
- Los administradores pueden enviar mensajes **sin ninguna restricción**.
- Los alumnos solo pueden enviar un máximo de 3 mensajes.
- Los alumnos que no pertenezcan a ningún paralelo no pueden enviar mensajes.
- Los stickers deben estar permitidos.
- Los administradores pueden dar una excepción a los alumnos para que puedan enviar los mensajes que quieran. **OJO**:
    - Independiente de si pertenecen o no a un paralelo.
    - **NO** exime de la regla de los stickers.

Para la creación del sistema se deben considerar los siguientes puntos:

- En el grupo hay dos tipos de usuarios: **Administradores y Alumnos**.

- **Cada usuario tiene**:
    - Nombre.
    - Apellido.
    - Número telefónico.

- **Cada administrador tiene**:
    - Rol: "Talleres" o "Catedra".

- **Cada alumno tiene**:
    - Paralelo: "C1", "C2", "C3", o "X" si no pertenece al curso de POO.
    - Cantidad de mensajes enviados.
    - Estado de excepción.

- **Cada sticker tiene**:
    - Id.
    - Descripción.
    - Permitido: "Si" o "No".

- Los usuarios deben implementar una interfaz que se encargue del filtro donde deben existir los **pseudométodos**:
    - puedeEnviarMensaje()
    - puedeEnviarSticker()
    - obtenerMotivoBloqueo()
    - obtenerMotivoSticker()

- Se debe utilizar una arquitectura de software adecuada:
    - Un orden en paquetes de **Dominio** y **Lógica**.
    - Una interfaz de **Sistema**, un **SistemaImpl** y una **App**.

Finalmente, el programa debe ser capaz de:
- Leer el archivo con la información de los usuarios: 
    - Nombre: usuarios.txt 
    - Formato: _tipoDeUsuario,nombre,apellido,numero,rol/paralelo (Según corresponda)_
- Leer el archivo con la información de los stickers:
    - Nombre: stickers.txt 
    - Formato: _id,descripcion,permitido_
- Tener un menú que permita:
    - Enviar un mensaje, desde un número de teléfono.
    - Enviar un sticker, desde un número de telefono.
    - Ver todos los usuarios que no pueden enviar mensajes.
    - Ver todos los stickers que si están disponibles.
    - Darle excepción a un alumno (Solo pueden hacerlo los administradores).
    - Ver historial de mensajes enviados.