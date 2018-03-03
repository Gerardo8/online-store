package com.example.server.domain

import javax.persistence.*

@Entity
@Table(name = "BRANDS")
data class Brand(
        @Column(nullable = false, length = 30, unique = true)
        val name: String = ""
): BaseEntity<Short>()
