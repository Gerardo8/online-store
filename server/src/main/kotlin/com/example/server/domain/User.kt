package com.example.server.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "USERS")
data class User(

        @NotEmpty(message = "First name is required.")
        @Column(length = 30, unique = true, nullable = false)
        val username: String = "",

        @Email(message = "Please provide a valid email address.")
        @NotEmpty(message = "Email is required.")
        @Column(length = 30, unique = true, nullable = false)
        val email: String = "",

        @NotEmpty(message = "Password is required.")
        @Column(length = 255, nullable = false)
        @JsonIgnore
        val password: String = "",

        @NotEmpty(message = "First name is required.")
        @Column(length = 20, nullable = false)
        val firstName: String = "",

        @NotEmpty(message = "Last name is required.")
        @Column(length = 20, nullable = false)
        val lastName: String = "",

        @Column(nullable = false)
        val enabled: Boolean = true,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "USERS_AUTHORITIES",
                joinColumns = [(JoinColumn(name = "USER_ID"))],
                inverseJoinColumns = [(JoinColumn(name = "AUTHORITY_ID"))]
        )
        @JsonIgnore
        val authorities: Set<Authority> = hashSetOf()

) : BaseEntity<Long>()
