import java.util.ArrayList;

public class Principal1 {

	public static void main(String[] args) {
		
		int v = 5;
		Grafo grafo = new Grafo(v);
		
		
		grafo.adicionarAresta(0, 1);
		grafo.adicionarAresta(0, 2);
		grafo.adicionarAresta(1, 2);
		grafo.adicionarAresta(1, 3);
		grafo.adicionarAresta(2, 3);
		grafo.adicionarAresta(3, 4);
		
		
		ArrayList<Integer> conjuntoIndependenteMax = grafo.conjuntoIndependenteMaximo();
		
		System.out.println("Conjunto Independente Maximo: " + conjuntoIndependenteMax);
	}

}
