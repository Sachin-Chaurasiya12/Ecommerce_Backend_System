package com.example.EcommBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI CustomOpenApi(){
        return new OpenAPI()
                    .info(new Info()
                    .title("Ecommerce API")
                    .description("Documentation for Ecommerce System API")
                    .version("1.0.0")
                );
    }
}
