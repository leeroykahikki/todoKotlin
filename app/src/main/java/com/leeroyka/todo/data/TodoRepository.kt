package com.leeroyka.todo.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.leeroyka.todo.data.db.TodoDao
import com.leeroyka.todo.data.db.TodoDatabase
import com.leeroyka.todo.data.db.TodoRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Leeroyka
 */
class TodoRepository(application: Application) {

    private val todoDao: TodoDao
    private val allTodos: LiveData<List<TodoRecord>>

    init {
        val database = TodoDatabase.getInstance(application.applicationContext)
        todoDao = database!!.todoDao()
        allTodos = todoDao.getAllTodoList()
    }

    fun saveTodo(todo: TodoRecord) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.saveTodo(todo)
        }
    }

    fun updateTodo(todo: TodoRecord) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.updateTodo(todo)
        }
    }


    fun deleteTodo(todo: TodoRecord) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                todoDao.deleteTodo(todo)
            }
        }
    }

    fun getAllTodoList(): LiveData<List<TodoRecord>> {
        return allTodos
    }
}