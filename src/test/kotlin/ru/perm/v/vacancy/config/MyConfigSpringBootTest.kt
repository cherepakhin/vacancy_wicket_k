package ru.perm.v.vacancy.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = arrayOf(MyConfig::class))
class MyConfigSpringBootTest {
    @Autowired
    lateinit var myConfig: MyConfig

    @Test
    fun companyRestUrlTest() {
        assertEquals("http://127.0.0.1:8980/vacancy/api/company", myConfig.remoteHost + myConfig.companyRestUrl)
    }

    @Test
    fun vacancyRestUrlTest() {
        assertEquals("http://127.0.0.1:8980/vacancy/api/vacancy", myConfig.remoteHost + myConfig.vacancyRestUrl)
    }
}