package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class RestTemplateIntegrationForTestProfileTest {

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Test
    fun getMyConfigRemoteHost() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }

}