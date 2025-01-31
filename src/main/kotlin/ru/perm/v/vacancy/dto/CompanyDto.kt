package ru.perm.v.vacancy.dto

class CompanyDto(val n: Long, val name: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CompanyDto

        if (n != other.n) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return n.hashCode() + name.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}