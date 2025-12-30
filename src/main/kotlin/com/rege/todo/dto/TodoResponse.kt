package com.rege.todo.dto

import com.rege.todo.entity.Todo

data class TodoResponse(
    val id: Long,
    val title: String,
    val isDone: Boolean
) {
    companion object {  // static 대체
        fun of(todo: Todo): TodoResponse {
            return TodoResponse(
                id = requireNotNull(todo.id) { "id 값이 없습니다." }, // null 검증(IllegalArgumentException)
                title = todo.title,
                isDone = todo.isDone
            )
        }
    }
}
