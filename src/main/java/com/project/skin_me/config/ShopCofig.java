package com.project.skin_me.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopCofig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
