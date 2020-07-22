package com.mohammad.framework.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    val userId: String,
    val message: String,
    var fromMe: Boolean,
    var createdAt: Long = 0
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
