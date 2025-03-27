package extensions

import alugueis.InfoJogoJson
import alugueis.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.descricao, this.preco)
}