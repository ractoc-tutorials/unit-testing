package com.ractoc.tutorials.junit;

/**
 * Returns a person with first and lastname which are not correct for the unit tests.
 */
public class PersonServiceImpl implements PersonService {

	/**
	 * {@inheritDoc}
	 */
	public Person getPersonByName(String firstName, String lastName) throws PersonServiceException {
		Person person = new Person();
		person.setFirstName("incorrect firstName");
		person.setLastName("incorrect lastName");
		return person;
	}

}
