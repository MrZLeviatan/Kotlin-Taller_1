package ejercicio_03

data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)

fun Producto.valorTotal(): Double = precio * cantidad

// Función con valor por defecto de 10.0 en el parámetro 'porcentaje'
fun aplicarDescuento(producto: Producto, porcentaje: Double = 10.0): Producto {
    val nuevoPrecio = producto.precio * (1 - porcentaje / 100)
    return producto.copy(precio = nuevoPrecio)
}

fun main() {
    val laptop = Producto("Laptop", 1000.0, 3)

    // 1. Invocación con valor por defecto (10% de descuento)
    val desc1 = aplicarDescuento(laptop)
    println("Default (10%): $desc1") // Precio: 900.0

    // 2. Invocación con argumento posicional (25% de descuento)
    val desc2 = aplicarDescuento(laptop, 25.0)
    println("Posicional (25%): $desc2") // Precio: 750.0

    // 3. Invocación con argumento nombrado (25% de descuento)
    val desc3 = aplicarDescuento(laptop, porcentaje = 25.0)
    println("Nombrado (25%): $desc3") // Precio: 750.0
}
