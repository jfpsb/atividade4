package conta;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ContaBancaria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private float saldo;
	private int senha;
	protected ArrayList<String> extrato = new ArrayList<String>();

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
		
		extrato.add("Realizado depósito de " + valor + " em " + retornaDataAtual());
	}
	
	public static String retornaDataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm:ss").format(new Date());
	}
}
