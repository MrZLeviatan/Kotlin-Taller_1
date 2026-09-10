package ejercicio_02


fun main() {

    // Lista ya entregada del taller
    val datos: List<Any?> = listOf(15, "42", 3.5, "hola", true, null, -8, "7.5", 100)

    // Valor acumulativo de los números encontrados o convertidos.
    var sumaNumeros = 0.0

    // Ciclo aplicando el withIndex de la lista
    for ((index, dato) in datos.withIndex()) {
        // Clasifica el tipo de dato
        val tipoTexto = clasificar(dato)

        // Intenta convertir el dato a un valor numérico (Double)
        val valorNumerico = aNumero(dato)

        // Acumular la suma si el valor se pudo convertir a número
        if (valorNumerico != null) {
            sumaNumeros += valorNumerico
        }

        // Determinar el rango solo si se pudo convertir y el valor numérico es un entero
        val rangoTexto = if (valorNumerico != null) {
            rangoDe(valorNumerico.toInt())
        } else {
            "no aplica"
        }

        // Formatear las salidas con el operador Elvis
        val numTexto = valorNumerico?.toString() ?: "no aplica"

        println("[$index] $dato -> $tipoTexto | numérico: $numTexto | rango: $rangoTexto")
    }

    println("\nSuma total de valores numéricos: $sumaNumeros")
}

/**
 *  Método para retornar el tipo de valor en texto.
 */
fun clasificar(valor: Any?): String {
    // Ciclo when con el retorno al tipo de valor usando la notación "is".
    return when (valor) {
        is Int -> "entero"
        is Double -> "decimal"
        is String -> "texto"
        is Boolean -> "booleano"
        null -> "desconocido"
        else -> "desconocido"
    }
}


/**
 * Método que intenta convertir cualquier tipo de dato a valor Double
 */
fun aNumero(valor: Any?): Double? {
    return when (valor) {
        // Si es un valor entero, se convierte con el toDouble y lo retorna
        is Int -> valor.toDouble()
        // Si es un valor double, se retorna el valor por defecto
        is Double -> valor
        // Si es un valor String, entra en un bloque try para manejar la exception.
        is String -> try {
            valor.toDouble()
        } catch (e: NumberFormatException) {
            // Si lanza la exceptión por intento de conversión, se retorna null
            null
        }
        else -> null
    }
}


/**
 * Método que etiqueta el rango del valor entero.
 */
fun rangoDe(numero: Int): String {
    return when {
        // Si es un número negativo
        numero < 0 -> "negativo"
        // Si es un dígito
        numero in 0..9 -> "dígito"
        // Si es una decena
        numero in 10..99 -> "decena"
        // Si es un número grande
        else -> "grande"
    }
}
