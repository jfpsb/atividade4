package agencia;

import java.util.HashMap;

import arquivo.ManipulaArquivo;
import input.Ler;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;
import pessoa.gerente.OperacoesGerente;

public class OperacoesAgencia {
	public Agencia CadastrarAgencia() {
		Agencia agencia = new Agencia();
		Gerente gerente = null;
		HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
		int opcao;
		String matriculaPesquisa;

		System.out.println("Voc� ir� agora escolher o gerente para esta ag�ncia. Acompanhe o menu a seguir: ");
		System.out.println("1 - O gerente que desejo j� est� cadastrado, deixe-me digitar sua matr�cula;");
		System.out.println("2 - Desejo cadastrar um novo gerente para esta ag�ncia;");
		System.out.println("3 - Liste-me todos os gerentes cadastrados para que eu possa escolher;");
		System.out.println("Informe sua escolha: ");
		opcao = Ler.lerInt();

		switch (opcao) {
		case 1:
			matriculaPesquisa = Ler.linha();
			gerente = ManipulaArquivo.<Gerente>RetornaObjArquivo(matriculaPesquisa, "Gerentes");
			break;
		case 2:
			gerente = OperacoesGerente.CadastrarGerente();
			break;
		case 3:
			System.out.println("Listando todos os gerentes:");
			ManipulaArquivo.ListarArquivos("Gerentes");
			break;
		default:
			System.out.println("Op��o inv�lida.");
			break;
		}
		
		agencia.setGerente(gerente);
		agencia.setClientes(clientes);
		agencia.setNumero(1307);
		
		return agencia;
	}
}
