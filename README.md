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

---

### [Ejercicio 3: Inventario con data classes y extensiones](src/ejercicio_03/Ejecicio_3.kt)

Implemente lo siguiente:

1. Una `data class` llamada **Producto** con las propiedades: `nombre (String), precio (Double) y cantidad (Int)`.

2. Una función de extensión sobre **Producto** llamada `valorTotal()` que retorne el precio multiplicado por la cantidad.

3. Una función `aplicarDescuento` que reciba un **Producto** y un porcentaje de descuento con valor por defecto de 10%, y retorne una copia del producto con el precio modificado (`usar copy()`). Debe poder invocarse de estas tres formas:
  
  ```kotlin
    aplicarDescuento(producto)
    aplicarDescuento(producto, 25.0)
    aplicarDescuento(producto, porcentaje = 25.0)
  ```

4. Una función de extensión sobre `List<Producto>` llamada `resumen()` que retorne un `String` con el siguiente formato (usando interpolación de cadenas y forEach):

    ```text
        Inventario (3 productos):
        - Teclado: 80000.0 x 2 = 160000.0
        - Mouse: 45000.0 x 5 = 225000.0
        - Monitor: 750000.0 x 1 = 750000.0
        Total inventario: 1135000.0
    ```
  
5. Una función de extensión sobre **Producto** llamada `estaAgotado()` que retorne `true` cuando la cantidad sea 0.


6. En main:

   - Cree una lista con al menos 5 productos e imprima el resumen.
   - Aplique descuentos a dos productos y verifique que los productos originales no cambiaron (imprima ambos y explique por qué en un comentario).
   - Use desestructuración para recorrer la lista e imprimir solo nombre y precio.
   - Compare dos productos creados con los mismos valores usando `==` y `===`, e imprima ambos resultados. Explique en un comentario por qué la data class hace que `==` sea true.

<br>

---

### [Ejercicio 4: Máquina de estados con sealed classes](src/ejercicio_04/Ejercicio_4.kt)

Este ejercicio se centra en modelar estados y transiciones, no en manipular listas.

1. Un `enum class` llamado **Prioridad** con los valores BAJA, MEDIA, ALTA y CRÍTICA, cada uno con una propiedad `nivel` de tipo `Int` (1 a 4 respectivamente) y una función `esUrgente()` que retorne `true` cuando el nivel sea mayor o igual a 3.


2. Una `sealed class` llamada `EstadoTarea` con las subclases:
   - `Pendiente` (sin propiedades adicionales)
   - `EnProgreso(val porcentaje: Int)`
   - `Completada(val fechaFinalizacion: String)`
   - `Cancelada(val motivo: String)`


3. Una `data class` llamada Tarea con: `titulo (String)`, `descripcion (String?)`, `prioridad (Prioridad)` y `estado (EstadoTarea)`.


4. Una función de extensión `EstadoTarea.esFinal(): Boolean` que use `when` para indicar si desde ese estado ya no hay transiciones posibles (Completada y Cancelada son finales).


5. Una función `describir(tarea: Tarea): String` que use `when` sobre el estado y aproveche el `smart cast` para incluir los datos propios de cada subclase. Por ejemplo:

    ```text
        [ALTA] Entregar informe: en progreso (60%)
        [BAJA] Ordenar escritorio: cancelada por "ya no es necesario"
    ```

    La función **NO** debe usar `else:` al ser una `sealed class`, el compilador verifica que todos los casos estén cubiertos. Comente una de las ramas y observe el error que reporta el compilador; documéntelo.


6. Una función `avanzar(tarea: Tarea, incremento: Int): Tarea` que retorne una nueva tarea aplicando estas reglas con `when`:
    
    - Si está Pendiente, pasa a EnProgreso con el porcentaje del incremento.
    - Si está EnProgreso, suma el incremento al porcentaje actual; si alcanza o supera 100, pasa a Completada con la fecha "2026-01-01".
    - Si el estado ya es final, retorna la tarea sin cambios.


7. En `main`, cree una tarea en estado Pendiente y llame avanzar varias veces en un ciclo hasta que `esFinal()` retorne `true`, imprimiendo la descripción en cada paso. Verifique que el estado nunca supere el 100%.


<br>

---

### [Ejercicio 5: Sistema hospitalario (herencia e interfaces)]()

Este ejercicio se centra en la programación orientada a objetos con Kotlin: herencia, constructores e interfaces.

1. Una interfaz `Identificable` con la propiedad `identificacion: String` y una función `resumenIdentidad(): String` con implementación por defecto que retorne el nombre y la identificación.


2. Una clase `open class Persona(val nombre: String, override val identificacion: String, val genero: Genero) : Identificable` donde:

   - `Genero` es un `enum class` con los valores MASCULINO, FEMENINO y OTRO.
   - La clase tiene una propiedad `correo: String?` con valor por defecto null.
   - Un bloque `init` válida que el nombre no esté vacío y lanza una excepción en caso contrario.
   - Sobreescribe `toString()` con override.


3. Un `enum class` llamado **Especialidad** con al menos los valores PEDIATRÍA, CARDIOLOGÍA y NEUROLOGÍA, y una clase **Medico** que herede de Persona y agregue `especialidad (Especialidad), salario (Double) y anioIngreso (Int)`. Debe tener:
 
    - Un **constructor secundario** que reciba solo nombre, identificación, género y especialidad, y delegue en el primario asignando un salario base por defecto y el año actual.
    - Una función `antiguedad(anioActual: Int = 2026): Int`.
    - `override` de `resumenIdentidad()` para incluir la especialidad.


4. Una clase **Paciente** que herede de Persona y agregue `telefono (String)` y `direccion (data class Direccion(val calle: String, val ciudad: String, val codigoPostal: String)`).


5. Una clase Hospital con listas mutables de médicos y pacientes que permita:

    - `agregarMedico`, `eliminarMedico`, `agregarPaciente`, `eliminarPaciente`.
    - `totalSalarios(especialidad: Especialidad): Double`, recorriendo la lista con un ciclo.
    - `medicoConMasAntiguedad(): Medico?` que retorne `null` cuando no haya médicos registrados (no use `!!`).
    - `contactar(identificacion: String): String` que busque la persona y retorne su correo usando el operador `Elvis` para devolver "Sin correo registrado" cuando sea nulo.


6. En `main`, registre al menos 3 médicos y 3 pacientes, invoque todas las operaciones e imprima los resultados. Verifique el comportamiento de `medicoConMasAntiguedad()` sobre un hospital vacío.


No se requiere interfaz gráfica de usuario.

<br>

---


 
