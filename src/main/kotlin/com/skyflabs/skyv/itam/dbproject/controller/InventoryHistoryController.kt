package com.skyflabs.skyv.itam.dbproject.controller

import com.skyflabs.skyv.itam.dbproject.entity.InventoryHistory
import com.skyflabs.skyv.itam.dbproject.service.InventoryHistoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/history")
class InventoryHistoryController(private val historyService: InventoryHistoryService) {

    @GetMapping("/item/{itemId}")
    fun getHistoryByItemId(@PathVariable itemId: Long): List<InventoryHistory> = historyService.getHistoryByItemId(itemId)

    @PostMapping
    fun logChange(@RequestBody history: InventoryHistory): InventoryHistory = historyService.logChange(history)
}

