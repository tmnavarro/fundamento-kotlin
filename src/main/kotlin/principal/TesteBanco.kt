package principal

import alugueis.Gamer
import alugueis.Jogo
import database.Banco
import database.GamerDAO
import database.JogoDAO

fun main() {

    val entityManager = Banco.getEntityManager()


    val jogo = Jogo("Meu Jogo Novo", "Capa do Jogo", "Descrição do Jogo", 59.99)

    val JogoDAO = JogoDAO(entityManager)

    JogoDAO.adicionar(jogo)

    val jogos: List<Jogo> = JogoDAO.getLista()

    println(jogos.toString())

//    val jogo1 = JogoDAO.getById(1)
//
//    println(jogo1)

    JogoDAO.deleteById(1)

    val gamer = Gamer("Tulio", "email@server.com", "17/06/1992", "meuUser")

    val gamerDAO = database.GamerDAO(entityManager)

    gamerDAO.adicionar(gamer)
    val gamers: List<Gamer> = gamerDAO.getLista()

    println(gamers.toString())


    entityManager.close()

}