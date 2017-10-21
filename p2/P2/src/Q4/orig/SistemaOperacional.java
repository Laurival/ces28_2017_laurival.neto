package Q4.orig;

public class SistemaOperacional{
	
	public InterfaceImpressora getDriverImpressao(String impressora) {
		if( impressora.equals("Tinta"))
			return new ImpressoraTinta();
		if (impressora.equals("Laser"))
			return new ImpressoraLaser();
		else
			return new Impressora();
		
	}
	public void Impressao(String conteudo, String impressora){
		this.getDriverImpressao(impressora).Imprimir(conteudo);
	}
}
