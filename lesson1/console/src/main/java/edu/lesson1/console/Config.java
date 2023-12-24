package edu.lesson1.console;

import org.springframework.beans.factory.annotation.Value;

public class Config {

	@Value("${app.save.folder}")
	private String savedName;

	public Config() {
	}

	public String getSavedName() {
		return savedName;
	}
}
