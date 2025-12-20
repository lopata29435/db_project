package com.skyflabs.skyv.itam.dbproject.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "inventory_history")
class InventoryHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    var item: Item,

    @Column(name = "change_type", nullable = false)
    @Enumerated(EnumType.STRING)
    var changeType: ChangeType,

    @Column(name = "quantity_changed", nullable = false)
    var quantityChanged: Int,

    @Column(name = "change_date", nullable = false)
    var changeDate: LocalDateTime = LocalDateTime.now()
)

enum class ChangeType {
    ADD, CONSUME, EXPIRE, ADJUSTMENT
}

