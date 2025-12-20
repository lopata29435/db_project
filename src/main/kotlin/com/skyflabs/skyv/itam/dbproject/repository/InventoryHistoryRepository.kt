package com.skyflabs.skyv.itam.dbproject.repository

import com.skyflabs.skyv.itam.dbproject.entity.InventoryHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryHistoryRepository : JpaRepository<InventoryHistory, Long> {
    fun findByItemId(itemId: Long): List<InventoryHistory>
}

