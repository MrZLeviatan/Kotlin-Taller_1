<h1 align="center">

_Taller #1: Kotlin - Desarrollo de Aplicaciones para Dispositivos Móviles_

</h1>

Este repositorio contiene las soluciones correspondientes al **Taller #1** de la asignatura **Desarrollo de Aplicaciones para Dispositivos Móviles** (periodo 2026-2) de la **Universidad del Quindío**.
Aquí se consolidan los ejercicios, guía práctica y resolución de problemáticas desarrolladas durante el taller, abarcando conceptos fundamentales del lenguaje.

<br>

> **Universidad del Quindío**  
> **Programa:** Ingeniería de Sistemas y Computación  
> **Curso:** Desarrollo de Aplicaciones para Dispositivos Móviles (2026-2)  
> **Autores:** Jhon Stivenson Mendez, Nicolas Cabrera Serrano, Robinson Daniel Gañan


<br>

---

### Ejercicio 1: Predecir y corregir

Este ejercicio no requiere escribir programas nuevos: se trata de leer código y entender qué hace Kotlin.

<br>

- ### [Parte A: ¿Qué imprime?](src/ejercicio_01/Ejercicio_A.kt)

    Antes de ejecutar el código, escriba en un comentario el resultado que usted espera de cada println. Luego ejecútelo y explique en una línea cada diferencia entre lo que esperaba y lo que ocurrió.

    ```kotlin
        fun main() {
            val a: Int? = 127
            val b: Int? = 127
            println(a == b)
            println(a === b)
            
            val c: Int? = 128
            val d: Int? = 128
            println(c == d)
            println(c === d)
            
            val texto1 = "Kotlin"
            val texto2 = StringBuilder("Kot").append("lin").toString()
            println(texto1 == texto2)
            println(texto1 === texto2)
            
            val nombres: List<String?> = listOf("Ana", null, "Beatriz")
            for (nombre in nombres) {
              println(nombre?.length ?: -1)
            }
        }
    ```
      
    Responda además: ¿qué pasaría si en el último ciclo se reemplazara `nombre?.length ?: -1` por `nombre!!.length?` ¿En qué iteración fallaría y con qué excepción?
     
<br>


- ### [Parte B: Corregir el código](src/ejercicio_01/Ejercicio_B.kt)

    El siguiente código tiene cinco errores que impiden su compilación. Corríjalos y explique en un comentario por qué cada uno era un error en Kotlin (y no necesariamente en Java):

    ```kotlin
        fun main() {
            val contador = 0
            for (i in 1..5) {
                contador = contador + i
            }
            println("Suma: $contador")
        
            var apellido: String = null
            println(apellido.length)
        
            val numeros = listOf(1, 2, 3)
            numeros.add(4)
        
            val texto = "42"
            val total: Int = texto + 8
            println(total)
        }
    ```
  
<br>

- ### [Parte C: Reescribir con expresiones](src/ejercicio_01/Ejercicio_C.kt)

    Reescriba la siguiente función usando `if` como expresión (una sola asignación, sin `var` y sin `return` dentro de las ramas):

    ```kotlin
        fun clasificarNota(nota: Double): String {
            var resultado: String
            if (nota >= 4.5) {
                resultado = "Excelente"
            } else if (nota >= 3.0) {
                resultado = "Aprobado"
            } else {
                resultado = "Reprobado"
            }
            return resultado
        }
    ```
  

<br>

---

### [Ejercicio 2: Analizador de datos mixtos](src/ejercicio_02/Ejercicio_A.kt)

En este ejercicio no se deben crear clases. El objetivo es dominar when, los ciclos y la conversión de tipos. Partiendo de la siguiente lista:

  ```kotlin
    val datos: List<Any?> = listOf(15, "42", 3.5, "hola", true, null, -8, "7.5", 100)
  ```

implemente:

  1. `fun clasificar(valor: Any?): String` que use `when` con `is` para retornar el tipo del valor en texto: "entero", "decimal", "texto", "booleano" o "desconocido" cuando el valor sea nulo.

  2. `fun aNumero(valor: Any?): Double?` que intente convertir cualquier valor a Double:

     - Si es `Int` o `Double`, lo convierte con `toDouble()`.
     - Si es `String`, lo convierte usando `try` como expresión (`toDouble()` lanza `NumberFormatException`), retornando `null` si no es convertible.
     - En cualquier otro caso retorna `null`.

  3. `fun rangoDe(numero: Int): String` que use `when` con rangos `(in, !in)` para retornar: "negativo" para valores menores a 0, "dígito" entre 0 y 9, "decena" entre 10 y 99, y "grande" en cualquier otro caso.

  4. En `main`, recorra datos con `withIndex()` e imprima una línea por elemento con este formato exacto:

      > - [0] 15 -> entero | numérico: 15.0 | rango: decena
      > - [1] 42 -> texto | numérico: 42.0 | rango: decena
      > - [3] hola -> texto | numérico: no aplica | rango: no aplica
      > - [5] null -> desconocido | numérico: no aplica | rango: no aplica

     Use el operador Elvis para mostrar "no aplica" cuando la conversión retorne null.


  5. Calcule e imprima la suma de todos los valores convertibles a número, usando un ciclo (no use sum() ni filter).


<br>

- ### [Parte B: Ciclos y arreglos](src/ejercicio_02/Ejercicio_B.kt)

    1. Cree un arreglo vacío de 10 posiciones con `arrayOfNulls<Int>(10)` y llénelo con los números pares del 2 al 20 usando un ciclo con `step`.
    
    2. Recórralo con `índices` e imprima únicamente las posiciones impares del arreglo.
    
    3. Imprima una cuenta regresiva de 20 a 0 de 5 en 5 usando `downTo` y `step`, en una sola línea separada por `,` .
  
    4. Explique en un comentario la diferencia entre `for (i in 0..arreglo.size)` y `for (i in 0 until arreglo.size)`, y por qué la primera opción falla.


<br>

### Ejercicio 3: Inventario con data classes y extensiones

Implemente lo siguiente:
Una data class llamada Producto con las propiedades: nombre (String), precio (Double) y cantidad (Int).
Una función de extensión sobre Producto llamada valorTotal() que retorne el precio multiplicado por la cantidad.
Una función aplicarDescuento que reciba un Producto y un porcentaje de descuento con valor por defecto de 10%, y retorne una copia del producto con el precio modificado (usar copy()). Debe poder invocarse de estas tres formas:
aplicarDescuento(producto)
aplicarDescuento(producto, 25.0)
aplicarDescuento(producto, porcentaje = 25.0)


### Requerimientos

1. **Data class Producto**
    - Propiedades:
        - `nombre` (String)
        - `precio` (Double)
        - `cantidad` (Int)

2. **Función de extensión sobre Producto**
    - Nombre: `valorTotal()`
    - Retorna el resultado de `precio * cantidad`.

3. **Función aplicarDescuento**
    - Recibe:
        - Un objeto `Producto`
        - Un porcentaje de descuento (`Double`) con valor por defecto de **10%**
    - Retorna:
        - Una copia del producto con el precio modificado (usar `copy()`).
    - Debe poder invocarse de las siguientes formas:
        - `aplicarDescuento(producto)`
        - `aplicarDescuento(producto, 25.0)`
        - `aplicarDescuento(producto, porcentaje = 25.0)`
