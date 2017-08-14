package aula02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person p0;
	private Person p1;
	
	@Before
	public void setUp(){
		p0 = new Person();
		p1 = new Person(); 
	}
	@Test
	public void WhenCreateaPersonThenIDisCorrect() {
		assertEquals(0,p0.getId());
		assertEquals(1,p1.getId());
	}
	

}
