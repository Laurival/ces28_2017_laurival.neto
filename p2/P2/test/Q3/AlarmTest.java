package Q3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q3.TireMonitor.Alarm;
import Q3.TireMonitor.InterfaceSensor;

public class AlarmTest {

	@Mock
	InterfaceSensor mSensor = Mockito.mock(InterfaceSensor.class);
	Alarm alarm;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void WhenCreateNewAlarmThenVerifyAlarmIsOff() {
		// Item B, esse teste verifa o método isAlarmOn()
		alarm = new Alarm(mSensor);
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void WhenCheckWithVeryLowPressureValueThenVerifyAlarmIsOn() {
		// Item B, esse teste verifica o caso quando a pressao é muito baixa
		alarm = new Alarm(mSensor);
		Mockito.when(mSensor.popNextPressurePsiValue()).thenReturn(10.0);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void WhenCheckWithVeryHighPressureValueThenVerifyAlarmIsOn() {
		// Item B, esse teste verifica o caso quando a pressao é muito alta
		alarm = new Alarm(mSensor);
		Mockito.when(mSensor.popNextPressurePsiValue()).thenReturn(30.0);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void WhenCheckWithNormalPressureValueThenVerifyAlarmIsOn() {
		// Item B, esse teste verifica o caso quando a pressao é padrão
		alarm = new Alarm(mSensor);
		Mockito.when(mSensor.popNextPressurePsiValue()).thenReturn(20.0);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
}
