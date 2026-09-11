package ejercicio_05.models.interfaces

/**
    Interfaz pública, que define un contrato de comportamientos y propiedades para las clases que la implementen
 */
interface Identificable {

    // Propiedad abstracta que toda clase que implemente esta interfaz debe proveer
    val identificacion: String


    // Función con una implementación por defecto que retorna una cadena formateada
    fun resumenIdentidad(): String {
        return "Identificación: $identificacion"
    }
}