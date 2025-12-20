package com.skyflabs.skyv.itam.dbproject.controller

import com.skyflabs.skyv.itam.dbproject.entity.Item
import com.skyflabs.skyv.itam.dbproject.service.ItemService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/items")
class ItemController(private val itemService: ItemService) {

    @GetMapping
    fun getAllItems(): List<Item> = itemService.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): Item = itemService.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody item: Item): Item = itemService.createItem(item)

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody item: Item): Item = itemService.updateItem(id, item)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long) = itemService.deleteItem(id)

    @GetMapping("/expiring")
    fun getExpiringItems(@RequestParam date: String): List<Item> = itemService.getItemsExpiringBefore(LocalDate.parse(date))

    @GetMapping("/category/{categoryId}")
    fun getItemsByCategory(@PathVariable categoryId: Long): List<Item> = itemService.getItemsByCategory(categoryId)

    @GetMapping("/location/{locationId}")
    fun getItemsByLocation(@PathVariable locationId: Long): List<Item> = itemService.getItemsByLocation(locationId)
}

