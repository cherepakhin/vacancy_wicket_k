package ru.perm.v.vacancy.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto

@SpringBootTest
@ActiveProfiles("test")
class ProjectRestTemplateIntegrationTest {
    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Autowired
    lateinit var projectRestTemplate: ProjectRestTemplate

    @Test
    fun checkRemoteHostValue() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }

    @Test
    fun checkWorkRestTemplate() {
        val COMPANY_N = 1L
        val response = projectRestTemplate?.getForObjectCompany(remoteHost + "/company/${COMPANY_N}")

        assert(response != null)
        assertEquals(CompanyDto(COMPANY_N, "COMPANY_1"), response)
    }

    @Test
    fun forList() {
        val url = "http://127.0.0.1:8980/vacancy/api/company/"
        val companies = RestTemplate().getForEntity(url, List::class.java).body as List<CompanyDto>

        assertEquals(4, companies.size)
    }

    @Test
    fun forEntity() {
        val url = "http://127.0.0.1:8980/vacancy/api/company/1"
        val company = RestTemplate().getForEntity(url, CompanyDto::class.java).body as CompanyDto

        assertEquals(1, company.n)
    }
}