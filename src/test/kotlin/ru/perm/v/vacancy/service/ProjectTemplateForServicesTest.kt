package ru.perm.v.vacancy.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.perm.v.vacancy.dto.CompanyDto

/**
 * Test with projectRestTemplate
 */
@SpringBootTest
@ActiveProfiles("dev")
class ProjectTemplateForServicesTest {
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


    @Test
    fun getAllCheckBody_WithProjectRestTemplate() {
        val gson = Gson()
        val response = projectRestTemplate?.getForObjectList(remoteHost + "/company/")
        val companies: List<CompanyDto> =
            gson.fromJson(response.toString(), object : TypeToken<List<CompanyDto>>() {}.type)
        assertEquals(4, companies.size)
        assertEquals(CompanyDto(-1, "-"), companies[0])
        assertEquals(CompanyDto(1, "COMPANY_1"), companies[1])
        assertEquals(CompanyDto(2, "COMPANY_2"), companies.get(2))
        assertEquals(CompanyDto(3, "3_COMPANY"), companies.get(3))
    }

}