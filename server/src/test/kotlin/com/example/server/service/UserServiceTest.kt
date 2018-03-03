package com.example.server.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class UserServiceTest {

    private val username = "Gerardo8"

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun `Get user by username should return user`() {
        val user = this.userService.findByUsername(this.username)
        Assertions.assertThat(user).isNotNull
        Assertions.assertThat(user?.email).isEqualTo("gerardo.lopezre@gmail.com")
    }

}