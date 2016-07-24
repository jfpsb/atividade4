package agencia;

import java.util.HashMap;
import java.util.Map;

import cliente.Cliente;
import cliente.Gerente;
import conta.*;

public class Agencia {
	private Gerente gerente;
	HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

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
