# Ayudantía 4

<img align="right" width="200" alt="Giganotosaurus bailando" src="https://media.tenor.com/SdZ_Tv4QBI0AAAAi/%D1%85%D0%BE%D0%BC%D1%8F%D0%BA-dance.gif" />


## Ejercicio 1 — VeteriRoss

Eric Ross, fuera de ser el Dios de ICCI, también dirige una veterinaria, donde mayormente le gusta cuidar y pasar tiempo con los cuyis. Por lo cual, son su especialidad y su mayor fuente de ingreso.

Últimamente, Ross ha recibido mucha demanda por un raro brote de enfermedades en los animales de la zona. Su sistema manual de registros ya no está dando abasto, así que decide pedirte ayuda para crear un programa que automatice toda la información de los pacientes y sus pagos.

### Archivos de entrada

#### `Pacientes.txt`

Contiene los pacientes que están registrados en la clínica. Todas las líneas comparten un formato base, y cada especie agrega sus propios atributos al final.

**Formato base:** `Especie-Nombre-Peso-Edad`

```txt
Cuyi-Nako-3-8-3-4
Gato-Mona-5-4-6
Perro-Willow-13-3-2
Conejo-Cuco-10-7-4
```

| Especie | Formato completo |
|---|---|
| **Cuyi** | `Especie-Nombre-Peso-Edad-LargoDientes-Velocidad` |
| **Gato** | `Especie-Nombre-Peso-Edad-LargoCola` |
| **Perro** | `Especie-Nombre-Peso-Edad-VacunasPendientes` |
| **Conejo** | `Especie-Nombre-Peso-Edad-LargoOrejas` |

> Todos los valores numéricos del archivo son enteros.

### Requerimientos

- Leer el archivo y guardar los pacientes en un **único** `ArrayList` cuyo tipo sea la clase padre.
- Crear la clase padre con los atributos comunes y una clase hija por cada especie con sus atributos propios.
- Crear un menú con las opciones:
    1. **Mostrar pacientes:** muestra todos los pacientes con su especie y todos sus atributos.
    2. **Agregar paciente:** pide la especie, luego los datos base y finalmente los atributos propios de esa especie. El paciente se agrega a la lista.
    3. **Calcular precio:** pide el nombre de un paciente y muestra el precio de su atención. Si no existe, se informa.
    4. **Salir**

### Aclaraciones

- El precio de la atención depende de la especie y se calcula con las siguientes fórmulas:

| Especie | Fórmula |
|---|---|
| Cuyi | `(peso*edad + largoDientes*100) / velocidad` |
| Gato | `(peso + edad) * largoCola` |
| Perro | `peso*edad + vacunasPendientes*20` |
| Conejo | `peso*2 + edad*largoOrejas` |

- El precio debe ser un `double`. Ojo con la división entera en Java.
- Se asume que los nombres de los pacientes no se repiten.

### Ejemplo de ejecución

```text
===== VeteriRoss =====
1) Mostrar pacientes
2) Agregar paciente
3) Calcular precio
4) Salir
Opción: 1

[Cuyi] Nako | Peso: 3 | Edad: 8 | Largo dientes: 3 | Velocidad: 4
[Gato] Mona | Peso: 5 | Edad: 4 | Largo cola: 6
[Perro] Willow | Peso: 13 | Edad: 3 | Vacunas pendientes: 2
[Conejo] Cuco | Peso: 10 | Edad: 7 | Largo orejas: 4

===== VeteriRoss =====
1) Mostrar pacientes
2) Agregar paciente
3) Calcular precio
4) Salir
Opción: 3

Nombre del paciente: Willow
El precio de la atención de Willow es $79.0

===== VeteriRoss =====
1) Mostrar pacientes
2) Agregar paciente
3) Calcular precio
4) Salir
Opción: 2

Especie: Perro
Nombre: Toby
Peso: 8
Edad: 2
Vacunas pendientes: 1
Paciente agregado correctamente.

===== VeteriRoss =====
1) Mostrar pacientes
2) Agregar paciente
3) Calcular precio
4) Salir
Opción: 3

Nombre del paciente: Toby
El precio de la atención de Toby es $36.0

===== VeteriRoss =====
1) Mostrar pacientes
2) Agregar paciente
3) Calcular precio
4) Salir
Opción: 3

Nombre del paciente: Garfield
No existe un paciente con ese nombre.

===== VeteriRoss =====
1) Mostrar pacientes
2) Agregar paciente
3) Calcular precio
4) Salir
Opción: 4

Hasta luego...
```