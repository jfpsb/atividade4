package agencia;

import java.io.Serializable;
import java.util.HashMap;

import conta.*;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;

public class Agencia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private Gerente gerente;
	HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

	//getter setters
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

	public void AtualizarContas(float tarifa, float taxa) {
		for (Cliente c : clientes.values()) {
			ContaBancaria conta = c.getConta();

			if (conta instanceof ContaCorrente) {			
				((ContaCorrente) conta).Tarifar(tarifa);
			}
			else {
				((ContaPoupanca) conta).Render(taxa);
			}
		}
	}
	
	public float calcularReceitaAgencia() {
		float total = 0;
		
		for(Cliente c : clientes.values()){
			total =+ c.getConta().getSaldo();
		}
		
		return total;
	}
	
	public float calcularReceitaContaCorrente(){
		float total = 0;
		
		for(Cliente c : clientes.values()){
			ContaBancaria conta = c.getConta();
			if(conta instanceof ContaCorrente){
				total += conta.getSaldo();
			}
		}
		
		return total;
	}
	
	public float calcularReceitaContaPoupanca(){
		float total = 0;
		
		for(Cliente c : clientes.values()){
			ContaBancaria conta = c.getConta();
			if(conta instanceof ContaPoupanca){
				total += conta.getSaldo();
			}
		}
		
		return total;
	}
}
