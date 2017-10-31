package mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Person {
	public interface PersonListener{
		void onPersonNameChanged();
	}
	
	public Person()
	{
	
	}
	
	public Person(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		if(Pattern.matches("^[A-Z]\\D*", name)){
			if (name.length()<=5)
				_name = "VERMELHO "+ name;
			else if (name.length()<=10)
				_name = "AMARELO "+ name;
			else
				_name = "VERDE "+ name;
			fireOnNameChanged();
		}
	}

	public void addListener(PersonListener l)
	{
		this.listeners.add(l);
	}
	
	public void removeListener(PersonListener l)
	{
		this.listeners.remove(l);
	}
	
	private void fireOnNameChanged() {
		for(PersonListener l:this.listeners)
		{
			l.onPersonNameChanged();
		}
	}
	
	private String _name;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
