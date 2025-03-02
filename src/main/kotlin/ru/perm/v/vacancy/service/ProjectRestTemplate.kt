package ru.perm.v.vacancy.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto

/**
 * Demo use RestTemplate
 */
@Service
class ProjectRestTemplate {

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    /**
     * Demo use RestTemplate() for return OBJECT
     */
    fun getForObjectCompany(url: String): CompanyDto? {
// for list
//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java).toList()

//      РАБОТАЕТ!
//      val response = RestTemplate().getForObject(url, CompanyDto::class.java)

        val response = RestTemplate().getForObject(url, CompanyDto::class.java)

        return response
    }

    /**
     * Demo use RestTemplate() for return LIST OBJECT
     */
    fun getForObjectList(url: String): Any {

//      val response = RestTemplate().getForObject(url, CompanyDto::class.java)

// for list
//      val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java).toList()
//      val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java)
//      val response = RestTemplate().exchange<List<CompanyDto>>(url, HttpMethod.GET,
//              null, object : ParameterizedTypeReference<List<CompanyDto>>() {})

        val response = RestTemplate().getForEntity(url, List::class.java).body as List<CompanyDto>
        return response
    }

}