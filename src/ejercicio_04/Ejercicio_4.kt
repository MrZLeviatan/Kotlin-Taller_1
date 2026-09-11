package ejercicio_04


fun main() {
    // Tarea inicial en estado Pendiente
    var tarea = Tarea(
        titulo = "Entregar informe",
        null,
        prioridad = Prioridad.ALTA,
        estado = EstadoTarea.Pendiente
    )

    println("=== INICIO DEL FLUJO DE TRABAJO ===")
    println(describir(tarea))

    val incrementoPaso = 40

    // Avanzar el estado en ciclo hasta llegar a un estado final
    while (!tarea.estado.esFinal()) {
        tarea = avanzar(tarea, incrementoPaso)
        println(describir(tarea))
    }

    println("\n=== ESTADO FINAL ALCANZADO ===")
    println("¿Es un estado final?: ${tarea.estado.esFinal()}")

}