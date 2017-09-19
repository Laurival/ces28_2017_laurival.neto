package CompositeMethod;

import java.util.LinkedList;
import java.util.List;

public class Drawing implements Shape{
	
	private List<Shape> shapes;
	
	public Drawing() {
		shapes = new LinkedList<Shape>();
	}

	@Override
	public void draw(String fillColor) {
		for(Shape s: shapes)
			s.draw(fillColor);
	}
	
	public void add(Shape Birl){
		shapes.add(Birl);
	}

	public void clear(){
		shapes.clear();
		System.out.println("Clearing all the shapes from drawing");
	}
}
