package cliente;

import conta.ContaBancaria;

public class Cliente extends Pessoa {
	private ContaBancaria conta;

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
}
