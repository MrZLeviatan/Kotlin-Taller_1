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
      
    Responda además: ¿qué pasaría si en el último ciclo se reemplazara `nombre?.length ?: -1` por nombre!!.length?` ¿En qué iteración fallaría y con qué excepción?
     
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