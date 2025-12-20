package com.skyflabs.skyv.itam.dbproject.service

import com.skyflabs.skyv.itam.dbproject.entity.InventoryHistory

interface InventoryHistoryService {
    fun getHistoryByItemId(itemId: Long): List<InventoryHistory>
    fun logChange(history: InventoryHistory): InventoryHistory
}

