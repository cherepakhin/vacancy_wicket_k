package ru.perm.v.vacancy.service

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import ru.perm.v.vacancy.dto.CompanyDto
import java.util.Arrays

@Service
class ProjectRestTemplate {

    fun getForObject(url: String): Any {
//        return CompanyDto(1L,"")
// for list
//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java).toList()
        val response = RestTemplate().getForObject(url, CompanyDto::class.java)

//        val companies = RestTemplate().exchange(url, HttpMethod.GET, null, List<CompanyDto>).body!!
        return response
//        var result = RestTemplate().getForObject(url) ?: throw Exception()
//        return RestTemplate().getForObject(url) ?: throw Exception()
    }

}