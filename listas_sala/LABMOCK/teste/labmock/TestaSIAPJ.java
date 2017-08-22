package labmock;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestaSIAPJ {
	
	@InjectMocks private SIAPJ siapj;
	
	@Mock private IServicoEmail email;
	@Mock private IServicoEmail email2;
	@Mock private IServicoDB db;
	@Mock private IServicoDB db2;
	@Mock private IValidatorProcesso procVal;
	@Mock private IValidatorProcesso procVal2;
	@Mock private IProcesso processo;
	@Mock private IProcesso processofalse;
	@Mock private Connection conn;
	@Mock private Statement statement;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		siapj = new SIAPJ(email,db,procVal);
	}
	@Test
	public void testaCriaReclamacao() throws SQLException{
		
		when(processo.getEmail()).thenReturn("email");
		when(processofalse.getEmail()).thenReturn("email");
		when(procVal.validaProcesso(processo)).thenReturn(true);
		when(procVal.validaProcesso(processofalse)).thenReturn(false);
		when(conn.createStatement()).thenReturn(statement);
		when(conn.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
		siapj.criaReclamacao(processo);
		siapj.criaReclamacao(processofalse);
		
		// Exercicio 2
		Mockito.verify(db).persisteProcesso(processo);
		Mockito.verify(email).sendEmail(processo.getEmail(), "Processo aceito");
		Mockito.verify(email).sendEmail(processofalse.getEmail(), "Existem erros em seu processo");
		Mockito.verify(procVal,Mockito.times(2)).validaProcesso(Mockito.any());
		Mockito.verify(db,Mockito.times(1)).persisteProcesso(Mockito.any());
		// Exercicio 3
		Mockito.verify(email,Mockito.times(2)).sendEmail(Mockito.any(),Mockito.any());
		//Mockito.verify(conn.createStatement(),Mockito.times(1));
		
	
	}
	@Test
	public void testaInicializacaoSIAPJ() {
		
		siapj = new SIAPJ(email2,db2,procVal2);
		Assert.assertNotNull(siapj);
	}
	
}

