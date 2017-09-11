package questao4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import org.junit.Test;

public class TesteQuestao4 {
	@InjectMocks private ControladorPTC controlador;
	@Mock private Sensor sensor;
	@Mock private Datacenter datacenter;
	@Mock private PainelCondutor painelcondutor;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		controlador = new ControladorPTC(sensor,datacenter,painelcondutor);
	}
	
	@Test
	public void TestaCriarControlador() { 
		// Questao 4.a Teste de Inicializacao
		Assert.assertNotNull(controlador);
	}
	
	@Test
	public void TestaIsCruzamentoFalso() { 
		// Questao 4.b Testa o comportamento de isCruzamento() quando falso
		when(sensor.isCruzamento()).thenReturn(false);
		when(sensor.getVelocidade()).thenReturn((double) 200);
		controlador.run();
		Mockito.verify(datacenter).gerarRelatorio(Mockito.any());
		Mockito.verify(painelcondutor).imprimeAviso("200.0", 1);
	}
	
	@Test
	public void TestaIsCruzamentoVerdadeiroVelocidade200() {
		// Questao 4.c Testa o comportamento de isCruzamento() quando verdadeiro e velocidade superior a 100
		when(sensor.isCruzamento()).thenReturn(true);
		when(sensor.getVelocidade()).thenReturn((double) 200);
		controlador.run();
		Mockito.verify(painelcondutor,Mockito.times(2)).imprimeAviso("Velocidade alta", 1);
	}

	@Test
	public void TestaIsCruzamentoVerdadeiroVelocidade10() {
		// Questao 4.d Testa o comportamento de isCruzamento() quando verdadeiro, enviarMsgPrioritariaPainel() quando falto e velocidade inferior a 20
		when(sensor.isCruzamento()).thenReturn(true);
		when(sensor.getVelocidade()).thenReturn((double) 10);
		when(painelcondutor.imprimeAviso("Velocidade Baixa", 1)).thenReturn(false);
		controlador.run();
		Mockito.verify(painelcondutor,Mockito.times(2)).imprimeAviso("Velocidade Baixa", 1);
		Mockito.verify(painelcondutor,Mockito.times(1)).aceleraVelocidadeTrem(20);	
	}
}
