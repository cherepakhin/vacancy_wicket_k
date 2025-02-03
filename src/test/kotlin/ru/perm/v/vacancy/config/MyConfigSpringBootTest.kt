package ru.perm.v.vacancy.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class MyConfigSpringBootTest {

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Value("\${myconfig.companyRestUrl}")
    val companyRestUrl: String? = null

    @Test
    fun companyRestUrlTest() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }

    @Test
    fun companyRestHostTest() {
        assertEquals("/company", companyRestUrl)
    }

}