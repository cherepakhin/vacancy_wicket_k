package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.perm.v.vacancy.config.MyConfig

/**
 * Перед запуском теста проект /prog/kolin/vacancy_backend НУЖНО запустить! (НУЖНО ЗАМОКАТЬ!)
 */
@SpringBootTest
@ActiveProfiles("test")
class CompanyServiceIntegrationTest {

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null
//    @MockkBean
//    val projectRestTemplate = Mockito.mock(ProjectRestTemplate::class.java)

    @Test
    fun getMyConfigRemoteHost() {
        assertEquals("http://127.0.0.1:8980/vacancy/api", remoteHost)
//        val companyService = CompanyServiceImpl()
//
//        val company = companyService.getByN(1)
//
//        assertEquals(CompanyDto(1, "COMPANY_1"), company)
    }

//    @Test
//    fun testGetAll() {
//        val companies = listOf(
//            CompanyDto(1L, "Test Company 1"),
//            CompanyDto(2L, "Test Company 2"))
//        val myConfig = Mockito.mock(MyConfig::class.java)
//        Mockito.`when`(myConfig.remoteHost).thenReturn("http://127.0.0.1:8980/vacancy/api")
//        Mockito.`when`(myConfig.companyRestUrl).thenReturn("/company")
//        val projectRestTemplate = Mockito.mock(ProjectRestTemplate::class.java)
//        val url = " http://127.0.0.1:8980/vacancy/api/company"
//        Mockito.`when`(projectRestTemplate.getForObject(url, List::class.java)).thenReturn(companies)
//        val companyService = CompanyServiceImpl()
//
//        val result = companyService.getAll()
//
//        assertEquals(companies, result)
//        Mockito.verify(restTemplate).getForObject(url, List::class.java)
//    }

}