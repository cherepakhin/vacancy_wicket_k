package ru.perm.v.vacancy.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto

/**
 * Test with projectRestTemplate
 */
@SpringBootTest
@ActiveProfiles("dev")
class RestTemplateForServicesTest {
    @Autowired
    val projectRestTemplate: ProjectRestTemplate? = null

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

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
    fun getAllCheckBody_WithProjectRestTemplateAndGson() {
//        val response = RestTemplate().getForEntity(remoteHost + "/company/", List::class.java).body as List<CompanyDto>
//        assertEquals(4, response.size)

        val json = RestTemplate().getForEntity(remoteHost + "/company/", String::class.java).body
        val typeToken = object : TypeToken<kotlin.collections.List<CompanyDto>>() {}.type
        val companies = Gson().fromJson<List<CompanyDto>>(json, typeToken)

        assertEquals(4, companies.size)
        assertEquals(CompanyDto(-1L, "-"), companies[0])
        assertEquals(CompanyDto(1, "COMPANY_1"), companies[1])
        assertEquals(CompanyDto(2, "COMPANY_2"), companies.get(2))
        assertEquals(CompanyDto(3, "3_COMPANY"), companies.get(3))
    }

    @Test
    fun getAllCheckBody_WithProjectRestTemplateAndJacksonAndBody() {
        val response = RestTemplate().getForEntity(remoteHost + "/company/", Array::class.java).body
        assertEquals(4, response.size)
        assertEquals(java.util.LinkedHashMap::class.java, response[0]!!.javaClass)
    }

    @Test
    fun getAllCheckBody_WithProjectRestTemplateAndJacksonAndBodyConvert() {
        val response = RestTemplate().getForEntity(remoteHost + "/company/",
            String::class.java).body
        val mapper = ObjectMapper()
        val type = mapper.getTypeFactory().constructParametricType(
            List::class.java, CompanyDto::class.java);
        val companies = mapper.readValue<List<CompanyDto>>(response, type)

        assertEquals(4, companies.size)
        assertEquals(CompanyDto(-1L, "-"), companies[0])
        assertEquals(CompanyDto(1, "COMPANY_1"), companies[1])
        assertEquals(CompanyDto(2, "COMPANY_2"), companies.get(2))
        assertEquals(CompanyDto(3, "3_COMPANY"), companies.get(3))
    }

    @Test
    fun getAllCheckBody_WithProjectRestTemplate() {
        val response = RestTemplate().getForEntity(remoteHost + "/company/",
            Array::class.java).body
        assertEquals(4, response.size)
        assertEquals(java.util.LinkedHashMap::class.java, response[0]!!.javaClass)
    }

    @Test
    fun getAllCheckBody_WithProjectRestTemplateAsReceiveStringToJackson() {

        val jacksonMapper = jacksonObjectMapper()
//        val typeFactory = jacksonMapper.typeFactory.constructCollectionType(List::class.java, CompanyDto::class.java)
        val json = RestTemplate().getForEntity(remoteHost + "/company/", String::class.java).body
        val companies: List<CompanyDto> = jacksonMapper.readValue(json)
//        val typeToken = object : TypeToken<kotlin.collections.List<CompanyDto>>() {}.type
//        val companies = Gson().fromJson<List<CompanyDto>>(json, typeToken)

        assertEquals(4, companies.size)
        assertEquals(CompanyDto(-1L, "-"), companies[0])
        assertEquals(CompanyDto(1, "COMPANY_1"), companies[1])
        assertEquals(CompanyDto(2, "COMPANY_2"), companies.get(2))
        assertEquals(CompanyDto(3, "3_COMPANY"), companies.get(3))
    }

}