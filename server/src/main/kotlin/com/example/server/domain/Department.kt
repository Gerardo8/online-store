package com.example.server.domain

import javax.persistence.*

@Entity
@Table(name = "DEPARTMENTS")
data class Department(
        @Column(nullable = false, length = 50, unique = true)
        val name: String = ""
): BaseEntity<Short>()
