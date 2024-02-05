package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @Autowired
    lateinit var webClient: WebTestClient

    @Test
    fun `test object`() {
        webClient.get()
            .uri("/hello")
            .exchange()
            .expectStatus()
            .isOk
            .expectBody(Response::class.java)
            .value {
                assert(it.message == "Hello, World!")
            }
    }

    @Test
    fun `test list`() {
        webClient.get()
            .uri("/hello")
            .exchange()
            .expectStatus().isOk
            .expectBody(List::class.java)
            .value<WebTestClient.ListBodySpec<String>> {
                assert(it[0] == "Hello")
            }
    }
}
