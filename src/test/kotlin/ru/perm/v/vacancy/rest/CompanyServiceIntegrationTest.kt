package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService

@SpringBootTest
class CompanyServiceIntegrationTest {

    @Autowired
    lateinit var companyService: CompanyService

    @Test
    fun getByN() {
        val company = companyService.getByN(1)

        assertEquals(CompanyDto(1, "COMPANY_1"), company)
    }
}