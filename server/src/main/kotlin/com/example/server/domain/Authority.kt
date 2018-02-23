package com.example.server.domain

import org.hibernate.annotations.Immutable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Immutable
data class Authority(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Short? = null,
        var name: String = ""
)