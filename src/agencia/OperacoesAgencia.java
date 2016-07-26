package agencia;

import java.util.HashMap;

import arquivo.ManipulaArquivo;
import input.Ler;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;
import pessoa.gerente.OperacoesGerente;

/**
 * Controla as operações de Agência.
 * 
 * @author jfpsb
 *
 */
public class OperacoesAgencia {
	/**
	 * Realiza o cadastro de uma Agência no sistema.
	 * 
	 * @return Retorna a agência criada.
	 */
	public static Agencia CadastrarAgencia() {
		Agencia agencia = new Agencia();
		Gerente gerente = null;
		HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
		int opcao, numeroAgencia;
		String matriculaPesquisa;

		while (gerente == null) {

			System.out.println("Você irá agora escolher o gerente para esta agência. Acompanhe o menu a seguir: ");
			System.out.println("1 - O gerente que desejo já está cadastrado, deixe-me digitar sua matrícula;");
			System.out.println("2 - Desejo cadastrar um novo gerente para esta agência;");
			System.out.println("3 - Liste-me todos os gerentes cadastrados para que eu possa escolher;");
			System.out.printf("Informe sua escolha: ");
			opcao = Ler.lerInt();

			switch (opcao) {
			case 1:
				matriculaPesquisa = Ler.linha();
				gerente = ManipulaArquivo.<Gerente> RetornaObjArquivo(matriculaPesquisa, "Gerentes");
				break;
			case 2:
				gerente = OperacoesGerente.CadastrarGerente();
				break;
			case 3:
				System.out.println("Listando todos os gerentes:");
				boolean lista = ManipulaArquivo.ListarArquivos("Gerentes");
				if (lista)
					gerente = digitarNumeroGerente();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}

		System.out.printf("Informe o número desta agência: ");
		numeroAgencia = Ler.lerInt();

		agencia.setGerente(gerente);
		agencia.setClientes(clientes);
		agencia.setNumero(numeroAgencia);

		ManipulaArquivo.SalvarObjArquivo(agencia, "Agencias", String.valueOf(agencia.getNumero()));

		return agencia;
	}

	/**
	 * Se for escolhida a opção de escolher um gerente já cadastrado, este
	 * método retorna o objeto do gerente baseado na matrícula digitada pelo
	 * usuário.
	 * 
	 * @return Gerente escolhido pelo usuário.
	 */
	private static Gerente digitarNumeroGerente() {
		int numero;
		System.out.println("Digite o número do gerente: ");
		numero = Ler.lerInt();
		return ManipulaArquivo.<Gerente> RetornaObjArquivo(String.valueOf(numero), "Gerentes");
	}
}
