package ru.perm.v.vacancy.rest

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService
import ru.perm.v.vacancy.service.ProjectRestTemplate

/**
 * Перед запуском теста проект /prog/kotlin/vacancy_backend НУЖНО запустить,
 * т.к. это интеграционные тесты
 */
@SpringBootTest
@ActiveProfiles("dev")
class CompanyServiceIntegrationTest {

    @Autowired
    val companyService: CompanyService? = null

    val gson = Gson()

    @Autowired
    val projectRestTemplate: ProjectRestTemplate? = null

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Test
    fun getMyConfigRemoteHost() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
    }

    @Test
    fun getByN_WithProjectRestTemplate() {
        val company = projectRestTemplate?.getForObjectCompany(remoteHost + "/company/1")

        assertEquals(CompanyDto(1, "COMPANY_1"), company)
    }

    //TODO: echo

    @Test
    fun getAllCheckBody_WithProjectRestTemplate() {
        val response = projectRestTemplate?.getForObjectList(remoteHost + "/company/")
        val companies: List<CompanyDto> =
            gson.fromJson(response.toString(), object : TypeToken<List<CompanyDto>>() {}.type)
        assertEquals(4, companies.size)
        assertEquals(CompanyDto(-1, "-"), companies[0])
        assertEquals(CompanyDto(1, "COMPANY_1"), companies[1])
        assertEquals(CompanyDto(2, "COMPANY_2"), companies.get(2))
        assertEquals(CompanyDto(3, "3_COMPANY"), companies.get(3))
    }

    @Test
    fun getAllCheckStatus() {
        val COMPANY_N = 1L
        if (companyService == null) {
            fail("CompanyService is null")
        }
        val company = companyService?.getByN(COMPANY_N)
        assertEquals(CompanyDto(COMPANY_N, ""), company)
//        val response = projectRestTemplate?.getForEntity(remoteHost + "/company/")
//        assertEquals("OK", response)
    }

}