package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all API endpoints
                .allowedOrigins("http://localhost:3000")  // Allow frontend React app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }	

};
}
	}
