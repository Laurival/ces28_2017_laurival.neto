package View;

import java.util.Observable;
import java.util.Observer;

import Presenter.UTM;

public class ViewDrone implements Observer, IView {
	private UTM _presenter;
	private int _id;
	
	public ViewDrone(UTM presenter, int id) {
		this.setPresenter(presenter);
		this._id = id;
	}
	
	public void setPresenter(UTM presenter) {
		_presenter = presenter;
		_presenter.addObserver(this);
	}
	
	public void sendSelfStatus( double x, double y, double z) {
		_presenter.updateStatus(_id, x,  y, z);
	}

	public void update(Observable o, Object arg) {
		printStatus();
	}

	public void printStatus() {
		System.out.println("Drone "+ _id +": Conexão Estável");
	}
}
