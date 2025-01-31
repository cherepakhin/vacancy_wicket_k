package ru.perm.v.vacancy.dto

class VacancyDto {
    var id: Long = 0
    var name: String = ""
    var description: String = ""
    var companyDto: CompanyDto = CompanyDto(-1L, "")

    constructor() {

    }

    constructor(id: Long, name: String, description: String, companyDto: CompanyDto) : this() {
        this.id = id
        this.name = name
        this.description = description
        this.companyDto = companyDto
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VacancyDto

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (companyDto != other.companyDto) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + companyDto.hashCode()
        return result
    }
}