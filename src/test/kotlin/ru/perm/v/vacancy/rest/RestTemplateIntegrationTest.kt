package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto

@SpringBootTest
@ActiveProfiles("test")
class RestTemplateIntegrationTest {

    val remoteHost = "http://127.0.0.1:8980/vacancy/api/company"

    @Test
    fun getBodyAsString() {
        val N = 1L
        val company = RestTemplate().getForObject("$remoteHost/$N", String::class.java)

        assertEquals("{\"n\":1,\"name\":\"COMPANY_1\"}", company)
    }

    @Test
    fun getBodyAsCompany() {
        val N = 1L
        val company =
            RestTemplate().getForObject("$remoteHost/$N", CompanyDto::class.java)

        assertEquals(CompanyDto(N, "COMPANY_1"), company)
    }

    @Test
    fun getForRequestEntity() {
        val N = 1L
        val URL = "$remoteHost/$N"
        val response = RestTemplate().getForEntity(URL, CompanyDto::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(CompanyDto(N, "COMPANY_1"), response.body)

    }
}