package alugueis

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo:Jogo,
    val periodo: Periodo
) {


    val valorAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel(gamer= ${gamer.nome}, jogo= ${jogo.titulo}, valorAluguel= $valorAluguel)"
    }
}
