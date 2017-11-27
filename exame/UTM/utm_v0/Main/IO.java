package Main;

import Model.Drone;
import Presenter.UTM;
import View.ViewDrone;
import View.ViewGCS;

public class IO {
	public static void main(String[] args) {
		UTM utm = new UTM();
		ViewGCS gcs0 = new ViewGCS(utm,0);
		Drone drone0 = new Drone("GCS 0",0);
		ViewDrone viewdrone0 = new ViewDrone(utm,0);
		
		ViewGCS gcs1 = new ViewGCS(utm,1);
		Drone drone1 = new Drone("GCS 1",1);
		ViewDrone viewdrone1 = new ViewDrone(utm,1);
			
		ViewGCS gcs2 = new ViewGCS(utm,2);
		Drone drone2 = new Drone("GCS 2",2);
		ViewDrone viewdrone2 = new ViewDrone(utm,2);
			
		
		utm.setDrone(drone0);
		utm.setDrone(drone1);
		utm.setDrone(drone2);
		// Note que haverão muitos prints, pois cada atualizacao faz dar update em cada drone e em cada GCS
		// Dessa forma, cada atualizacao de um drone printará em todos os consoles que por sua vez printam todas as posicoes dos drones
		
		viewdrone0.sendSelfStatus(0.0, 1.0, 2.0);
		viewdrone1.sendSelfStatus(1.0, 1.0, 1.0);
		viewdrone2.sendSelfStatus(2.0, 2.0, 2.0);
		
	}
}
