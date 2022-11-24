package com.leeroyka.todo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author Leeroyka
 */

@Dao
interface TodoDao {

    @Insert
    suspend fun saveTodo(todoRecord: TodoRecord)

    @Delete
    suspend fun deleteTodo(todoRecord: TodoRecord)

    @Update
    suspend fun updateTodo(todoRecord: TodoRecord)

    @Query("SELECT * FROM todo ORDER BY id DESC")
    fun getAllTodoList(): LiveData<List<TodoRecord>>
}