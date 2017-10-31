package mvp.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mvp.model.Person;
import mvp.presenter.PersonDetailPresenterImpl;
import mvp.view.PersonDetailView;


public class MVPTest {

	@Mock	
	public Person personMock = Mockito.mock(Person.class);
	public PersonDetailView view;
	public PersonDetailPresenterImpl presenter ;		
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void TestCreateController() {
		presenter =  new PersonDetailPresenterImpl(personMock);
		assertNotNull(presenter);
	}

	@Test
	public void TestChangedButtonPressedController() {
		presenter =  new PersonDetailPresenterImpl(personMock);
		Mockito.when(personMock.getName()).thenReturn("Lau");
		presenter.changedButtonPressed("Lau");
		Mockito.verify(personMock,Mockito.times(1)).setName(Mockito.anyString());
	}

}
