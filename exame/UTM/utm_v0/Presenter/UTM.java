package Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Model.Drone;
import Model.Drone.DroneListener;


public class UTM extends Observable implements DroneListener{
	private List<Drone> _drones;
	private Drone _model;
	
	public UTM(){
		List<Drone> drones = new ArrayList<Drone>();
		_drones = drones;
	}

	public void updateStatus(int id, double x, double y, double z) {
		this.getDrone(id).setPosicao(x,y,z);
	}
	
	public Drone getDrone(int id) {
		return _drones.get(id);
	}

	public void setDrone(Drone model) {
		model.addListener(this);
		_model = model;
		_drones.add(model);
	}

	@Override
	public void onStatusChanged(int id) {
		setChanged();
		notifyObservers(this.getDrone(id).getID());
	}
	

	public double getX(int id){
		return getDrone(id).getX();
	}
	public double getY(int id){
		return getDrone(id).getY();
	}
	public double getZ(int id){
		return getDrone(id).getZ();
	}
}
