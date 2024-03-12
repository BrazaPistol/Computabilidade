import java.util.ArrayList;

public class Grafo {

	int v;
	boolean[] [] MatrizAdj;
	
	Grafo(int vertices){
		v = vertices;
		MatrizAdj = new boolean [v][v];
	}
	
	void adicionarAresta (int origem, int destino) {
		MatrizAdj[origem][destino] = true;
		MatrizAdj[destino][origem] = true;
	
}
	ArrayList<Integer> conjuntoIndependenteMaximo()
	{
		boolean[] visitado = new boolean[v];
		ArrayList<Integer> conjuntoIndependente = new ArrayList<>();
		
		for (int i = 0; i < v; i++)
		{
			if(!visitado[i]) {
				conjuntoIndependente.add(i);
				
		for (int j = 0; j < v; j++)
		{
			if(MatrizAdj[i][j])
			{
				visitado[j] = true;
			}
		}
			}
		}
		
		return conjuntoIndependente;
		
	}
}
