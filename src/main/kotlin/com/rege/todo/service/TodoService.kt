package com.rege.todo.service

import com.rege.todo.dto.TodoRequest
import com.rege.todo.dto.TodoResponse
import com.rege.todo.entity.Todo
import com.rege.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(
    private val todoRepository: TodoRepository // 생성자 주입(매개변수로 작성)
) {

    @Transactional
    fun create(request: TodoRequest): TodoResponse {
        val todo = Todo(title = request.title)  // new 없이 생성
        todoRepository.save(todo)
        return TodoResponse.of(todo)
    }

    @Transactional(readOnly = true)
    fun getTodo(id: Long): TodoResponse {
        // findByIdOrNull + 엘비스 연산자(?:)
        // 좌항이 null이면 우항(예외 던지기) 실행
        // 코틀린은 기본적으로 null이 Optional 역할을 함
        val todo = todoRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("해당 todo가 없음")
        return TodoResponse.of(todo)
    }

}