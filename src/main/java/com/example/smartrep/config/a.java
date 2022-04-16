package com.example.smartrep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.spring.web.plugins.Docket;

public interface a {
    @Bean
    Docket api();

    void addResourceHandlers(ResourceHandlerRegistry registry);
}
