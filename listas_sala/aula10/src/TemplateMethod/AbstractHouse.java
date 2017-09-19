package TemplateMethod;

public abstract class AbstractHouse {
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}

	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}

	protected abstract void buildWalls();

	protected abstract void buildPillars();

}
