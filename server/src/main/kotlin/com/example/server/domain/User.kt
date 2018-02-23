package com.example.server.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
data class User(

        @Column(length = 30, unique = true, nullable = false)
        val username: String,

        @Email
        @Column(length = 30, unique = true, nullable = false)
        val email: String,

        @Column(length = 255, nullable = false)
        val password: String,

        @Column(length = 20, nullable = false)
        val firstName: String,

        @Column(length = 20, nullable = false)
        val lastName: String,

        @Column(nullable = false)
        val enabled: Boolean = true,

        @ManyToMany
        @JoinTable(name = "USER_AUTHORITY",
                joinColumns = [(JoinColumn(name = "USER_ID"))],
                inverseJoinColumns = [(JoinColumn(name = "AUTHORITY_ID"))]
        )
        @Column(nullable = false)
        val authorities: Set<Authority>,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @get:JsonProperty("_id")
        val id: Long? = null
)