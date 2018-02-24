package com.example.server.service

import com.example.server.domain.User
import com.example.server.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl(private val userRepository: UserRepository) : UserService, GenericService<User, Long>(userRepository) {

    override fun findByUsername(username: String) = this.userRepository.findByUsername(username)

    override fun findByEmail(username: String) = this.userRepository.findByEmail(username)
}