package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Model.Drone;
import Presenter.UTM;
import View.ViewDrone;
import View.ViewGCS;

class TesteUTM {

	@Mock	
	public Drone drone0 = Mockito.mock(Drone.class);
	public Drone drone1 = Mockito.mock(Drone.class);
	public Drone drone2 = Mockito.mock(Drone.class);
	public ViewGCS gcs0;
	public ViewDrone viewdrone0;
	public UTM utm;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void TestCreateUTM() {
		// Testa a criacao
		utm =  new UTM();
		
		assertNotNull(utm);
	}
	@Test
	public void TestCreateGCS() {
		// Testa a criacao
		utm =  new UTM();
		gcs0 =  new ViewGCS(utm,0);
		
		assertNotNull(gcs0);
	}
	@Test
	public void TestCreateViewDrone() {
		// Testa a criacao
		utm =  new UTM();
		viewdrone0 =  new ViewDrone(utm,0);
		
		assertNotNull(viewdrone0);
	}
	
	@Test
	public void TestSetDroneInUTM() {
		// Verifica se ao setar um drone ele chame corretamente os metodos
		utm = new UTM();
		utm.setDrone(drone0);
		
		Mockito.verify(drone0,Mockito.times(1)).addListener(Mockito.any());
	}
	
	@Test
	public void TestGetDroneInUTM() {
		// Verifica se a relação Drone-ID esta correta
		utm =  new UTM();
		utm.setDrone(drone0);
		Mockito.when(drone0.getID()).thenReturn(0);
		
		assertEquals(drone0,utm.getDrone(0));
	}
	
	@Test
	public void TestGetXYZInUTM() {
		// Verificação indireta dos prints: Verifica se os get's de posicao estao corretos
		utm =  new UTM();
		utm.setDrone(drone0);
		Mockito.when(drone0.getID()).thenReturn(0);
		Mockito.when(drone0.getX()).thenReturn(0.0);
		Mockito.when(drone0.getY()).thenReturn(0.0);
		Mockito.when(drone0.getZ()).thenReturn(0.0);
		
		assertEquals(0.0,utm.getX(0));
		assertEquals(0.0,utm.getY(0));
		assertEquals(0.0,utm.getZ(0));
	}
	
	@Test
	public void TestUpdateStatusInUTMWith1Drone() {
		// Verifica se o updateStatus atualiza corretamente
		utm =  new UTM();
		utm.setDrone(drone0);
		Mockito.when(drone0.getID()).thenReturn(0);
		utm.updateStatus(0, 0.0, 0.0, 0.0);
		Mockito.verify(drone0).setPosicao(0.0,0.0,0.0);
	}
	
	@Test
	public void TestUpdateStatusInUTMWith2Drones() {
		// Verifica se o updateStatus atualiza corretamente o drone correto, ou seja, id = 0 atualiza drone0 
		utm =  new UTM();
		utm.setDrone(drone0);
		utm.setDrone(drone1);
		Mockito.when(drone0.getID()).thenReturn(0);
		Mockito.when(drone1.getID()).thenReturn(1);
		utm.updateStatus(0, 0.0, 0.0, 0.0);
		utm.updateStatus(1, 1.0, 1.0, 1.0);
		Mockito.verify(drone0).setPosicao(0.0,0.0,0.0);
		Mockito.verify(drone1).setPosicao(1.0,1.0,1.0);
	}
	
	@Test
	public void TestUpdateStatusInUTMWith3Drones() {
		// Verifica se o updateStatus atualiza corretamente o drone correto, ou seja, id = 0 atualiza drone0 
		// Alem disso, verifica se a quantidade de chamadas estao corretas
		utm =  new UTM();
		utm.setDrone(drone0);
		utm.setDrone(drone1);
		utm.setDrone(drone2);
		Mockito.when(drone0.getID()).thenReturn(0);
		Mockito.when(drone1.getID()).thenReturn(1);
		Mockito.when(drone2.getID()).thenReturn(2);
		
		utm.updateStatus(0, 0.0, 0.0, 0.0);
		utm.updateStatus(1, 1.0, 1.0, 1.0);
		utm.updateStatus(2, 2.0, 2.0, 2.0);
		Mockito.verify(drone0,Mockito.times(1)).setPosicao(0.0,0.0,0.0);
		Mockito.verify(drone1,Mockito.times(1)).setPosicao(1.0,1.0,1.0);
		Mockito.verify(drone2,Mockito.times(1)).setPosicao(2.0,2.0,2.0);
	}
}
