package conta;

public class ContaCorrente extends ContaBancaria implements ITransacoes {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

		saldo -= tarifa;

		this.setSaldo(saldo);

		System.out.println("\nNovo saldo após tarifa: " + this.getSaldo());
		
		extrato.add("Realizada tarifação em conta de valor " + tarifa + ". Novo saldo: " + this.getSaldo() + ". Em " + retornaDataAtual());
	}

	@Override
	public boolean Sacar(float valor, int senha) {
		float saldo = this.getSaldo();

		if (Autenticar(senha) && valor <= (saldo + limiteEspecial)) {
			saldo = saldo - valor;

			this.setSaldo(saldo);
			
			extrato.add("Saque de valor " + valor + " realizado em " + retornaDataAtual());

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
			
			extrato.add("Transferência de valor " + valor + " realizada em " + retornaDataAtual() + " para conta de número " + conta.getNumero());

			return true;
		}

		return false;
	}

}
