package View;

import Presenter.InterpolationPresenter;

public interface InterfaceView {
	
	// RESPONSABILITY: IMPRIMIR RESULTADOS
    public void printResult();
    
    // Garantir a intera��o com o sistema
    public void setPresenter(InterpolationPresenter presenter);
    
}
