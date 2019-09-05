package com.ractoc.tutorials.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonValidatorTest {

	private PersonValidator validator = new PersonValidator();

	@Test
	void testValidatePerson() {
		// Given
		Person person = new Person();
		person.setFirstName("Valid First Name");
		person.setLastName("ValidLastName");

		// When
		boolean result = validator.validatePerson(person);

		// Then
		assertTrue(result);
	}

	@Test
	void testValidatePersonInvalidFirstName() {
		// Given
		Person person = new Person();
		person.setFirstName("Some#invalid*characters");
		person.setLastName("ValidLastName");

		// When
		boolean result = validator.validatePerson(person);

		// Then
		assertFalse(result);
	}

	@Test
	void testValidatePersonInvalidLastName() {
		// Given
		Person person = new Person();
		person.setFirstName("Valid First Name");
		person.setLastName("Some#invalid*characters");

		// When
		boolean result = validator.validatePerson(person);

		// Then
		assertFalse(result);
	}

}
