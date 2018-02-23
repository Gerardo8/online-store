package com.example.server.security

import com.example.server.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserDetailsServiceImpl(private val userRepository: UserRepository): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = this.userRepository.findByUsername(username) ?:
                    this.userRepository.findByEmail(username) ?:
                    throw UsernameNotFoundException("${username.toUpperCase()} NOT FOUND")

        return  CustomUserDetails(user)
    }
}