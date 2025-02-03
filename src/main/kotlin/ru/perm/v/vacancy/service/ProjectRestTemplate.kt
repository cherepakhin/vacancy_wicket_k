package ru.perm.v.vacancy.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto

@Service
class ProjectRestTemplate {

    fun getForObjectList(url: String): Any {
// for list
//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java).toList()

//      РАБОТАЕТ!
//      val response = RestTemplate().getForObject(url, CompanyDto::class.java)

//        val response = RestTemplate().getForObject(url, Array<CompanyDto>::class.java)
        val response = RestTemplate().getForObject(url, List::class.java);

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

}