package edu.skillbox.lesson2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import edu.skillbox.lesson2.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

@Configuration
@Profile("init")
public class LoaderInit {
    
    @Bean
    public List<Student> init(@Value("${app.loader.url}") String url) throws FileNotFoundException {
		List<Student> students = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(url).getFile());     
		// File file = new File("src/main/resources/" + url);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
            ClassLoader ClassLoader = getClass().getClassLoader();
			String[] arr = sc.nextLine().split(";");
			Student c = new Student();
			c.setFirstName(arr[0]);
			c.setLastName(arr[1]);
			c.setAge(Integer.parseInt(arr[2]));
			students.add(c);
		}
		return students;
    }
}
