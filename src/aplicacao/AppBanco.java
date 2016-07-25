package aplicacao;

import java.util.HashMap;

import agencia.Agencia;
import agencia.ArquivosAgencia;
import input.Ler;
import pessoa.cliente.Cliente;
import pessoa.gerente.Gerente;

public class AppBanco {
	private Agencia banco;
	private AppCliente appCliente;
	private AppGerente appGerente;

	public Agencia getBanco() {
		return banco;
	}

	public void setBanco(Agencia banco) {
		this.banco = banco;
	}

	public AppCliente getAppCliente() {
		return appCliente;
	}

	public void setAppCliente(AppCliente appCliente) {
		this.appCliente = appCliente;
	}

	public AppGerente getAppGerente() {
		return appGerente;
	}

	public void setAppGerente(AppGerente appGerente) {
		this.appGerente = appGerente;
	}

	public AppBanco() {
//		escolherAgencia();
	}

//	private static Agencia escolherAgencia() {
//		int opcao;
//		
//		System.out
//				.println("O número da Agência precisa ser informado ou criado. Siga o seguinte menu para prosseguir: ");
//		System.out.println("1 - Desejo criar uma nova agência e utilizá-la;");
//		System.out.println("2 - Já sei o número da agência que desejo acessar, deixe-me digitar;");
//		System.out.println("3 - Não sei o número da agência, mostre-me a lista de todas as agências;");
//		System.out.println("4 - Não desejo mais utilizar a aplicação;");
//		System.out.println("Qual opção deseja?");
//
//		opcao = Ler.lerInt();
//
//		switch (opcao) {
//		case 1:
//			
//
//			break;
//		case 2:
//			int numero;
//			System.out.println("Digite o número da agência: ");
//			numero = Ler.lerInt();
//			agencia = ArquivosAgencia.RetornaAgenciaArquivo(numero);
//
//			if (agencia != null)
//				banco = agencia;
//
//			break;
//		case 3:
//			break;
//		case 4:
//			System.out.println("Aplicação encerrada.");
//			System.exit(0);
//			break;
//		default:
//			System.out.println("Opcão inválida.");
//			break;
//		}
//	}
}
