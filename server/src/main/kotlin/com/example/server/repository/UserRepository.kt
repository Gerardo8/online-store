package com.example.server.repository

import com.example.server.GenericCRUD
import com.example.server.domain.User

interface UserRepository: GenericCRUD<User, Long> {

    fun findByUsername(username: String): User?

    fun findByEmail(username: String): User?
}