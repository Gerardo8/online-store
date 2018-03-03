package com.example.server.domain

import org.hibernate.annotations.Immutable
import javax.persistence.*

@Entity
@Immutable
@Table(name = "AUTHORITIES")
data class Authority(
        @Column(nullable = false, length = 30, unique = true, updatable = false)
        val name: String = ""
): BaseEntity<Short>()