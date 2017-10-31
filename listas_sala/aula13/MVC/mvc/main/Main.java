package mvc.main;

import mvc.controller.PersonDetailControllerImpl;
import mvc.model.Person;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("Rhuan");
		new PersonDetailControllerImpl(p);
	}

}

