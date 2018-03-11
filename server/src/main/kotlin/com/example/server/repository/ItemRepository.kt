package com.example.server.repository

import com.example.server.domain.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long>
