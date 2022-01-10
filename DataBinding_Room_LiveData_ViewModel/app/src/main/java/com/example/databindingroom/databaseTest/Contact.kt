package com.example.databindingroom.databaseTest

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val Phone: String,
    val createdDate: Date,
    val isActive: Int
)
