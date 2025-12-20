package com.skyflabs.skyv.itam.dbproject.controller

import com.skyflabs.skyv.itam.dbproject.entity.Supplier
import com.skyflabs.skyv.itam.dbproject.service.SupplierService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/suppliers")
class SupplierController(private val supplierService: SupplierService) {

    @GetMapping
    fun getAllSuppliers(): List<Supplier> = supplierService.getAllSuppliers()

    @GetMapping("/{id}")
    fun getSupplierById(@PathVariable id: Long): Supplier = supplierService.getSupplierById(id)

    @PostMapping
    fun createSupplier(@RequestBody supplier: Supplier): Supplier = supplierService.createSupplier(supplier)

    @PutMapping("/{id}")
    fun updateSupplier(@PathVariable id: Long, @RequestBody supplier: Supplier): Supplier = supplierService.updateSupplier(id, supplier)

    @DeleteMapping("/{id}")
    fun deleteSupplier(@PathVariable id: Long) = supplierService.deleteSupplier(id)
}

