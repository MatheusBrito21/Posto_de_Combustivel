package postoCombustivel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PostoMain {
	public static void main(String[] args) {
		//criar as instancias de Bomba e carros
		
		Carros FU = new Carros("FIAT-UNO","JGG-7389", 8.9 ,12.7,48);
		Carros FK = new Carros("FORD-KA","JGF-8573", 8.1,11.6,55);
		Carros CC3 = new Carros("CITROEN-C3","JWM-1235", 7.5,11.9,47);
		Carros AUA1 = new Carros("AUDI-A1","JGE-4583",0,10.8,45);
		Carros AUA4 = new Carros("AUDI-A4","JMM-7513", 0 ,8.8,65);

		List<Carros> listaCarros = Arrays.asList(AUA4,AUA1,CC3,FK,FU);
		
		
		//Laco de repetição  linha 26-49
		//Selecion a bomba para abastecer a lista de carros
		//se 1 = Gasolina
		//se 2 = Etanol
		Scanner e = new Scanner(System.in);
		int aux;//auxilia no controle do loop
		do {
			aux = 1;
			
			System.out.println("Selecione uma opção de Combustivel"
					+ "\n1 -> Gasolina"
					+ "\n2 -> Etanol"
					+ "\nOpção: ");
			int op = e.nextInt();
			
			if (op == 1) {
				Bomba bombaGasolina = new Bomba(1000, "Gasolina");
				for (Carros c : listaCarros) {
					bombaGasolina.abastecer(c);
				}
			} else if (op == 2) {
				Bomba bombaEtanol = new Bomba(1000, "Etanol");
				for (Carros c : listaCarros) {
					bombaEtanol.abastecer(c);
				}
			} else {
				System.out.println("Opção invalida");
				aux = 0;
			} 
		} while(aux == 0);
		e.close();

	
	}//main
	
	
}//classe
