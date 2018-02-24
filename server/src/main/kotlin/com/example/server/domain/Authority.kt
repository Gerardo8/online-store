package com.example.server.domain

import org.hibernate.annotations.Immutable
import javax.persistence.*

@Entity
@Immutable
@Table(name = "AUTHORITIES")
data class Authority(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Short? = null,
        var name: String = ""
)