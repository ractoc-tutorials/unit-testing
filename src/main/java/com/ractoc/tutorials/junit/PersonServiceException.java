package com.ractoc.tutorials.junit;

/**
 * This exception is thrown when something goes wrong in the PersonService implementation.
 */
public class PersonServiceException extends Exception {

	private static final long serialVersionUID = 8256263739468888643L;

	public PersonServiceException(String msg) {
		super(msg);
	}

}
