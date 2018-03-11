package com.example.server.domain

import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity<out ID>(

        @Version
        val version: Long? = null,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: ID? = null,

        @Column(nullable = false)
        val registerDate: LocalDateTime = LocalDateTime.now(),

        val lastUpdate: LocalDateTime? = null
)
