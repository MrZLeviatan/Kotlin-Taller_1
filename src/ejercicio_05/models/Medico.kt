package ejercicio_05.models

import ejercicio_05.models.enums.Especialidad
import ejercicio_05.models.enums.Genero
import java.time.Year

class Medico(

    // Variables "heredadas" de la clase Persona
    nombre: String,
    identificacion: String,
    genero: Genero,
    correo: String? = null,

    // Variables propias de la clase.
    val especialidad: Especialidad,
    val salario: Double,
    val anioIngreso: Int,

    // Hereda de la clase Persona
    ): Persona(nombre, genero, correo, identificacion){

    // Constructor secundario que sobrecarga la instancia al recibir solo 4 argumentos.
    constructor(
        nombre: String,
        identificacion: String,
        genero: Genero,
        especialidad: Especialidad
    // Delega en el constructor primario asignando un salario por defecto y el año.
    ) : this(
        nombre = nombre,
        identificacion = identificacion,
        genero = genero,
        especialidad = especialidad,
        salario = 2100000.0,
        anioIngreso = Year.now().value
    )


    // Función para calcular cuantos años de permanencia tiene el médico en la institución
    fun antiguedad(anioActual: Int = Year.now().value): Int {
        // Resta el año de ingreso al año actual y usa 'coerceAtLeast(0)' para evitar que retorne números negativos si el año ingresado es futuro.
        return (anioActual - anioIngreso).coerceAtLeast(0)
    }

    // Sobrescribe el método 'resumenIdentidad()' de la clase base 'Persona'.
    override fun resumenIdentidad(): String {
        // Llama a la implementación de la herencia y le concatena la especialidad del médico.
        return "[Médico] ${super.resumenIdentidad()} - Especialidad: $especialidad"
    }

}