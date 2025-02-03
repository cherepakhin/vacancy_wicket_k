package ru.perm.v.vacancy.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
class MyConfig {
    var remoteHost: String = ""

    var companyRestUrl: String = ""

    var vacancyRestUrl: String = ""

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    constructor() {
        logger.info("MyConfig constructor:")
        logger.info("remoteHost: $remoteHost")
        logger.info("companyRestUrl: $companyRestUrl")
        logger.info("vacancyRestUrl: $vacancyRestUrl")
    }
}