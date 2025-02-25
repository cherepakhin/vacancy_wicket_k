package ru.perm.v.vacancy.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")  // Значения задаются в файле:
                         // src/TEST/resources/application-test.yaml
                         // @ActiveProfiles("test") -> TEST/resources/application-test.yaml
                         // "test" -> application-test.yaml
                         // application-test.yaml есть только в src/TEST/resources
                         // Если application-test.yaml нет существует, то тогда ниоткуда не берутся
class ConfigForMainDev {
    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Test
    fun getMyConfigRemoteHost() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }
}