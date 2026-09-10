package ejercicio_01


/**
    Reescriba la siguiente función usando if como expresión (una sola asignación, sin var y sin return dentro de las ramas):
 */

fun clasificarNota(nota: Double): String {
    return if (nota >= 4.5) {
        "Excelente"
    } else if (nota >= 3.0) {
        "Aprobado"
    } else {
        "Reprobado"
    }
}


fun main (){
    println(clasificarNota(4.0))
}