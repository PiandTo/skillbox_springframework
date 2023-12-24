package edu.lesson1.console;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("init")
public class LoaderInit implements CommandLineRunner {

	private HashMap<String, Contact> contacts;
	private Config config;

	LoaderInit(Config config, HashMap<String, Contact> contacts) {
		this.config = config;
		this.contacts = contacts;
	}

	@Override
	public void run(String... args) throws Exception {
		Logic logic = new Logic(contacts);
		logic.mainLogic(config);
	}

}
