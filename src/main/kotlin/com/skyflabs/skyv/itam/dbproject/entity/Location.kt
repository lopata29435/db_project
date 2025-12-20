package com.skyflabs.skyv.itam.dbproject.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "location")
class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    var items: MutableList<Item> = mutableListOf()
)

