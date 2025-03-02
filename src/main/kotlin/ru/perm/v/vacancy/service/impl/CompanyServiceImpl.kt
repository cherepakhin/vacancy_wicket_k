package ru.perm.v.vacancy.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService
import ru.perm.v.vacancy.service.ProjectRestTemplate
import kotlin.jvm.javaClass

//TODO: add tests. see RestTemplateForServicesTest, ...
@Service
class CompanyServiceImpl : CompanyService {

    @Value("\${myconfig.remoteHost}")
    val remoteHost: String? = null

    @Value("\${myconfig.companyRestUrl}")
    val companyRestUrl: String? = null

//    @Autowired
//    lateinit var projectRestTemplate: ProjectRestTemplate

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    override fun getByN(n: Long): CompanyDto {
        logger.info("Get company by n=$n")
        logger.info("myConfig.companyRestUrl: " + companyRestUrl)
        logger.info("rest: " + companyRestUrl)

        val url = remoteHost + companyRestUrl + "/$n"
        logger.info("url: " + url)
        // можно так
        // val companyDTO = projectRestTemplate.getForObjectCompany(url)
        // но так лучше
        val result = RestTemplate().exchange(url, HttpMethod.GET,
            null, object : ParameterizedTypeReference<CompanyDto>() {})
        val companyDTO = result.body as CompanyDto
        return companyDTO
    }

    override fun getAll(): List<CompanyDto> {
        logger.info("Get all companies")
        logger.info("myConfig.remoteHost: " + remoteHost)
        logger.info("myConfig.companyRestUrl: " + companyRestUrl)
        if (companyRestUrl == null) {
            throw Exception("companyRestUrl=null")
        }
        val urlCompany = remoteHost + companyRestUrl + "/"
        logger.info("urlCompany: $urlCompany")
        val result = RestTemplate().exchange(urlCompany, HttpMethod.GET,
            null, object : ParameterizedTypeReference<List<CompanyDto>>() {})
        val listCompanies = result.body as List<CompanyDto>
        logger.info("listCompanies: " + listCompanies)
//        logger.info("listCompanies[0]: " + listCompanies[0].javaClass.name)
//        logger.info("listCompanies[0]: " + listCompanies[0])
        return listCompanies
    }
}