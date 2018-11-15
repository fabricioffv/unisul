import java.util.List;
import java.util.Random;


public class Carteira {
	double carteiraInicial[]  = new double[10];
	double retornosMeses[] = new double[10];
	char nomeAcoes[] = new char[10];
	
	public void SetCarteiraInicial() {
		retornosMeses[0] = 0.42292;//1
		retornosMeses[1] = 0.25685;//2
		retornosMeses[2] = 0.04128;
		retornosMeses[3] = 0.05812;
		retornosMeses[4] = -0.01731;
		retornosMeses[5] = 0.09615;//5
		retornosMeses[6] = 0.12039;//4
		retornosMeses[7] = 0.05166;
		retornosMeses[8] = -0.00424;
		retornosMeses[9] = 0.21782;//3
		
		carteiraInicial[0] = 0.30;
		carteiraInicial[1] = 0.25;
		carteiraInicial[2] = 0.20;
		carteiraInicial[3] = 0.15;
		carteiraInicial[4] = 0.10;
		carteiraInicial[5] = 0.0;
		carteiraInicial[6] = 0.0;
		carteiraInicial[7] = 0.0;
		carteiraInicial[8] = 0.0;
		carteiraInicial[9] = 0.0;
		
		nomeAcoes[0] = 'A';
		nomeAcoes[1] = 'B';
		nomeAcoes[2] = 'C';
		nomeAcoes[3] = 'D';
		nomeAcoes[4] = 'E';
		nomeAcoes[5] = 'F';
		nomeAcoes[6] = 'G';
		nomeAcoes[7] = 'H';
		nomeAcoes[8] = 'I';
		nomeAcoes[9] = 'J';
	}
	
	public double[] GetMelhorVizinho(double aCarteira[]) {
		double arrVizinhos[][] = new double[35][10];
		
		//Popular array arrVizinhos com carteira atual para depois realizar as trocas
		for(int i=0; i < arrVizinhos.length; i++) {
			arrVizinhos[i] = aCarteira.clone();
		}
		
		double valorA, valorB;
		int x = 0;
		
		//Realiza as trocas
		for(int a=0; a < aCarteira.length; a++) {
			for(int b=a+1; b < aCarteira.length; b++) {
				if((aCarteira[a] > 0.0) || (aCarteira[b] > 0.0)) {
					valorA = arrVizinhos[x][a];
					valorB = arrVizinhos[x][b];
					arrVizinhos[x][a] = valorB;
					arrVizinhos[x][b] = valorA;
					x++;
				}
			}
			
		}
	
			
		//Calculo do retorno total de cada carteira
//		double valorMaior = -99999.0;
		double valorMaior = GetValorTotalCarteira(aCarteira);
		double valorCalculo = 0;
		int iMaior = -1;
		
		
		for(int i=0; i < arrVizinhos.length; i++) {
			valorCalculo = 0;
			valorCalculo = GetValorTotalCarteira(arrVizinhos[i]);
			
			if (valorCalculo > valorMaior) {
				valorMaior = valorCalculo;
				iMaior = i;
			}
		}
		
		double[] melhorVizinho;
		
		if (iMaior == -1) {
			melhorVizinho = aCarteira;
		}else {
			melhorVizinho = arrVizinhos[iMaior];
		}
		 
		
		if(GetValorTotalCarteira(melhorVizinho) > GetValorTotalCarteira(aCarteira)) {
			return GetMelhorVizinho(melhorVizinho.clone());
		}else {
			return aCarteira;
		}
	
	}
	
	public double[] SortearCarteira(double[] aPerc) {
		double retorno[] = new double[10];
		retorno = aPerc.clone();
		Random random = new Random();
		
		for (int i=0; i < retorno.length; i++) {
			//sorteia um índice
			int j = random.nextInt(retorno.length); 
			
			//troca o conteúdo dos índices i e j do vetor
			double aux = retorno[i];
			retorno[i] = retorno[j];
			retorno[j] = aux;
		}
		
		return retorno;
	}
	
