package mercadoVirtual;

public class Mercado {
	private BancoDeDados DB;
	private Cliente client; 
	
	public Mercado(){
		this.DB = BancoDeDados.create();
	}
	
	public void addCliente(String nome, int id){
		client = Cliente.create(nome, id);
		DB.registrarCliente(client);
	}
	
	public void buy(int id ){
		Produto product = DB.selectProduto(id);
		client.addProduto(product);
	}
	
	public double pay(){
		double totalValue = client.getTotal();
		DB.processarPagamento(client, totalValue);
		return totalValue;
	}
}
