package aplicacao;

import java.util.ArrayList;

import conta.ContaBancaria;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import input.Ler;
import pessoa.cliente.Cliente;

public class AppCliente {

	private static boolean logado;
	private static Cliente cliente;

	public AppCliente(Cliente cliente) {
		AppCliente.cliente = cliente;
		System.out.println("VOCÊ PRECISARÁ LOGAR ANTES DE REALIZAR QUALQUER OPERAÇÃO!");
	}

	public void mostrarMenuCliente() {
		int opcao, repetir = 1, sair = 0;

		while (repetir == 1) {
			System.out.println("Acompanhe o seguinte menu: ");
			System.out.println("1 - Desejo logar para usar as operações disponíveis;");
			System.out.println("2 - Desejo realizar um saque;");
			System.out.println("3 - Desejo realizar um depósito;");
			System.out.println("4 - Desejo realizar uma transferência;");
			System.out.println("5 - Desejo verificar meu saldo;");
			System.out.println("6 - Desejo verificar meu extrato bancário;");
			System.out.println("7 - Desejo sair deste menu;");

			System.out.printf("Digite a opção desejada: ");
			opcao = Ler.lerInt();

			switch (opcao) {
			case 1:
				logado = logar();
				if (logado)
					System.out.println("Login efetuado com sucesso.");
				else
					System.out.println("Erro ao logar.");
				break;
			case 2:
				if (sacar()) {
					System.out.println("Saque efetuado com sucesso.");
				} else {
					System.out.println("Erro ao sacar.");
				}
				break;
			case 3:
				depositar();
				break;
			case 4:
				if (transferir()) {
					System.out.println("Transferência efetuada com sucesso.");
				} else {
					System.out.println("Transferência não realizada.");
				}
				break;
			case 5:
				float saldo = verificarSaldo();
				System.out.println("Seu saldo atual é: " + saldo);
				break;
			case 6:
				verificarExtrato();
				break;
			case 7:
				sair();
				repetir = 0;
				sair = 1;
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
			
			AppBanco.atualizaArquivoAgencia();
			AppBanco.atualizaArquivoGerente();

			if (sair != 1) {
				System.out.printf("Deseja repetir o menu de Cliente? Digite 1 para SIM, qualquer outro para NÃO: ");
				repetir = Ler.lerInt();
			}
		}
	}

	public static boolean logar() {
		int senha;

		System.out.printf("Informe sua senha para login: ");
		senha = Ler.lerInt();

		if (senha == cliente.getConta().getSenha()) {
			return true;
		}

		return false;
	}

	public static boolean sacar() {
		if (!logado)
			return false;

		float valor;
		int senha;

		ContaBancaria c = cliente.getConta();

		System.out.printf("Digite o valor a ser sacado: ");
		valor = Ler.lerFloat();

		System.out.printf("Digite sua senha para autenticação: ");
		senha = Ler.lerInt();

		if (c instanceof ContaCorrente) {
			return ((ContaCorrente) c).Sacar(valor, senha);
		} else {
			return ((ContaPoupanca) c).Sacar(valor, senha);
		}
	}

	public static void depositar() {
		if (!logado)
			return;

		float valor;

		System.out.printf("Informe o valor a ser depositado: ");
		valor = Ler.lerFloat();

		cliente.getConta().Depositar(valor);

		System.out.println("Depósito efetuado com sucesso.");
	}

	public boolean transferir() {
		if (!logado)
			return false;

		ContaBancaria conta;
		int numeroConta, senha;
		float valor;

		System.out.printf("Informe o número da conta para qual irá transferir: ");
		numeroConta = Ler.lerInt();

		if (AppBanco.getBanco().getClientes().containsKey(numeroConta)) {
			conta = AppBanco.getBanco().getClientes().get(numeroConta).getConta();
		} else {
			System.out.println("Esta conta não existe.");
			return false;
		}

		System.out.printf("Digite o valor a ser transferido: ");
		valor = Ler.lerFloat();

		System.out.printf("Informe sua senha para autenticação: ");
		senha = Ler.lerInt();

		// Conta do cliente atual
		ContaBancaria c = cliente.getConta();

		if (c instanceof ContaCorrente) {
			return ((ContaCorrente) c).Transferir(conta, valor, senha);
		} else {
			return ((ContaPoupanca) c).Transferir(conta, valor, senha);
		}
	}

	public static float verificarSaldo() {
		if (!logado) {
			System.out.println("Autenticação falhou.");
			return 0;
		}

		return cliente.getConta().getSaldo();
	}

	public static void verificarExtrato() {
		if (!logado) {
			System.out.println("Você não está logado.");
			return;
		}

		ArrayList<String> ext = new ArrayList<String>();

		ext = cliente.getConta().getExtrato();

		for (String s : ext) {
			System.out.println(s);
		}
	}

	public void sair() {
		logado = false;
	}
}
