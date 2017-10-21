package Q3.TireMonitor;

import java.util.Random;

// Abaixo foi acrescentado o "implements" para integração item B
public class Sensor implements InterfaceSensor {
	public static final double OFFSET = 16;

	public double popNextPressurePsiValue() {
		double pressureTelemetryValue;
		pressureTelemetryValue = samplePressure();

		return OFFSET + pressureTelemetryValue;
	}

	private static double samplePressure() {
		// placeholder implementation that simulate a real sensor in a real tire
		Random basicRandomNumbersGenerator = new Random();
		double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble()
				* basicRandomNumbersGenerator.nextDouble();
		return pressureTelemetryValue;
	}

}// class