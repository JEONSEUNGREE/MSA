package com.example.springRestAPI.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

// swagger-ui/index.html
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // Swagger 2 사용
                // 기본 응답코드들 (200, 401, 403 ...) 에 대한 기본 메세지 사용 여부
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                        "Title",
                        "Description",
                        "1.0",
                        "Term of service URL",
                        new Contact("Contact name", "Contact URL", "Contact email"),
                        "License",
                        "License URL",
                        Collections.emptyList()
                ));
    }
}
