package com.example.server

import com.example.server.domain.Authority
import com.example.server.domain.User
import com.example.server.repository.AuthorityRepository
import com.example.server.service.UserService
import org.slf4j.Logger
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class ServerApplication(
        private val authorityRepository: AuthorityRepository,
        private val userService: UserService,
        private val passwordEncoder: PasswordEncoder,
        private val logger: Logger
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val authorities = hashSetOf(Authority(name = "ROLE_USER"), Authority(name = "ROLE_ADMIN"))
//        val authorities = this.authorityRepository.findAll().toMutableSet()
        this.authorityRepository.saveAll(authorities)
        this.logger.info(authorities.toString())

        val user = this.userService.save(User("Gerardo8", "gerardo.lopezre@gmail.com",
                this.passwordEncoder.encode("YNWA"), "Gerardo", "López", authorities = authorities))

        this.logger.info(user.toString())

    }
}

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args) {
        addInitializers(beans {

        })
    }
}
