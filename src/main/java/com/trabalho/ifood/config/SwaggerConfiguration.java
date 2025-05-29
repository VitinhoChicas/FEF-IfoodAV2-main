package com.trabalho.ifood.config;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("Ifood")
                .pathsToMatch("/")
                .packagesToScan("com.trabalho.ifood.resources")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info().title("Ifood")
                .description("Ifood")
                .version("1.0")
                .contact(new Contact().name("Curso Spring")
                        .url("https://github.com/VitinhoChicas/FEF-IfoodAV2-main")
                        .email("victorchicas525@gmail.com")));
    }
}