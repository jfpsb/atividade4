package aplicacao;

import java.util.ArrayList;

import conta.ContaBancaria;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import pessoa.cliente.Cliente;

public class AppCliente extends Cliente {

	private boolean logado;

	public AppCliente(int numero, int senha) {
		logado = this.logar(numero, senha);
	}

	public boolean logar(int numero, int senha) {

		if (numero == this.getConta().getNumero() && senha == this.getConta().getSenha()) {
			return true;
		}

		return false;
	}

	public boolean sacar(float valor, int senha) {
		if (!logado)
			return false;

		ContaBancaria c = this.getConta();

		if (c instanceof ContaCorrente) {
			return ((ContaCorrente) c).Sacar(valor, senha);
		} else {
			return ((ContaPoupanca) c).Sacar(valor, senha);
		}
	}

	public void depositar(float valor) {
		if (!logado)
			return;

		this.getConta().Depositar(valor);
	}

	public boolean transferir(ContaBancaria conta, float valor, int senha) {
		if (!logado)
			return false;

		ContaBancaria c = this.getConta();

		if (c instanceof ContaCorrente) {
			return ((ContaCorrente) c).Transferir(conta, valor, senha);
		} else {
			return ((ContaPoupanca) c).Transferir(conta, valor, senha);
		}
	}

	public float verificarSaldo() {
		if (!logado) {
			System.out.println("Autenticação falhou.");
			return 0;
		}

		return this.getConta().getSaldo();
	}

	public String verificarExtrato() {
		if (!logado)
			return "Autenticação falhou";
		
		ArrayList<String> ext = new ArrayList<String>();
		
		ext = this.getConta().getExtrato();
		
		for(String s : ext){
			System.out.println(s);
		}
		
		return null;
	}

	public void sair() {
		logado = false;
	}
}
