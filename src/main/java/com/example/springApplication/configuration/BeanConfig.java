package com.example.springApplication.configuration;

import com.example.springApplication.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //run firstly
public class BeanConfig {

//    @Bean //Method-level annotation for creating bean.
//    public Student student() {
//        return new Student("Farida", "Mammadli");
//    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
