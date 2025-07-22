package com.bservice.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ExampleController {

    @GetMapping("/api/a")
    fun getA(): ResponseEntity<String> {
        Thread.sleep(Random.nextLong(100, 1000))
        return ResponseEntity.ok("B Service Call Success")
    }

    @GetMapping("/api/b")
    fun getB(): ResponseEntity<String> {
        Thread.sleep(Random.nextLong(100, 1000))
        return ResponseEntity.ok("B Service Call Success")
    }

    @GetMapping("/api/c")
    fun getC(): ResponseEntity<String> {
        Thread.sleep(Random.nextLong(100, 1000))
        return ResponseEntity.ok("B Service Call Success")
    }

    @GetMapping("/api/d")
    fun getD(): ResponseEntity<String> {
        Thread.sleep(Random.nextLong(100, 1000))
        return ResponseEntity.ok("B Service Call Success")
    }
}