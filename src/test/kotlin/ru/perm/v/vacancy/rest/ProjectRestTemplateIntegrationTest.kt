package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.ProjectRestTemplate

@SpringBootTest
@ActiveProfiles("test")
class ProjectRestTemplateIntegrationTest {

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Test
    fun getMyConfigRemoteHost() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }

    @Test
    fun getBodyAsString() {
        val N = 1L
        val company = RestTemplate().getForObject("$remoteHost/company/$N", String::class.java)

        assertEquals("{\"n\":1,\"name\":\"COMPANY_1\"}", company)
    }

    @Test
    fun getBodyAsCompany() {
        val N = 1L
        val company =
            RestTemplate().getForObject("$remoteHost/company/$N", CompanyDto::class.java)

        assertEquals(CompanyDto(N, "COMPANY_1"), company)
    }

    @Test
    fun getForRequestEntity() {
        val N = 1L
        val URL = "$remoteHost/company/$N"
        val response = RestTemplate().getForEntity(URL, CompanyDto::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(CompanyDto(N, "COMPANY_1"), response.body)

    }
}