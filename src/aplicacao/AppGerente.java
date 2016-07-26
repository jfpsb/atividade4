package aplicacao;

import input.Ler;
import pessoa.cliente.Cliente;
import pessoa.cliente.OperacoesCliente;

public class AppGerente {
	public void mostraMenuGerente() {
		int opcao, repetir = 1, sair = 0;

		while (repetir == 1) {
			System.out.println("Acompanhe o seguinte menu: ");
			System.out.println("1 - Desejo adicionar um cliente � Ag�ncia;");
			System.out.println("2 - Desejo atualizar todas as contas da Ag�ncia;");
			System.out.println("3 - Desejo calcular a receita total da Ag�ncia;");
			System.out.println("4 - Desejo calcular a receita das contas correntes da Ag�ncia;");
			System.out.println("5 - Desejo calcular a receita das contas poupan�a da Ag�ncia;;");
			System.out.println("6 - Desejo sair deste menu;");

			System.out.printf("Digite a op��o desejada: ");
			opcao = Ler.lerInt();

			switch (opcao) {
			case 1:
				adicionarCliente();
				break;
			case 2:
				atualizarContas();
				break;
			case 3:
				calcularReceitaAgencia();
				break;
			case 4:
				calcularReceitaContaCorrente();
				break;
			case 5:
				calcularReceitaContaPoupanca();
				break;
			case 6:
				repetir = 0;
				sair = 1;
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}

			if (sair != 1) {
				System.out.printf("Deseja repetir o menu de Gerente? Digite 1 para SIM, qualquer outro para N�O: ");
				repetir = Ler.lerInt();
			}
		}
	}

	public static void adicionarCliente() {
		Cliente cliente;

		System.out.println("Voc� ir� agora cadastrar o novo cliente: ");
		cliente = new OperacoesCliente().CadastrarCliente();

		AppBanco.getBanco().getClientes().put(cliente.getConta().getNumero(), cliente);

		System.out.println("Cliente inserido com sucesso.");
	}

	private static void atualizarContas() {
		float tarifa, taxa;

		System.out.println("Informe a tarifa que ser� utilizada: ");
		tarifa = Ler.lerFloat();

		System.out.println("Informe a taxa que ser� utilizada: ");
		taxa = Ler.lerFloat();

		AppBanco.getBanco().AtualizarContas(tarifa, taxa);

		System.out.println("Contas atualizadas.");
	}

	private static void calcularReceitaAgencia() {
		System.out.println("A receita total da Ag�ncia �: " + AppBanco.getBanco().calcularReceitaAgencia());
	}

	private static void calcularReceitaContaCorrente() {
		System.out.println("A receita total das contas corrente da Ag�ncia �: "
				+ AppBanco.getBanco().calcularReceitaContaCorrente());
	}

	private static void calcularReceitaContaPoupanca() {
		System.out.println("A receita total das contas poupan�a da Ag�ncia �: "
				+ AppBanco.getBanco().calcularReceitaContaPoupanca());
	}
}
