package com.skyflabs.skyv.itam.dbproject.service.impl

import com.skyflabs.skyv.itam.dbproject.entity.InventoryHistory
import com.skyflabs.skyv.itam.dbproject.repository.InventoryHistoryRepository
import com.skyflabs.skyv.itam.dbproject.service.InventoryHistoryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InventoryHistoryServiceImpl(private val historyRepository: InventoryHistoryRepository) : InventoryHistoryService {
    override fun getHistoryByItemId(itemId: Long): List<InventoryHistory> = historyRepository.findByItemId(itemId)

    @Transactional
    override fun logChange(history: InventoryHistory): InventoryHistory = historyRepository.save(history)
}

