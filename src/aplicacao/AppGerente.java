package aplicacao;

import input.Ler;

public class AppGerente {
	public void mostraMenuGerente() {
		int opcao, repetir = 1, sair = 0;

		while (repetir == 1) {
			System.out.println("Acompanhe o seguinte menu: ");
			System.out.println("1 - Desejo adicionar um cliente à Agência;");
			System.out.println("2 - Desejo atualizar todas as contas da Agência;");
			System.out.println("3 - Desejo calcular a receita total da Agência;");
			System.out.println("4 - Desejo calcular a receita das contas correntes da Agência;");
			System.out.println("5 - Desejo calcular a receita das contas poupança da Agência;;");
			System.out.println("6 - Desejo sair deste menu;");

			System.out.printf("Digite a opção desejada: ");
			opcao = Ler.lerInt();
			
			switch (opcao) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
			
			if (sair != 1) {
				System.out.printf("Deseja repetir o menu de Gerente? Digite 1 para SIM, qualquer outro para NÃO: ");
				repetir = Ler.lerInt();
			}
		}
	}
}
