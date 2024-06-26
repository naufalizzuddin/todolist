package com.kelompok6.todolist

import android.content.Context
import androidx.room.Room
import com.kelompok6.todolist.data.ToDoDatabase
import com.kelompok6.todolist.data.ToDoRepo


object Graph {
    lateinit var database: ToDoDatabase

    val ToDoRepo by lazy {
        ToDoRepo(todoDao = database.todoDAO())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, ToDoDatabase::class.java, "com.kelompok6.todolist.db").build()
    }
}