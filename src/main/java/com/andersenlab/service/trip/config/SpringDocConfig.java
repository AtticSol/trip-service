package com.andersenlab.service.trip.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
    name = "Authorization",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT")
public class SpringDocConfig {
  @Bean
  public OpenAPI springShopOpenAPI(
      @Value("${apiVersion}") String version, @Value("${buildVersion}") String buildVersion) {
    return new OpenAPI()
        .info(
            new Info()
                .title("Trip service")
                .description(String.format("Trip service<br/>buildVersion: %s", buildVersion))
                .version(version));
  }
}
