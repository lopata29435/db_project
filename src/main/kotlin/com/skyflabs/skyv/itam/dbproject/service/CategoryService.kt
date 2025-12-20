package com.skyflabs.skyv.itam.dbproject.service

import com.skyflabs.skyv.itam.dbproject.entity.Category

interface CategoryService {
    fun getAllCategories(): List<Category>
    fun getCategoryById(id: Long): Category
    fun createCategory(category: Category): Category
    fun updateCategory(id: Long, category: Category): Category
    fun deleteCategory(id: Long)
}

