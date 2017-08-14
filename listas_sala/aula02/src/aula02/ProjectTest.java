package aula02;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
	
	private Person p0;
	private Person p1;
	private Project project1;
	
	@Before
	public void setUp() {
		p0 = new Person();
		p1 = new Person();
		project1 = new Project();
	}

	@Test
	public void WhenAddingParticipantsThenCheckIfProjectContainsIt() {
		List<Person> p = new LinkedList<Person>();
		p.add(p0);
		p.add(p1);
		project1.setParticipants(p);
		assertTrue(project1.getParticipants().equals(p));
	}

	@Test
	public void WhenAdding2ParticipantsThenReturnNumberOfParticipants2() {
		List<Person> p = new LinkedList<Person>();
		assertEquals(0,project1.getNumberOfParticipants());
		p.add(p0);
		p.add(p1);
		project1.setParticipants(p);
		assertEquals(2,project1.getNumberOfParticipants());
	}

	@Test
	public void WhenAddingParticipantsThenCheckIfPersonParticipatesOnIt () {
		Person p2 = new Person();
		List<Person> p = new LinkedList<Person>();
		p.add(p0);
		p.add(p1);
		project1.setParticipants(p);
		assertTrue(project1.participate(p0));
		assertTrue(project1.participate(p1));
		assertTrue(!project1.participate(p2));
	}

}
