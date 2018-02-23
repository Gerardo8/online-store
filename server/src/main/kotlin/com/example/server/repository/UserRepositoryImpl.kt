package com.example.server.repository

import com.example.server.domain.User
import com.example.server.domain.User_
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository, GenericRepository<User, Long>(User::class.java) {

    override fun findByUsername(username: String): User? {
        val criteria = this.createCriteriaQuery()
        val root = this.createRoot()
        val builder = this.createBuilder()
        criteria.select(root)
        criteria.where(builder.equal(root.get(User_.username), username))
        return this.entityManager.createQuery(criteria).singleResult
    }

    override fun findByEmail(username: String): User? {
        val criteria = this.createCriteriaQuery()
        val root = this.createRoot()
        val builder = this.createBuilder()
        criteria.select(root)
        criteria.where(builder.equal(root.get(User_.email), username))
        return this.entityManager.createQuery(criteria).singleResult
    }
}