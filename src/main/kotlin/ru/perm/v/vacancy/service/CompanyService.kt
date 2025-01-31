package ru.perm.v.vacancy.service

import ru.perm.v.vacancy.dto.CompanyDto

interface CompanyService {
    @Throws(Exception::class)
    fun getByN(n:Long): CompanyDto
}