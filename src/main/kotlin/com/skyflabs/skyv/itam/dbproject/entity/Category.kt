package com.skyflabs.skyv.itam.dbproject.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    @JsonIgnore
    var parentCategory: Category? = null,

    @OneToMany(mappedBy = "parentCategory", cascade = [CascadeType.ALL])
    var subCategories: MutableList<Category> = mutableListOf(),

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    var items: MutableList<Item> = mutableListOf()
)

