package aula02;



public class Person {
	// 1. modificacao no static - private static
	private static int _nextId = 0;
	private int _id;
	
	public boolean equals(Object anObject) {
		if (this == anObject)
			return true;
		if (!(anObject instanceof Person))
			return false;
		Person otherperson = (Person) anObject;
		if (otherperson.getId()== this.getId())
			return true;
		return false;
	}
	
	Person(){
		_id = _nextId++;
	}
	
	// Participe deleted
	   
	public int getId() {
	  return _id;
	}


}
