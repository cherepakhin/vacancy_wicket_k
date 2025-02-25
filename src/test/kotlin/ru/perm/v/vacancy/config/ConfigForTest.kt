package ru.perm.v.vacancy.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
// Значения задаются из файла src/test/resources/application-test.yaml ("src/TEST/..." !!!)
// не из src/MAIN/...
@ActiveProfiles("test")
class ConfigForTest {
    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Test
    fun getMyConfigRemoteHost() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }
}