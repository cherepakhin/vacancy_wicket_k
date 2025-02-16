package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.perm.v.vacancy.config.MyConfig
import ru.perm.v.vacancy.service.CompanyService
import ru.perm.v.vacancy.service.ProjectRestTemplate

/**
 * Перед запуском теста проект /prog/kotlin/vacancy_backend НУЖНО запустить,
 * т.к. это интеграционные тесты
 */
@SpringBootTest
@ActiveProfiles("test")
class CompanyServiceIntegrationTest {
    @Autowired
    val projectRestTemplate: ProjectRestTemplate? = null

    // так правильно внедрять значение частного параметра
    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Autowired
    val companyService: CompanyService? = null

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
    fun getAllCheckStatus() {
        if (companyService == null) {
            fail("CompanyService is null")
        }
        assertEquals("http://127.0.0.1:8980/vacancy/test/api", remoteHost)

//        val company = companyService?.getByN(COMPANY_N)
//        assertEquals(CompanyDto(COMPANY_N, ""), company)
//        val response = projectRestTemplate?.getForEntity(remoteHost + "/company/")
//        assertEquals("OK", response)
    }
}