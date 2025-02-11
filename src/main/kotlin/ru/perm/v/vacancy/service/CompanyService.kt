package ru.perm.v.vacancy.service

import ru.perm.v.vacancy.config.MyConfig
import ru.perm.v.vacancy.dto.CompanyDto

interface CompanyService {
    @Throws(Exception::class)
    fun getByN(n:Long): CompanyDto
    fun getAll(): List<CompanyDto>
    fun config(): MyConfig
}