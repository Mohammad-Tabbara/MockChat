package com.mohammad.framework.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DisplayContact(
    @PrimaryKey val id: String,
    val name: String,
    val imagePath: String
) {
    var lastMessage: String? = null
    var lastMessageCreatedAt: Long? = null
}
