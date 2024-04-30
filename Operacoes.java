import java.util.Random;

import org.jfree.data.xy.XYSeries;

public class Operacoes {
	
	public int somaMatrizes(int[][] matriz1, int[][] matriz2) {
		int linhas = matriz1.length;
		int colunas = matriz1[0].length;
		int[][] resultado = new int[linhas] [colunas];
		int operacoes = 0;
		
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j< colunas; j++) {
				resultado[i][j] = matriz1[i][j] + matriz2[i][j];
				operacoes++;
			}
		}
		return operacoes;
	}

	public static void main(String[] args) {
		Operacoes objoperacoes = new Operacoes();
		Grafico objGrafico;
		Random random = new Random();
		
		XYSeries series = new XYSeries( "Complexidade Quadratica");
		for( int tamanho = 100; tamanho < 1000; tamanho = tamanho+100) {
			int[][] matriz1 = new int [tamanho][tamanho];
			int[][] matriz2 = new int [tamanho][tamanho]; 

			for(int i = 0; i < tamanho; i++) {
				 for (int j = 0; j < tamanho; j++) {
					 matriz1[i][j] = random.nextInt(200);
					 matriz2[i][j] = random.nextInt(200);
				 }
			}
			int quantidade = objoperacoes.somaMatrizes(matriz1, matriz2);
			series.add(tamanho, quantidade);
			System.out.println("Quantidade de buscas: " + quantidade);
	}
		objGrafico = new Grafico(series);
		System.out.println("Quantidade gerado com sucesso!");
}
}