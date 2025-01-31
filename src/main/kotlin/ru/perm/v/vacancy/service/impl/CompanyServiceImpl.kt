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

    val restCompanyClient = RestTemplate()

    override fun getByN(n: Long): CompanyDto {
        TODO("Not yet implemented")
    }
}