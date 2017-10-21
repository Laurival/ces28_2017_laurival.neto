package Q4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import Q4.orig.Calculadora;
import Q4.orig.Despesa;
import Q4.orig.RelatorioDespesas;
import Q4.orig.SistemaOperacional;

import java.util.Iterator;

public class RelatorioDespesasTest {

	@Mock
	Calculadora mCalculadora = Mockito.mock(Calculadora.class);
	SistemaOperacional mSO = Mockito.mock(SistemaOperacional.class);
	String impressora;
	Iterator<Despesa> despesas;
	RelatorioDespesas rela;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void WhenCallImprimirRelatorioThenCallImpressao() {
		rela = new RelatorioDespesas(mCalculadora,mSO,impressora);
		rela.ImprimirRelatorio(despesas);
		Mockito.verify(mSO,Mockito.times(1)).Impressao(Mockito.any(),Mockito.any());
	}
	
	@Test
	public void WhenCallImprimirRelatorioThenCall() {
		rela = new RelatorioDespesas(mCalculadora,mSO,impressora);
		rela.ImprimirRelatorio(despesas);
		Mockito.verify(mCalculadora,Mockito.times(1)).calcularTotalDespesa(Mockito.any());
	}
	

}
