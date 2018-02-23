package com.example.server.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Item(

        @Column(nullable = false, length = 30)
        var name: String = "",

        @Column(nullable = false)
        var price: Float = 0.00F,

        var description: String = "",

        @Column(nullable = false)
        var model: String = "",
//       brand, department

        @Enumerated(EnumType.STRING)
        var color: Color = Color.BLUE,

        @Column(nullable = false)
        val registerDate: LocalDateTime = LocalDateTime.now(),

        val lastUpdate: LocalDateTime? = null,

        @Id
        @GeneratedValue
        val id: Long? = null
)