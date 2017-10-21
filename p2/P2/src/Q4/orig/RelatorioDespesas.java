package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	private Calculadora calculadora;
	private SistemaOperacional so;
	private String impressora;
	//
	public RelatorioDespesas(Calculadora calculadora, SistemaOperacional so, String impressora) {
		this.calculadora = calculadora;
		this.so = so;
		this.impressora = impressora;
	}
	// Agora, o método Imprimir relatório delega com os parametros corretos as
	// atividades para imprimir o relatório de despesas
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {	
		String conteudo = "Relatório de Despesas";
		float totalDespesa = calculadora.calcularTotalDespesa(despesas);
		conteudo += ("\n Total das despesas:" + totalDespesa);
		
		so.Impressao(conteudo,impressora);
	}
}