package extensions

import alugueis.Gamer
import alugueis.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
     return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
