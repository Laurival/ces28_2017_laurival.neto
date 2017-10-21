package Q3.TireMonitor;

public class Alarm {
	private final double LowPressureThreshold = 17;
	private final double HighPressureThreshold = 21;

	// Acrescentado o private pois � um atributo interno da classe item C
	private InterfaceSensor sensor;
	private boolean alarmOn;

	// Um construtor para n�o ficar as implementa��es jogadas no codigo item C
	public Alarm(InterfaceSensor sensor) {
		this.sensor = sensor;
		alarmOn = false;
	}
	
	public void check() {
		double psiPressureValue = sensor.popNextPressurePsiValue();

		if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
			alarmOn = true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}