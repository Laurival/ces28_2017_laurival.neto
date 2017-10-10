package mercadoVirtual;

import java.util.HashMap;
import java.util.Map;

public class BancoDeDados {
	Map<Integer, Produto> produtosById;
	Map<Integer, Cliente> clientesById;

	private BancoDeDados() {
		produtosById = new HashMap<>();
		clientesById = new HashMap<>();
		for (int i = 0; i < 500; i++) {
			produtosById.put(new Integer(i), Produto.create("Produto #" + i, i, (double) (i * 3 + 1)));
		}
	}
	public static BancoDeDados create(){
		return new BancoDeDados();
	}

	public Cliente selectCliente(int id) {
		return clientesById.get(new Integer(id));
	}

	public Produto selectProduto(int id) {
		return produtosById.get(new Integer(id));
	}

	public void processarPagamento(Cliente cliente, double valor) {
		System.out.println("(Pagamento processado) Cliente: " + cliente.getId() + ", Valor: " + valor);
	}

	public void registrarCliente(Cliente cliente) {
		clientesById.put(cliente.getId(), cliente);
	}
}