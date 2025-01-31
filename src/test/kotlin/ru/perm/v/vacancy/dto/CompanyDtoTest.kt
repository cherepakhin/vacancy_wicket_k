package ru.perm.v.vacancy.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class CompanyDtoTest {

    @Test
    fun testGettersAndSetters() {
        val id = 1L
        val name = "Test Company"

        val companyDto = CompanyDto(id, name)

        assertEquals(id, companyDto.n)
        assertEquals(name, companyDto.name)
    }

    @Test
    fun testEquals() {
        val companyDto1 = CompanyDto(1L, "Test Company")
        val companyDto2 = CompanyDto(1L, "Test Company")
        val companyDto3 = CompanyDto(2L, "Another Company")

        assertEquals(companyDto1, companyDto2)
        assertEquals(companyDto1, companyDto1)
        assertEquals(companyDto2, companyDto2)

        assertNotEquals(companyDto1, companyDto3)
        assertNotEquals(companyDto2, companyDto3)
    }

}

