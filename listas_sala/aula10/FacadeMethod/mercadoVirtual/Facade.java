package mercadoVirtual;

public class Facade {
	private static Mercado market;

	public static void startMarket() {
		market = new Mercado();
	}

	public void addCliente(String nome, int id) {
		market.addCliente(nome, id);

	}

	public void buy(int id) {
		market.buy(id);
	}

	public void pay() {
		market.pay();
	}

}
