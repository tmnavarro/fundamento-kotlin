package database

import alugueis.Jogo
import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    protected val manager : EntityManager,
    protected val entityType: Class<TEntity>){

    abstract fun toEntity(objeto: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getLista(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity ->
            toModel(entity)
        }
    }

    open fun adicionar(objeto: TModel) {
        val entity = toEntity(objeto)
        println("AQUI")
        println(entity.toString())
        println("AQUI2")
        try {
            manager.transaction.begin()
            manager.persist(entity)
            manager.transaction.commit()
        } catch (e: Exception) {
            if (manager.transaction.isActive) {
                manager.transaction.rollback()
            }
            e.printStackTrace()
        }
    }

    open fun getById(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        return toModel(entity)
    }

    open fun deleteById(i: Int) {
        val entity = manager.find(entityType, i)
        try {
            manager.transaction.begin()
            manager.remove(entity)
            manager.transaction.commit()
        } catch (e: Exception) {
            if (manager.transaction.isActive) {
                manager.transaction.rollback()
            }
            e.printStackTrace()
        }
    }
}