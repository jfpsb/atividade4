package aplicacao;

import agencia.Agencia;
import agencia.OperacoesAgencia;
import arquivo.ManipulaArquivo;
import input.Ler;
import pessoa.cliente.Cliente;

public class AppBanco {
	private static Agencia banco = null;
	private static AppCliente appCliente;
	private static AppGerente appGerente;

	public static Agencia getBanco() {
		return banco;
	}

	/**
	 * Chama os m�todos que dar�o in�cio ao banco.
	 */
	public void iniciaAppBanco() {
		escolherAgencia();
		atualizaArquivoAgencia();
	}

	/**
	 * M�todo respons�vel por determinar a ag�ncia a ser usada.
	 */
	private static void escolherAgencia() {
		int opcao;

		while (banco == null) {

			System.out.println(
					"O n�mero da Ag�ncia precisa ser informado ou criado. Siga o seguinte menu para prosseguir: ");
			System.out.println("1 - Desejo criar uma nova ag�ncia e utiliz�-la;");
			System.out.println("2 - J� sei o n�mero da ag�ncia que desejo acessar, deixe-me digitar;");
			System.out.println("3 - N�o sei o n�mero da ag�ncia, mostre-me a lista de todas as ag�ncias;");
			System.out.println("4 - N�o desejo mais utilizar a aplica��o;");
			System.out.printf("Qual op��o deseja? ");

			opcao = Ler.lerInt();

			switch (opcao) {
			case 1:
				banco = OperacoesAgencia.CadastrarAgencia();
				break;
			case 2:
				banco = digitarNumeroAgencia();
				break;
			case 3:
				boolean lista = ManipulaArquivo.ListarArquivos("Agencias");
				if (lista)
					banco = digitarNumeroAgencia();
				break;
			case 4:
				System.out.println("Aplica��o encerrada.");
				System.exit(0);
				break;
			default:
				System.out.println("Opc�o inv�lida.");
				break;
			}

			atualizaArquivoAgencia();
			escolherTipoPessoa();
			banco = null;
		}
	}

	/**
	 * Ap�s escolher a ag�ncia, deve ser escolhido o tipo de usu�rio que ir�
	 * utilizar o sistema.
	 */
	private static void escolherTipoPessoa() {
		int opcao, repetir = 1;

		while (repetir == 1) {
			if (banco.getClientes().size() != 0) {
				appGerente = null;
				appCliente = null;
				System.out.println("1 - Gerente");
				System.out.println("2 - Cliente");
				System.out.printf("Informe que tipo de usu�rio ir� acessar o banco: ");
				opcao = Ler.lerInt();

				switch (opcao) {
				case 1:
					iniciarAppGerente();
					break;
				case 2:
					iniciarAppCliente();
					break;
				default:
					System.out.println("Op��o inv�lida.");
					break;
				}
			} else {
				System.out.println("Esta Ag�ncia n�o possui clientes, voc� ser� enviado direto ao modo Gerente.");
				iniciarAppGerente();
			}

			System.out.printf(
					"Deseja repetir o acesso (Cliente ou Gerente)? Digite 1 para SIM, qualquer outro para N�O: ");
			repetir = Ler.lerInt();
		}
	}

	/**
	 * Atualiza o arquivo que guarda os dados da ag�ncia atual.
	 */
	public static void atualizaArquivoAgencia() {
		if (banco != null)
			ManipulaArquivo.SalvarObjArquivo(banco, "Agencias", String.valueOf(banco.getNumero()));
	}

	/**
	 * Atualiza o arquivo que guarda os dados do gerente da ag�ncia atual.
	 */
	public static void atualizaArquivoGerente() {
		if (banco.getGerente() != null)
			ManipulaArquivo.SalvarObjArquivo(banco.getGerente(), "Gerentes",
					String.valueOf(banco.getGerente().getMatricula()));
	}

	/**
	 * Inicia a aplica��o de cliente.
	 */
	private static void iniciarAppCliente() {
		int numero;

		System.out.printf("Informe o n�mero de sua conta banc�ria: ");
		numero = Ler.lerInt();

		if (banco.getClientes().containsKey(numero)) {
			Cliente cliente = banco.getClientes().get(numero);
			appCliente = new AppCliente(cliente);
			appCliente.mostrarMenuCliente();
		} else {
			System.out.println("Esta conta n�o existe nesta Ag�ncia.");
		}
	}

	/**
	 * Inicia a aplica��o de gerente.
	 */
	private static void iniciarAppGerente() {
		String matricula;

		System.out.printf("Informe a matr�cula do Gerente respons�vel por esta Ag�ncia: ");
		matricula = Ler.linha();
		if (matricula.equals(banco.getGerente().getMatricula())) {
			appGerente = new AppGerente();
			appGerente.mostraMenuGerente();
		} else {
			System.out.println("A matr�cula informada est� incorreta.");
		}
	}

	/**
	 * Pede ao usu�rio que digita o n�mero da ag�ncia desejada que ser� buscada
	 * na pasta de ag�ncias.
	 * 
	 * @return Retorna a ag�ncia que tem n�mero igual ao n�mero digitado pelo
	 *         usu�rio.
	 */
	private static Agencia digitarNumeroAgencia() {
		int numero;
		System.out.printf("Digite o n�mero da ag�ncia: ");
		numero = Ler.lerInt();
		return ManipulaArquivo.<Agencia> RetornaObjArquivo(String.valueOf(numero), "Agencias");
	}
}
