package com.example.server.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InjectionPoint
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class AppConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    fun logger(injectionPoint: InjectionPoint) = LoggerFactory.getLogger(injectionPoint.member.declaringClass)

}
