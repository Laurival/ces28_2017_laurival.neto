package Q4.orig;

import java.util.Iterator;

public class Calculadora {
	// Agora, calculadora calcula o total de despesas Item A
	public float calcularTotalDespesa(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa += despesa;
		}
		return totalDespesa;
	}
}
