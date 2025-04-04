package database

import alugueis.Gamer
import extensions.toEntity
import extensions.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            id = entity.id,
            nome = entity.nome,
            email = entity.email,
            dataNascimento = entity.dataNascimento,
            usuario = entity.usuario
        ).apply { plano = entity.plano.toModel() }
    }

    override fun toEntity(objeto: Gamer): GamerEntity {
        return GamerEntity(
            id = objeto.id,
            nome = objeto.nome,
            email = objeto.email,
            dataNascimento = objeto.dataNascimento,
            usuario = objeto.usuario,
            plano = objeto.plano.toEntity()
        )
    }
}