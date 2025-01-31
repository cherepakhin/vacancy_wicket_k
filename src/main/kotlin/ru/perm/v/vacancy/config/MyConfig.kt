package ru.perm.v.vacancy.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MyConfig {
    @Value("\${myconfig.remoteHost}")
    var remoteHost: String = ""
    @Value("\${myconfig.companyRestUrl}")
    var companyRestUrl: String = ""
    @Value("\${myconfig.vacancyRestUrl}")
    var vacancyRestUrl: String = ""
}