package Main;

import java.io.File;

import Presenter.InterpolationPresenter;
import View.InterpolationView;


public class entradaUsuario {

	public static void main(String[] args) {
		// RESPONSABILITY: CREATE APP
		InterpolationPresenter presenter = new InterpolationPresenter();
		InterpolationView view = new InterpolationView(presenter);

		   // ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
		   // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		   view.getMethod("Lagrange");
		// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
		// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		   view.calculateResult(10.3f, new File("./data.dat"));
	}

}
