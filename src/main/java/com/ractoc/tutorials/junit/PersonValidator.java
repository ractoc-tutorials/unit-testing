package com.ractoc.tutorials.junit;

import java.util.regex.Pattern;

/**
 * Validator to validate a person object.
 */
public class PersonValidator {

	public boolean validatePerson(Person person) {
		return (matchName(person.getFirstName()) && matchName(person.getLastName()));
	}

	private boolean matchName(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z ]+");
		return namePattern.matcher(name).matches();
	}
}
