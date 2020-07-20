package com.mohammad.framework.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    val userId: String,
    val message: String,
    var fromMe: Boolean,
    val createdAt: Long
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
