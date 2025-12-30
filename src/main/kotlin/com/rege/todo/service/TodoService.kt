package com.rege.todo.service

import com.rege.todo.dto.TodoRequest
import com.rege.todo.dto.TodoResponse
import com.rege.todo.entity.Todo
import com.rege.todo.repository.TodoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository // 생성자 주입(매개변수로 작성)
) {

    @Transactional
    fun create(request: TodoRequest): TodoResponse {
        val todo = Todo(title = request.title)
        todoRepository.save(todo)
        return TodoResponse.of(todo)
    }
}