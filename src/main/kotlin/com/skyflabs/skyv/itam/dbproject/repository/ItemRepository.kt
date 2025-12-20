package com.skyflabs.skyv.itam.dbproject.repository

import com.skyflabs.skyv.itam.dbproject.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ItemRepository : JpaRepository<Item, Long> {
    fun findByExpiryDateBefore(date: LocalDate): List<Item>
    fun findByCategoryId(categoryId: Long): List<Item>
    fun findByLocationId(locationId: Long): List<Item>
}

