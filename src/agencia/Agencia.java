package agencia;

import java.io.Serializable;
import java.util.HashMap;

import conta.*;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;

/**
 * Classe de Agência.
 * 
 * @author jfpsb
 *
 */
public class Agencia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private Gerente gerente;
	HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

	// getter setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public HashMap<Integer, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<Integer, Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * O gerente poderá atualizar as contas, indicando a tarifa para as Contas
	 * Correntes e a taxa de rendimento para as Contas Poupanças
	 * 
	 * @param tarifa
	 *            Tarifa informada pelo gerente.
	 * @param taxa
	 *            Taxa de rendimento informada pelo gerente.
	 */
	public void AtualizarContas(float tarifa, float taxa) {
		for (Cliente c : clientes.values()) {
			ContaBancaria conta = c.getConta();

			if (conta instanceof ContaCorrente) {
				((ContaCorrente) conta).Tarifar(tarifa);
			} else {
				((ContaPoupanca) conta).Render(taxa);
			}
		}
	}

	/**
	 * O gerente poderá calcular a soma de todas as Contas Bancárias
	 * 
	 * 
	 * @return Valor da soma de saldo de todas as contas.
	 */
	public float calcularReceitaAgencia() {
		float total = 0;

		for (Cliente c : clientes.values()) {
			total += c.getConta().getSaldo();
		}

		return total;
	}

	/**
	 * O gerente poderá calcular a soma dos saldos de todas as Contas Correntes
	 * 
	 * @return Valor da soma de saldo de todas as contas corrente.
	 */
	public float calcularReceitaContaCorrente() {
		float total = 0;

		for (Cliente c : clientes.values()) {
			ContaBancaria conta = c.getConta();
			if (conta instanceof ContaCorrente) {
				total += conta.getSaldo();
			}
		}

		return total;
	}

	/**
	 * O gerente poderá calcular a soma dos saldos de todas as Contas Poupanças
	 * 
	 * @return Valor da soma de saldo de todas as contas poupança.
	 */
	public float calcularReceitaContaPoupanca() {
		float total = 0;

		for (Cliente c : clientes.values()) {
			ContaBancaria conta = c.getConta();
			if (conta instanceof ContaPoupanca) {
				total += conta.getSaldo();
			}
		}

		return total;
	}
}
