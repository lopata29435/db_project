package com.skyflabs.skyv.itam.dbproject.repository

import com.skyflabs.skyv.itam.dbproject.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>

