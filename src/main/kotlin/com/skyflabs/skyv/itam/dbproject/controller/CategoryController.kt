package com.skyflabs.skyv.itam.dbproject.controller

import com.skyflabs.skyv.itam.dbproject.entity.Category
import com.skyflabs.skyv.itam.dbproject.service.CategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping
    fun getAllCategories(): List<Category> = categoryService.getAllCategories()

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): Category = categoryService.getCategoryById(id)

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category = categoryService.createCategory(category)

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody category: Category): Category = categoryService.updateCategory(id, category)

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long) = categoryService.deleteCategory(id)
}

