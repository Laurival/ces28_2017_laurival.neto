package mvc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mvc.controller.PersonDetailControllerImpl;
import mvc.model.Person;
import mvc.view.PersonDetailView;


public class MVCTest {
	
	@Mock	
	public PersonDetailView viewMock = Mockito.mock(PersonDetailView.class);
	public Person personMock = Mockito.mock(Person.class);
	
	public PersonDetailControllerImpl controller ;		
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void TestCreateController() {
		controller =  new PersonDetailControllerImpl(personMock, viewMock);
		assertNotNull(controller);
	}

	@Test
	public void TestChangedButtonPressedController() {
		controller =  new PersonDetailControllerImpl(personMock, viewMock);
		Mockito.when(viewMock.getNameFromTextField()).thenReturn("Abc");
		controller.changedButtonPressed();
		Mockito.verify(viewMock,Mockito.times(1)).getNameFromTextField();
		Mockito.verify(personMock,Mockito.times(1)).setName(Mockito.anyString());
	}
	
}
