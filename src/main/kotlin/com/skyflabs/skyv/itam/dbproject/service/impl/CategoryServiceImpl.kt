package com.skyflabs.skyv.itam.dbproject.service.impl

import com.skyflabs.skyv.itam.dbproject.entity.Category
import com.skyflabs.skyv.itam.dbproject.repository.CategoryRepository
import com.skyflabs.skyv.itam.dbproject.service.CategoryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {
    override fun getAllCategories(): List<Category> = categoryRepository.findAll()

    override fun getCategoryById(id: Long): Category = categoryRepository.findById(id).orElseThrow { RuntimeException("Category not found") }

    @Transactional
    override fun createCategory(category: Category): Category = categoryRepository.save(category)

    @Transactional
    override fun updateCategory(id: Long, category: Category): Category {
        val existing = getCategoryById(id)
        existing.name = category.name
        existing.parentCategory = category.parentCategory
        return categoryRepository.save(existing)
    }

    @Transactional
    override fun deleteCategory(id: Long) = categoryRepository.deleteById(id)
}

