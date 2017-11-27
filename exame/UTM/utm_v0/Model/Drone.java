package Model;

import java.util.ArrayList;
import java.util.List;

public class Drone {
	private List<DroneListener> _listeners = new ArrayList<DroneListener>();
	private int _id; 
	private double _x;
	private double _y;
	private double _z;
	private double _umidade;
	private String _dono;
		
	public Drone(String _dono, int id) {
		this._id = id;
		this._dono = _dono;
		this._x = 0.0;
		this._y = 0.0;
		this._z = 0.0;
		this._umidade = 0.0;
	}
	
	public interface DroneListener {
		void onStatusChanged(int id);
	}
	
	public void setPosicao(double x, double y, double z) {
		this._x = x;
		this._y = y;
		this._z = z;
		fireOnStatusChanged();
	}
	
	public void addListener(DroneListener l) {
		this._listeners.add(l);
	}

	public void removeListener(DroneListener l) {
		this._listeners.remove(l);
	}

	public int getID() {
		return _id;
	}
	public double getX() {
		return _x;
	}
	
	public double getY() {
		return _y;
	}
	
	public double getZ() {
		return _z;
	}
	
	public double get_umidade() {
		return _umidade;
	}

	public void set_umidade(double umidade) {
		this._umidade = umidade;
	}
	
	private void fireOnStatusChanged() {
		int i;
		i=0;
		for (DroneListener l : this._listeners) {
			l.onStatusChanged(i);
			i = i+1;
		}
	}
	

}
