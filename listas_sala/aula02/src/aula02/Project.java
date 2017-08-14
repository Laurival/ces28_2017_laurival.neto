package aula02;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Project {
 
  private List<Person> _participants = new LinkedList<Person>( );
  
  public List<Person> getParticipants() { return Collections.unmodifiableList( _participants ); }
  public int getNumberOfParticipants() { return _participants.size(); }
  public void setParticipants(List<Person> p){
	  _participants = new LinkedList<Person>(p) ;
  }
  
  
  
  public boolean participate(Person m) {
	  return _participants.contains(m);
  }
  
  public void printParticipants() {
	  for (int i=0; i < _participants.size(); i++)
		  System.out.println("project has person "+_participants.get(i).getId());
  }
}

