package models;

import java.util.regex.Pattern;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;

	Person(String firstName, String lastName, String phoneNumber, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		if (Pattern.matches("[A-Z][a-z-]{1,20}", firstName)) {
			this.firstName = firstName;
		}
	}

	String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		if (Pattern.matches("[A-Z][a-z-]{1,20}", lastName)) {
			this.lastName = lastName;
		}
	}

	String getPhoneNumber() {
		return phoneNumber;
	}


	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public abstract void showInfo();
}
