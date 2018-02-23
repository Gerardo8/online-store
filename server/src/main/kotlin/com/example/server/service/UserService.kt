package com.example.server.service

import com.example.server.GenericCRUD
import com.example.server.domain.User

interface UserService: GenericCRUD<User, Long> {

    fun findByUsername(username: String): User?

    fun findByEmail(username: String): User?
}