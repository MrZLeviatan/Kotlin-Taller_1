package ejercicio_04

import java.time.LocalDate

data class Tarea (

    val titulo: String,
    val descripcion: String?,
    val prioridad: Prioridad,
    val estado: EstadoTarea,
){}


// Describe el estado actual de una tarea
fun describir (tarea: Tarea): String {
    val detalleEstado = when (val estado = tarea.estado) {
        is EstadoTarea.Pendiente -> "Pendiente"
        is EstadoTarea.EnProgreso -> "En Progreso (${estado.porcentaje})"
        is EstadoTarea.Completada -> "Completada el ${estado.fechaFinalizacion}"
        is EstadoTarea.Cancelada -> "Cancelada por ${estado.motivo}"
    }
    return "[${tarea.prioridad}] ${tarea.titulo} | $detalleEstado"
}

/**
    Error al comentar una rama (oh opción) del ´when´

    Si se comenta una de las ramas en la función 'describir' (por ejemplo, 'is EstadoTarea.Cancelada'),
        el compilador de Kotlin arroja el siguiente error:

        'when' expression must be exhaustive, add the 'Is Cancelada' branch or an 'else' branch

    Al evaluar una 'sealed class', el compilador exige exhaustividad. Sabe exactamente cuántas
        subclases existen y no permite omitir ninguna a menos que se defina un bloque 'else'.
 */



// Retorna una descripción legible del estado actual aprovechando Smart Cast.
fun avanzar(tarea: Tarea, incremento: Int): Tarea {

    // Asigna el nuevo estado a la Tarea
    val nuevoEstado = when (val estadoActual = tarea.estado) {
        // Si el estado actual de la tarea es pendiente
        is EstadoTarea.Pendiente -> {
            /*
              Calcula el porcentaje asegurando que no supere el valor de 100 usando la función 'coerceAtMost'

              La función 'coerceAtMost' sirve para establecer un límite máximo para un valor.
                Si el número original es mayor que el máximo que se indica, la función "lo frena" y devuelve ese valor máximo.
                Si es menor o igual, devuelve el número original sin cambios.
            */
            val nuevoPorcentaje = incremento.coerceAtMost(100)

            // Verifica si el nuevoPorcentaje es mayor al 100%
            if (nuevoPorcentaje >= 100) {
                // Si es mayor al 100% se guarda la fecha actual en la que se completo la tarea
                EstadoTarea.Completada(LocalDate.now().toString())
            } else {
                // Si no es mayor, se guarda el nuevo estado de tarea con el porcentaje completado de la tarea.
                EstadoTarea.EnProgreso(nuevoPorcentaje)
            }
        }
        // Si el estado ya se encontraba en progreso
        is EstadoTarea.EnProgreso -> {
            /*
                Calcula el nuevo porcentaje (sumando el porcentaje que ya se tenía más el incremento)
                    y asegurando que no se supere el valor de 100 con la función 'coerceAtMost'.
             */
            val nuevoPorcentaje = (estadoActual.porcentaje + incremento).coerceAtMost(100)

            // Verifica si el nuevo porcentaje de tarea completada es el 100%
            if (nuevoPorcentaje >= 100) {
                // Si es mayor al 100% se guarda la fecha actual en la que se completo la tarea
                EstadoTarea.Completada(LocalDate.now().toString())
            } else {
                // Si no es mayor, se guarda la actualización del estado de tarea con el porcentaje completado de la tarea.
                EstadoTarea.EnProgreso(nuevoPorcentaje)
            }
        }
        // Si es una tarea ya finalizada, devuelve el mismo estado
        is EstadoTarea.Completada, is EstadoTarea.Cancelada -> estadoActual
    }
    // Retorna una copia de la tarea original actualizando únicamente la propiedad 'estado' con 'nuevoEstado'.
    return tarea.copy(estado = nuevoEstado)
}