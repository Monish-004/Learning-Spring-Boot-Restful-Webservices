package com.Restful_Webservices.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutomationModelMapper
{
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
