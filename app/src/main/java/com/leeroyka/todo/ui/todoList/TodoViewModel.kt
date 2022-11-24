package com.leeroyka.todo.ui.todoList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.leeroyka.todo.data.TodoRepository
import com.leeroyka.todo.data.db.TodoRecord

/**
 * @author Leeroyka
 */
class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoRepository = TodoRepository(application)
    private val allTodoList: LiveData<List<TodoRecord>> = repository.getAllTodoList()

    fun saveTodo(todo: TodoRecord) {
        repository.saveTodo(todo)
    }

    fun updateTodo(todo: TodoRecord){
        repository.updateTodo(todo)
    }

    fun deleteTodo(todo: TodoRecord) {
        repository.deleteTodo(todo)
    }

    fun getAllTodoList(): LiveData<List<TodoRecord>> {
        return allTodoList
    }

}
