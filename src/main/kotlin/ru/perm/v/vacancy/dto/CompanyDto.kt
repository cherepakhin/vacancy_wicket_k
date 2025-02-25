package ru.perm.v.vacancy.dto

import kotlinx.serialization.Serializable

@Serializable
class CompanyDto {
    var n: Long = -1L
    var name: String = ""

    // need for jackson
    constructor() {

    }

    constructor(n: Long, name: String) :this() {
        this.n = n
        this.name = name
    }

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