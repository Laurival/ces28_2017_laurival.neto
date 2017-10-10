package Application;

import mercadoVirtual.Facade;


public class Aplicacao {
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.startMarket();
		// registrar comprador
		facade.addCliente("ZÉ", 123);
		
		// realizar uma compra
		facade.buy(223);
		
		// realizar outra compra
		facade.buy(342);
		
		// fechar compra
		facade.pay();
		
	}
}
