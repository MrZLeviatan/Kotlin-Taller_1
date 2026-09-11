package ejercicio_05.models

import ejercicio_05.models.enums.Genero

class Paciente(

    // Variables "heredadas" de la clase Persona
    nombre: String,
    identificacion: String,
    genero: Genero,
    correo: String? = null,

    // Variables propias de la clase.
    val telefono: String,
    val direccion: Direccion

    // Hereda de la clase Persona
    ): Persona(nombre, genero, correo, identificacion){


    // Sobrescribe el método 'resumenIdentidad()' de la clase base 'Persona'.
    override fun resumenIdentidad(): String {
        // Llama a la implementación de la herencia y agrega el tipo de Persona
        return "[Paciente] ${super.resumenIdentidad()}"
    }

}