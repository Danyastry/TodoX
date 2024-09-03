package com.example.todos.data.model

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity("todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("description")
    val description: String,

    @ColumnInfo("done")
    val done: Boolean = false,

    @ColumnInfo("added")
    val addedDate: Long = System.currentTimeMillis()
)

val TodoEntity.addDate: String
    @SuppressLint("SimpleDateFormat")
    get() = SimpleDateFormat("MM/dd HH:mm", Locale.UK).format(Date(addedDate))