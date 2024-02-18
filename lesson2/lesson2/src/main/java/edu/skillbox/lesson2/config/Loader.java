package edu.skillbox.lesson2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import edu.skillbox.lesson2.entity.Student;

import java.util.List;
import java.util.ArrayList;

@Configuration
@Profile("!init")
public class Loader {

    @Bean
    public List<Student> init() {
        return new ArrayList<>();
    }
    
}
