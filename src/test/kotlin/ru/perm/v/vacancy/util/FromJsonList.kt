package ru.perm.v.vacancy.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.vacancy.dto.CompanyDto

class FromJsonList {
    @Test
    fun fromJsonArrayToList() {
        val json = "[CompanyDto(n=-1, name=-), CompanyDto(n=1, name=COMPANY_1), CompanyDto(n=2, name=COMPANY_2), CompanyDto(n=3, name=3_COMPANY)]"
        val typeToken = object : TypeToken<List<CompanyDto>>() {}.type
        val companies: List<CompanyDto> =
            Gson().fromJson<List<CompanyDto>>(json, typeToken)

        assertEquals(4, companies.size)
    }
}