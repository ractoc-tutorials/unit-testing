package com.ractoc.tutorials.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonHandlerSetterInjectionTest {

	@Mock
	private PersonService mockedPersonService;

	private PersonHandler personHandler;

	@Before
	public void setup() {
		personHandler = new PersonHandler();
		personHandler.setPersonService(mockedPersonService);
	}

	@Test
	public void testGetPersonByName() throws Exception {
		// Given
		Person person = new Person();
		person.setFirstName("firstName");
		person.setLastName("lastName");
		// normally, you would set this next call up with the exact string used in the getPersonByName.
		when(mockedPersonService.getPersonByName(anyString(), anyString())).thenReturn(person);

		// When
		Person result = personHandler.getPersonByName("firstName", "lastName");

		// Then
		// When setting up the when() call with the exact strings used in the getPersonByName, this call should not be needed.
		verify(mockedPersonService).getPersonByName("firstName", "lastName");
		assertNotNull(result);
		assertEquals("firstName", result.getFirstName());
		assertEquals("lastName", result.getLastName());
	}

	@Test(expected = PersonServiceException.class)
	public void testGetPersonByNamePersonServiceException() throws Exception {
		// Given
		Person person = new Person();
		person.setFirstName("firstName");
		person.setLastName("lastName");
		// it is good practice to use an exception message not used in the actual code. This way, it is easy to determine if the
		// exception is thrown by the mock or somewhere else.
		when(mockedPersonService.getPersonByName(anyString(), anyString())).thenThrow(new PersonServiceException("test exception"));

		// When
		personHandler.getPersonByName("firstName", "lastName");

		// Then
		// Since the actuall call results in an exception, the Then is empty.
	}

}
