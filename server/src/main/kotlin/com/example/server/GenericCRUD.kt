package com.example.server

interface GenericCRUD<T, in ID> {

    fun findById(id: ID): T

    fun save(entity: T): T

    fun saveAll(entities: Iterable<T>): Iterable<T>

    fun update(entity: T): T

    fun delete(entity: T)

    fun deleteById(id: ID)

    fun deleteAll()

    fun deleteAll(entities: Iterable<T>)

    fun findAll(): Iterable<T>

    fun findAllById(ids: Iterable<ID>): Iterable<T>

    fun count(): Int

    fun existById(id: ID): Boolean

}
