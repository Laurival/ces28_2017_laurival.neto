package TemplateMethod;

public class WoodenHouse extends AbstractHouse {

	protected void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
	protected void buildWalls() {
		System.out.println("Building Wooden Walls");
	}
}
