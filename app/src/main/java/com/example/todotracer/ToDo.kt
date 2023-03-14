package com.example.todotracer

import java.time.LocalDate
import java.util.Date

class ToDo(val name: String, val description: String, val category: String,
           val dueDate: LocalDate, val urgency: String) {
}