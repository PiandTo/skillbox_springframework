package edu.lesson1.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!init")
public class Loader implements CommandLineRunner {

	@Autowired
	Config config;

	@Override
	public void run(String... args) throws Exception {
		Logic logic = new Logic();
		logic.mainLogic(config);
	}

}
