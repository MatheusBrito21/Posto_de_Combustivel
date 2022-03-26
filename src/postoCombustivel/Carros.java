package postoCombustivel;

public class Carros {
	String modelo;
	String placa;
	double consumoEtanol;
	double consumoGasolina;
	double capacidadeTanque;
	private double tanqueAtual = 0;//incia com o tanque vazio
	
	public Carros(String modelo, String placa, 
			double consumoEtanol, 
			double consumoGasolina, 
			double capacidadeTanque) {
		this.modelo = modelo;
		this.placa = placa;
		this.consumoEtanol = consumoEtanol;
		this.consumoGasolina = consumoGasolina;
		this.capacidadeTanque = capacidadeTanque;
	}

	public double getTanqueAtual() {
		return tanqueAtual;
	}

	public void setTanqueAtual(double tanqueAtual) {
		this.tanqueAtual = tanqueAtual;
	}
	
	
	
	
}
