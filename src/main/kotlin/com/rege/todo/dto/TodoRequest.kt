package com.rege.todo.dto

import jakarta.validation.constraints.NotBlank

data class TodoRequest(
    @field:NotBlank // 코틀린은 field 붙여야함
    val title: String
)
