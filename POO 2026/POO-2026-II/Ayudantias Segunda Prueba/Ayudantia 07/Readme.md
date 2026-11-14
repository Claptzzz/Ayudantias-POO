# Ayudantía 07 — Visitor, Strategy y GUI: Breaking Pan

## Contexto

Martín y Nicolás se cansaron de ser ayudantes. Entre sueldos bajos y deudas cada vez más altas, decidieron dejarlo todo para abrir la panadería más revolucionaria jamás vista. Persiguiendo ese sueño, pasaron días y noches probando nuevas recetas basadas en combinaciones químicas que aprendieron de Margarita, su profesora de Química en la universidad.

Después de dar con varias recetas, notaron que cada pan producía efectos distintos en el cuerpo y la mente. Por eso decidieron cobrar cada uno según la intensidad de sus efectos: mientras más fuerte el pan, más caro.

El negocio creció tan rápido que ya no dan abasto cobrando a mano. Necesitan un sistema que lea los pedidos de sus clientes, calcule cuánto cuesta cada uno y les permita cobrar con distintos medios de pago... y ahí es donde entras tú.

## Objetivo

Desarrollar en Java una aplicación con interfaz gráfica (Java Swing) que funcione como una **pasarela de pago simple**: el usuario selecciona un pedido, el sistema calcula su precio según el tipo de pan, el usuario elige un medio de pago y se muestra el precio final con el descuento aplicado.

## Tipos de pan

Existen 4 tipos de pan. Todos comparten algunos atributos y cada uno tiene además atributos propios:

| Atributos en común | Descripción |
|---|---|
| `Tipo` | Nombre del tipo de pan |
| `TipoHarina` | Harina con la que se prepara |
| `Kg` | Peso del pan en kilogramos (decimal) |

| Pan | Atributos específicos |
|---|---|
| **Panketa** | `TiempoDeFermentacion` |
| **Pranck** | `GradosDelGolpeDeFrio`, `TiempoDelGolpeDeFrio` |
| **Panmina** | `GradosDelHorno` |
| **Panto** | `GramosAdicionales`, `GradosDelHorno` |

## Archivos

### Panes.txt

Contiene la receta de cada tipo de pan. Los atributos específicos van al final de la línea, en el orden de la tabla anterior.

Formato: ***Tipo;TipoHarina;Kg;AtributosEspecificos...***

```
Panketa;Integral;2.5;40
Pranck;Blanca;1.0;-18;45
Panmina;Centeno;0.8;220
Panto;Espelta;1.2;150;200
```

### Pedidos.txt

Contiene los pedidos de los clientes. `TipoDePan` corresponde a uno de los panes definidos en `Panes.txt`.

Formato: ***NombreCliente;TipoDePan;Unidades***

```
Martin;Panketa;2
Nicolas;Panto;1
Margarita;Panmina;3
Javiera;Pranck;5
```

## Cálculo del precio

### 1. Precio unitario

Cada pan calcula su precio unitario con su propia fórmula:

| Pan | Fórmula |
|---|---|
| **Panketa** | `Kg * TiempoDeFermentacion` |
| **Pranck** | `GradosDelGolpeDeFrio + TiempoDelGolpeDeFrio` |
| **Panmina** | `GradosDelHorno / Kg` |
| **Panto** | `(GramosAdicionales * GradosDelHorno) / Kg` |

> Trabajen con `double` para evitar divisiones enteras.

### 2. Subtotal del pedido

```
Subtotal = PrecioUnitario * Unidades
```

### 3. Medio de pago

Sobre el subtotal se aplica el descuento según el medio de pago elegido:

| Medio de pago | Descuento |
|---|---|
| **Efectivo** | 0% |
| **Débito** | 10% |
| **Crédito** | 15% |

```
PrecioFinal = Subtotal - (Subtotal * Descuento)
```

### Ejemplo

Para el pedido `Martin;Panketa;2` pagado con **Débito**:

| Paso | Cálculo | Resultado |
|---|---|---|
| Precio unitario | `2.5 * 40` | $100 |
| Subtotal | `100 * 2` | $200 |
| Descuento (10%) | `200 * 0.10` | $20 |
| **Precio final** | `200 - 20` | **$180** |

## Requerimientos

### Interfaz gráfica (Java Swing)

La aplicación debe contar con una ventana que permita:

1. **Ver los pedidos** cargados desde `Pedidos.txt` (por ejemplo, en un `JComboBox` o `JList`).
2. **Seleccionar un pedido** y mostrar su detalle: cliente, tipo de pan, unidades, precio unitario y subtotal.
3. **Elegir el medio de pago** entre Efectivo, Débito y Crédito (por ejemplo, con `JRadioButton` o un `JComboBox`).
4. **Pagar**: al presionar un botón, mostrar un resumen con el subtotal, el descuento aplicado y el precio final (por ejemplo, con un `JOptionPane`).
