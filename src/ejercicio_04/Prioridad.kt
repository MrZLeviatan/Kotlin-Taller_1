package ejercicio_04

/**
    Enum que representa la prioridad de una tarea.
        Asigna un nivel numérico del 1 al 4 a cada constante.
 */
enum class Prioridad(var nivel: Int) {

    // Definen la constante e inicializa su nivel.
    BAJA(1),
    MEDIA(2),
    ALTA(3),
    CRITICA(4);


    //Retorna true si el nivel es mayor o igual a 3 (ALTA o CRÍTICA).
    fun esUrgente(): Boolean = nivel >= 3
}