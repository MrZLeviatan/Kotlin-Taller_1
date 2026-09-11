package ejercicio_05.models

import ejercicio_05.models.enums.Especialidad


class Hospital {

    // Lista de medios y pacientes del hospital.
    val medicos: MutableList<Medico> = mutableListOf()
    val pacientes: MutableList<Paciente> = mutableListOf()


    // Funciones relacionadas con las listas (agregar, eliminar) de los medicos y pacientes.
    fun agregarMedico(medico: Medico) = medicos.add(medico)
    fun eliminarMedico(medico: Medico) = medicos.remove(medico)

    fun agregarPacientes(paciente: Paciente) = pacientes.add(paciente)
    fun eliminarPacientes(paciente: Paciente) = pacientes.remove(paciente)


    // Función para obtener la sumatoria de salarios asociados a una Especialidad
    fun totalSalarios(especialidad: Especialidad): Double {
        // Variable acumulativa del total
        var total = 0.0
        // Recorre la lista de los medicos
        for (medico in medicos) {
            // Verifica si la especialidad del médico es igual a la especialidad indicada
            if (medico.especialidad == especialidad) {
                // Suma el salario del médico al total
                total += medico.salario
            }
        }
        // Retorna el total de la suma de los salarios
        return total
    }

    // Función para buscar el médico con mayor antigüedad
    fun medicoConMasAntiguedad(): Medico?{
        // Valida si la lista de medicos no se encuentra vacía
        if (medicos.isEmpty()) return null

        // Toma como inicialización al primer médico de la lista
        var masAntiguo = medicos[0]
        // Recorre la lista de medicos
        for (medico in medicos) {
            // Válida si el médico actual es más antiguo que el guardado en la bandera
            if (medico.antiguedad() > masAntiguo.antiguedad()) {
                // Guarda el médico actual al cumplir con la sentencia
                masAntiguo = medico
            }
        }
        // Retorna al médico mas antiguo
        return masAntiguo
    }


    // Función para buscar una persona (médico o paciente)
    fun contactar(identificacion: String): String {

        /*
            Se hace una búsqueda en cascada, primero en la lista de médicos
                ("it" referente al médico actual del recorrido de find) si no es encontrado,
                    el operador Elvis se activa y hace la misma búsqueda en la lista de pacientes.
            Al ser medicó y paciente heredado de la clase Persona, se puede hacer polimorfismo.
         */
        val persona: Persona? = medicos.find { it.identificacion == identificacion }
            ?: pacientes.find { it.identificacion == identificacion }

        // Se retorna el correo de la persona (si este es nulo o la búsqueda dio nulo, se activa el operador Elvis).
        return persona?.correo ?: "Sin correo registrado"
    }



}