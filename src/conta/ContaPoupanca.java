package conta;

public class ContaPoupanca extends ContaBancaria implements ITransacoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void Render(float taxa) {
		float saldo = this.getSaldo();

		saldo += (saldo * taxa);

		this.setSaldo(saldo);

		System.out.println("Novo saldo após rendimento: " + this.getSaldo());
	}

	@Override
	public boolean Sacar(float valor, int senha) {
		float saldo = this.getSaldo();

		if (Autenticar(senha) && valor <= saldo) {
			saldo -= valor;
			this.setSaldo(saldo);
		}

		return false;
	}

	@Override
	public boolean Transferir(ContaBancaria conta, float valor, int senha) {
		float saldoOutcome = this.getSaldo(); // Origem da transferência
		float saldoIncome = conta.getSaldo(); // Destino da transferência

		if (Autenticar(senha) && valor <= saldoOutcome) {
			saldoOutcome -= valor;
			saldoIncome += valor;

			this.setSaldo(saldoOutcome);
			conta.setSaldo(saldoIncome);

			return true;
		}

		return false;
	}
}
