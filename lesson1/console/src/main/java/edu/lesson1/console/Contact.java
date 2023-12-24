package edu.lesson1.console;

public class Contact {
	private String fullName;
	private String phoneNumber;
	private String email;

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return this.fullName + " | " + this.phoneNumber + " | " + this.email;
	}

	public String saveToFile() {
		return this.fullName + ";" + this.phoneNumber + ";" + this.email;
	}
}
