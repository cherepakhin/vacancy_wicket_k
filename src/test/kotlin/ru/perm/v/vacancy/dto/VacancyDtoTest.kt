package ru.perm.v.vacancy.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class VacancyDtoTest {
    @Test
    fun testGettersAndSetters() {
        val id = 1L
        val name = "Test Vacancy"
        val description = "Test description"
        val companyDto = CompanyDto(1L, "Test Company")

        val vacancyDto = VacancyDto(id, name, description, companyDto)

        assertEquals(id, vacancyDto.id)
        assertEquals(name, vacancyDto.name)
        assertEquals(description, vacancyDto.description)
        assertEquals(companyDto, vacancyDto.companyDto)
    }

    @Test
    fun testBoundaryCases() {
        val vacancyDto = VacancyDto(Long.MIN_VALUE, "", "", CompanyDto(Long.MIN_VALUE, ""))
        assertEquals(Long.MIN_VALUE, vacancyDto.id)
        assertEquals("", vacancyDto.name)
        assertEquals("", vacancyDto.description)
        assertEquals(CompanyDto(Long.MIN_VALUE, ""), vacancyDto.companyDto)

        val vacancyDto2 = VacancyDto(Long.MAX_VALUE, "a".repeat(1000), "b".repeat(1000), CompanyDto(Long.MAX_VALUE, "c".repeat(1000)))
        assertEquals(Long.MAX_VALUE, vacancyDto2.id)
        assertEquals("a".repeat(1000), vacancyDto2.name)
        assertEquals("b".repeat(1000), vacancyDto2.description)
        assertEquals(CompanyDto(Long.MAX_VALUE, "c".repeat(1000)), vacancyDto2.companyDto)
    }

    @Test
    fun testEquals() {
        val vacancyDto1 = VacancyDto(1L, "Test Vacancy", "Test description", CompanyDto(1L, "Test Company"))
        val vacancyDto2 = VacancyDto(1L, "Test Vacancy", "Test description", CompanyDto(1L, "Test Company"))
        val vacancyDto3 = VacancyDto(2L, "Another Vacancy", "Another description", CompanyDto(2L, "Another Company"))

        assertEquals(vacancyDto1, vacancyDto2)
        assertEquals(vacancyDto1, vacancyDto1)
        assertEquals(vacancyDto2, vacancyDto2)

        assertNotEquals(vacancyDto1, vacancyDto3)
        assertNotEquals(vacancyDto2, vacancyDto3)
    }
}