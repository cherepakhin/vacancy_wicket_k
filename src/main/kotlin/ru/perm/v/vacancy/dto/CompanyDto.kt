package ru.perm.v.vacancy.dto

//import kotlinx.serialization.*
//import kotlinx.serialization.json.Json
//
//@Serializable
class CompanyDto(val n: Long, val name: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        val otherDto = other as CompanyDto
        if (!n.equals(otherDto.n)) return false
        if (!name.equals(other.name)) return false

        return true
    }

    override fun hashCode(): Int {
        return n.hashCode() + name.hashCode()
    }

    override fun toString(): String {
        return "CompanyDto(n=$n, name=$name)"
    }
}