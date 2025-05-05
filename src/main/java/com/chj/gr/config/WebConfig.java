package com.chj.gr.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class ForSwaggerAggregatorConfig implements WebMvcConfigurer {
//	
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/v3/api-docs/**")
//                .allowedOrigins("http://*****:8765")
//                .allowedMethods("GET");
//    }
//}

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${swagger.aggregator.cors.uri}")
	private String swaggerAggregatorUri;		/** "gr-conf-swagger-aggregator". **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(swaggerAggregatorUri)	// Origine de "gr-conf-swagger-aggregator"
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    	
		/**
		 * @TO_DELETE
		 * Permettre toutes les origines (moins sécurisé, à utiliser pour le développement uniquement) :
		 */
//    	registry.addMapping("/**").allowedOrigins("*");
        
        /**
         * @TODO Didn't work YET depuis gr-conf-swagger-aggregator..
         */
        // Configuration explicite pour les endpoints Actuator
//        registry.addMapping("/actuator/**")
//                .allowedOrigins(swaggerAggregatorUri)
//                .allowedMethods("GET", "POST", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true);
    }
}
