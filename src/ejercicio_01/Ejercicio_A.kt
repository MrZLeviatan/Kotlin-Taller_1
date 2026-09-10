package ejercicio_01


/**
    Antes de ejecutar el código, escriba en un comentario el resultado que usted espera de cada println.
    Luego ejecútelo y explique en una línea cada diferencia entre lo que esperaba y lo que ocurrió.

    Responda además: ¿qué pasaría si en el último ciclo se reemplazara nombre?.length ?: -1 por nombre!!.length?
        ¿En qué iteración fallaría y con qué excepción?
 */

fun main() {

    val a: Int? = 127
    val b: Int? = 127

    // Devuelve True, pues el operador de comparación Igual a (==), toma la igualdad estructural (como el equals() en java).
    println(a == b)
    // Devuelve True, pues el operador de comparación Igual a (===), toma la igualdad referencial apuntando al mismo objeto de memoria.
    println(a === b)

    // Ocurre Exactamente igual a las hipótesis.


    val c: Int? = 128
    val d: Int? = 128

    // Devuelve True, pues igual a la explicación anterior, este operador de comparación solo toma la igualdad estructural.
    println(c == d)
    // Devuelve False, pues la JVM trabaja únicamente con caché de enteros (Int) de -127 a 127, en este caso obliga a crear el objeto de memoria en otra.
    println(c === d)

    // Ocurre Exactamente igual a las hipótesis.


    val texto1 = "Kotlin"
    val texto2 = StringBuilder("Kot").append("lin").toString()

    /*
    Devuelve True, pues sigue siendo la igualdad estructural y en términos simples ambos textos siguen la misma estructura
        (aun cuando tengan diferente forma de creación).
    */
    println(texto1 == texto2)
    // Devuelve False, pues la creación de ambos objetos es manejado en diferentes espaciós de la memoria de la JVM.
    println(texto1 === texto2)

    // Ocurre Exactamente igual a las hipótesis.


    val nombres: List<String?> = listOf("Ana", null, "Beatriz")
    for (nombre in nombres) {
        // Imprime el tamaño de los nombres normal a exceptión del null, es este caso entra (por el Elvis) e imprime él -1.
        println(nombre?.length ?: -1)

        // Ocurre Exactamente igual a las hipótesis.
    }

    /**
        Al remplazar la línea de código "nombre?.length?: -1" por "nombre!!.length?", ocurriría la exceptión NullPointException
            en la segunda interacción del ciclo. Pues la notación "!!", evitaría la validación inicial del nulo, entrando al ciclo
            y manda al error cuando se llegara al println.
     */
}
