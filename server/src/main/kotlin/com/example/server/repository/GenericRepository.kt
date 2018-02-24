package com.example.server.repository

import com.example.server.GenericCRUD
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

abstract class GenericRepository<T, in ID>(val targetClass: Class<T>) : GenericCRUD<T, ID> {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    override fun findById(id: ID): T = this.entityManager.find(this.targetClass, id) as T

    override fun save(entity: T): T {
        this.entityManager.persist(entity)
        return entity
    }

    override fun saveAll(entities: Iterable<T>): Iterable<T> {
        for (entity in entities) {
            this.save(entity)
        }
        return entities
    }

    override fun update(entity: T): T = this.entityManager.merge(entity)

    override fun delete(entity: T) = this.entityManager.remove(entity)

    override fun deleteById(id: ID) = this.delete(this.findById(id))

    override fun deleteAll() {
        val criteriaDelete = this.entityManager.criteriaBuilder.createCriteriaDelete(this.targetClass)
        this.entityManager.createQuery(criteriaDelete)
    }

    override fun deleteAll(entities: Iterable<T>) {
       for (entity in entities) {
           this.entityManager.remove(entity)
       }
    }

    override fun findAll(): Iterable<T> = this.entityManager
            .createQuery(this.createCriteriaQuery())
            .resultList as Iterable<T>

    override fun findAllById(ids: Iterable<ID>): Iterable<T> {
        val entities = ArrayList<T>()
        ids.mapTo(entities) { this.findById(it) }
        return entities
    }

    override fun count() = this.entityManager.createQuery(this.createCriteriaQuery()).maxResults

    override fun existById(id: ID) = this.entityManager.find(this.targetClass, id) != null

    fun createCriteriaQuery() = this.entityManager.criteriaBuilder.createQuery(this.targetClass)

    fun createBuilder() = this.entityManager.criteriaBuilder
}