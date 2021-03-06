package mvc.controller;

import java.util.regex.Pattern;

import mvc.model.Person;
import mvc.view.PersonDetailView;
import mvc.view.PersonDetailViewListener;
import sun.security.util.Length;

public class PersonDetailControllerImpl implements PersonDetailViewListener {

	public PersonDetailControllerImpl(Person person)
	{
		this.setModel(person);
		this.setView(person); 
	}
	
	public PersonDetailControllerImpl(Person person, PersonDetailView view)
	{
		this.setModel(person);
		_view = view;
	}
	@Override
	public void changedButtonPressed() {
		final String newName = _view.getNameFromTextField();
		if (isNotEmpty(newName))  
		{	
			this.getModel().setName(newName);
		}
	}
	
	@Override
	public void windowClosed() {
		System.exit(0);
	}
	
	protected PersonDetailView getView() {
		return _view;
	}
	
	protected void setView(Person person){
		_view = new PersonDetailView(person, this);
		this.getView().display();
	}
	
	protected Person getModel() {
		return _model;
	}

	protected void setModel(Person model) {
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}

	private Person _model;
	private PersonDetailView _view;
}
