package com.example.weeksevensq012ikechiu;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeekSevenSq012IkechiuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekSevenSq012IkechiuApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
