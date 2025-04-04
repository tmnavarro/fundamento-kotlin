package principal

import alugueis.Gamer
import database.Banco
import database.GamerDAO
import database.PlanosDAO

fun main() {

    val gamer = Gamer(
        "Tulio",
        "email@servidor.com",
        "17/06/1992",
        "meuUser"
    )

    val manager = Banco.getEntityManager()
    val planosDAO = PlanosDAO(manager)
    val gamerDAO = GamerDAO(manager)


    val listaPlanos = planosDAO.getLista()

    println(listaPlanos)

    val plano = planosDAO.getById(10)
    println(plano)
    println(gamer)
    gamerDAO.adicionar(gamer)

    val listGamers = gamerDAO.getLista()

    println(listGamers)
//
//    manager.close()

}
