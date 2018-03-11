package com.example.server.repository

import com.example.server.domain.User
import com.example.server.domain.User_
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository, GenericRepository<User, Long>(User::class.java) {

    override fun findByUsername(username: String) = this.findByUniqueRootParam<String>(User_.username, username)

    override fun findByEmail(email: String) = this.findByUniqueRootParam<String>(User_.email, email)
}
