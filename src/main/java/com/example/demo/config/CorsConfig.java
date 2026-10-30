package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Глобальная настройка CORS для всех /api/** эндпоинтов.
 * Если добавишь Spring Security — перенеси настройки туда.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    @Override 
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
        // Разрешённые origins (для dev — localhost фронта)
                .allowedOrigins("http://localhost:8080", "http://localhost:5173")
                // Разрешённые HTTP-методы
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // Разрешённые заголовки (Authorization нужен для JWT)
                .allowedHeaders("*")
                // Разрешить отправку cookies / Authorization header
                .allowCredentials(true)
                // Кэш preflight-запросов (сек). В prod можно увеличить.
                .maxAge(3600);
    }
}
