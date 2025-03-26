package principal

import alugueis.Jogo
import servicos.ConsumoApi
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite o código do jogo: ")
    val busca = leitura.nextLine()

    val infoJogo = ConsumoApi().buscaJogo(busca)
    println(infoJogo)
    var jogo1: Jogo? = null

    val resultado = runCatching {
        Jogo(infoJogo.info.title, infoJogo.info.thumb)

    }

    resultado.onFailure {
        println("Jogo não encontrado")
    }

    resultado.onSuccess {
        println(jogo1)
    }

}