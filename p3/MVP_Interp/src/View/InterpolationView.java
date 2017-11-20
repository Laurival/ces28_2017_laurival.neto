package View;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import Presenter.InterpolationPresenter;

public class InterpolationView implements InterfaceView, Observer{
	private DecimalFormat formatResult = new DecimalFormat("####.######");
	private InterpolationPresenter _presenter;
	
	public InterpolationView(InterpolationPresenter presenter) {
		this.setPresenter(presenter);
	}
	
	public void setPresenter(InterpolationPresenter presenter) {
		_presenter = presenter;
		presenter.addObserver(this);
	}
	
	// RESPONSABILITY: IMPRIMIR RESULTADOS
    public void printResult() {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + _presenter.getDataFile());
    	System.out.println("Interp at " + formatResult.format(_presenter.getValue()) + " ; result = " + formatResult.format(_presenter.getResult()));
	}

	public void getMethod(String string) {
		_presenter.getMethod(string);
	}

	public void calculateResult(float f, File file) {
		_presenter.calculateResult(f, file);
	}

	@Override
	public void update(Observable o, Object arg) {
		printResult();
	}


	
}
