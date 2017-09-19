package TemplateMethod;

public class GlassHouse extends AbstractHouse {
	
	protected void buildPillars() {
		System.out.println("Building Pillars with Glass coating");
	}

	protected void buildWalls() {
		System.out.println("Building Glass Walls");
	}
}