package ru.perm.v.vacancy.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.perm.v.vacancy.config.MyConfig
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService
import ru.perm.v.vacancy.service.ProjectRestTemplate
import kotlin.jvm.javaClass

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

        val companyDTO = projectRestTemplate.getForObjectCompany(url)
        return companyDTO as CompanyDto
    }

    override fun getAll(): List<CompanyDto> {
        logger.info("Get all companies")
        val url = myConfig.remoteHost + myConfig.companyRestUrl +"/"
        logger.info("url: " + url)
        var companies = projectRestTemplate.getForObjectList(url)
        logger.info("companies: " + companies)
        logger.info("companies.class: " + companies.javaClass)
        logger.info("companies.class.name: " + companies.javaClass.name)
        val listCompany = companies as List<*>
        logger.info("listCompany: " + listCompany)
//        val theGson = Gson();
//        val customer = theGson
//            .fromJson(customerObject, Customer::class.java);
//        jacksonObjectMapper().
        for(dto in listCompany) {
            logger.info("company: " + dto)
//            logger.info(dto?.javaClass?.name)
//            val gson = Gson()
//            JSON.readValue(dto)
//            var c = ObjectMapper().readValue("dto", CompanyDto::javaClass.name)
//            logger.info("c:" + c)
//            val c = dto as CompanyDto
//            logger.info(c.name)
        }
        return ArrayList()
    }

    override fun config(): MyConfig {
        return myConfig
    }
}