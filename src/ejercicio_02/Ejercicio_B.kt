package ejercicio_02


fun main() {

    // Se crea el arreglo vacío de 10 posiciones y se llena con pares de 2 a 20.
    val arreglo = arrayOfNulls<Int>(10)
    var posicion = 0

    for (numero in 2..20 step 2) {
        arreglo[posicion] = numero
        posicion++
    }

    println("Arreglo de pares completo: ${arreglo.contentToString()}")


    // Sé recorrer por índices y se imprime únicamente las posiciones impares (índices 1, 3, 5, 7, 9)
    println("\nElementos en posiciones (índices) impares:")
    for (i in arreglo.indices) {
        if (i % 2 != 0) {
            println("Índice [$i]: ${arreglo[i]}")
        }
    }


    // Cuenta regresiva de 20 a 0 de 5 en 5 en una sola línea separada por coma
    print("Cuenta regresiva: ")
    println((20 downTo 0 step 5).joinToString(", "))

}


/**
    - for( i in 0..arreglo.size) utiliza el operador de rango inclusivo '..'.
        Esto genera una secuencia que va desde 0 hasta el valor exacto de arreglo.size (incluyéndolo).
            Para un arreglo de 10 elementos (size = 10), el rango evaluado será de 0 a 10 (11 posiciones en total desbordándose).

    - '0 until arreglo.size' utiliza el operador de rango exclusivo 'until'.
        Esto genera una secuencia desde 0 hasta arreglo.size - 1.
            Para un arreglo de 10 elementos, el rango evaluado será de 0 a 9 (exactamente las 10 posiciones válidas).


    La primera opción falla porque en Kotlin (y Java) usan arreglos indexados basados en cero hasta size - 1.
        Si se itera o se recorre un arreglo con el for( i in 0..arreglo.size) se desbordará al tomar la última posición fantasma
            lanzando una excepción "ArrayIndexOutOfBoundsException" en tiempo de ejecución.

 */
