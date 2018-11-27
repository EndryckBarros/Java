package edu.cenario2;

public class Principal {

	public static void main(String[] args) {
		Pousada politanos = new Pousada("Politanos", "Salvador", "Bahia", 58.75, 38);
		Pousada afrociberdelia = new Pousada("Afrociberdelia", "Olinda", "Pernanbuco", 42.20, 23);
		
		String[] opcoes = { "Politanos", "Afrociberdelia" };

		boolean continua = true;
		do {
			
			int opcao = Console.mostrarMenu(opcoes, "Escolha a Pousada:", null);

			switch (opcao) {
			case 1:
				menu2(politanos);
				break;
			case 2:
				menu2(afrociberdelia);
				break;
			case -1:
				System.out.println("Saindo...");
				continua = false;
				break;
			}
		} while (continua);		
	}
	
	public static void menu2(Pousada pousada) {
		String[] opcoes = { 
				"Ocupar Quarto", "Desocupar Quarto", "Quantidade de Quartos Ocupados", 
				"Quantidade de Quartos Desocupados", "Ver Quartos Ocupados",
				"Ver Quartos Desocupados", "Valor a Ser Faturado com as Pernoites Atuais"};
		
		boolean continua = true;
		do {
			int opcao = Console.mostrarMenu(opcoes, "Pousada: " + pousada.getNome(), null);

			switch (opcao) {
			case 1:
				int numero = Console.recuperaInteiroPositivo("Informe o Número do Quarto: ");
				boolean disponibilidade = pousada.ocuparQuarto(numero);
				
				if(disponibilidade == true) {
					System.out.println("O Quarto Número: " + numero + " Foi Reservado.");
					System.out.println("Tenha uma boa estadia!");
					System.out.println();
				}else {
					System.out.println("Quarto Indisponível.");
					System.out.println();
				}
				break;
			case 2:
				numero = Console.recuperaInteiroPositivo("Informe o Número do Quarto: ");
				int estado = pousada.desocuparQuarto(numero);
				if(estado == 1) {
					pousada.getQuatos()[numero] = 0;
					System.out.println("O Quarto Foi Desocupado.");
					System.out.println();
				}else {
					System.out.println("Este Quarto Já Está Vazio.");
					System.out.println();
				}
				break;
			case 3:
				System.out.println("Há " + pousada.totalQuartosOcupados() + " Quartos Ocupados.");
				System.out.println();
				break;
			case 4:
				System.out.println("Há " + pousada.totalQuartosLivres() + " Quartos Disponíveis.");
				System.out.println();
				break;
			case 5:
				int numeroDosQuartos[] = pousada.quartosOcupados();
				for (int i = 0; i < numeroDosQuartos.length; i++) {
					System.out.print("Quarto Numero: " + (numeroDosQuartos[i]));
					System.out.println();
				}
				System.out.println();
				break;
			case 6:
				numeroDosQuartos = pousada.quartosLivres();
				for (int i = 0; i < numeroDosQuartos.length; i++) {
					System.out.print("Quarto Numero: " + (numeroDosQuartos[i]));
					System.out.println();
				}
				System.out.println();
				break;
			case 7:
				System.out.print("Valor: " + pousada.valorParaFaturar());
				System.out.println();
				break;
			case -1:
				for (int i = 0; i < 20; ++i)
				    System.out.println ();
				continua = false;
				break;
			}
		} while (continua);
	}

}
