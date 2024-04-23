
public class PesquisaDados {

	int pesquisaBinaria(int chave, int vetor[], int TamanhoVetor) {
		int inicio = 0;
		int meio;
		int fim = TamanhoVetor -1;
		
		int QuantidadeOperacoes=0;
		
		while (inicio <= fim) {
			QuantidadeOperacoes++;
			
			meio = (inicio + fim) /2;
			if (chave < vetor[meio])
				fim = meio -1;
			else if(chave > vetor[meio])
				inicio = meio + 1;
			else return QuantidadeOperacoes;
					
		}
		return QuantidadeOperacoes;
	}
}
