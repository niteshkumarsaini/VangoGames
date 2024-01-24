package com.vangogames.vangogames.Helpers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/games/**")
                .addResourceLocations("classpath:/static/games/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

    }
}
