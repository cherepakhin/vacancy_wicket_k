package ru.perm.v.vacancy.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.perm.v.vacancy.dto.CompanyDto
import ru.perm.v.vacancy.service.CompanyService

@RestController
@RequestMapping("/company")
class CompanyCtrl {
    @Autowired
    lateinit var companyService: CompanyService

    @GetMapping("/{id}")
    fun echo(@PathVariable("id") id:Long): CompanyDto {
        return companyService.getByN(id)
    }
}