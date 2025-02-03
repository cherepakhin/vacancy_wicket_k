package ru.perm.v.vacancy.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MyConfigFromGigaTest {

    @Test
    fun testGettersAndSetters() {
        val remoteHost = "http://test.com"
        val companyRestUrl = "/company"
        val vacancyRestUrl = "/vacancy"

        val myConfig = MyConfig(remoteHost, companyRestUrl, vacancyRestUrl)

        assertEquals(remoteHost, myConfig.remoteHost)
        assertEquals(companyRestUrl, myConfig.companyRestUrl)
        assertEquals(vacancyRestUrl, myConfig.vacancyRestUrl)
    }

    @Test
    fun testBoundaryCases() {
        val myConfig = MyConfig("", "", "")
        assertEquals("", myConfig.remoteHost)
        assertEquals("", myConfig.companyRestUrl)
        assertEquals("", myConfig.vacancyRestUrl)

        val myConfig2 = MyConfig("a".repeat(1000), "b".repeat(1000), "c".repeat(1000))
        assertEquals("a".repeat(1000), myConfig2.remoteHost)
        assertEquals("b".repeat(1000), myConfig2.companyRestUrl)
        assertEquals("c".repeat(1000), myConfig2.vacancyRestUrl)
    }
}






