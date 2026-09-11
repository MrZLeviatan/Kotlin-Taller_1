package ejercicio_05.models

import ejercicio_05.models.enums.Genero
import ejercicio_05.models.interfaces.Identificable

/**
    ´Open´ permite que otras clases hereden de esta clase
 */
open class Persona(

    // Variables inmutables de la clase
    val nombre: String,
    val genero: Genero,
    val correo: String? = null,

    // Propiedad que sobrescribe la propiedad declarada en 'Identificable'
    override val identificacion: String

    // Se implementa la interfaz 'Identificable'
    ): Identificable {

    // Bloque de inicialización que se ejecuta inmediatamente después de llamar al constructor primario
    init {
        /*
            Válida que nombre no esté vacío ni contenga solo espacios en blanco
                si falla, lanza una IllegalArgumentException con el mensaje dado
         */
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío." }
    }

    // Sobrescribe el método 'resumenIdentidad()' heredado de la interfaz 'Identificable'.
    override fun resumenIdentidad(): String {
        return "Nombre: $nombre  Identificación: ($identificacion)"
    }

    // Sobrescribe el método estándar 'toString()' de la clase base.
    override fun toString(): String {
        return "Persona(nombre='$nombre', identificacion='$identificacion', genero=$genero, correo=${correo ?: "Sin Correo"})"
    }


}