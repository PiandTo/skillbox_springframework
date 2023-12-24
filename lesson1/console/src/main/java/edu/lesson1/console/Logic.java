package edu.lesson1.console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Logic {

	HashMap<String, Contact> contacts = new HashMap<>();

	public Logic(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}

	public Logic() {
	}

	public void mainLogic(Config config) throws IOException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("Choose what to do and press ENTER\n");
			System.out.println("[1] - add NEW contact");
			System.out.println("[2] - show ALL contacts");
			System.out.println("[3] - DELETE contact");
			System.out.println("[4] - SAVE contact in file");

			String choice = sc.nextLine();
			switch (choice) {
				case "1":
					create();
					break;
				case "2":
					showAll();
					break;
				case "3":
					System.out.println("Enter email!");
					String s = sc.nextLine();
					delete(s);
					break;
				case "4":
					save(config);
					break;
			}
		}
	}

	public void create() {
		Contact contact = new Contact();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter FullName; Phonenumber; Email");
		String c1 = sc.nextLine();

		Contact c2 = parse(c1);
		if (c2 == null) {
			return;
		}
		contacts.put(c2.getEmail(), c2);
	}

	public void showAll() {
		for (Contact e : contacts.values()) {
			System.out.println(e.toString());
		}
	}

	public void delete(String email) {
		for (String e : contacts.keySet()) {
			if (e.equals(email)) {
				contacts.remove(email);
			}
		}
	}

	public Contact parse(String str) {
		Contact r = new Contact();
		String[] arr = str.split("; ");
		if (arr.length != 3) {
			System.out.println("Wrong input");
			return null;
		}
		r.setFullName(arr[0]);
		r.setPhoneNumber(arr[1]);
		r.setEmail(arr[2]);
		return r;
	}

	public void save(Config config) throws IOException {

		StringBuilder sb = new StringBuilder();
		int i = 0;
		int length = contacts.size();

		for (Contact c : contacts.values()) {
			sb.append(c.saveToFile());
			i++;
			if (i < length) {
				sb.append('\n');
			}
		}

		Path path = Paths.get("src/main/resources/" + config.getSavedName());
		Files.write(path, sb.toString().getBytes());
	}
}
