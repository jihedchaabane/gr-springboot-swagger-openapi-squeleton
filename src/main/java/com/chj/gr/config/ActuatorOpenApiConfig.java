package com.chj.gr.config;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

@Configuration
public class ActuatorOpenApiConfig {
    @Bean
    public OpenApiCustomiser actuatorOpenApiCustomiser() {
        return openApi -> {
            Paths paths = openApi.getPaths();
            if (paths == null) {
                paths = new Paths();
                openApi.setPaths(paths);
            }
            // Ajouter l'endpoint /actuator/health
            paths.addPathItem("/actuator/health", new PathItem()
                .get(new io.swagger.v3.oas.models.Operation()
                    .summary("Get health status")
                    .description("Retrieve the health status of the application")
                    .addTagsItem("Actuator")));
            // Ajouter l'endpoint /actuator/info
            paths.addPathItem("/actuator/info", new PathItem()
                .get(new io.swagger.v3.oas.models.Operation()
                    .summary("Get application info")
                    .description("Retrieve general information about the application")
                    .addTagsItem("Actuator")));
            // Ajouter d'autres endpoints Actuator si nécessaire
        };
    }
}
