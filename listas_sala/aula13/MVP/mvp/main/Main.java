package mvp.main;

import mvp.model.Person;
import mvp.presenter.PersonDetailPresenterImpl;
import mvp.view.PersonDetailView;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("La");
		PersonDetailPresenterImpl presenter = new PersonDetailPresenterImpl(p);
		new PersonDetailView(presenter);
	}

}

