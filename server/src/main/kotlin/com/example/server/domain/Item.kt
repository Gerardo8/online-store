package com.example.server.domain

import javax.persistence.*

@Entity
@Table(name = "ITEMS")
data class Item(

        @Column(nullable = false, length = 50)
        val name: String = "",

        @Column(nullable = false)
        var price: Float = 0.00F,

        @Column(length = 50)
        var description: String = "",

        @Column(nullable = false, length = 30)
        var model: String = "",

        @ManyToOne
        val brand: Brand? = null,

        @ManyToOne
        val department: Department? = null,

        @Enumerated(EnumType.STRING)
        var color: Color = Color.BLUE

): BaseEntity<Long>()