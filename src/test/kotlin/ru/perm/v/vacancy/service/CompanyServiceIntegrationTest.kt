package ru.perm.v.vacancy.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
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

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    // так правильно внедрять значение частного параметра
    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Autowired
    lateinit var companyService: CompanyService

// так НЕ получится
//    @Value("\${myconfig}")
//    val myConfig: MyConfig? = null
// надо так:
//    @Value("\${myconfig.remoteHost}")
//    val remoteHost: String? = null
//
//    Тест пройдет, но это не то что нужно. Значения из application.yaml не будут видны.
//    @Test
//    fun checkMyConfig() {
//        assertEquals("-", myConfig?.remoteHost)
//    }

    @BeforeEach
    fun initDB() {
    }

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