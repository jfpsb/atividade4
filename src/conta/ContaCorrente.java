package conta;

public class ContaCorrente extends ContaBancaria implements ITransacoes {
	protected float limiteEspecial;

	public ContaCorrente() {
		this.limiteEspecial = 100;
	}

	public float getLimiteEspecial() {
		return limiteEspecial;
	}

	public void setLimiteEspecial(float limiteEspecial) {
		this.limiteEspecial = limiteEspecial;
	}

	public void Tarifar(float tarifa) {
		float saldo = this.getSaldo();

		saldo = saldo - tarifa;

		this.setSaldo(saldo);

		System.out.println("\nNovo saldo após tarifa: " + this.getSaldo());
	}

	@Override
	public boolean Sacar(float valor, int senha) {
		float saldo = this.getSaldo();

		if (Autenticar(senha) && valor <= Math.abs((saldo + limiteEspecial))) {
			saldo = saldo - valor;

			this.setSaldo(saldo);

			return true;
		}

		return false;
	}

	@Override
	public boolean Transferir(ContaBancaria conta, float valor, int senha) {
		float saldoOutcome = this.getSaldo();
		float saldoIncome = conta.getSaldo();

		if (Autenticar(senha) && valor <= (saldoOutcome + limiteEspecial)) {
			saldoOutcome -= valor;
			saldoIncome += valor;

			this.setSaldo(saldoOutcome);
			conta.setSaldo(saldoIncome);

			return true;
		}

		return false;
	}

}
