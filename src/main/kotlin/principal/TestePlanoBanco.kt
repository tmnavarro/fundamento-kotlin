package principal

import alugueis.PlanoAssinatura
import alugueis.PlanoAvulso
import database.Banco
import database.PlanosDAO
import org.jboss.jandex.Main

fun main() {

//    val planoAssinatura = PlanoAssinatura(
//        tipo = "PRATA",
//        mensalidade = 50.0,
//        jogosIncluidos = 5,
//        valorDesconto = 0.2
//    )
//    val planoAvulso = PlanoAvulso(
//        tipo = "BRONZE",
//    )
//
    val manager = Banco.getEntityManager()

    val planosDAO = PlanosDAO(manager)
//
//    planosDAO.adicionar(planoAvulso)
//    planosDAO.adicionar(planoAssinatura)

    val planos = planosDAO.getLista()

    println(planos)
}