package com.skyflabs.skyv.itam.dbproject.service

import com.skyflabs.skyv.itam.dbproject.entity.Item
import java.time.LocalDate

interface ItemService {
    fun getAllItems(): List<Item>
    fun getItemById(id: Long): Item
    fun createItem(item: Item): Item
    fun updateItem(id: Long, item: Item): Item
    fun deleteItem(id: Long)
    fun getItemsExpiringBefore(date: LocalDate): List<Item>
    fun getItemsByCategory(categoryId: Long): List<Item>
    fun getItemsByLocation(locationId: Long): List<Item>
}

