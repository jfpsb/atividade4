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

		System.out.println("Novo saldo ap�s rendimento: " + this.getSaldo());
		
		extrato.add("Realizado rendimento em conta de valor " + (saldo * taxa) + ". Novo saldo: " + this.getSaldo() + ". Em " + retornaDataAtual());
	}

	@Override
	public boolean Sacar(float valor, int senha) {
		float saldo = this.getSaldo();

		if (Autenticar(senha) && valor <= saldo) {
			saldo -= valor;
			this.setSaldo(saldo);
			
			extrato.add("Saque de valor " + valor + " realizado em " + retornaDataAtual());
			
			return true;
		}

		return false;
	}

	@Override
	public boolean Transferir(ContaBancaria conta, float valor, int senha) {
		float saldoOutcome = this.getSaldo(); // Origem da transfer�ncia
		float saldoIncome = conta.getSaldo(); // Destino da transfer�ncia

		if (Autenticar(senha) && valor <= saldoOutcome) {
			saldoOutcome -= valor;
			saldoIncome += valor;

			this.setSaldo(saldoOutcome);
			conta.setSaldo(saldoIncome);
			
			extrato.add("Transfer�ncia de valor " + valor + " realizada em " + retornaDataAtual() + " para conta de n�mero " + conta.getNumero());

			return true;
		}

		return false;
	}
}
