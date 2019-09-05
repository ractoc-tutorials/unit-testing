package com.ractoc.tutorials.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonValidatorTest {

	private PersonValidator validator = new PersonValidator();

	@Test
	public void testValidatePerson() {
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
	public void testValidatePersonInvalidFirstName() {
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
	public void testValidatePersonInvalidLastName() {
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
