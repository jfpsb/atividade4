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

	public void setBanco(Agencia banco) {
		AppBanco.banco = banco;
	}

	public AppBanco() {
		escolherAgencia();
		escolherTipoPessoa();
	}

	private static Agencia escolherAgencia() {
		int opcao;

		while (banco == null) {

			System.out.println(
					"O número da Agência precisa ser informado ou criado. Siga o seguinte menu para prosseguir: ");
			System.out.println("1 - Desejo criar uma nova agência e utilizá-la;");
			System.out.println("2 - Já sei o número da agência que desejo acessar, deixe-me digitar;");
			System.out.println("3 - Não sei o número da agência, mostre-me a lista de todas as agências;");
			System.out.println("4 - Não desejo mais utilizar a aplicação;");
			System.out.printf("Qual opção deseja? ");

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
				System.out.println("Aplicação encerrada.");
				System.exit(0);
				break;
			default:
				System.out.println("Opcão inválida.");
				break;
			}
		}

		return banco;
	}

	private static void escolherTipoPessoa() {
		int opcao, repetir = 1;

		while (repetir == 1) {
			if (banco.getClientes().size() != 0) {

				appGerente = null;
				appCliente = null;
				System.out.println("1 - Gerente");
				System.out.println("2 - Cliente");
				System.out.printf("Informe que tipo de usuário irá acessar o banco: ");
				opcao = Ler.lerInt();

				switch (opcao) {
				case 1:
					iniciarAppGerente();
					break;
				case 2:
					iniciarAppCliente();
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}
			} else {
				System.out.println("Esta Agência não possui clientes, você será enviado direto ao modo Gerente.");
				iniciarAppGerente();
			}

			System.out.printf(
					"Deseja repetir o acesso (Cliente ou Gerente)? Digite 1 para SIM, qualquer outro para NÃO: ");
			repetir = Ler.lerInt();
		}
	}

	private static void iniciarAppCliente() {
		int numero;

		System.out.printf("Informe o número de sua conta bancária: ");
		numero = Ler.lerInt();

		if (banco.getClientes().containsKey(numero)) {
			Cliente cliente = banco.getClientes().get(numero);
			appCliente = new AppCliente(cliente);
			appCliente.mostrarMenuCliente();
		} else {
			System.out.println("Esta conta não existe nesta Agência.");
		}
	}

	private static void iniciarAppGerente() {
		String matricula;

		System.out.printf("Informe a matrícula do Gerente responsável por esta Agência: ");
		matricula = Ler.linha();
		if (matricula.equals(banco.getGerente().getMatricula())) {
			appGerente = new AppGerente();
			appGerente.mostraMenuGerente();
		} else {
			System.out.println("A matrícula informada está incorreta.");
		}
	}

	private static Agencia digitarNumeroAgencia() {
		int numero;
		System.out.printf("Digite o número da agência: ");
		numero = Ler.lerInt();
		return ManipulaArquivo.<Agencia> RetornaObjArquivo(String.valueOf(numero), "Agencias");
	}
}
