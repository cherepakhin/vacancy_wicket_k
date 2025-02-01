package ru.perm.v.vacancy.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.perm.v.vacancy.config.MyConfig
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService
import ru.perm.v.vacancy.service.ProjectRestTemplate

@Service
class CompanyServiceImpl : CompanyService {
    @Autowired
    lateinit var myConfig: MyConfig

    @Autowired
    lateinit var projectRestTemplate: ProjectRestTemplate

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    override fun getByN(n: Long): CompanyDto {

        logger.info("Get company by n=$n")
        logger.info("myConfig.companyRestUrl: " + myConfig.companyRestUrl)
        logger.info("rest: " + myConfig.remoteHost + myConfig.companyRestUrl)
        val url = myConfig.remoteHost + myConfig.companyRestUrl + "/$n"
        logger.info("url: " + url)

        val companyDTO = projectRestTemplate.getForObject(url)
        return companyDTO as CompanyDto
    }

    override fun getAll(): List<CompanyDto> {
        logger.info("Get all companies")
        val url = myConfig.remoteHost + myConfig.companyRestUrl
        logger.info("url: " + url)
        var companies = projectRestTemplate.getForObject(url)
        return companies!! as List<CompanyDto>
    }


}