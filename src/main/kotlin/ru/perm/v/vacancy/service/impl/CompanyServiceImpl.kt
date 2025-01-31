package ru.perm.v.vacancy.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.perm.v.vacancy.config.MyConfig
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService

@Service
class CompanyServiceImpl : CompanyService {
    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    @Autowired
    lateinit var myConfig: MyConfig

    val restTemplate = RestTemplate()

    override fun getByN(n: Long): CompanyDto {
        logger.info("Get company by n=$n")
        logger.info("myConfig.companyRestUrl: " + myConfig.companyRestUrl)
        logger.info("rest: " + myConfig.remoteHost + myConfig.companyRestUrl)
        val url = myConfig.remoteHost + myConfig.companyRestUrl + "/$n"
        logger.info("url: " + url)
        val companyDTO = restTemplate.getForObject(url, CompanyDto::class.java)
        return companyDTO!!
    }
}