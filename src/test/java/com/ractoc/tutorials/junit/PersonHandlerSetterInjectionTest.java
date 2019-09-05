package com.ractoc.tutorials.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonHandlerSetterInjectionTest {

	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";

	@Mock
	private PersonService mockedPersonService;

	private PersonHandler personHandler;

	@BeforeEach
	void setup() {
		personHandler = new PersonHandler();
		personHandler.setPersonService(mockedPersonService);
	}

	@Test
	void testGetPersonByName() throws PersonServiceException {
		// Given
		Person person = new Person();
		person.setFirstName(FIRST_NAME);
		person.setLastName(LAST_NAME);
		// normally, you would set this next call up with the exact string used in the getPersonByName.
		when(mockedPersonService.getPersonByName(anyString(), anyString())).thenReturn(person);

		// When
		Person result = personHandler.getPersonByName(FIRST_NAME, LAST_NAME);

		// Then
		// When setting up the when() call with the exact strings used in the getPersonByName, this call should not be needed.
		verify(mockedPersonService).getPersonByName(FIRST_NAME, LAST_NAME);
		assertNotNull(result);
		assertEquals(FIRST_NAME, result.getFirstName());
		assertEquals(LAST_NAME, result.getLastName());
	}

	@Test
	void testGetPersonByNamePersonServiceException() throws PersonServiceException {
		// Given
		Person person = new Person();
		person.setFirstName(FIRST_NAME);
		person.setLastName(LAST_NAME);
		// it is good practice to use an exception message not used in the actual code. This way, it is easy to determine if the
		// exception is thrown by the mock or somewhere else.
		when(mockedPersonService.getPersonByName(anyString(), anyString())).thenThrow(new PersonServiceException("test exception"));

		// When
		assertThrows(PersonServiceException.class, ()->personHandler.getPersonByName(FIRST_NAME, LAST_NAME));

		// Then
		// Since the actuall call results in an exception, the Then is empty.
	}

}
