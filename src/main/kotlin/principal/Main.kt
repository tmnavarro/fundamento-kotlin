package principal

import alugueis.Gamer
import alugueis.Jogo
import extensions.transformarIdade
import servicos.ConsumoApi
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitura)
    println("Usuario criado com sucesso $gamer")
    println("Idade ${gamer.dataNascimento?.transformarIdade()}")


    do {
        println("Digite o código do jogo: ")
        val busca = leitura.nextLine()

        val infoJogo = ConsumoApi().buscaJogo(busca)
        println(infoJogo)
        var jogo1: Jogo? = null

        val resultado = runCatching {
            jogo1 = Jogo(infoJogo.info.title, infoJogo.info.thumb)

        }

        resultado.onFailure {
            println("Jogo não encontrado")
        }

        resultado.onSuccess {
            gamer.jogos.add(jogo1)
            println(jogo1)
        }

        println("Continuar S/N: ")
        val continuar = leitura.nextLine()

    } while (continuar.equals("S", true))


    gamer.jogos.sortBy {
        it?.titulo
    }

    gamer.jogos.forEach {
        println("Jogos do gamer: ${it?.titulo}")
    }

    val jogosFiltrados = gamer.jogos.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    println("Jogos do Batman: $jogosFiltrados")

}