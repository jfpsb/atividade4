package aplicacao;

import java.util.ArrayList;

import conta.ContaBancaria;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import input.Ler;
import pessoa.cliente.Cliente;

public class AppCliente {

	private boolean logado;
	private Cliente cliente;

	public AppCliente(Cliente cliente) {
		this.cliente = cliente;
		System.out.println("VOC� PRECISAR� LOGAR ANTES DE REALIZAR QUALQUER OPERA��O!");
	}

	public void mostrarMenuCliente() {
		int opcao;

		System.out.println("Acompanhe o seguinte menu: ");
		System.out.println("1 - Desejo logar para usar as opera��es dispon�veis;");
		System.out.println("2 - Desejo realizar um saque;");
		System.out.println("3 - Desejo realizar um dep�sito;");
		System.out.println("4 - Desejo realizar uma tranfer�ncia;");
		System.out.println("5 - Desejo verificar meu saldo;");
		System.out.println("6 - Desejo verificar meu extrato banc�rio;");
		System.out.println("7 - Desejo sair deste menu;");

		System.out.printf("Digite a op��o desejada: ");
		opcao = Ler.lerInt();

		switch (opcao) {
		case 1:
			
			break;
		}
	}

	public boolean logar(int numero, int senha) {

		if (numero == cliente.getConta().getNumero() && senha == cliente.getConta().getSenha()) {
			return true;
		}

		return false;
	}

	public boolean sacar(float valor, int senha) {
		if (!logado)
			return false;

		ContaBancaria c = cliente.getConta();

		if (c instanceof ContaCorrente) {
			return ((ContaCorrente) c).Sacar(valor, senha);
		} else {
			return ((ContaPoupanca) c).Sacar(valor, senha);
		}
	}

	public void depositar(float valor) {
		if (!logado)
			return;

		cliente.getConta().Depositar(valor);
	}

	public boolean transferir(ContaBancaria conta, float valor, int senha) {
		if (!logado)
			return false;

		ContaBancaria c = cliente.getConta();

		if (c instanceof ContaCorrente) {
			return ((ContaCorrente) c).Transferir(conta, valor, senha);
		} else {
			return ((ContaPoupanca) c).Transferir(conta, valor, senha);
		}
	}

	public float verificarSaldo() {
		if (!logado) {
			System.out.println("Autentica��o falhou.");
			return 0;
		}

		return cliente.getConta().getSaldo();
	}

	public String verificarExtrato() {
		if (!logado)
			return "Autentica��o falhou";

		ArrayList<String> ext = new ArrayList<String>();

		ext = cliente.getConta().getExtrato();

		for (String s : ext) {
			System.out.println(s);
		}

		return null;
	}

	public void sair() {
		logado = false;
	}
}
