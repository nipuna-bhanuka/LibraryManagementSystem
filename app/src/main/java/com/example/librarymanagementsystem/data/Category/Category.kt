package com.example.librarymanagementsystem.data.Category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "is_Available")
    val isAvailable : Boolean,
    @ColumnInfo(name = "is_Active")
    val isActive : Boolean = true
)