package principal

import alugueis.Periodo
import alugueis.PlanoAssinatura
import servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val gamers = consumo.buscaGamers()

    val jogos = consumo.buscaJogos()

    var gamer1 = gamers.get(1)

    var jogo1 = jogos.get(1)
    var jogo2 = jogos.get(2)
    var jogo3 = jogos.get(3)


    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
//    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))



    gamer1.plano = PlanoAssinatura("PRATA", 10.0, 1)
    gamer1.alugaJogo(jogo1, periodo1)
    gamer1.alugaJogo(jogo2, periodo2)
//    gamer1.alugaJogo(jogo3, periodo3)

    println(gamer1.jogosAlugados)


}