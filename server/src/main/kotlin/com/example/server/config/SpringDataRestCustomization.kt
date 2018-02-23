package com.example.server.config

import com.example.server.web.VERSION
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration

@Configuration
class SpringDataRestCustomization(private val webConfig: WebConfig): RepositoryRestConfigurerAdapter() {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        config.setBasePath(VERSION)
        config.corsRegistry.addMapping("$VERSION/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true).maxAge(3600)
    }
}