package conta;

public interface ITransacoes {
	public boolean Sacar(float valor, int senha);
	public boolean Transferir(ContaBancaria conta, float valor, int senha);
}
