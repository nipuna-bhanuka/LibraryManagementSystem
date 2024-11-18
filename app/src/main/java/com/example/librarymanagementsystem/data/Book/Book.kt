package com.example.librarymanagementsystem.data.Book
import androidx.room.*
import com.example.librarymanagementsystem.data.Category.Category

@Entity(
    tableName = "books",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["category_Id"],
            onDelete = ForeignKey.CASCADE
        )],
)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "author")
    val author : String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "category_Id")
    val categoryId : Int,
    @ColumnInfo(name = "is_Available")
    val isAvailable : Boolean,
    @ColumnInfo(name = "is_Active")
    val isActive : Boolean = true
)