	public double GetValorTotalCarteira(double [] pCarteira) {
		double valor = 0.0;
		for(int i=0; i < pCarteira.length; i++) {
			valor += pCarteira[i] * this.retornosMeses[i];
		}
		return valor;
	}
		
	
	public static void main(String[] args) {
		Carteira carteira = new Carteira();
		double melhorVizinho[] = null;
		String strNomeAcoes = "", strPercentuais = "";
		
		carteira.SetCarteiraInicial();
		
		//Exibição da Carteira Inicial
		System.out.println("- Carteira Inicial -");
		for(int i = 0; i < carteira.carteiraInicial.length; i++) {
			if(i==0) {
				strNomeAcoes += Character.toString(carteira.nomeAcoes[i]);
				strPercentuais += Double.toString(carteira.carteiraInicial[i]);
			}else {
				strNomeAcoes += "\t" + Character.toString(carteira.nomeAcoes[i]);
				strPercentuais += "\t" + Double.toString(carteira.carteiraInicial[i]);
			}
		}
		System.out.println(strNomeAcoes + "\n" + strPercentuais + "\nTotal: " + carteira.GetValorTotalCarteira(carteira.carteiraInicial));
					
		
		melhorVizinho = carteira.GetMelhorVizinho(carteira.carteiraInicial.clone());
				
		//Exibição do melhor vizinho
		strPercentuais = "";
		System.out.println("\n - Melhor Vizinho -");
		for(int i = 0; i < melhorVizinho.length; i++) {
			if(i==0) {
				strPercentuais += Double.toString(melhorVizinho[i]);
			}else {
				strPercentuais += "\t" + Double.toString(melhorVizinho[i]);
			}
		}
		System.out.println(strNomeAcoes + "\n" + strPercentuais + "\nTotal: " + carteira.GetValorTotalCarteira(melhorVizinho));
		
		//Exibe o total do melhor vizinho da carteira inicial encontrado 
		System.out.println("\n- Retorno do melhor Vizinho da Carteira inicial - ");
		for(int i=0; i < melhorVizinho.length; i++) {
			System.out.println(
			"Ação " + Character.toString(carteira.nomeAcoes[i]) + "\tAplicacao de : " + Double.toString(melhorVizinho[i] * 100) + "%" +
			"\tRetorno de: " + Double.toString(melhorVizinho[i] * carteira.retornosMeses[i]) );
		}
		System.out.println("Total: " + carteira.GetValorTotalCarteira(melhorVizinho));
		
		
		
		//*************************************SORTEIO*************************************************
		for(int s=1; s < 10000; s++) {
			double[] sorteada = new double[10];
			
			//Sorteio da Carteira
			sorteada = carteira.SortearCarteira(carteira.carteiraInicial.clone());
			
			System.out.println("\n\n**********" + s + "º Sorteio**********\n");
			
			//Exibição do sorteio
			strPercentuais = "";
			System.out.println("\n - Carteira Sorteada -");
			for(int i = 0; i < sorteada.length; i++) {
				if(i==0) {
					strPercentuais += Double.toString(sorteada[i]);
				}else {
					strPercentuais += "\t" + Double.toString(sorteada[i]);
				}
			}
			System.out.println(strNomeAcoes + "\n" + strPercentuais + "\nTotal: " + carteira.GetValorTotalCarteira(sorteada));
			
			melhorVizinho = null;
			melhorVizinho = carteira.GetMelhorVizinho(sorteada);
			
			
			//Exibição da Melhor Vizinho da Carteira Sorteada
			strPercentuais = "";
			System.out.println("\n - Melhor Vizinho da Carteira Sorteada -");
			for(int i = 0; i < sorteada.length; i++) {
				if(i==0) {
					strPercentuais += Double.toString(melhorVizinho[i]);
				}else {
					strPercentuais += "\t" + Double.toString(melhorVizinho[i]);
				} 
			}
			System.out.println(strNomeAcoes + "\n" + strPercentuais + "\nTotal: " + carteira.GetValorTotalCarteira(melhorVizinho));
			
			if (carteira.GetValorTotalCarteira(melhorVizinho) != 0.262326) {
				System.out.println("Diferente");
			}
			
			//Exibe o total do melhor vizinho da carteira sorteada encontrado
			System.out.println("\n - Retorno do melhor vizinho da Carteira sorteada - ");
			for(int i=0; i < melhorVizinho.length; i++) {
				System.out.println(
				"Ação " + Character.toString(carteira.nomeAcoes[i]) + "\tAplicacao de : " + Double.toString(melhorVizinho[i] * 100) + "%" +
				"\tRetorno de: " + Double.toString(melhorVizinho[i] * carteira.retornosMeses[i]) );
			}
			System.out.println("Total: " + carteira.GetValorTotalCarteira(melhorVizinho));
		}
	}

}