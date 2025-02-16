package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService

/**
 * Перед запуском теста проект /prog/kotlin/vacancy_backend НУЖНО запустить,
 * т.к. это интеграционные тесты
 */
@SpringBootTest
@ActiveProfiles("test")
class CompanyServiceIntegrationTest {
//    @Autowired
//    val projectRestTemplate: ProjectRestTemplate? = null

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

    @Test
    fun checkRemoteHostValue() {
        if (companyService == null) {
            fail("CompanyService is null")
        }
        assertEquals("http://127.0.0.1:8980/vacancy/test/api", remoteHost)

//        val company = companyService?.getByN(COMPANY_N)
//        assertEquals(CompanyDto(COMPANY_N, ""), company)
//        val response = projectRestTemplate?.getForEntity(remoteHost + "/company/")
//        assertEquals("OK", response)
    }

    @Test
    fun getAll() {
        if (companyService == null) {
            fail("CompanyService is null")
        }
        val companies = companyService.getAll()

        logger.info(companies[0].javaClass.name)
        assertEquals(4, companies.size)
        assertEquals(CompanyDto(n=-1, name="-"), companies[0])
        assertEquals(CompanyDto(n=1, name="COMPANY_1"), companies[1])
        assertEquals(CompanyDto(n=2, name="COMPANY_2"), companies[2])
        assertEquals(CompanyDto(n=3, name="3_COMPANY"), companies[3])
    }

}