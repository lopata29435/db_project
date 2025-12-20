package com.skyflabs.skyv.itam.dbproject.service.impl

import com.skyflabs.skyv.itam.dbproject.entity.ChangeType
import com.skyflabs.skyv.itam.dbproject.entity.InventoryHistory
import com.skyflabs.skyv.itam.dbproject.entity.Item
import com.skyflabs.skyv.itam.dbproject.repository.InventoryHistoryRepository
import com.skyflabs.skyv.itam.dbproject.repository.ItemRepository
import com.skyflabs.skyv.itam.dbproject.service.ItemService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class ItemServiceImpl(
    private val itemRepository: ItemRepository,
    private val historyRepository: InventoryHistoryRepository
) : ItemService {
    override fun getAllItems(): List<Item> = itemRepository.findAll()

    override fun getItemById(id: Long): Item = itemRepository.findById(id).orElseThrow { RuntimeException("Item not found") }

    @Transactional
    override fun createItem(item: Item): Item {
        val savedItem = itemRepository.save(item)
        if (savedItem.quantity > 0) {
            val history = InventoryHistory(
                item = savedItem,
                changeType = ChangeType.ADD,
                quantityChanged = savedItem.quantity
            )
            historyRepository.save(history)
        }
        return savedItem
    }

    @Transactional
    override fun updateItem(id: Long, item: Item): Item {
        val existing = getItemById(id)
        val oldQuantity = existing.quantity

        existing.name = item.name
        existing.description = item.description
        existing.quantity = item.quantity
        existing.expiryDate = item.expiryDate
        existing.category = item.category
        existing.location = item.location
        existing.supplier = item.supplier

        val savedItem = itemRepository.save(existing)

        if (savedItem.quantity != oldQuantity) {
            val diff = savedItem.quantity - oldQuantity
            val history = InventoryHistory(
                item = savedItem,
                changeType = ChangeType.ADJUSTMENT,
                quantityChanged = diff
            )
            historyRepository.save(history)
        }

        return savedItem
    }

    @Transactional
    override fun deleteItem(id: Long) = itemRepository.deleteById(id)

    override fun getItemsExpiringBefore(date: LocalDate): List<Item> = itemRepository.findByExpiryDateBefore(date)

    override fun getItemsByCategory(categoryId: Long): List<Item> = itemRepository.findByCategoryId(categoryId)

    override fun getItemsByLocation(locationId: Long): List<Item> = itemRepository.findByLocationId(locationId)
}

