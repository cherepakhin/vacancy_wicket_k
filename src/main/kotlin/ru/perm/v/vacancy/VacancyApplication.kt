package ru.perm.v.vacancy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VacancyApplication

fun main(args: Array<String>) {
    runApplication<VacancyApplication>(*args)
}
