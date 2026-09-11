package ejercicio_03

/**
    Al ser una clase "data", Kotlin genera automáticamente métodos como equals(), hasCode(),
        toString(), copy() y los componentes para desestructuración (componentN).
 */
data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int
) {
}


// Función de extensión sobre Producto que retorna el precio por la cantidad.
fun Producto.valorTotal(): Double = precio * cantidad


/**
    Retorna una copia del producto con el precio ajustado según el porcentaje dado.
        Posee un valor por defecto de 10.0%.
 */
fun aplicarDescuento(producto: Producto, porcentaje: Double = 10.0): Producto {
    // Se calcula el factor descuento (para que pase de 10.0 a 0.10)
    val factorDescuento = 1.0 - (porcentaje / 100.0)
    // Se calcula el nuevo precio aplicando el descuento
    val nuevoPrecio = producto.precio * factorDescuento
    // Se hace una copia nueva del producto
    return producto.copy(precio = nuevoPrecio)
}


/**
    Función de extensión sobre List<Producto> que genera un reporte detallado del inventario.
 */
fun List<Producto>.resumen(): String {
    // Se crea un constructor de una cadena para ir armando el texto sin crear múltiples strings en memoria
    val sb = StringBuilder()
    // Contador al total general de los productos
    var totalGeneral = 0.0

    // Encabezado con el total de los productos a mostrar
    sb.appendLine("Inventario (${this.size} productos):")

    // Ciclo para recorrer cada producto que contiene la lista
    this.forEach { prod ->
        // Valor total del producto actual mediante la función de extensión
        val totalProducto = prod.valorTotal()
        // Se suma el valor del producto a la suma total
        totalGeneral += totalProducto
        // Agrega una línea formateada con el nombre, precio unitario, cantidad y total acumulado de ese producto.
        sb.appendLine("- ${prod.nombre}: ${prod.precio} x ${prod.cantidad} = $totalProducto")
    }
    // Se agrega al final de la cadena la suma total en general.
    sb.append("Total inventario: $totalGeneral")
    // Convierte todo el contenido acumulado en el StringBuilder a una cadena de texto (String) final y la retorna.
    return sb.toString()
}