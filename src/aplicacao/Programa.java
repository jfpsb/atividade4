package aplicacao;

public class Programa {
	public static void main(String[] args) {
		System.out.println(">>>>> Aplica��o Banco <<<<<");
		AppBanco appBanco = new AppBanco();
		
		System.out.println("Nome: " + appBanco.getBanco().getGerente().getNome());
		System.out.println("N�mero: " + appBanco.getBanco().getNumero());
	}
}
