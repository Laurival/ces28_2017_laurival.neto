package Q3.TireMonitor;

// Interface foi criada para que a classe Alarm possa ser testada sem precisar da implementacao da classe Sensor item B
public interface InterfaceSensor {
	// Acrescentou-se o método que a classe Alarm utiliza do Sensor para que
	// seja mockada item B
	public double popNextPressurePsiValue();
}
