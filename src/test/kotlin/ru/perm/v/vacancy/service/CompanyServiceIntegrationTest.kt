package ru.perm.v.vacancy.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.perm.v.vacancy.dto.CompanyDto

/**
 * Перед запуском теста проект /prog/kotlin/vacancy_backend НУЖНО запустить,
 * т.к. это интеграционные тесты
 */
@SpringBootTest
@ActiveProfiles("test")
class CompanyServiceIntegrationTest {

    @Autowired
    lateinit var companyService: CompanyService

    @Test
    fun getByN() {
        val COMPANY_N = 1L

        val company = companyService.getByN(COMPANY_N)

        assertEquals(CompanyDto(COMPANY_N, "COMPANY_1"), company)
    }

    @Test
    fun getAll() {
        val companies = companyService.getAll()
        assertEquals(4, companies.size)
        assertEquals(CompanyDto(n = -1, name = "-"), companies[0])
        assertEquals(CompanyDto(n = 1, name = "COMPANY_1"), companies[1])
        assertEquals(CompanyDto(n = 2, name = "COMPANY_2"), companies[2])
        assertEquals(CompanyDto(n = 3, name = "3_COMPANY"), companies[3])
    }

}