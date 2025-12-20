package com.skyflabs.skyv.itam.dbproject.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "supplier")
class Supplier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(name = "contact_info")
    var contactInfo: String? = null,

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    var items: MutableList<Item> = mutableListOf()
)

