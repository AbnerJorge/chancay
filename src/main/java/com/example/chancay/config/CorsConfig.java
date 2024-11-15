package com.example.chancay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    //configura las politicas de CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //permite el acceso de todas las rutas
            .allowedOrigins("http://localhost:8080", "http://10.0.2.2:8080") //origenes permitidos
            .allowedMethods("GET", "POST", "PUT", "DELETE") //metodos permitidos
            .allowedHeaders("*"); //encabezados permitida
    }
}
