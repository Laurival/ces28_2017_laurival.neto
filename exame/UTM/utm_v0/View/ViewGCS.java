package View;

import java.util.Observable;
import java.util.Observer;

import Presenter.UTM;

public class ViewGCS implements Observer, IView{
	private UTM _presenter;
	private int _id;
	
	public ViewGCS(UTM presenter, int id) {
		this.setPresenter(presenter);
		this._id = id;
	}
	
	public void setPresenter(UTM presenter) {
		_presenter = presenter;
		_presenter.addObserver(this);
	}
	
	
	public void printStatus() {
		System.out.println("Controlador "+_id+": Conexão Estável");
		System.out.println("Posicao: " + _presenter.getX(_id)+" "+_presenter.getY(_id)+" "+_presenter.getZ(_id));
	}

	public void update(Observable o, Object arg) {
		printStatus();
	}
}
