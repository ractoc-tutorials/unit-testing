package com.ractoc.tutorials.junit;

/**
 * Object identifying a person.
 */
public class Person {
	private String firstName;
	private String lastName;

	/**
	 * Gets the field firstName.
	 *
	 * @return the field
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the field firstName.
	 *
	 * @param firstName
	 *            the new value
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the field lastName.
	 *
	 * @return the field
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the field lastName.
	 *
	 * @param lastName
	 *            the new value
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
