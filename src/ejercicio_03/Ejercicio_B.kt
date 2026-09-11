

data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)

fun Producto.valorTotal(): Double = precio * cantidad

// Función de extensión sobre List<Producto>
fun List<Producto>.resumen(): String {
    val builder = StringBuilder()
    var totalGeneral = 0.0

    builder.appendLine("Inventario (${this.size} productos):")

    this.forEach { producto ->
        val subtotal = producto.valorTotal()
        totalGeneral += subtotal
        builder.appendLine("- ${producto.nombre}: ${producto.precio} x ${producto.cantidad} = $subtotal")
    }

    builder.append("Total inventario: $totalGeneral")

    return builder.toString()
}

fun main() {
    val inventario = listOf(
        Producto("Teclado", 80000.0, 2),
        Producto("Mouse", 45000.0, 5),
        Producto("Monitor", 750000.0, 1)
    )

    println(inventario.resumen())
}