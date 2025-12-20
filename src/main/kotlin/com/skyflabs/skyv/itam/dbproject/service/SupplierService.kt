package com.skyflabs.skyv.itam.dbproject.service

import com.skyflabs.skyv.itam.dbproject.entity.Supplier

interface SupplierService {
    fun getAllSuppliers(): List<Supplier>
    fun getSupplierById(id: Long): Supplier
    fun createSupplier(supplier: Supplier): Supplier
    fun updateSupplier(id: Long, supplier: Supplier): Supplier
    fun deleteSupplier(id: Long)
}

