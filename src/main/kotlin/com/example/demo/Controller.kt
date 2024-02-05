package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/hello")
    suspend fun hello() = Response("Hello, World!")

    @GetMapping("/hello-list")
    suspend fun helloList() = listOf("Hello")
}

data class Response(
    val message: String
)