package postoCombustivel;

import java.util.Date;

public class Bomba {
	String tipoCombustivel;
	double capacidade;//capacidade total do tanque em litros:10 a 30 mil
	private double bombaAtualL;//Litros de combustivel na bomba
	private Date data = new Date();
	
	public Bomba(double capacidade, String tipoCombustivel) {
		this.capacidade = capacidade;
		this.tipoCombustivel = tipoCombustivel;
		encherBomba();
	}
	
	//enche a bomba de combustivel de acordo
	//com a capacidade total
	private void encherBomba() {
		setBombaAtual(capacidade);
	}

	public double getBombaAtual() {
		return bombaAtualL;
	}

	public void setBombaAtual(double bombaAtual) {
		this.bombaAtualL = bombaAtual;
	}
	//Pressupondo que todos os veículos 
	//estão com tanque vazio e os terão completados,
	public void abastecer(Carros carro) {
		try {
			//caso o carro nao possa ser abastecido com Etanol
			//o metodo irá lançar uma RuntimeExcepion 
			if(carro.consumoEtanol == 0 
					&& this.tipoCombustivel.equalsIgnoreCase("etanol")) {
				throw new CombustivelException();
			}
			
			if (carro.getTanqueAtual() < carro.capacidadeTanque) {
				//enche o tanque do Carro
				//se o tanque atual for menor que a capacidade total
				double litrosCombustivel = 0;
				do {
					carro.setTanqueAtual(litrosCombustivel++);
				} while (carro.getTanqueAtual() < carro.capacidadeTanque);
				
				double precoFinal = calcularPreco(litrosCombustivel -1);

				System.out.println(
						linhasFormat()+
						"\n" + data 
						+ "\n" + carro.modelo 
						+ " " + carro.placa 
						+ "\nCombustivel:" + tipoCombustivel
						+ "\nTotal abastecido(L):" + carro.getTanqueAtual()
						+ "\nPreço Total:R$"+precoFinal);
				statusBomba(litrosCombustivel - 1);
			}else {
				//se o tanque ja estiver cheio
				System.out.println(
						"\n" + data
						+ "\n"+carro.modelo
						+ " " + carro.placa 
						+ "\nO tanque do carro está cheio!");
			}
		} catch (CombustivelException e) {
			System.out.println(
					linhasFormat()+
					"\n" + data
					+ "\n"+carro.modelo
					+ " " + carro.placa 
					+ "\nNão pode ser abastecido com Etanol!");
		}
	}
	//calcula o preco final do abastecimento
	private double calcularPreco(double litroC) {
		if(this.tipoCombustivel.equalsIgnoreCase("Etanol")) {
			double precoE = litroC * 2.27;
			return precoE;
		}else if(this.tipoCombustivel.equalsIgnoreCase("Gasolina")) {
			
			double precoG = litroC * 2.9;
			return precoG;
		}else {
			return 0;
		}
	}
	
	
	private void statusBomba(Double combustivel) {
		//atualiza o status atual da bomba de combustivel
		//recebendo como parametro a quantide de combustivel 
		//do ultimo abastecimento
		setBombaAtual(bombaAtualL - combustivel);
		if(getBombaAtual() == 0) {
			System.out.println("A bomba de combustível está vazia!");
		}else {
			
			System.out.println(
					"\n\nBomba atual(L):"+getBombaAtual()+"/"+capacidade
					+"\nCombustível:"+ tipoCombustivel
					+"\nTotal abastecido(L):"+(capacidade - getBombaAtual())
					+linhasFormat());
		}
		
	}
	
	//imprime um conjunto de linhas
	//para ajudar na formatação e visualização no console
	public String linhasFormat() {
		return "\n-----------------------";
	}
	
	
}
