package ejercicio_04

/**
    Jerarquía cerrada del estado de las tareas.
    Declara la clase sealed, limitando sus subclases posibles dentro del mismo paquete
        en tiempo de compilación.
 */
sealed class EstadoTarea {

    // Define el estado 'Pendiente' como un objeto único (singleton), ya que no requiere almacenar datos adicionales.
    data object Pendiente : EstadoTarea()

    // Define los estados como ´data class´ para almacenar las propiedades inmutables
    data class EnProgreso(val porcentaje: Int) : EstadoTarea()
    data class Completada(val fechaFinalizacion: String) : EstadoTarea()
    data class Cancelada(val motivo: String) : EstadoTarea()
}



// Función para determinar si el estado actual de la tarea ha finalizado.
fun EstadoTarea.esFinal(): Boolean = when (this) {
    // Evalúa si el estado tarea se encuentra en completado o cancelada (devuelve true)
    is EstadoTarea.Completada, is EstadoTarea.Cancelada -> true
    // Evalúa si el estado tarea se encuentra pendiente o en progreso (devuelve false)
    EstadoTarea.Pendiente, is EstadoTarea.EnProgreso -> false

    // En el estado Pendiente no se usa ´ís´ al ser un objeto singleton, el when evalúa directamente la referencia.

}