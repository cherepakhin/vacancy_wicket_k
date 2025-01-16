package ru.perm.v.vacancy.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/echo")
class EchoCtrl {
    @GetMapping("/{message}")
    fun echo(@PathVariable("message") message: String): String {
        return message
    }
}