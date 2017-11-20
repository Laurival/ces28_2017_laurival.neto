package Presenter;

import java.io.File;
import java.util.Observable;
import java.util.Vector;

import Model.CubicSpline;
import Model.InterpolationMethod;
import Model.Lagrange;
import Model.readFileToXY;

public class InterpolationPresenter extends Observable{
	private InterpolationMethod _interpolationModel;
	private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private final String DEFAULT_METHOD = CS_METHOD;
    private File _file;
    private float _value;
    private double _result;
    private Vector<Double> x, y;
    
    public InterpolationPresenter() {
		bind();
	}
    public void bind() {
        this._interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);
    }
	public File getDataFile() {
        return _file;
    }
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod() { 
    	return _interpolationModel;
    	}
	public InterpolationMethod getMethod(String method) {
        switch (method) {
            case L_METHOD:
                _interpolationModel = new Lagrange();
                break;
            case CS_METHOD:
                _interpolationModel = new CubicSpline();
                break;
            default:
            	System.out.println("Unknown method " + method);
        }

        return _interpolationModel;
    }
	// RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
	public void calculateResult(float value, File file) {
		
		if(file == null)
	           return;
	    else _file = file;
		_value = value;
		
		readFileToXY _fileModel = new readFileToXY();
		x = new Vector<Double>();
        y = new Vector<Double>();
		_fileModel.buildDataPoints(file,x,y);
		if(getMethod() != null) {
            _result = getMethod().calculateResult(value, x, y);
            setChanged();
            notifyObservers();
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
    }
	public float getValue() {
		return _value;
	}
	public double getResult() {
		return _result;
	}
}
