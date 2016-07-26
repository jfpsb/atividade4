package agencia;

import java.util.HashMap;

import arquivo.ManipulaArquivo;
import input.Ler;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;
import pessoa.gerente.OperacoesGerente;

/**
 * Controla as opera��es de Ag�ncia.
 * 
 * @author jfpsb
 *
 */
public class OperacoesAgencia {
	/**
	 * Realiza o cadastro de uma Ag�ncia no sistema.
	 * 
	 * @return Retorna a ag�ncia criada.
	 */
	public static Agencia CadastrarAgencia() {
		Agencia agencia = new Agencia();
		Gerente gerente = null;
		HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
		int opcao, numeroAgencia;
		String matriculaPesquisa;

		while (gerente == null) {

			System.out.println("Voc� ir� agora escolher o gerente para esta ag�ncia. Acompanhe o menu a seguir: ");
			System.out.println("1 - O gerente que desejo j� est� cadastrado, deixe-me digitar sua matr�cula;");
			System.out.println("2 - Desejo cadastrar um novo gerente para esta ag�ncia;");
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
				System.out.println("Op��o inv�lida.");
				break;
			}
		}

		System.out.printf("Informe o n�mero desta ag�ncia: ");
		numeroAgencia = Ler.lerInt();

		agencia.setGerente(gerente);
		agencia.setClientes(clientes);
		agencia.setNumero(numeroAgencia);

		ManipulaArquivo.SalvarObjArquivo(agencia, "Agencias", String.valueOf(agencia.getNumero()));

		return agencia;
	}

	/**
	 * Se for escolhida a op��o de escolher um gerente j� cadastrado, este
	 * m�todo retorna o objeto do gerente baseado na matr�cula digitada pelo
	 * usu�rio.
	 * 
	 * @return Gerente escolhido pelo usu�rio.
	 */
	private static Gerente digitarNumeroGerente() {
		int numero;
		System.out.println("Digite o n�mero do gerente: ");
		numero = Ler.lerInt();
		return ManipulaArquivo.<Gerente> RetornaObjArquivo(String.valueOf(numero), "Gerentes");
	}
}
