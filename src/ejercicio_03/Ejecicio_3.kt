package ejercicio_03


fun main() {

    // Se crea una lista de 5 productos
    val productos = listOf(
        Producto("Teclado", 80000.0, 2),
        Producto("Mouse", 45000.0, 5),
        Producto("Monitor", 750000.0, 1),
        Producto("Audífonos", 120000.0, 0),
        Producto("Silla Gamer", 500000.0, 3)
    )

    // Se imprime el resumen del inventario
    println("=== RESUMEN DE INVENTARIO ===")
    println(productos.resumen())

    // Se prueba las tres formas de invocar aplicarDescuento
    val tecladoOriginal = productos[0]
    // Formato 1: usa 10% por defecto
    val tecladoDescDefecto = aplicarDescuento(tecladoOriginal)
    // Formato 2: por posición
    val tecladoDesc25 = aplicarDescuento(tecladoOriginal, 25.0)
    // Formato 3: parámetro nombrado
    val tecladoDesc25Nombrado = aplicarDescuento(tecladoOriginal, porcentaje = 25.0)

    println("\n=== PRUEBA DE DESCUENTOS E INMUTABILIDAD ===")
    println("Original:              $tecladoOriginal")
    println("Con desc. por defecto: $tecladoDescDefecto")
    println("Con desc. del 25%:     $tecladoDesc25")

    /*
        Explicación de Inmutabilidad:

        El producto original no cambia porque las propiedades de la data class son inmutables ('val')
            y la función 'aplicarDescuento' utiliza el método '.copy()'.

        '.copy()' NO modifica la instancia existente, sino que crea un nuevo objeto Producto
            en memoria con el valor actualizado, manteniendo el objeto original intacto.
     */


    // Se usa desestructuración para recorrer la lista
    println("\n=== LISTADO (DESESTRUCTURACIÓN) ===")
    for ((nombre, precio) in productos) {
        println("Producto: $nombre | Precio: $$precio")
    }


    // Comparación de productos con los mismos valores (== vs ===)
    println("\n=== COMPARACIÓN CON DATA CLASS ===")
    val p1 = Producto("Mouse", 45000.0, 5)
    val p2 = Producto("Mouse", 45000.0, 5)

    println("p1 == p2  : ${p1 == p2}")
    println("p1 === p2 : ${p1 === p2}")

    /*
        Explicación de comparación (== vs ===)

        Al declarar una clase como 'data class', el compilador genera automáticamente
            las funciones 'equals()', 'hashCode()' y 'toString()' basadas en los parámetros del constructor.

        - El operador '==' evalúa igualdad estructural llamando a '.equals()'.
            Como la data class compara las propiedades una a una y todas coinciden, 'p1 == p2' devuelve 'true'.

        - El operador '===' evalúa igualdad referencial (dirección de memoria). Al ser dos
            instancias creadas independientemente, se ubican en referencias distintas lo cual devuelve ´false´.
     */
}