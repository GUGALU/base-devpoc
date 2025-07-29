package com.polli.gustavo.devpoc.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String API_VERSION = "v0.0.1";
    private static final String API_TITLE = "API Documentation";
    private static final String API_DESCRIPTION = "Documentação da API";
    private static final String SECURITY_SCHEME_NAME = "bearerAuth";
    private static final String SECURITY_SCHEME = "bearer";
    private static final String BEARER_FORMAT = "JWT";
    private static final String LICENSE_NAME = "Apache 2.0";
    private static final String LICENSE_URL = "http://springdoc.org";

    @Bean
    public OpenAPI smartSkillsOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME_NAME, createSecurityScheme()))
                .info(createApiInfo());
    }

    private SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
                .name(SECURITY_SCHEME_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme(SECURITY_SCHEME)
                .bearerFormat(BEARER_FORMAT);
    }

    private Info createApiInfo() {
        return new Info()
                .title(API_TITLE)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .license(new License().name(LICENSE_NAME).url(LICENSE_URL));
    }
}

