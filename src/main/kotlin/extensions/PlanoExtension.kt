package extensions

import alugueis.Plano
import alugueis.PlanoAssinatura
import alugueis.PlanoAvulso
import database.PlanoAssinaturaEntity
import database.PlanoAvulsoEntity
import database.PlanoEntity

fun Plano.toEntity(): PlanoEntity {

    return if (this is PlanoAssinatura){
        PlanoAssinaturaEntity(
            tipo = this.tipo,
            mensalidade = this.mensalidade,
            jogosIncluidos = this.jogosIncluidos,
            id = this.id,
            valorDesconto = this.valorDesconto
        )
    } else {
        PlanoAvulsoEntity(
            tipo = this.tipo,
            id = this.id
        )
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(
            tipo = this.tipo,
            mensalidade = this.mensalidade,
            jogosIncluidos = this.jogosIncluidos,
            valorDesconto = this.valorDesconto,
            id = this.id
        )
    } else {
        PlanoAvulso(
            tipo = this.tipo,
            id = this.id
        )
    }
}