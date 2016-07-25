package pessoa.cliente;

import java.io.Serializable;

import conta.ContaBancaria;
import pessoa.Pessoa;

public class Cliente extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContaBancaria conta;

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
}
