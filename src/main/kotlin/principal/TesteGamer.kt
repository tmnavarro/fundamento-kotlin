package principal

import alugueis.Gamer


fun main() {

    val gamer = Gamer("Tulio", "email@server.com", "17/06/1992", "meuUser")

    println(gamer.toString())


    gamer.let {
        it.dataNascimento = "17/06/1992"
        it.usuario = "asdSS"
    }

    println(gamer.toString())
}