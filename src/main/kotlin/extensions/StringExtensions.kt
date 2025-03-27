package extensions

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarIdade(): Int {
    val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val dataNascimento = LocalDate.parse(this, formater)
    val dataAtual = LocalDate.now()

    return Period.between(dataNascimento, dataAtual).years
}