package conta;

import java.util.ArrayList;

public class ContaBancaria {
	private int numero;
	private float saldo;
	private int senha;
	private ArrayList<String> extrato;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public ArrayList<String> getExtrato() {
		return extrato;
	}

	public void setExtrato(ArrayList<String> extrato) {
		this.extrato = extrato;
	}

	public boolean Autenticar(int senha) {
		if (this.senha == senha) {
			return true;
		}

		return false;
	}

	public void Depositar(float valor) {
		float saldo = getSaldo();

		saldo += valor;

		setSaldo(saldo);
		
		System.out.println("Dep�sito realizado com sucesso.");
	}
}
