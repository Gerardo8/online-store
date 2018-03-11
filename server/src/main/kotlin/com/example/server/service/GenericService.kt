package com.example.server.service

import com.example.server.GenericCRUD
import org.springframework.transaction.annotation.Transactional

@Transactional
abstract class GenericService<T, in ID>(private val repository: GenericCRUD<T, ID>) : GenericCRUD<T, ID> {

    override fun saveAll(entities: Iterable<T>) = this.repository.saveAll(entities)

    override fun deleteAll(entities: Iterable<T>) = this.repository.deleteAll(entities)

    override fun findAllById(ids: Iterable<ID>) = this.repository.findAllById(ids)

    override fun count() = this.repository.count()

    override fun existById(id: ID) = this.repository.existById(id)

    override fun findById(id: ID) = this.repository.findById(id)

    override fun save(entity: T) = this.repository.save(entity)

    override fun update(entity: T) = this.repository.update(entity)

    override fun delete(entity: T) = this.repository.delete(entity)

    override fun deleteById(id: ID) = this.repository.deleteById(id)

    override fun deleteAll() = this.repository.deleteAll()

    override fun findAll() = this.repository.findAll()

}
