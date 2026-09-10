package ejercicio_01

/**
    El siguiente código tiene cinco errores que impiden su compilación. Corríjalos y explique en un comentario
    por qué cada uno era un error en Kotlin (y no necesariamente en Java):
 */

fun main() {


    var contador = 0
    /*
        1. Error
        La variable es inicializada con "val", esta notación hace a la variable inmutable (no puede ser reasignada)
            lo cual vemos que rompe dentro del ciclo for. No es necesariamente un error de Java porque este no trabaja con
                las notaciónes "val" o "var" (aunque si tiene el final).
     */
    for (i in 1..5) {
        // Se cambia la estructura del contador para que se vea más wonito.
        contador += i
    }
    println("Suma: $contador")

    /*
        2. Error
        Para trabajar variables nulas en Kotlin, es necesario utilizar la notación "?", si no se utiliza, Kotlin activará
            su NullSafe y manda error antes de ejecutar el código. En sí Java no tiene tan implementado estos NullSafe en su
                ecosistema.
     */
    // También, viendo que la variable no será reasignada, es mejor trabajarla con val (aun cuando no sea obligatorio).
    val apellido: String? = null

    /*
        3. Error
        Igualmente al anterior error, como se está trabajando con variables posiblemente nulas, es necesario seguir usando
            la notación "?", por temas del NullSafe de Kotlin.
     */
    println(apellido?.length)

    /*
        4. Error
        Aquí depende del contexto del que se está trabajando, pues si es necesario trabajar con Listas inmutables, estás como
            no permite modificar la colección, mandaran error al intentar la agregación de otro objeto en ellas.
                Si es necesario agregar esa posición, lo mejor séra cambiar el tipo de lista a una mutable (MutableList), si no es necesario
                    lo mejor será borrar la línea con él ".add".
     */
    val numeros = mutableListOf(1, 2, 3)
    numeros.add(4)
    println(numeros)

    /*
        4. Error
        Kotlin al ser un lenguaje altamente tipado, no permite la operación entre variables de diferentes tipos. En este caso lo mejor
            será cambiar el tipo de texto a un entero con los Castings (con el fin de poder realizar la operación). Es un error
                que igualmente se puede ver en Java por su también tipado fuerte.
     */
    val texto = "42"
    val total: Int = texto.toInt() + 8
    println(total)


}
