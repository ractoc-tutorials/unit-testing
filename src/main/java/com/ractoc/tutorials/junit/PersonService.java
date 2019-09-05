package com.ractoc.tutorials.junit;

/**
 * Interface describing the PersonService
 */
public interface PersonService {
	/**
	 * Method using the first and last name of a person to load it from some underlying data service.
	 * 
	 * @param firstName
	 *            The firstName of the person being loaded
	 * @param lastName
	 *            The lastName of the person being loaded
	 * @return The loaded person
	 */
	Person getPersonByName(String firstName, String lastName) throws PersonServiceException;
}
