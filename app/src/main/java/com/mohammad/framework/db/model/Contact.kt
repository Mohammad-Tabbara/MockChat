package com.mohammad.framework.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(@PrimaryKey val id: String, val name: String, val imagePath: String)
