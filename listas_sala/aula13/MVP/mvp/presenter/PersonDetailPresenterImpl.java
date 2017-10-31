package mvp.presenter;

import java.util.Observable;

import mvp.model.Person;
import mvp.model.Person.PersonListener;

public class PersonDetailPresenterImpl extends Observable implements PersonListener {

	public PersonDetailPresenterImpl(Person person){
		this.setModel(person);
	}

	public void changedButtonPressed(String newName) {
		if (isNotEmpty(newName))
			this.getModel().setName(newName);
	}
	
	protected Person getModel() {
		return _model;
	}

	protected void setModel(Person model) {
		model.addListener(this);
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}

	private Person _model;
	
	@Override
	public void onPersonNameChanged() {
		setChanged();
		notifyObservers(this.getModel().getName());
	}
	
	public String getName(){
		return this.getModel().getName();
	}
}
