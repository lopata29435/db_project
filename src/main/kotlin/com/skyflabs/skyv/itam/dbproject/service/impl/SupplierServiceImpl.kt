package com.skyflabs.skyv.itam.dbproject.service.impl

import com.skyflabs.skyv.itam.dbproject.entity.Supplier
import com.skyflabs.skyv.itam.dbproject.repository.SupplierRepository
import com.skyflabs.skyv.itam.dbproject.service.SupplierService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SupplierServiceImpl(private val supplierRepository: SupplierRepository) : SupplierService {
    override fun getAllSuppliers(): List<Supplier> = supplierRepository.findAll()

    override fun getSupplierById(id: Long): Supplier = supplierRepository.findById(id).orElseThrow { RuntimeException("Supplier not found") }

    @Transactional
    override fun createSupplier(supplier: Supplier): Supplier = supplierRepository.save(supplier)

    @Transactional
    override fun updateSupplier(id: Long, supplier: Supplier): Supplier {
        val existing = getSupplierById(id)
        existing.name = supplier.name
        existing.contactInfo = supplier.contactInfo
        return supplierRepository.save(existing)
    }

    @Transactional
    override fun deleteSupplier(id: Long) = supplierRepository.deleteById(id)
}

