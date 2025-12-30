package com.rege.todo.controller

import com.rege.todo.dto.TodoRequest
import com.rege.todo.dto.TodoResponse
import com.rege.todo.service.TodoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {
    @PostMapping
    fun create(@Valid @RequestBody request: TodoRequest): ResponseEntity<TodoResponse> {
        return ResponseEntity.ok(todoService.create(request))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = ResponseEntity.ok(todoService.getTodo(id))
    // 메서드 내용이 한 줄이면 중괄호와 return을 생략하고 = 로 단일 표현식 함수로 씀, 타입 추론
}