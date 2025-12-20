package com.skyflabs.skyv.itam.dbproject.repository

import com.skyflabs.skyv.itam.dbproject.entity.Supplier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SupplierRepository : JpaRepository<Supplier, Long>

