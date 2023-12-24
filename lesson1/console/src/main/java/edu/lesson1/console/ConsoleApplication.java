package edu.lesson1.console;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleApplication.class, args);
	}

	@Bean
	public Config getConfig() {
		return new Config();
	}

	@Bean
	@Profile("init")
	public HashMap<String, Contact> init(@Value("${app.load.folder}") String loadName) throws IOException {
		HashMap<String, Contact> contacts = new HashMap<>();
		File file = new File("src/main/resources/" + loadName);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String[] arr = sc.nextLine().split(";");
			Contact c = new Contact();
			c.setFullName(arr[0]);
			c.setPhoneNumber(arr[1]);
			c.setEmail(arr[2]);
			contacts.put(c.getEmail(), c);
		}
		return contacts;
	}
}