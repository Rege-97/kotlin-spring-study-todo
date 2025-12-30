package com.rege.todo.controller

import com.rege.todo.dto.TodoRequest
import com.rege.todo.dto.TodoResponse
import com.rege.todo.service.TodoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
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
}