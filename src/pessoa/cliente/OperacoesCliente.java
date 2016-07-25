package pessoa.cliente;

import conta.ContaBancaria;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import input.Ler;

public class OperacoesCliente {
	public Cliente CadastrarCliente() {
		Cliente cliente = new Cliente();
		String nome, cpf;
		ContaBancaria conta;
		int opcaoConta;
		int numeroConta, senhaConta;
		float saldoInicial;
		
		System.out.println("Informe o nome do cliente: ");
		nome = Ler.linha();

		System.out.println("Informe o CPF do cliente: ");
		cpf = Ler.linha();
		
		System.out.println("Informe o número da conta do cliente: ");
		numeroConta = Ler.lerInt();
		
		System.out.println("Informe a senha da conta do cliente: ");
		senhaConta = Ler.lerInt();
		
		System.out.println("Informe o saldo inicial da conta do cliente: ");
		saldoInicial = Ler.lerInt();
		
		System.out.println("1 - Conta Corrente;");
		System.out.println("2 - Conta Poupança;");
		System.out.println("Informe que tipo de conta este cliente irá utilizar: ");
		opcaoConta = Ler.lerInt();
		
		if(opcaoConta == 1) {
			conta = new ContaCorrente();
		}
		else {
			conta = new ContaPoupanca();
		}
		
		conta.setNumero(numeroConta);
		conta.setSenha(senhaConta);
		conta.setSaldo(saldoInicial);
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setConta(conta);
		
		return cliente;
	}
}
