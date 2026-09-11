package ejercicio_05

import ejercicio_05.models.Direccion
import ejercicio_05.models.Hospital
import ejercicio_05.models.Medico
import ejercicio_05.models.enums.Especialidad
import ejercicio_05.models.enums.Genero
import ejercicio_05.models.Paciente


fun main() {

    println("=== 1. PRUEBA DE HOSPITAL VACÍO ===")
    // Se crea una instancia del hospital vacío.
    val hospitalVacio = Hospital()
    // Se llama a la función para comprobar el comportamiento de esta en casos vacíos.
    val medicoAntiguoVacio = hospitalVacio.medicoConMasAntiguedad()
    println("Médico con más antigüedad en hospital vacío: $medicoAntiguoVacio")



    println("\n=== 2. CREACIÓN DE HOSPITAL Y REGISTRO DE DATOS ===")
    // Se crea una segunda instancia del hospital
    val hospital = Hospital()

    // Registro de 3 Médicos (usando constructor primario y secundario)
    val med1 = Medico("Dra. Ana López", "M-101", Genero.FEMENINO, "ana.lopez@hospital.com",
        Especialidad.CARDIOLOGIA, 1000.0, 2015,)
    val med2 = Medico("Dr. Carlos Pérez", "M-102", Genero.MASCULINO, null,
        Especialidad.PEDIATRIA, 620.0, 2018)
    // Uso del constructor secundario
    val med3 = Medico("Dr. Roberto Gómez", "M-103", Genero.MASCULINO, Especialidad.CARDIOLOGIA)


    // Se agrega los 3 objetos médicos al hospital
    hospital.agregarMedico(med1)
    hospital.agregarMedico(med2)
    hospital.agregarMedico(med3)


    // Registro de 3 Pacientes
    val pac1 = Paciente("Juan Martínez", "P-201", Genero.MASCULINO, "juan.m@mail.com", "3101234567",
        Direccion("Calle 10 #12-34", "Armenia", "630001"), )
    val pac2 = Paciente("María Rodríguez", "P-202", Genero.FEMENINO, null,"3207654321",
        Direccion("Cra 14 #5-20", "Calarcá", "631001"))
    val pac3 = Paciente("Sofía Ramírez", "P-203", Genero.FEMENINO, null, "3001112233",
        Direccion("Av. Bolivar #19-02", "Armenia", "630002"))

    // Se agrega los 3 objetos de pacientes al hospital
    hospital.agregarPacientes(pac1)
    hospital.agregarPacientes(pac2)
    hospital.agregarPacientes(pac3)

    println("Médicos y pacientes registrados exitosamente.\n")


    println("\n=== 3. PRUEBAS DE MÉTODOS Y OPERACIONES ===")

    // Resumen de Identidad
    println("\n--- Resumen de Identidad ---")
    println(med3.resumenIdentidad())
    println(pac1.resumenIdentidad())


    // Total de salarios por Especialidad
    println("\n--- Total Salarios por Especialidad ---")
    val totalCardiologia = hospital.totalSalarios(Especialidad.CARDIOLOGIA)
    val totalNeurologia = hospital.totalSalarios(Especialidad.NEUROLOGIA)
    println("Total salarios en CARDIOLOGÍA: $$totalCardiologia")
    println("Total salarios en NEUROLOGÍA:  $$totalNeurologia")


    // Médico con más antigüedad
    println("\n--- Médico con más Antigüedad ---")
    val masAntiguo = hospital.medicoConMasAntiguedad()
    if (masAntiguo != null) {
        println("El médico con más antigüedad es: ${masAntiguo.nombre} (${masAntiguo.antiguedad()})")
    }

    // Contactar personas
    println("\n--- Búsqueda de Contacto ---")
    println("Contacto Dra. Ana (M-101):  ${hospital.contactar("M-101")}")
    println("Contacto María (P-202):     ${hospital.contactar("P-202")}")
    println("Contacto Inexistente (999): ${hospital.contactar("999")}")
    println()


    // Eliminación de registros
    println("--- Eliminación de Registros ---")
    hospital.eliminarMedico(med3)
    hospital.eliminarPacientes(pac3)
    println("Total médicos restantes: ${hospital.medicos.size}")
    println("Total pacientes restantes: ${hospital.pacientes.size}")
}

