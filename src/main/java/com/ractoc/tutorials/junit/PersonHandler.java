package com.ractoc.tutorials.junit;

/**
 * Handler to handle all person related tasks.
 */
public class PersonHandler {

	private PersonService personService;

	public PersonHandler() {
	}

	public PersonHandler(PersonService personService) {
		this.personService = personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public void init() {
		personService = new PersonServiceImpl();
	}

	public Person getPersonByName(String firstName, String lastName) throws PersonServiceException {
		return personService.getPersonByName(firstName, lastName);
	}

}
