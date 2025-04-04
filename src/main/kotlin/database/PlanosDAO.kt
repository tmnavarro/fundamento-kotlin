package database

import alugueis.Plano
import extensions.toEntity
import extensions.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {

    override fun toEntity(plano: Plano) : PlanoEntity{
    return plano.toEntity()

    }

    override fun toModel(entity: PlanoEntity): Plano {
        return  entity.toModel()
    }
}