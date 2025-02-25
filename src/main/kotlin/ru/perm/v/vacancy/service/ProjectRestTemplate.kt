package ru.perm.v.vacancy.service

import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto

@Service
class ProjectRestTemplate {

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    fun getForObjectList(url: String): Any {
// for list
//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java).toList()

//      РАБОТАЕТ!
//      val response = RestTemplate().getForObject(url, CompanyDto::class.java)

//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java)
        val response = RestTemplate().getForEntity(url, List::class.java).body as List<CompanyDto>
//        val response = RestTemplate().exchange<List<CompanyDto>>(url, HttpMethod.GET,
//            null, object : ParameterizedTypeReference<List<CompanyDto>>() {})
        return response
    }

    fun getForObjectCompany(url: String): CompanyDto? {
// for list
//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java).toList()

//      РАБОТАЕТ!
//      val response = RestTemplate().getForObject(url, CompanyDto::class.java)

        val response = RestTemplate().getForObject(url, CompanyDto::class.java)

        return response
    }

//    fun getForEntity(url: String): ResponseEntity {
//        RestTemplate().getForEntity(url)
//    }
}